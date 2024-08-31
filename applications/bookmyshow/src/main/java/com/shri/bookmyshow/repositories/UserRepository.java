package com.shri.bookmyshow.repositories;

import com.shri.bookmyshow.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.OptionalInt;

@Repository
public interface UserRepository extends JpaRepository<User,Long>{

    Optional<User> findById(Long id);

    Optional<User> findByEmail(String email);

}
