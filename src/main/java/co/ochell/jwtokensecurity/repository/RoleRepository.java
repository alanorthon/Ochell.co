package co.ochell.jwtokensecurity.repository;

import co.ochell.jwtokensecurity.model.user.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, Long> {
    Role findByName(String name);
}
