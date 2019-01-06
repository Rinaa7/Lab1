package test.repository;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;
import test.entity.Product;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;
import java.util.Optional;

public interface ProductRepository extends PagingAndSortingRepository<Product,Integer> {
    Optional<Product> findById(Integer id);
    List<Product> findAll();

    @Query("SELECT COUNT(entity) FROM Product entity")
    Integer Count(@Param("_entity") Product _entity);

    @Modifying
    @Transactional
    @Query("DELETE FROM Product entity WHERE entity.id = :#{#_id}")
    void delete(@Param("_id") Optional<Product> _id);
}

