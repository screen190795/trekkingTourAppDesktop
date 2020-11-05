package model;

public abstract class DAOFactory {

    public abstract EquipmentDAO getEquipmentDAO();
    public abstract ItemDAO getItemDAO();
    public abstract EquipmentTypeDAO getItemTypeDAO();
    public abstract ProductDAO getProductDAO();
    public abstract ProductMenuDAO getProductMenuDAO();
    public abstract ProductMenuTypeDAO getProductMenuTypeDAO();
    public abstract ClientDAO getClientDAO();
    public abstract RouteTypeDAO getRouteTypeDAO();
    public static DAOFactory getDAOFactory(){
        return  new H2DAOFactory();
    }
}
