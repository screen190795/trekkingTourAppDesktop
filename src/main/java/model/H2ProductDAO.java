package model;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class H2ProductDAO implements ProductDAO {


    public static void main(String[] args){
        H2ProductDAO h2ProductDAO = new H2ProductDAO();
        h2ProductDAO.findAll();
        System.out.println("OK");
    }



    @Override
    public void insertProduct(Product product) {
        Connection connection = H2DAOFactory.createConnection();
        String sql = "INSERT INTO PRODUCTS VALUES(null, ?, ?, ?, ?, ?, ?, ?)";

        try {
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setString(1, product.getName());
            stm.setFloat(2, product.getWeight());
            stm.setFloat(3,product.getCalories());
            stm.setFloat(4,product.getProteins());
            stm.setFloat(5,product.getFats());
            stm.setFloat(6,product.getCarbohydrates());
            stm.setString(7,product.getDescription());
            stm.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    @Override
    public boolean deleteProduct(int id) {

        String sql = "DELETE FROM PRODUCTS WHERE PRODUCT_ID = ?";
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
    public boolean updateProduct(Product product) {
        Connection connection = H2DAOFactory.createConnection();
        String sql = "UPDATE PRODUCTS SET PRODUCT_NAME=?, PRODUCT_WEIGHT=?, PRODUCT_CALORIES=?, PRODUCT_PROTEINS=?, PRODUCT_FATS =?, PRODUCT_CARBOHYDRATES =?,PRODUCT_DESCRIPTION =? WHERE PRODUCT_ID=?";
        try {
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setInt(8, product.getId());
            stm.setString(1, product.getName());
            stm.setFloat(2, product.getWeight());
            stm.setFloat(3,product.getCalories());
            stm.setFloat(4,product.getProteins());
            stm.setFloat(5,product.getFats());
            stm.setFloat(6,product.getCarbohydrates());
            stm.setString(7,product.getDescription());
            int rowsAffected = stm.executeUpdate();
            stm.close();
            System.out.println(rowsAffected + " Rows affected");
        } catch (SQLException | NumberFormatException throwables) {
            throwables.printStackTrace();
        }
        return true;
    }

    @Override
    public List<Product> findAll() {
        List<Product> products = new ArrayList<>();
                String sql = "SELECT * FROM PRODUCTS";
                try (Connection connection = H2DAOFactory.createConnection()) {
                    Statement statement = connection.createStatement();
                    ResultSet rs = statement.executeQuery(sql);
                    while (rs.next()) {
                        int id = rs.getInt(1);
                        String name = rs.getString(2);
                        float weight = rs.getFloat(3);
                        float calories = rs.getFloat(4);
                        float proteins = rs.getFloat(5);
                        float fats = rs.getFloat(6);
                        float carbohydrates = rs.getFloat(7);
                        String description = rs.getString(8);
                        Product product = new Product();
                        product.setId(id);
                        product.setName(name);
                        product.setWeight(weight);
                        product.setCalories(calories);
                        product.setProteins(proteins);
                        product.setFats(fats);
                        product.setCarbohydrates(carbohydrates);
                        product.setDescription(description);
                        products.add(product);
            }



        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return products;
    }

    @Override
    public Product selectProductById(int id) {
        String sql = "SELECT * FROM PRODUCTS WHERE PRODUCT_ID = ?";
        Product product = new Product();
        product.setId(id);

        try (Connection connection = H2DAOFactory.createConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, id);
            ResultSet rs = statement.executeQuery();
            if (rs.next()) {
                int productId = rs.getInt(1);
                String name = rs.getString(2);
                float weight = rs.getFloat(3);
                float calories = rs.getFloat(4);
                float proteins = rs.getFloat(5);
                float fats = rs.getFloat(6);
                float carbohydrates = rs.getFloat(7);
                String description = rs.getString(8);
                product.setId(productId);
                product.setName(name);
                product.setWeight(weight);
                product.setCalories(calories);
                product.setProteins(proteins);
                product.setFats(fats);
                product.setCarbohydrates(carbohydrates);
                product.setDescription(description);
            }

        } catch (SQLException | NumberFormatException throwables) {
            throwables.printStackTrace();
        }
        return product;
    }
}
