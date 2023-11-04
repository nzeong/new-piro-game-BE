package piro.newcardgame.domain.card.dto.response;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.Set;

@Getter
@NoArgsConstructor
public class AttackResponse {
    private Set<Long> randomNumbers;
    private List<String> nickNames;

    @Builder
    public AttackResponse(Set<Long> randomNumbers, List<String> nickNames) {
        this.randomNumbers = randomNumbers;
        this.nickNames = nickNames;
    }

    public static AttackResponse from(Set<Long> randomNumbers, List<String> nickNames) {
        return AttackResponse.builder()
                .randomNumbers(randomNumbers)
                .nickNames(nickNames)
                .build();
    }
}