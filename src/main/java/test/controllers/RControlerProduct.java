package test.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.expression.ExpressionException;
import org.springframework.web.bind.annotation.*;
import test.entity.Category;
import test.entity.Manufacturer;
import test.entity.Product;
import test.repository.CategoryRepository;
import test.repository.ManufacturerRepository;
import test.repository.ProductRepository;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("ControlerAll")
public class RControlerProduct {
    private final ProductRepository productRepository;
    private final CategoryRepository categoryRepository;
    private final ManufacturerRepository manufacturerRepository;

    @Autowired
    public RControlerProduct(ProductRepository productRepository,
                             CategoryRepository categoryRepository,
                             ManufacturerRepository manufacturerRepository) {
        this.productRepository = productRepository;
        this.categoryRepository = categoryRepository;
        this.manufacturerRepository = manufacturerRepository;
    }

    @GetMapping("/Product")
    Iterable<Product> getAllProduct() {
        return (List<Product>) productRepository.findAll();
    }

    @GetMapping("/Product/{productId}")
    Optional<Product> getProductId(@PathVariable Integer productId){
        return productRepository.findById(productId);
    }


    @GetMapping("/ProductCreate")
    Product createProduct( @RequestParam(name = "idManufacturer", defaultValue = "") Integer idManufacturer,
                       @RequestParam(name = "idCategory", defaultValue = "") Integer idCategory,
                       @RequestParam(name  = "description", defaultValue = "") String description,
                       @RequestParam(name  = "name", defaultValue = "") String name,
                       @RequestParam(name  = "price", defaultValue = "") Double price,
                       @RequestParam(name  = "quantity", defaultValue = "") Integer quantity) {
        Product product = new Product();
        Optional<Category> maybeCategory = categoryRepository.findById(idCategory);
        Category category = maybeCategory
                .orElseThrow(() -> new ExpressionException(String.valueOf(idCategory)));

        Optional<Manufacturer> maybeManufacturer = manufacturerRepository.findById(idManufacturer);
        Manufacturer manufacturer = maybeManufacturer
                .orElseThrow(() -> new ExpressionException(String.valueOf(idManufacturer)));

        category.setProductSet(new HashSet<Product>());
        manufacturer.setProductSet(new HashSet<Product>());
        product.setDescription(description);
        product.setName(name);
        product.setPrice(price);
        product.setQuantity(quantity);
        category.getProductSet().add(product);
        manufacturer.getProductSet().add(product);
        return productRepository.save(product);
    }


    @RequestMapping("/Product")
    Product updateProduct( @RequestParam(name = "idManufacturer", defaultValue = "") Integer idManufacturer,
                       @RequestParam(name = "idCategory", defaultValue = "") Integer idCategory,
                       @RequestParam(name = "id", defaultValue = "") Integer id,
                           @RequestParam(name  = "description", defaultValue = "") String description,
                           @RequestParam(name  = "name", defaultValue = "") String name,
                           @RequestParam(name  = "price", defaultValue = "") Double price,
                           @RequestParam(name  = "quantity", defaultValue = "") Integer quantity){
        Product product2 = new Product();
        if (productRepository.findAll().size() < id){
            product2 = createProduct(idManufacturer,idCategory, description,name, price, quantity);
        }
        else{
            Optional<Product> maybeProduct= productRepository.findById(id);
            Product product = maybeProduct
                    .orElseThrow(() -> new ExpressionException(String.valueOf(id)));
            product.setDescription(description);
            product.setName(name);
            product.setPrice(price);
            product.setQuantity(quantity);
            product2 = product;
            productRepository.save(product);
        }
        return product2;
    }

    @GetMapping("/ProductDelete/{productId}")
    Product deleteProduct(@PathVariable Integer productId) throws Exception {
        Product product = productRepository.findById(productId)
                .orElseThrow(() -> new ExpressionException(String.valueOf(productId)));
        productRepository.delete(product);
        return product;
    }
}
