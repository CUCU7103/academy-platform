package spring.academy.user.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import spring.academy.user.domain.User;

@Repository
public interface UserRepository extends JpaRepository<User, String> {

}
