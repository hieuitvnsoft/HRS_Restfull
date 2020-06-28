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
public class ShipMethod {
   
    private Integer shipMethodId;
    private String shipMethodName;

    public ShipMethod(Integer shipMethodId, String shipMethodName) {
        this.shipMethodId = shipMethodId;
        this.shipMethodName = shipMethodName;
    }

    public Integer getShipMethodId() {
        return shipMethodId;
    }

    public void setShipMethodId(Integer shipMethodId) {
        this.shipMethodId = shipMethodId;
    }

    public String getShipMethodName() {
        return shipMethodName;
    }

    public void setShipMethodName(String shipMethodName) {
        this.shipMethodName = shipMethodName;
    }
    
   
}
