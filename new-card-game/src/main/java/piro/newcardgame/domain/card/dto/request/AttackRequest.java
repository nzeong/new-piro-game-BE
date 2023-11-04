package piro.newcardgame.domain.card.dto.request;

import jakarta.persistence.Column;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import piro.newcardgame.domain.card.domain.Game;
import piro.newcardgame.domain.card.domain.GameStatus;
import piro.newcardgame.domain.user.domain.User;

@Getter
@NoArgsConstructor
public class AttackRequest {
    private Long fromScore;
    private String nick;

    @Builder
    public AttackRequest(Long fromScore, String nick) {
        this.fromScore = fromScore;
        this.nick = nick;
    }

    public Game toEntity(User fromUser, User toUser){
        return Game.builder()
                .fromId(fromUser)
                .fromScore(fromScore)
                .toId(toUser)
                .status(GameStatus.PROGRESS)
                .build();
    }
}
