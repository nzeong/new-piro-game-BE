package piro.newcardgame.domain.card.domain;

import lombok.Getter;

@Getter
public enum GameStatus {
    PROGRESS("진행중"),
    CANCELLED("취소"),
    COMPLETED("완료");

    private final String value;

    GameStatus(String value) {
        this.value = value;
    }
}
