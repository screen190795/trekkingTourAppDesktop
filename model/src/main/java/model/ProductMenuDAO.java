package model;

import javax.sql.RowSet;
import java.util.Collection;
import java.util.List;

public interface ProductMenuDAO {
    void insertProductMenu(ProductMenu productMenu);
    boolean deleteProductMenu(int productId, int productMenuTypeId);
    List<ProductMenu> findAllProductMenu();
    List<ProductMenu> findProductMenuByType(int id);

}
