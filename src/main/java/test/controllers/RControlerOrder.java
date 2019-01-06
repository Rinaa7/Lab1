package test.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.expression.ExpressionException;
import org.springframework.web.bind.annotation.*;
import test.entity.Customer;
import test.entity.Order;
import test.entity.Product;
import test.repository.CustomerRepository;
import test.repository.OrderRepository;
import test.repository.ProductRepository;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("ControlerAll")
public class RControlerOrder {
    private final OrderRepository orderRepository;
    private final CustomerRepository customerRepository;
    private final ProductRepository productRepository;

    @Autowired
    public RControlerOrder(OrderRepository orderRepository,
                           CustomerRepository customerRepository,
                           ProductRepository productRepository) {
        this.orderRepository = orderRepository;
        this.customerRepository = customerRepository;
        this.productRepository = productRepository;
    }

    @GetMapping("/Order")
    Iterable<Order> getAllOrder() {
        return (List<Order>) orderRepository.findAll();
    }

    @GetMapping("/Order/{orderId}")
    Optional<Order> getOrderId(@PathVariable Integer orderId){
        return orderRepository.findById(orderId);
    }


    @GetMapping("/OrderCreate")
    Order createOrder( @RequestParam(name = "idProduct", defaultValue = "") Integer idProduct,
                       @RequestParam(name = "idCustomer", defaultValue = "") Integer idCustomer,
                       @RequestParam(name  = "quantity", defaultValue = "") Integer quantity,
                       @RequestParam(name  = "deliverymethod", defaultValue = "") String deliverymethod,
                       @RequestParam(name  = "paymentmethod", defaultValue = "") String paymentmethod,
                       @RequestParam(name  = "status", defaultValue = "") String status,
                       @RequestParam(name  = "comment", defaultValue = "") String comment                       ) {
        Order order = new Order();
        Optional<Customer> maybeCustomer = customerRepository.findById(idCustomer);
        Customer customer = maybeCustomer
                .orElseThrow(() -> new ExpressionException(String.valueOf(idCustomer)));

        Optional<Product> maybeProduct = productRepository.findById(idProduct);
        Product product = maybeProduct
                .orElseThrow(() -> new ExpressionException(String.valueOf(idProduct)));

        customer.setOrderSet(new HashSet<Order>());
        product.setOrderSet(new HashSet<Order>());
        order.setQuantity(quantity);
        order.setDeliverymethod(deliverymethod);
        order.setPaymentmethod(paymentmethod);
        order.setStatus(status);
        order.setComment(comment);
        customer.getOrderSet().add(order);
        product.getOrderSet().add(order);
        return orderRepository.save(order);
    }


    @RequestMapping("/Order")
    Order updateOrder( @RequestParam(name = "idProduct", defaultValue = "") Integer idProduct,
                       @RequestParam(name = "idCustomer", defaultValue = "") Integer idCustomer,
                       @RequestParam(name = "id", defaultValue = "") Integer id,
                       @RequestParam(name  = "quantity", defaultValue = "") Integer quantity,
                       @RequestParam(name  = "deliverymethod", defaultValue = "") String deliverymethod,
                       @RequestParam(name  = "paymentmethod", defaultValue = "") String paymentmethod,
                       @RequestParam(name  = "status", defaultValue = "") String status,
                       @RequestParam(name  = "comment", defaultValue = "") String comment) {
        Order order2 = new Order();
        if (orderRepository.findAll().size() < id){
            order2 = createOrder(idProduct,idCustomer, quantity,deliverymethod, paymentmethod, status, comment);
        }
        else{
            Optional<Order> maybeOrder= orderRepository.findById(id);
            Order order = maybeOrder
                    .orElseThrow(() -> new ExpressionException(String.valueOf(id)));
            order.setComment(comment);
            order.setDeliverymethod(deliverymethod);
            order.setPaymentmethod(paymentmethod);
            order.setQuantity(quantity);
            order.setStatus(status);
            order2 = order;
            orderRepository.save(order);
        }
        return order2;
    }

    @GetMapping("/OrderDelete/{orderId}")
    Order deleteOrder(@PathVariable Integer orderId) throws Exception {
        Order order = orderRepository.findById(orderId)
                .orElseThrow(() -> new ExpressionException(String.valueOf(orderId)));
        orderRepository.delete(order);
        return order;
    }
}
