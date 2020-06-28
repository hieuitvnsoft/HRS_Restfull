/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities_extend;


/**
 *
 * @author Admin
 */
public class ProductDetail {
    
     private Integer id;
    private Double priceNew;
    private Integer quantity;
    private String imgProduct;
    private String colorName;
    private Integer productId;
    private String sizeName;
    
    private String productName;
    private String colorCode;
    private String description;
    private String producerName;
    private String subProductTypeName;


    public String getColorName() {
        return colorName;
    }

    public void setColorName(String colorName) {
        this.colorName = colorName;
    }

    public String getSizeName() {
        return sizeName;
    }

    public void setSizeName(String sizeName) {
        this.sizeName = sizeName;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

   

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getProducerName() {
        return producerName;
    }

    public void setProducerName(String producerName) {
        this.producerName = producerName;
    }

    public String getSubProductTypeName() {
        return subProductTypeName;
    }

    public void setSubProductTypeName(String subProductTypeName) {
        this.subProductTypeName = subProductTypeName;
    }

  

    public ProductDetail(Integer id, Double priceNew, Integer quantity, String imgProduct, String colorName, Integer productId, String sizeName, String productName, String colorCode, String description, String producerName, String subProductTypeName) {
        this.id = id;
        this.priceNew = priceNew;
        this.quantity = quantity;
        this.imgProduct = imgProduct;
        this.colorName = colorName;
        this.productId = productId;
        this.sizeName = sizeName;
        this.productName = productName;
        this.colorCode = colorCode;
        this.description = description;
        this.producerName = producerName;
        this.subProductTypeName = subProductTypeName;
       
    }

    public String getColorCode() {
        return colorCode;
    }

    public void setColorCode(String colorCode) {
        this.colorCode = colorCode;
    }

   

   
    public ProductDetail() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Double getPriceNew() {
        return priceNew;
    }

    public void setPriceNew(Double priceNew) {
        this.priceNew = priceNew;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

   

    public String getImgProduct() {
        return imgProduct;
    }

    public void setImgProduct(String imgProduct) {
        this.imgProduct = imgProduct;
    }



    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    
}
