package lk.ijse.dep.pos.dao;

import lk.ijse.dep.pos.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CustomerDAO extends JpaRepository<Customer, String> {

    @Query(value = "SELECT id FROM Customer ORDER BY id DESC LIMIT 1", nativeQuery = true)
    String getLastCustomerId() throws Exception;

    Customer getCustomerById(String id);

    List<Customer> getCustomerByNameLike(String query);

    Customer getFirstCustomerByOrderByIdDesc();

    @Query(value = "SELECT * FROM Customer WHERE id=?#{{0}} and name=?#{{1}}", nativeQuery = true)
    Customer anotherQuery(String id, String name);

    @Query(value = "SELECT c FROM Customer c WHERE c.name LIKE ?#{[0]}")
    List<Customer> depQuery(String c);
}
