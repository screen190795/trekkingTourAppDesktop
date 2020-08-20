package model;

import javax.sql.RowSet;
import java.sql.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class H2ProductMenuTypeDAO implements ProductMenuTypeDAO {

    @Override
    public void insertProductMenuType(ProductMenuType productMenuType) {

        Connection connection = H2DAOFactory.createConnection();
        String sql = "INSERT INTO PRODUCT_MENU_TYPES VALUES(null, ?, ?, ?, ?, ?, ?, ?)";

        try {
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setString(1, productMenuType.getName());
            stm.setInt(2, productMenuType.getWeight());
            stm.setInt(3,productMenuType.getCalories());
            stm.setFloat(4,productMenuType.getProteins());
            stm.setFloat(5,productMenuType.getFats());
            stm.setFloat(6,productMenuType.getCarbohydrates());
            stm.setString(7,productMenuType.getDescription());
            stm.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

    }

    @Override
    public boolean deleteProductMenuType(int id) {
        String sql = "DELETE FROM PRODUCT_MENU_TYPES WHERE PRODUCT_MENU_TYPE_ID = ?";
        try (Connection connection = H2DAOFactory.createConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, id);
            statement.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        System.out.println("Запись успешно удалена");
        return true;
    }

    @Override
    public List<ProductMenuType> findAllProductMenuTypes() {
        List<ProductMenuType> productMenuTypeList = new ArrayList<>();
        String sql = "SELECT * FROM PRODUCT_MENU_TYPES";
        try (Connection connection = H2DAOFactory.createConnection()) {
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery(sql);
            while (rs.next()) {
                int id = rs.getInt(1);
                String name = rs.getString(2);
                int weight = rs.getInt(3);
                int calories = rs.getInt(4);
                float proteins = rs.getFloat(5);
                float fats = rs.getFloat(6);
                float carbohydrates = rs.getFloat(7);
                String description = rs.getString(8);
               ProductMenuType productMenuType = new ProductMenuType();
               productMenuType.setId(id);
                productMenuType.setName(name);
                productMenuType.setWeight(weight);
                productMenuType.setCalories(calories);
                productMenuType.setProteins(proteins);
                productMenuType.setFats(fats);
                productMenuType.setCarbohydrates(carbohydrates);
                productMenuType.setDescription(description);
                productMenuTypeList.add(productMenuType);
            }



        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return productMenuTypeList;
    }

    @Override
    public boolean updateProductMenuType(ProductMenuType productMenuType){
        Connection connection = H2DAOFactory.createConnection();
    String sql = "UPDATE PRODUCT_MENU_TYPES SET PRODUCT_MENU_TYPE_NAME=?, PRODUCT_MENU_TYPE_WEIGHT=?, PRODUCT_MENU_TYPE_CALORIES=?, PRODUCT_MENU_TYPE_PROTEINS=?, PRODUCT_MENU_TYPE_FATS=?, PRODUCT_MENU_TYPE_CARBOHYDRATES =?,PRODUCT_MENU_TYPE_DESCRIPTION =? WHERE PRODUCT_MENU_TYPE_ID=?";
        try {
        PreparedStatement stm = connection.prepareStatement(sql);
        stm.setInt(8, productMenuType.getId());
        stm.setString(1, productMenuType.getName());
        stm.setInt(2, productMenuType.getWeight());
        stm.setInt(3,productMenuType.getCalories());
        stm.setFloat(4,productMenuType.getProteins());
        stm.setFloat(5,productMenuType.getFats());
        stm.setFloat(6,productMenuType.getCarbohydrates());
        stm.setString(7,productMenuType.getDescription());
        int rowsAffected = stm.executeUpdate();
        stm.close();
        System.out.println(rowsAffected + " Rows affected");
    } catch (SQLException | NumberFormatException throwables) {
        throwables.printStackTrace();
    }
        return true;
    }


    public static void main(String[] args) {
        H2ProductMenuTypeDAO h2ProductMenuTypeDAO = new H2ProductMenuTypeDAO();
        h2ProductMenuTypeDAO.deleteProductMenuType(1);
        }

}
