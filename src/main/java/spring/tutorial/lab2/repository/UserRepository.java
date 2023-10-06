package spring.tutorial.lab2.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import spring.tutorial.lab2.model.User;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Long> {
    User findUserByEmail(String email);

    @Query(value =
            "select u.* from user u " +
            "JOIN role r ON u.role_id = r.id " +
            "join group_user g on r.group_id = g.id " +
            "where  g.id = :id1",
            nativeQuery = true)
    List<User> findUsersByIdAndRole(@Param("id1") long id1);

}
