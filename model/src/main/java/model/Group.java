package model;

import java.io.Serializable;

public class Group implements Serializable {
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

    int clientId;
    int routeTypeId;



    @Override
    public String toString(){
        return "client's id = " + getClientId() + ", routeType's id = " + getRouteTypeId();
    }

}
