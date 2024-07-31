package Test;
import com.duan.fwrp.dao.RetailerInventoryDAO;
import com.duan.fwrp.entity.RetailerInventory;

import java.sql.SQLException;
import java.util.List;

public class GetAllInventoryTest {
    public static void main(String[] args) throws SQLException {
        RetailerInventoryDAO inventoryDAO = new RetailerInventoryDAO();
        List<RetailerInventory> inventoryList = inventoryDAO.getAllRetailerInventories();
        for (RetailerInventory item : inventoryList) {
            System.out.println(item.getItemName() + " - " + item.getQuantity());
        }
    }
}
