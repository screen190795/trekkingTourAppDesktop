package org.example.model;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class H2ProductMenuDAO implements ProductMenuDAO {


    @Override
    public void insertProductMenu(ProductMenu productMenu) {
        Connection connection = H2DAOFactory.createConnection();
        String sql = "INSERT INTO PRODUCT_MENU VALUES(?, ?)";

        try {
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setInt(1, productMenu.getProductId());
            stm.setInt(2, productMenu.getProductMenuTypeId());
            stm.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    @Override
    public boolean deleteProductMenu(int productId, int productMenuTypeId) {
        String sql = "DELETE FROM PRODUCT_MENU WHERE (PRODUCT_ID = ?) AND (PRODUCT_MENU_TYPE_ID = ?)";
        try (Connection connection = H2DAOFactory.createConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, productId);
            statement.setInt(2, productMenuTypeId);
            statement.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        System.out.println("Запись успешно удалена");
        return true;
    }

    @Override
    public List<ProductMenu> findAllProductMenu() {
        List<ProductMenu> productMenuList = new ArrayList<>();
        String sql = "SELECT * FROM PRODUCT_MENU";
        try (Connection connection = H2DAOFactory.createConnection()) {
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery(sql);
            while (rs.next()) {
                int productId = rs.getInt(1);
                int productMenuTypeId = rs.getInt(2);
                ProductMenu productMenu = new ProductMenu();
                productMenu.setProductId(productId);
                productMenu.setProductMenuTypeId(productMenuTypeId);
                productMenuList.add(productMenu);
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return productMenuList;
    }

    @Override
    public List<ProductMenu> findProductMenuByType(int id) {
       H2ProductDAO h2ProductDAO = new H2ProductDAO();
        List<ProductMenu> productMenuList = new ArrayList<>();
        String sql = "SELECT * FROM PRODUCT_MENU";
        try (Connection connection = H2DAOFactory.createConnection();
             Statement statement = connection.createStatement()) {
            ResultSet rs = statement.executeQuery(sql);

            while (rs.next()) {
                int productId = rs.getInt(1);
                int productMenuTypeId = rs.getInt(2);
                if (productMenuTypeId == id) {
                    Product product = h2ProductDAO.selectProductById(productId);

                    ProductMenu productMenu = new ProductMenu();
                    productMenu.setProductId(productId);
                    productMenu.setProductMenuTypeId(productMenuTypeId);
                    productMenuList.add(productMenu);
                }
            }


        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return productMenuList;
    }

    public static void main(String[] args) {
        ProductMenu productMenu = new ProductMenu();
        H2ProductMenuDAO h2ProductMenuDAO = new H2ProductMenuDAO();
        List<ProductMenu> productMenuList = h2ProductMenuDAO.findProductMenuByType(1);
        for(ProductMenu productMenu1: productMenuList){
            System.out.println(productMenu1.getProductId() + " " + productMenu1.getProductMenuTypeId());
        }

    }
}
