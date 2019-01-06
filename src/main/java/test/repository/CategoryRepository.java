package test.repository;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;
import test.entity.Category;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;
import java.util.Optional;

public interface CategoryRepository  extends PagingAndSortingRepository<Category,Integer> {
//    @Query("SELECT T FROM TestEntity T WHERE T.name LIKE CONCAT ('%', :text, '%')  ")
//    List<Category> findByNameNotLikeAnything (@Param("text") String text);
    Optional<Category> findById(Integer id);
    List<Category> findAll();

    @Query("SELECT COUNT(entity) FROM Category entity")
    Integer Count(@Param("_entity") Category _entity);

    @Modifying
    @Transactional
    @Query("DELETE FROM Category entity WHERE entity.id = :#{#_id}")
    void delete(@Param("_id") Optional<Category> _id);
}

