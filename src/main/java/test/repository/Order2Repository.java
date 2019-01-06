package test.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import test.entity.Manufacturer2;
import test.entity.Order2;

import java.util.List;
import java.util.Optional;

public interface Order2Repository extends PagingAndSortingRepository<Order2, Integer> {
    Optional<Order2> findById(Integer id);
    List<Order2> findAll();
}