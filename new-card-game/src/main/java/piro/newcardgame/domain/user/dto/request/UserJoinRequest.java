package piro.newcardgame.domain.user.dto.request;

import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import piro.newcardgame.domain.user.domain.User;

@Getter
@NoArgsConstructor
public class UserJoinRequest {

    private String name;
    private String nick;
    private String pwd;
    private String email;

    @Builder
    public UserJoinRequest(String name, String nick, String pwd, String email) {
        this.name = name;
        this.nick = nick;
        this.pwd = pwd;
        this.email = email;
    }

    public User toEntity(String encodedPwd) { // requestDto 단계에서 정의하고 Service에서는 꺼내 쓰는 것이 더 편한 듯

        return User.builder()
                .name(name)
                .nick(nick)
                .pwd(encodedPwd)
                .email(email)
                .build();
    }
}
