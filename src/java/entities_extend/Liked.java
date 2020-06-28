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
public class Liked {
    int Id;
    int userId;

    public int getId() {
        return Id;
    }

    public void setId(int Id) {
        this.Id = Id;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public int getStartus() {
        return startus;
    }

    public void setStartus(int startus) {
        this.startus = startus;
    }

    public Liked(int Id, int userId, int productId, int startus) {
        this.Id = Id;
        this.userId = userId;
        this.productId = productId;
        this.startus = startus;
    }

    public Liked() {
    }
    int productId;
    int startus;
}
