package test.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.expression.ExpressionException;
import org.springframework.web.bind.annotation.*;
import test.entity.Manufacturer;
import test.repository.ManufacturerRepository;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("ControlerAll")
public class RControlerManufacturer {
    private final ManufacturerRepository manufacturerRepository;

    @Autowired
    public RControlerManufacturer(ManufacturerRepository manufacturerRepository) {
        this.manufacturerRepository = manufacturerRepository;
    }

    @GetMapping("/Manufacturer")
    Iterable<Manufacturer> getAllManufacturer() {
        return (List<Manufacturer>) manufacturerRepository.findAll();
    }

    @GetMapping("/Manufacturer/{manufacturerId}")
    Optional<Manufacturer> getManufacturerId(@PathVariable Integer manufacturerId){
        return manufacturerRepository.findById(manufacturerId);
    }


    @GetMapping("/ManufacturerCreate")
    Manufacturer createManufacturer( @RequestParam(name  = "description", defaultValue = "") String description,
                             @RequestParam(name  = "name", defaultValue = "") String name,
                             @RequestParam(name  = "quantity", defaultValue = "") Integer quantity) {

        Manufacturer manufacturerCreate = new Manufacturer();
        manufacturerCreate.setDescription(description);
        manufacturerCreate.setName(name);
        manufacturerCreate.setQuantity(quantity);
        return manufacturerRepository.save(manufacturerCreate);
    }


    @RequestMapping("/Manufacturer")
    Manufacturer updateManufacturer( @RequestParam(name = "id", defaultValue = "") Integer id,
                             @RequestParam(name  = "description", defaultValue = "") String description,
                             @RequestParam(name  = "name", defaultValue = "") String name,
                             @RequestParam(name  = "quantity", defaultValue = "") Integer quantity) {
        Manufacturer manufacturer2 = new Manufacturer();
        if (manufacturerRepository.findAll().size() < id){
            manufacturer2 = createManufacturer(description, name, quantity);
        }
        else{
            Optional<Manufacturer> maybeManufacturer= manufacturerRepository.findById(id);
            Manufacturer manufacturer = maybeManufacturer
                    .orElseThrow(() -> new ExpressionException(String.valueOf(id)));
            manufacturer.setDescription(description);
            manufacturer.setName(name);
            manufacturer.setQuantity(quantity);
            manufacturer2 = manufacturer;
            manufacturerRepository.save(manufacturer);
        }
        return manufacturer2;
    }

    @GetMapping("/ManufacturerDelete/{manufacturerId}")
    Manufacturer deleteManufacturer(@PathVariable Integer manufacturerId) throws Exception {
        Manufacturer manufacturer = manufacturerRepository.findById(manufacturerId)
                .orElseThrow(() -> new ExpressionException(String.valueOf(manufacturerId)));
        manufacturerRepository.delete(manufacturer);
        return manufacturer;
    }
}
