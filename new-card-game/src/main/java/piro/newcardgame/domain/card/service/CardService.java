package piro.newcardgame.domain.card.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import piro.newcardgame.domain.card.domain.Game;
import piro.newcardgame.domain.card.domain.GameStatus;
import piro.newcardgame.domain.card.dto.request.AttackRequest;
import piro.newcardgame.domain.card.dto.response.AttackResponse;
import piro.newcardgame.domain.card.repository.GameRepository;
import piro.newcardgame.domain.user.domain.User;
import piro.newcardgame.domain.user.helper.UserHelper;
import piro.newcardgame.domain.user.repository.UserRepository;

import java.util.*;
import java.util.concurrent.ThreadLocalRandom;

@Service
@RequiredArgsConstructor
public class CardService {

    private final UserRepository userRepository;
    private final UserHelper userHelper;
    private final GameRepository gameRepository;

    public AttackResponse setAttack() {
        return AttackResponse.from(getRandomNumbers(), getAllUserNicknames());
    }

    private List<String> getAllUserNicknames() {
        List<User> users = userRepository.findAll();
        List<String> nicknames = new ArrayList<>();
        for (User user : users) {
            nicknames.add(user.getNick());
        }
        return nicknames;
    }

    private Set<Long> getRandomNumbers() {
        Set<Long> randomNumbers = new HashSet<>();
        while (randomNumbers.size() < 5) {
            long randomNumber = ThreadLocalRandom.current().nextLong(1, 11);
            randomNumbers.add(randomNumber);
        }
        return randomNumbers;
    }

    public void attack(AttackRequest request, Long userId) {
        User toUser = userHelper.findByNick(request.getNick());
        User fromUser = userHelper.findById(userId);
        Game game = request.toEntity(fromUser, toUser);
        gameRepository.save(game);
    }


}
