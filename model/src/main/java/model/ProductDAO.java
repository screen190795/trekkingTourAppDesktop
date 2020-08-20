package model;

import javax.sql.RowSet;
import java.util.Collection;
import java.util.List;

public interface ProductDAO {
    void insertProduct(Product product);
    boolean deleteProduct(int id);
    boolean updateProduct(Product product);
    List<Product> findAll();
    Product selectProductById(int id);

}
