package com.rbc.shopping.repository;


import com.rbc.shopping.entity.Items;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Repository class for ITEM_REPOSITORY table.
 *
 * @author SARA
 */
@Repository
public interface ItemRepository extends JpaRepository<Items, Long> {

    /**
     * Finds and returns List of Items.Native query to get items based on Category Id.
     *
     * @param itemCategoryId Long representing category Id.
     * @return Returns list of Items.
     */
    @Query(value = "SELECT * FROM ITEMS WHERE category_id = ?1", nativeQuery = true)
    List<Items> findItemsByCategoryId(Long itemCategoryId);
}
