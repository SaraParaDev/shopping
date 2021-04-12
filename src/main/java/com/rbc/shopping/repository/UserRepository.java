package com.rbc.shopping.repository;


import com.rbc.shopping.entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Repository class for USERS table.
 *
 * @author SARA
 */
@Repository
public interface UserRepository extends JpaRepository<Users, Long> {

    /**
     * Fetches User details based on User Id and Password.
     *
     * @param userId   long representing User Id.
     * @param password String representing Password.
     * @return Returns Users entity for the User Id and Password.
     */
    @Query(value = "SELECT * FROM USERS WHERE id = ?1 and password = ?2", nativeQuery = true)
    List<Users> fetchUserDetails(Long userId, String password);
}
