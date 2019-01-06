package test;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import test.entity.*;
import test.repository.*;

import java.io.IOException;

@Service
public class ReplicationService {
    @Autowired
    private ChangeRepository changeRepository;
    private CategoryRepository categoryRepository;
    private CustomerRepository customerRepository;
    private ManufacturerRepository manufacturerRepository;
    private OrderRepository orderRepository;
    private ProductRepository productRepository;

    public ReplicationService() {
    }

    public void execReplication(Message message) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        if (message.getName().equalsIgnoreCase("Customer")) {
            Customer2 customer2 = objectMapper.readValue(message.getJson(), Customer2.class);
            if (customer2.getOperation().equalsIgnoreCase("D")) {
                customerRepository.delete(customer2.getCustomer());
            } else {
                customerRepository.save(customer2.getCustomer());
            }
        } else if (message.getName().equalsIgnoreCase("Category")) {
            Category2 category2 = objectMapper.readValue(message.getJson(), Category2.class);
            if (category2.getOperation().equalsIgnoreCase("D")) {
                categoryRepository.delete(category2.getCategory());
            } else {
                categoryRepository.save(category2.getCategory());
            }
        } else if (message.getName().equalsIgnoreCase("Manufacturer")) {
            Manufacturer2 manufacturer2 = objectMapper.readValue(message.getJson(), Manufacturer2.class);
            if (manufacturer2.getOperation().equalsIgnoreCase("D")) {
                manufacturerRepository.delete(manufacturer2.getManufacturer());
            } else {
                manufacturerRepository.save(manufacturer2.getManufacturer());
            }

        } else if (message.getName().equalsIgnoreCase("Order")) {
            Order2 order2 = objectMapper.readValue(message.getJson(), Order2.class);
            if (order2.getOperation().equalsIgnoreCase("D")) {
                orderRepository.delete(order2.getOrder());
            } else {
                orderRepository.save(order2.getOrder());
            }
        } else if (message.getName().equalsIgnoreCase("Product")) {
            Product2 product2 = objectMapper.readValue(message.getJson(), Product2.class);
            if (product2.getOperation().equalsIgnoreCase("D")) {
                productRepository.delete(product2.getProduct());
            } else {
                productRepository.save(product2.getProduct());
            }
        }
    }
}
