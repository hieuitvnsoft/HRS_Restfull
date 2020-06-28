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
public class Result {
     int id;
    String message;

    public Result(int id, String message) {
        this.id = id;
        this.message = message;
    }

    public Result() {
     
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
    
}
