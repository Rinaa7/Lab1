package test.repository;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;
import test.entity.Manufacturer;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;
import java.util.Optional;

public interface ManufacturerRepository extends PagingAndSortingRepository<Manufacturer,Integer> {
    Optional<Manufacturer> findById(Integer id);
    List<Manufacturer> findAll();

    @Query("SELECT COUNT(entity) FROM Manufacturer entity")
    Integer Count(@Param("_entity") Manufacturer _entity);

    @Modifying
    @Transactional
    @Query("DELETE FROM Manufacturer entity WHERE entity.id = :#{#_id}")
    void delete(@Param("_id") Optional<Manufacturer> _id);
}
