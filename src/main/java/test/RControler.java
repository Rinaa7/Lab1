package test;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import test.entity.*;
import test.repository.*;


import java.util.HashSet;
import java.util.Random;
import java.util.Set;

@RestController
public class RControler {
    private final CategoryRepository categoryRepository;
    private final CustomerRepository customerRepository;
    private final ManufacturerRepository manufacturerRepository;
    private final OrderRepository orderRepository;
    private final ProductRepository productRepository;
    private Random random =new Random();
    public RControler(
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

    @RequestMapping("Controler")
    public Category controler (@RequestParam(name = "name", defaultValue = "")String name){

        Category category = new Category();
        category.setName("Категория "+ String.valueOf(random.nextInt()));
        category.setDescription("Описание категории: "+String.valueOf(random.nextInt()));
        category.setQuantity(random.nextInt());
        category.setProductSet(new HashSet<Product>());
        categoryRepository.save(category);

        Manufacturer manufacturer = new Manufacturer();
        manufacturer.setDescription("Производитель "+String.valueOf(random.nextInt()));
        manufacturer.setName("Наименование производителя: "+String.valueOf(random.nextInt()));
        manufacturer.setQuantity(random.nextInt());
        manufacturer.setProductSet(new HashSet<Product>());
        manufacturerRepository.save(manufacturer);

        Product product = null;
        for (int i = 0; i <= 5; i++) {
            product = new Product();
            product.setCategory(category);
            product.setManufacturer(manufacturer);
            product.setName("Товар "+String.valueOf(random.nextInt()));
            product.setDescription("Описание товара: "+String.valueOf(random.nextInt()));
            product.setPrice(random.nextDouble());
            product.setQuantity(random.nextInt());
            productRepository.save(product);
            category.getProductSet().add(product);
            manufacturer.getProductSet().add(product);
        }

        Customer customer = new Customer();
        customer.setContacts("+7"+String.valueOf(random.nextInt()));
        customer.setGeozona(random.nextInt());
        customer.setSale(random.nextInt());
        customer.setSurname(String.valueOf(random.nextInt()));
        customer.setOrderSet(new HashSet<Order>());
        customerRepository.save(customer);

        Order order = new Order();
        order.setCustomer(customer);
        order.setProduct(product);
        order.setComment("Комментарий: "+ String.valueOf(random.nextInt()));
        order.setDeliverymethod(String.valueOf(random.nextInt()));
        order.setPaymentmethod(String.valueOf(random.nextInt()));
        order.setQuantity(random.nextInt());
        order.setStatus(String.valueOf(random.nextInt()));
        customer.getOrderSet().add(order);
        orderRepository.save(order);


        return category;
    }
}

