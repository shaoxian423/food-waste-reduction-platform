package Test;

import com.duan.fwrp.dao.SurplusFoodDAO;

import java.sql.SQLException;

public class MarkAsSurplusTest {
    public static void main(String[] args) {
        SurplusFoodDAO surplusFoodDAO = new SurplusFoodDAO();
        try {
            surplusFoodDAO.markAsSurplus(1, true, 50.0);
            System.out.println("Marked as surplus successfully.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
