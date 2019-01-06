package test.repository;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import test.entity.Customer;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;
import java.util.Optional;

public interface CustomerRepository extends PagingAndSortingRepository<Customer,Integer> {
    Optional<Customer> findById(Integer id);
    List<Customer> findAll();

    @Query("SELECT COUNT(entity) FROM Customer entity")
    Integer Count(@Param("_entity") Customer _entity);

    @Modifying
    @Transactional
    @Query("DELETE FROM Customer entity WHERE entity.id = :#{#_id}")
    void delete(@Param("_id") Optional<Customer> _id);
}
