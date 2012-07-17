package com.ds.springexample.service;

import com.ds.springexample.dao.ProductRepository;
import com.ds.springexample.model.Product;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Dogukan Sonmez
 */

@Service
public class ProductManagerService {

    private static final Logger logger = LoggerFactory.getLogger(ProductManagerService.class);

    @Autowired
    private ProductRepository repository;

    public Product getProductById(Long id) {
        if (id != null) {
            return repository.get(id);

        } else {
            return new Product();
        }
    }

    public List getAllProducts() {
        return repository.getAll();
    }


    public void saveProduct(Product product) {
        logger.info("-------------Service product: " + product);
        repository.save(product);

    }

    public void updateProduct(Product product) {
        repository.update(product);
    }

    public void deleteProduct(Long id) {

    }


}
