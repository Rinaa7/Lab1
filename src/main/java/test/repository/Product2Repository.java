package test.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import test.entity.Order2;
import test.entity.Product2;

import java.util.List;
import java.util.Optional;


public interface Product2Repository extends PagingAndSortingRepository<Product2, Integer> {
    Optional<Product2> findById(Integer id);
    List<Product2> findAll();
}