package com.rbc.shopping.repository;


import com.rbc.shopping.entity.Wish;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Repository class for WISH table.
 *
 * @author SARA
 */
@Repository
public interface WishRepository extends JpaRepository<Wish, Long> {

    /**
     * Finds and returns list of Wishes based on the User Id.
     *
     * @param userId long representing User Id.
     * @return Returns set of Wish list for the User.
     */
    @Query(value = "SELECT * FROM WISH WHERE user_id = ?1", nativeQuery = true)
    List<Wish> findWishByUserId(Long userId);
}
