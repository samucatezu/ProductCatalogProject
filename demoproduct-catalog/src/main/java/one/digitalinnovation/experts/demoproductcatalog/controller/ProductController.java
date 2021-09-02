package one.digitalinnovation.experts.demoproductcatalog.controller;


import one.digitalinnovation.experts.demoproductcatalog.model.Product;
import one.digitalinnovation.experts.demoproductcatalog.repository.ProducRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping(value = "/product")
public class ProductController {

    @Autowired
    private ProducRepository producRepository;

    @RequestMapping(method = RequestMethod.POST)
    Product create(@RequestBody Product product) {

        return  producRepository.save(product);

    }

    @RequestMapping(value ="/{id", method = RequestMethod.GET)
    Optional<Product> findByID(@PathVariable Integer id){
        return producRepository.findById(id);

    }
}
