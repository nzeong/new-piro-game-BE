package piro.newcardgame.domain.user.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;


@Getter
@AllArgsConstructor
public enum ErrorCode {
    USERNAME_DUPICATED(HttpStatus.CONFLICT, "");

    private HttpStatus httpStatus;
    private String message;
}
