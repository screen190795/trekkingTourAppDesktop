package model;

import java.sql.SQLException;
import java.util.List;

public interface ItemDAO {
    void insertItem(Item item);
    boolean deleteItem(int id);
    Item findItemById(int key) throws SQLException;
    List<Item> findAll();
    boolean updateItem(Item item);
}
