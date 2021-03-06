package co.ochell.jwtokensecurity.repository;

import co.ochell.jwtokensecurity.model.user.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String name);
}
