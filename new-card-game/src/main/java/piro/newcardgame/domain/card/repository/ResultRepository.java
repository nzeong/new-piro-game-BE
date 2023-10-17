package piro.newcardgame.domain.card.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import piro.newcardgame.domain.card.domain.Game;
import piro.newcardgame.domain.card.domain.Result;

@Repository
public interface ResultRepository extends JpaRepository<Result, Long> {
}
