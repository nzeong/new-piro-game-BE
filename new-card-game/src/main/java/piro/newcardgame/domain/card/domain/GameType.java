package piro.newcardgame.domain.card.domain;

import lombok.Getter;

@Getter
public enum GameType {
    SMALL_WINS("작은 수 이김"),
    BIG_WINS("큰 수 이김");

    private final String value;

    GameType(String value) {
        this.value = value;
    }
}
