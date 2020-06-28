/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities_extend;

import entities.TblProductDetail;
import java.io.Serializable;

/**
 *
 * @author Admin
 */
public class Product implements Serializable {
    private Integer productId;
    private String productName;
    private Double priceOlder;
    private String description;
    private Integer status;
    private String imgProduct;
    private Integer producerId;
    private Integer subProductTypeId;

   
    private Double priceNew;
    private String imageex;

    public String getImageex() {
        return imageex;
    }

    public void setImageex(String imageex) {
        this.imageex = imageex;
    }

    public Product() {
    }

    public Product(Integer productId) {
        this.productId = productId;
    }

    public Product(Integer productId, String productName, Double priceOlder, String description, Integer status, String imgProduct, Integer producerId, Integer subProductTypeId) {
        this.productId = productId;
        this.productName = productName;
        this.priceOlder = priceOlder;
        this.description = description;
        this.status = status;
        this.imgProduct = imgProduct;
        this.producerId = producerId;
        this.subProductTypeId = subProductTypeId;
    }

     public Product(Integer productId, String productName, Double priceOlder, String description, Integer status, String imgProduct, Integer producerId, Integer subProductTypeId, String imgeex) {
        this.productId = productId;
        this.productName = productName;
        this.priceOlder = priceOlder;
        this.description = description;
        this.status = status;
        this.imgProduct = imgProduct;
        this.producerId = producerId;
        this.subProductTypeId = subProductTypeId;
        this.imageex =imgeex;
    }

    public Double getPriceNew() {
        return priceNew;
    }

    public void setPriceNew(Double priceNew) {
        this.priceNew = priceNew;
    }
    

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public Double getPriceOlder() {
        return priceOlder;
    }

    public void setPriceOlder(Double priceOlder) {
        this.priceOlder = priceOlder;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getImgProduct() {
        return imgProduct;
    }

    public void setImgProduct(String imgProduct) {
        this.imgProduct = imgProduct;
    }

    public Integer getProducerId() {
        return producerId;
    }

    public void setProducerId(Integer producerId) {
        this.producerId = producerId;
    }

    public Integer getSubProductTypeId() {
        return subProductTypeId;
    }

    public void setSubProductTypeId(Integer subProductTypeId) {
        this.subProductTypeId = subProductTypeId;
    }


    @Override
    public String toString() {
        return "entities.TblProduct[ productId=" + productId + " ]";
    }
    
}
