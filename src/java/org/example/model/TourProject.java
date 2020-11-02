package org.example.model;

import java.io.Serializable;
import java.util.List;

public class TourProject implements Serializable {
    String name;
    EquipmentType equipmentType;
List<Item> itemList;
ProductMenuType productMenuType;
List<Product> productList;
RouteType routeType;
List<Client> clientList;

    public EquipmentType getEquipmentType() {
        return equipmentType;
    }

    public void setEquipmentType(EquipmentType equipmentType) {
        this.equipmentType = equipmentType;
    }

    public List<Item> getItemList() {
        return itemList;
    }

    public void setItemList(List<Item> itemList) {
        this.itemList = itemList;
    }

    public ProductMenuType getProductMenuType() {
        return productMenuType;
    }

    @Override
    public String toString() {
        return "TourProject{" +
                "name='" + name + '\'' +
                ", equipmentType=" + equipmentType +
                ", itemList=" + itemList +
                ", productMenuType=" + productMenuType +
                ", productList=" + productList +
                ", routeType=" + routeType +
                ", clientList=" + clientList +
                '}';
    }

    public void setProductMenuType(ProductMenuType productMenuType) {
        this.productMenuType = productMenuType;
    }

    public List<Product> getProductList() {
        return productList;
    }

    public void setProductList(List<Product> productList) {
        this.productList = productList;
    }

    public RouteType getRouteType() {
        return routeType;
    }

    public void setRouteType(RouteType routeType) {
        this.routeType = routeType;
    }

    public List<Client> getClientList() {
        return clientList;
    }

    public void setClientList(List<Client> clientList) {
        this.clientList = clientList;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

