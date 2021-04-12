package com.rbc.shopping.repository;


import com.rbc.shopping.entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Repository class for USERS table.
 *
 * @author SARA
 */
@Repository
public interface UserRepository extends JpaRepository<Users, Long> {

}
