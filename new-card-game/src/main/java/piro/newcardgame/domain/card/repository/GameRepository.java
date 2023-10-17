package piro.newcardgame.domain.card.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import piro.newcardgame.domain.card.domain.Game;

@Repository
public interface GameRepository extends JpaRepository<Game, Long> {
}
