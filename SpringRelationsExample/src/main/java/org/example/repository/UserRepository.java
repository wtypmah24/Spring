package org.example.repository;

import org.example.entity.user.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    List<User> findAllByLastNameAndFirstNameAndEmail(String lastName, String firstName, String email);
}
