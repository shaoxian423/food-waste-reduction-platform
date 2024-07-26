package Test;
import com.duan.fwrp.dao.SurplusFoodDAO;
import com.duan.fwrp.entity.SurplusFood;

import java.sql.SQLException;
import java.util.List;

public class SurplusFoodDAOTest {
    public static void main(String[] args) {
        SurplusFoodDAO surplusFoodDAO = new SurplusFoodDAO();
        try {
            List<SurplusFood> surplusFoodList = surplusFoodDAO.getAllSurplusFood();
            for (SurplusFood surplusFood : surplusFoodList) {
                System.out.println(surplusFood.getInventoryId() + " - " + surplusFood.isForSale());
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
