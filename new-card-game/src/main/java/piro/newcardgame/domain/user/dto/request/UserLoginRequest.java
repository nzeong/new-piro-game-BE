package piro.newcardgame.domain.user.dto.request;


import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class UserLoginRequest {
    @NotNull(message = "아이디를 입력해주세요.")
    private String name;

    @NotNull(message = "비밀번호를 입력해주세요.")
    private String pwd;
}
