package test.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.expression.ExpressionException;
import org.springframework.web.bind.annotation.*;

import test.entity.Customer;
import test.repository.CustomerRepository;


import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("ControlerAll")
public class RControlerCustomer {
    private final CustomerRepository customerRepository;

    @Autowired
    public RControlerCustomer(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @GetMapping("/Customer")
    Iterable<Customer> getAllCustomer() {
        return (List<Customer>) customerRepository.findAll();
    }

    @GetMapping("/Customer/{customerId}")
    Optional<Customer> getCustomerId(@PathVariable Integer customerId){
        return customerRepository.findById(customerId);
    }


    @GetMapping("/CustomerCreate")
    Customer createCustomer( @RequestParam(name  = "contacts", defaultValue = "") String contacts,
                             @RequestParam(name  = "geozona", defaultValue = "") Integer geozona,
                             @RequestParam(name  = "sale", defaultValue = "") Integer sale,
                             @RequestParam(name  = "surname", defaultValue = "") String surname) {

        Customer customerCreate = new Customer();
        customerCreate.setContacts(contacts);
        customerCreate.setGeozona(geozona);
        customerCreate.setSale(sale);
        customerCreate.setSurname(surname);
        return customerRepository.save(customerCreate);
    }


    @RequestMapping("/CustomerUpdate")
    Customer updateCustomer( @RequestParam(name = "id", defaultValue = "") Integer id,
                             @RequestParam(name  = "contacts", defaultValue = "") String contacts,
                             @RequestParam(name  = "geozona", defaultValue = "") Integer geozona,
                             @RequestParam(name  = "sale", defaultValue = "") Integer sale,
                             @RequestParam(name  = "surname", defaultValue = "") String surname) {
        Customer customer2 = new Customer();
        if (customerRepository.findAll().size() < id){
            customer2 = createCustomer(contacts, geozona, sale,surname);
        }
        else{
            Optional<Customer> maybeCustomer= customerRepository.findById(id);
            Customer customer = maybeCustomer
                    .orElseThrow(() -> new ExpressionException(String.valueOf(id)));
            customer.setContacts(contacts);
            customer.setGeozona(geozona);
            customer.setSale(sale);
            customer.setSurname(surname);
            customer2 = customer;
            customerRepository.save(customer);
        }
        return customer2;
    }

    @GetMapping("/CustomerDelete/{customerId}")
    Customer deleteCustomer(@PathVariable Integer customerId) throws Exception {
        Customer customer = customerRepository.findById(customerId)
                .orElseThrow(() -> new ExpressionException(String.valueOf(customerId)));
        customerRepository.delete(customer);
        return customer;
    }

}
