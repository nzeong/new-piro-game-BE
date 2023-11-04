package piro.newcardgame.domain.card;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import piro.newcardgame.domain.card.dto.request.AttackRequest;
import piro.newcardgame.domain.card.dto.response.AttackResponse;
import piro.newcardgame.domain.card.service.CardService;
import piro.newcardgame.domain.user.domain.User;

@RestController
@RequiredArgsConstructor
public class CardController {

    private final CardService cardService;

    @GetMapping("/attack")
    public ResponseEntity<AttackResponse> setAttack(){
        return ResponseEntity.status(HttpStatus.OK).body(cardService.setAttack());
    }

    @PostMapping("/attack")
    public ResponseEntity<String> attack(
            @RequestBody @Valid AttackRequest request,
            @AuthenticationPrincipal User user) {
        cardService.attack(request, user.getId());
        return ResponseEntity.status(HttpStatus.CREATED).body("게임이 생성되었습니다.");
    }

}
