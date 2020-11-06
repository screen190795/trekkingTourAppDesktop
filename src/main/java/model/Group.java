package model;

import java.io.Serializable;
/**
 * Класс описывает группу с привязкой к определенному маршруту
 */
public class Group implements Serializable {
    int clientId;
    int routeTypeId;

    public int getClientId() {
        return clientId;
    }

    public void setClientId(int clientId) {
        this.clientId = clientId;
    }

    public int getRouteTypeId() {
        return routeTypeId;
    }

    public void setRouteTypeId(int routeTypeId) {
        this.routeTypeId = routeTypeId;
    }

    @Override
    public String toString(){
        return "client's id = " + getClientId() + ", routeType's id = " + getRouteTypeId();
    }

}
