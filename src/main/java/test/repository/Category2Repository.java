package test.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import test.entity.Category2;
import test.entity.Change;

import java.util.List;
import java.util.Optional;

public interface Category2Repository extends PagingAndSortingRepository<Category2, Integer> {
    Optional<Category2> findById(Integer id);
    List<Category2> findAll();
}
