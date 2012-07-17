package com.ds.springexample.controller;

import com.ds.springexample.model.Product;
import com.ds.springexample.service.ProductManagerService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.inject.Inject;
import java.util.List;

/**
 * @author Dogukan Sonmez
 */

@Controller
@RequestMapping("/product/")
public class ProductController {

    private static final Logger logger = LoggerFactory.getLogger(ProductController.class);

    @Inject
    public ProductManagerService managerService;

    @RequestMapping(method = RequestMethod.GET, value = "edit")
    public ModelAndView editPerson(@RequestParam(value = "product", required = false) Product product) {
        logger.debug("Received request to edit person id : ");
        ModelAndView mav = new ModelAndView();
        mav.setViewName("edit");
        if (product == null) {
            product = new Product();
        }
        mav.addObject("product", product);
        return mav;
    }


    @RequestMapping(value = "{id}", method = RequestMethod.GET)
    public ModelAndView getProductById(@PathVariable Long id) {
        logger.info("Get product by id : " + id);
        ModelAndView mav = new ModelAndView();
        mav.setViewName("edit");
        Product product = null;
        if (id == null) {
            product = new Product();
        } else {
            product = managerService.getProductById(id);
        }
        mav.addObject("product", product);
        return mav;
    }


    @RequestMapping(value = "list", method = RequestMethod.GET)
    public ModelAndView getProducts() {
        List productList = managerService.getAllProducts();
        ModelAndView mv = new ModelAndView();
        mv.addObject("products", productList);
        mv.setViewName("list");
        logger.info("requesting /product");
        return mv;
    }


    @RequestMapping(method = RequestMethod.POST)
    public String addProduct(@ModelAttribute("product") Product product) {
        logger.info("Received post back on product " + product);
        managerService.saveProduct(product);
        logger.info("POSSSSSSSTTT");
        return "redirect:list";

    }

    @RequestMapping(method = RequestMethod.DELETE)
    public String deleteProduct(@PathVariable Long id) {
        logger.info("DELETEEEEE ");
        return "redirect:list";
    }

    @RequestMapping(method = RequestMethod.PUT)
    public String updateProduct() {
        logger.info("PUTTTTTT ");
        return "redirect:list";
    }


}
