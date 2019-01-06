package test.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.expression.ExpressionException;
import org.springframework.web.bind.annotation.*;
import test.entity.Category;
import test.repository.CategoryRepository;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("ControlerAll")
public class RControlerCategory {
    private final CategoryRepository categoryRepository;

    @Autowired
    public RControlerCategory(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @GetMapping("/Category")
    Iterable<Category> getAllCategory() {
        return (List<Category>) categoryRepository.findAll();
    }

    @GetMapping("/Category/{categoryId}")
    Optional<Category> getCategoryId(@PathVariable Integer categoryId){
        return categoryRepository.findById(categoryId);
    }


    @GetMapping("/CategoryCreate")
    Category createCategory( @RequestParam(name  = "name", defaultValue = "") String name,
                             @RequestParam(name  = "description", defaultValue = "") String description,
                             @RequestParam(name  = "quantity", defaultValue = "") Integer quantity) {

        Category categoryCreate = new Category();
        categoryCreate.setName(name);
        categoryCreate.setDescription(description);
        categoryCreate.setQuantity(quantity);

        return categoryRepository.save(categoryCreate);
    }


    @RequestMapping("/CategoryUpdate")
    Category updateCategory( @RequestParam(name = "id", defaultValue = "") Integer id,
                             @RequestParam(name  = "name", defaultValue = "") String name,
                             @RequestParam(name  = "description", defaultValue = "") String description,
                             @RequestParam(name  = "quantity", defaultValue = "") Integer quantity) {
        Category category2 = new Category();
        if (categoryRepository.findAll().size() < id){
            category2 = createCategory(name, description, quantity);
        }
        else{
            Optional<Category> maybeCategory= categoryRepository.findById(id);
            Category category = maybeCategory
                    .orElseThrow(() -> new ExpressionException(String.valueOf(id)));
            category.setName(name);
            category.setDescription(description);
            category.setQuantity(quantity);
            category2 = category;
            categoryRepository.save(category);
        }
        return category2;
    }

    @GetMapping("/CategoryDelete/{categoryId}")
    Category deleteCategory(@PathVariable Integer categoryId) throws Exception {
        Category category = categoryRepository.findById(categoryId)
                .orElseThrow(() -> new ExpressionException(String.valueOf(categoryId)));
        categoryRepository.delete(category);
        return category;
    }

}
