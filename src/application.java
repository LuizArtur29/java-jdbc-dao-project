import model.dao.DaoFactory;
import model.dao.SellerDao;
import model.entities.Department;
import model.entities.Seller;

import java.util.List;


public class application {

    public static void main(String[] args) {

        SellerDao sellerDao = DaoFactory.createSellerDao();

        Department department = new Department();
        department.setId(2);
        List<Seller> list = sellerDao.findByDepartment(department);
        for (Seller seller : list) {
            System.out.println(seller);
        }

        System.out.println(department);
    }
}
