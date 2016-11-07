package com.products.entities;

import javax.persistence.*;
import java.util.Date;
/**
 * Created by vladimir on 06.04.2016.
 */
@Entity
@Table(name = "product")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id")
    private Long id;
    @Column(name="name", nullable = false)
    private String name;
    @Column(name="manuf_name")
    private String manufacturer;
    @Column(name="price", nullable = false)
    private Long price;
    @Column(name="dt_adding", nullable = false)
    private Date addingToCatalogDate;
    @Column(name="descr")
    private String descritpion;
    @Column(name="photo")
    private byte[] photo;
    @ManyToOne(targetEntity = Category.class )
    @JoinColumn(name="cat_id")
//    @Column(name = "cat_id")
    private Category category;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescritpion() {
        return descritpion;
    }

    public void setDescritpion(String descritpion) {
        this.descritpion = descritpion;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public Long getPrice() {
        return price;
    }

    public void setPrice(Long price) {
        this.price = price;
    }

    public Date getAddingToCatalogDate() {
        return addingToCatalogDate;
    }

    public void setAddingToCatalogDate(Date addingToCatalogDate) {
        this.addingToCatalogDate = addingToCatalogDate;
    }

    public byte[] getPhoto() {
        return photo;
    }

    public void setPhoto(byte[] photo) {
        this.photo = photo;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", manufacturer='" + manufacturer + '\'' +
                ", price=" + price +
                ", addingToCatalogDate=" + addingToCatalogDate +
                ", descritpion='" + descritpion + '\'' +
                ", photo=" + photo == null? "no" : "there is" +
                ", category=" + category +
                '}';
    }
}
