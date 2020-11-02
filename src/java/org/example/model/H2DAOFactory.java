package org.example.model;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class H2DAOFactory extends DAOFactory {

    public static final String DRIVER=
            "org.h2.Driver";
    public static final String DBURL=
            "jdbc:h2:~/database/trakkingAppData";



    public static Connection createConnection() {
        // Use DRIVER and DBURL to create a connection
        // Recommend connection pool implementation/usage
        try {
            Class.forName(DRIVER); //Проверяем наличие JDBC драйвера для работы с БД
            Connection connection = DriverManager.getConnection(DBURL);//соединениесБД
            System.out.println("Соединение с СУБД выполнено.");
         return  connection;
        } catch (ClassNotFoundException e) {
            e.printStackTrace(); // обработка ошибки  Class.forName
            System.out.println("JDBC драйвер для СУБД не найден!");
        } catch (SQLException e) {
            e.printStackTrace(); // обработка ошибок  DriverManager.getConnection
            System.out.println("Ошибка SQL !");
        }
        return null;
    }

    @Override
    public EquipmentDAO getEquipmentDAO() {
        return new H2EquipmentDAO();
    }

    @Override
    public ItemDAO getItemDAO() {
        return new H2ItemDAO();
    }

    @Override
    public EquipmentTypeDAO getItemTypeDAO() {
        return new H2EquipmentTypeDAO();
    }

    @Override
    public ProductDAO getProductDAO() {
        return new H2ProductDAO();
    }

    @Override
    public ProductMenuDAO getProductMenuDAO() {
        return new H2ProductMenuDAO();
    }

    @Override
    public ProductMenuTypeDAO getProductMenuTypeDAO() {
        return new H2ProductMenuTypeDAO();
    }

    @Override
    public ClientDAO getClientDAO() {
        return new H2ClientDAO();
    }

    @Override
    public RouteTypeDAO getRouteTypeDAO() {
        return new H2RouteTypeDAO();
    }


}
