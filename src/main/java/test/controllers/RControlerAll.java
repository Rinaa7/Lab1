package test.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import test.repository.*;

import java.util.Random;
@RestController
@RequestMapping("ControlerAll")
public class RControlerAll {


    private final CategoryRepository categoryRepository;
    private final CustomerRepository customerRepository;
    private final ManufacturerRepository manufacturerRepository;
    private final OrderRepository orderRepository;
    private final ProductRepository productRepository;
    private Random random =new Random();
    @Autowired
    public RControlerAll(
            CategoryRepository categoryRepository,
            CustomerRepository customerRepository,
            ManufacturerRepository manufacturerRepository,
            OrderRepository orderRepository,
            ProductRepository productRepository){
        this.categoryRepository=categoryRepository;
        this.customerRepository=customerRepository;
        this.manufacturerRepository=manufacturerRepository;
        this.orderRepository=orderRepository;
        this.productRepository=productRepository;

    }

}

