package com.javaproject.fullStcakUsingJava.Repository;

import com.javaproject.fullStcakUsingJava.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {

}
