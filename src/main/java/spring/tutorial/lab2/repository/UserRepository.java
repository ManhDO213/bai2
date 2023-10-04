package spring.tutorial.lab2.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import spring.tutorial.lab2.model.User;

public interface UserRepository extends JpaRepository<User, Long> {
    User findUserByEmail(String email);
}
