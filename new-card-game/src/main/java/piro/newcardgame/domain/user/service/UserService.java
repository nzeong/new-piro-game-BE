package piro.newcardgame.domain.user.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import piro.newcardgame.domain.user.domain.User;
import piro.newcardgame.domain.user.dto.request.UserJoinRequest;
import piro.newcardgame.domain.user.exception.AppException;
import piro.newcardgame.domain.user.exception.ErrorCode;
import piro.newcardgame.domain.user.repository.UserRepository;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public String join(UserJoinRequest userJoinRequest){

        //유저의 name 중복 체크하기
        userRepository.findByName(userJoinRequest.getName())
                .ifPresent(user -> {
                    throw new AppException(ErrorCode.USERNAME_DUPICATED, userJoinRequest.getName() + "는 이미 있습니다.");
                });

        //저장
        User user = userJoinRequest.toEntity();
        userRepository.save(user);

        return "SUCCESS";
    }

}
