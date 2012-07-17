package com.ds.springexample.dao;

import com.ds.springexample.model.Product;
import org.hibernate.annotations.Entity;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

/**
 * @author Dogukan Sonmez
 */

@Repository
public class ProductRepository {

    private static final Logger logger = LoggerFactory.getLogger(ProductRepository.class);

    @PersistenceContext
    private EntityManager entityManager;


    public void save(Product product) {
        logger.info("Product repository save product:" + product);
        EntityManager em = entityManager.getEntityManagerFactory().createEntityManager();
        em.getTransaction().begin();
        em.persist(product);
        em.getTransaction().commit();
        logger.info("entity manager" + entityManager);
    }

    public void update(Product product) {
        entityManager.merge(product);
        entityManager.getTransaction().commit();
    }

    @Transactional(readOnly = true)
    public Product get(Long id) {
        logger.info("get product by id:" + id);
        return entityManager.find(Product.class, id);
    }

    @Transactional(readOnly = true)
    public List getAll() {
        return entityManager.createQuery("select p from Product p").getResultList();
    }

}