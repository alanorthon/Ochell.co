package co.ochell.jwtokensecurity.service;

import co.ochell.jwtokensecurity.model.user.User;

import java.util.List;

public interface UserService {

    User register(User user, String role);

    List<User> getAll();

    User findByUsername(String username);

    User findById(Long id);

    void delete(Long id);
}
