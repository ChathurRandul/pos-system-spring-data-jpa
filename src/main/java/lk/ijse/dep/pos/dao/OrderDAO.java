package lk.ijse.dep.pos.dao;

import lk.ijse.dep.pos.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface OrderDAO extends JpaRepository<Order, Integer> {

    @Query(value = "SELECT id FROM `Order` ORDER BY id DESC LIMIT 1", nativeQuery = true)
    int getLastOrderId() throws Exception;

    @Query(value = "SELECT IFNULL (SELECT customer_id FROM `Order` WHERE customer_id=?1)", nativeQuery = true)
    Boolean existsByCustomerId(String customerId) throws Exception;

}
