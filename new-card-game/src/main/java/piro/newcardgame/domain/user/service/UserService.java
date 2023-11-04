package piro.newcardgame.domain.user.service;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import piro.newcardgame.domain.user.domain.User;
import piro.newcardgame.domain.user.dto.request.UserJoinRequest;
import piro.newcardgame.domain.user.exception.AppException;
import piro.newcardgame.domain.user.exception.ErrorCode;
import piro.newcardgame.domain.user.repository.UserRepository;
import piro.newcardgame.global.utils.JwtTokenUtil;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final BCryptPasswordEncoder pwdEncoder;

    @Value("${jwt.token.secret}")
    private String key;
    private Long expireTimeMs = 1000 * 60 * 60l; // 1시간


    public String join(UserJoinRequest userJoinRequest){

        //유저의 name 중복 체크하기
        userRepository.findByName(userJoinRequest.getName())
                .ifPresent(user -> {
                    throw new AppException(ErrorCode.USERNAME_DUPICATED, userJoinRequest.getName() + "는 이미 있습니다.");
                });

        //저장
        User user = userJoinRequest.toEntity(pwdEncoder.encode(userJoinRequest.getPwd()));
        userRepository.save(user);

        return "SUCCESS";
    }

    public String login(String name, String pwd){
        // userName 없음
        User selectedUser = userRepository.findByName(name)
                .orElseThrow(() -> new AppException(ErrorCode.USERNAME_NOT_FOUND, name + "이 없습니다."));

        // password 틀림
        if(!pwdEncoder.matches(pwd, selectedUser.getPwd())){
            throw new AppException(ErrorCode.INVALID_PASSWORD, "비밀번호를 잘못 입력하였습니다.");
        }

        String token = JwtTokenUtil.createToken(selectedUser.getName(), key, expireTimeMs);
        // 앞에서 exception 안 났으면 토큰 발행
        return token;
    }

}
