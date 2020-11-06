package model;

import java.io.Serializable;


/**
 * Класс описывает привязку продуктов к определенным продуктовым наборам
 */
public class ProductMenu implements Serializable {
    int productId;
    int productMenuTypeId;

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public int getProductMenuTypeId() {
        return productMenuTypeId;
    }

    public void setProductMenuTypeId(int productMenuTypeId) {
        this.productMenuTypeId = productMenuTypeId;
    }
    @Override
    public String toString(){
        return "id продукта = " + getProductId() + "id типа продуктового меню= " + getProductMenuTypeId();
    }

}
