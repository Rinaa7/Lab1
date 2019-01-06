package test.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import test.entity.Customer2;
import test.entity.Manufacturer2;

import java.util.List;
import java.util.Optional;

public interface Manufacturer2Repository extends PagingAndSortingRepository<Manufacturer2, Integer> {
    Optional<Manufacturer2> findById(Integer id);
    List<Manufacturer2> findAll();
}
