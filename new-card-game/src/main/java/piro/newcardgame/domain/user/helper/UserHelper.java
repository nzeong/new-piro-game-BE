package piro.newcardgame.domain.user.helper;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import piro.newcardgame.domain.user.domain.User;
import piro.newcardgame.domain.user.exception.AppException;
import piro.newcardgame.domain.user.exception.ErrorCode;
import piro.newcardgame.domain.user.repository.UserRepository;

@Component
@RequiredArgsConstructor
public class UserHelper {
    public final UserRepository userRepository;
    public User findById(Long userId) {
        return userRepository
                .findById(userId)
                .orElseThrow(
                        () -> new AppException(ErrorCode.USERNAME_NOT_FOUND, ""));
    }

    public User findByNick(String nick) {
        return userRepository
                .findByNick(nick)
                .orElseThrow(
                        () -> new AppException(ErrorCode.USERNICKNAME_NOT_FOUND, ""));
    }
}
