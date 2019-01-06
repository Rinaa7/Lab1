package test.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import test.entity.Category2;
import test.entity.Customer2;

import java.util.List;
import java.util.Optional;



public interface Customer2Repository extends PagingAndSortingRepository<Customer2, Integer> {
    Optional<Customer2> findById(Integer id);
    List<Customer2> findAll();
}
