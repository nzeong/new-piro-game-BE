package piro.newcardgame.domain.user;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import piro.newcardgame.domain.user.dto.request.UserJoinRequest;
import piro.newcardgame.domain.user.dto.request.UserLoginRequest;
import piro.newcardgame.domain.user.service.UserService;

@RestController
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping("/join")
    public ResponseEntity<String> join(@RequestBody UserJoinRequest dto){
        userService.join(dto);
        return ResponseEntity.ok().body("회원가입이 성공했습니다.");
    }

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody UserLoginRequest dto){
        String token = userService.login(dto.getName(), dto.getPwd()); //로그인 시 토큰 리턴
        return ResponseEntity.ok().body(token);
    }
}
