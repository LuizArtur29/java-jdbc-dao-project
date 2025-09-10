import model.dao.SellerDao;
import model.dao.impl.SellerDaoJDBC;
import model.entities.Department;
import model.entities.Seller;

import java.util.Date;

public class application {

    public static void main(String[] args) {

        Department obj = new Department(1, "books");

        Seller seller = new Seller(21, 3000.0, new Date(), "bob@gmail.com", "Bob", obj);

        SellerDao sellerDao = new SellerDaoJDBC();

        System.out.println(seller);
    }
}
