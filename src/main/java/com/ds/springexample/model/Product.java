package com.ds.springexample.model;

import javax.persistence.*;
import java.io.Serializable;

/**
 * @author Dogukan Sonmez
 */

@Entity
public class Product implements Serializable {

    @Id
	@GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column
    private String description;

    @Column
    private Double price;

    public Product(){

    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append(id)
                .append(description)
                .append(price);
        return sb.toString();
    }

}

