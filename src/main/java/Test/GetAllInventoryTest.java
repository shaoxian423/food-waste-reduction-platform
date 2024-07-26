package Test;

import com.duan.fwrp.dao.RetailerInventoryDAO;
import com.duan.fwrp.entity.RetailerInventory;

import java.sql.SQLException;
import java.util.List;

public class GetAllInventoryTest {
    public static void main(String[] args) {
        RetailerInventoryDAO inventoryDAO = new RetailerInventoryDAO();
        try {
            List<RetailerInventory> inventoryList = inventoryDAO.getAllInventory();
            for (RetailerInventory item : inventoryList) {
                System.out.println(item.getName() + " - " + item.getQuantity());
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
