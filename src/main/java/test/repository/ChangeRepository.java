package test.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import test.entity.Change;
import java.util.List;
import java.util.Optional;

public interface ChangeRepository extends PagingAndSortingRepository<Change, Integer> {
    Optional<Change> findById(Integer id);
    List<Change> findAll();
}