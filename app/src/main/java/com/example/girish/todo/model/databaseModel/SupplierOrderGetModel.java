package com.example.girish.todo.model.databaseModel;

/**
 * Created by Girish on 8/18/2017.
 */
public class SupplierOrderGetModel {
    String productName;
    String productQuantity;
    String productImage;

    public SupplierOrderGetModel(String productName, String productQuantity, String productImage) {
        this.productName = productName;
        this.productQuantity = productQuantity;
        this.productImage = productImage;
    }

    public SupplierOrderGetModel(){
        super();
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getProductQuantity() {
        return productQuantity;
    }

    public void setProductQuantity(String productQuantity) {
        this.productQuantity = productQuantity;
    }

    public String getProductImage() {
        return productImage;
    }

    public void setProductImage(String productImage) {
        this.productImage = productImage;
    }
}
