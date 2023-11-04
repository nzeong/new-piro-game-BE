package piro.newcardgame.domain.user.dto.request;


import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor // @AllArgsConstructor 써주면 오류나요
public class UserLoginRequest {
    @NotNull(message = "아이디를 입력해주세요.")
    private String name;

    @NotNull(message = "비밀번호를 입력해주세요.")
    private String pwd;
}
