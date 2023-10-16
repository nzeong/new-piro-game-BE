package piro.newcardgame.domain.user.domain;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.antlr.v4.runtime.misc.NotNull;
import piro.newcardgame.global.entity.BaseEntity;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class User extends BaseEntity {
    @PrePersist
    public void prePresist(){
        this.totalScore = this.totalScore == null? 0:this.totalScore;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String nick;

    @Column(nullable = false)
    private String pwd;

    @Column(nullable = false)
    private String email;

    @Column(name = "total_score", nullable = false)
    private Long totalScore;

    @Builder
    public User(String name, String nick, String pwd, String email) {
        this.name = name;
        this.nick = nick;
        this.pwd = pwd;
        this.email = email;
    }
}
