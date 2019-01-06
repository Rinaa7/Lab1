package test.repository;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;
import test.entity.Order;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;
import java.util.Optional;

public interface OrderRepository extends PagingAndSortingRepository<Order,Integer> {
    Optional<Order> findById(Integer id);
    List<Order> findAll();

    @Query("SELECT COUNT(entity) FROM Order entity")
    Integer Count(@Param("_entity") Order _entity);

    @Modifying
    @Transactional
    @Query("DELETE FROM Order entity WHERE entity.id = :#{#_id}")
    void delete(@Param("_id") Optional<Order> _id);
}
