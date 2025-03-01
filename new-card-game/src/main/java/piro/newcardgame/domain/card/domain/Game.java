package piro.newcardgame.domain.card.domain;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import piro.newcardgame.domain.user.domain.User;
import piro.newcardgame.global.entity.BaseEntity;


@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Game extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "game_id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "from_id", nullable = false)
    private User fromId;

    @Column(name = "from_score", nullable = false)
    private Long fromScore;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "to_id")
    private User toId;

    @Column(name = "to_score")
    private Long toScore;

    @Enumerated(EnumType.STRING)
    private GameStatus status;

    @Builder
    public Game(User fromId, Long fromScore, User toId, Long toScore, GameStatus status) {
        this.fromId = fromId;
        this.fromScore = fromScore;
        this.toId = toId;
        this.toScore = toScore;
        this.status = status;
    }
}
