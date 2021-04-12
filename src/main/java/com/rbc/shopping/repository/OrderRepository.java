package com.rbc.shopping.repository;


import com.rbc.shopping.entity.Orders;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Repository class for ORDERS table.
 *
 * @author SARA
 */
@Repository
public interface OrderRepository extends JpaRepository<Orders, Long> {

    /**
     * Finds and returns orders list based on User id.
     *
     * @param userId long representing User Id.
     * @return List of Orders.
     */
    @Query(value = "SELECT * FROM ORDERS WHERE user_id = ?1", nativeQuery = true)
    List<Orders> findOrdersByUserId(Long userId);

    /**
     * Finds and returns orders list for all users except supplied User id.
     *
     * @param userId long representing user id.
     * @return List of Orders.
     */
    @Query(value = "SELECT * FROM ORDERS WHERE user_id <> ?1", nativeQuery = true)
    List<Orders> findOrdersByOtherUsers(Long userId);
}
