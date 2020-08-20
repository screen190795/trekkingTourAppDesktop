package model;

import javax.sql.RowSet;
import java.util.Collection;
import java.util.List;

public interface ProductMenuTypeDAO {
    void insertProductMenuType(ProductMenuType productMenuType);
    boolean deleteProductMenuType(int id);
    List<ProductMenuType> findAllProductMenuTypes();
    boolean updateProductMenuType(ProductMenuType productMenuType);

}
