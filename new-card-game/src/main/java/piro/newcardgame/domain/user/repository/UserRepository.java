package piro.newcardgame.domain.user.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import piro.newcardgame.domain.user.domain.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
}
