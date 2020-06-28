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
public class SubProductType {
      private Integer subProductTypeId;
   
    private String subProductTypeName;
   
   

    public SubProductType() {
    }

    public SubProductType(Integer subProductTypeId, String subProductTypeName) {
        this.subProductTypeId = subProductTypeId;
        this.subProductTypeName = subProductTypeName;
       
    }

    public Integer getSubProductTypeId() {
        return subProductTypeId;
    }

    public void setSubProductTypeId(Integer subProductTypeId) {
        this.subProductTypeId = subProductTypeId;
    }

    public String getSubProductTypeName() {
        return subProductTypeName;
    }

    public void setSubProductTypeName(String subProductTypeName) {
        this.subProductTypeName = subProductTypeName;
    }

   

    @Override
    public String toString() {
        return subProductTypeName;
    }
    
}
