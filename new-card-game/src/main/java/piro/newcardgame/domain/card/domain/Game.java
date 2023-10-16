package piro.newcardgame.domain.card.domain;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import piro.newcardgame.domain.user.domain.User;
import piro.newcardgame.global.entity.BaseEntity;


@Entity
@Getter
@NoArgsConstructor
public class Game extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "game_id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "from_id", nullable = false)
    private User fromId;

    @Column(name = "from_score", nullable = false)
    private int fromScore;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "to_id", nullable = false)
    private User toId;

    @Column(name = "to_score", nullable = false)
    private int toScore;

    @Enumerated(EnumType.STRING)
    private GameStatus status;
}
