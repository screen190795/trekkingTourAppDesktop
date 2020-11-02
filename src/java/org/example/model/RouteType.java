package org.example.model;

import java.io.Serializable;

public class RouteType implements Serializable {

    int routeTypeId;
    String routeTypeName;
    double routeTypeStartX;
    double RouteTypeStartY;
    double routeTypeFinishX;
    double routeTypeFinishY;
    float routeTypeDistance;

    public String getRouteTypeDescription() {
        return routeTypeDescription;
    }

    public void setRouteTypeDescription(String routeTypeDescription) {
        this.routeTypeDescription = routeTypeDescription;
    }

    String routeTypeDescription;
    float routeTypeDuration;

    public int getRouteTypeId() {
        return routeTypeId;
    }

    public void setRouteTypeId(int routeTypeId) {
        this.routeTypeId = routeTypeId;
    }

    public String getRouteTypeName() {
        return routeTypeName;
    }

    public void setRouteTypeName(String routeTypeName) {
        this.routeTypeName = routeTypeName;
    }

    public double getRouteTypeStartX() {
        return routeTypeStartX;
    }

    public void setRouteTypeStartX(double routeTypeStartX) {
        this.routeTypeStartX = routeTypeStartX;
    }

    public double getRouteTypeStartY() {
        return RouteTypeStartY;
    }

    public void setRouteTypeStartY(double routeTypeStartY) {
        RouteTypeStartY = routeTypeStartY;
    }

    public double getRouteTypeFinishX() {
        return routeTypeFinishX;
    }

    public void setRouteTypeFinishX(double routeTypeFinishX) {
        this.routeTypeFinishX = routeTypeFinishX;
    }

    public double getRouteTypeFinishY() {
        return routeTypeFinishY;
    }

    public void setRouteTypeFinishY(double routeTypeFinishY) {
        this.routeTypeFinishY = routeTypeFinishY;
    }

    public float getRouteTypeDistance() {
        return routeTypeDistance;
    }

    public void setRouteTypeDistance(float routeTypeDistance) {
        this.routeTypeDistance = routeTypeDistance;
    }

    public float getRouteTypeDuration() {
        return routeTypeDuration;
    }

    public void setRouteTypeDuration(float routeTypeDuration) {
        this.routeTypeDuration = routeTypeDuration;
    }

    @Override
    public String toString() {
        return "RouteType{" +
                "routeTypeId=" + routeTypeId +
                ", Наименование='" + routeTypeName + '\'' +
                ", Точка отправления, широта=" + routeTypeStartX +
                ", Точка отправления, долгота=" + RouteTypeStartY +
                ", Точка прибытия, широта=" + routeTypeFinishX +
                ", Точка прибытия, долгота=" + routeTypeFinishY +
                ", Общее расстояние=" + routeTypeDistance +
                ", Дополнительные сведения='" + routeTypeDescription + '\'' +
                ", Продолжительность маршрута=" + routeTypeDuration +
                '}';
    }
}
