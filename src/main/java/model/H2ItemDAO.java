package model;

import javax.sql.RowSet;
import java.sql.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class H2ItemDAO implements ItemDAO {

    @Override
    public void insertItem(Item item) {
        Connection connection = H2DAOFactory.createConnection();
        String sql = "INSERT INTO ITEMS VALUES(null, ?, ?, ?, ?)";

        try {
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setString(1, item.getName());
            stm.setFloat(2, item.getWeight());
            stm.setFloat(3, item.getVolume());
            stm.setString(4, item.getDescription());
            stm.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    @Override
    public boolean deleteItem(int id) {
        String sql = "DELETE FROM ITEMS WHERE ITEM_ID = ?";
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

    public Item findItemById(int key) throws SQLException {
        String sql = "SELECT * FROM ITEMS WHERE ITEM_ID = ?";
        Item item = new Item();
        item.setId(key);

        try (Connection connection = H2DAOFactory.createConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, key);
            ResultSet rs = statement.executeQuery();
            if (rs.next()) {
                int id = rs.getInt(1);
                String name = rs.getString(2);
                float weight = rs.getFloat(3);
                float volume = rs.getFloat(4);
                String description = rs.getString(5);
                item.setId(id);
                item.setName(name);
                item.setWeight(weight);
                item.setVolume(volume);
                item.setDescription(description);
            }

        } catch (SQLException | NumberFormatException throwables) {
            throwables.printStackTrace();
        }
        return item;
    }

    @Override
    public List<Item> findAll() {
        List<Item> items = new ArrayList<>();
        String sql = "SELECT * FROM ITEMS";
        try (Connection connection = H2DAOFactory.createConnection()) {
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery(sql);
            while (rs.next()) {
                int id = rs.getInt(1);
                String name = rs.getString(2);
                float weight = rs.getFloat(3);
                float volume = rs.getFloat(4);
                String description = rs.getString(5);
                Item item = new Item();
                item.setId(id);
                item.setName(name);
                item.setWeight(weight);
                item.setVolume(volume);
                item.setDescription(description);
                items.add(item);
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return items;
    }

    @Override
    public boolean updateItem(Item item) {

        String sql = "UPDATE ITEMS SET ITEM_NAME=?, ITEM_WEIGHT=?, ITEM_VOLUME=?, ITEM_DESCRIPTION=? WHERE ITEM_ID=?";
        try (Connection connection = H2DAOFactory.createConnection();

             PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(5, item.getId());
            statement.setString(1, item.getName());
            statement.setFloat(2, item.getWeight());
            statement.setFloat(3, item.getVolume());
            statement.setString(4, item.getDescription());

            int rowsAffected = statement.executeUpdate();
            statement.close();

            System.out.println(rowsAffected + " Rows affected");
            System.out.println("Items.Item with id " + item.getId() + " was updated in DB with following details: " + item.getName() + " " + item.getWeight() + " " + item.getVolume() + " " + item.getDescription());


        } catch (SQLException | NumberFormatException throwables) {
            throwables.printStackTrace();
        }
        return true;
    }

    @Override
    public RowSet selectItemRS() {
        return null;
    }

    @Override
    public Collection selectItemTO() {
        return null;
    }
}
