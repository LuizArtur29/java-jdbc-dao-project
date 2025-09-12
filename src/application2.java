import model.dao.DaoFactory;
import model.dao.DepartmentDao;
import model.entities.Department;
import model.entities.Seller;

import java.util.Date;
import java.util.List;
import java.util.Scanner;


public class application2 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        DepartmentDao departmentDao = DaoFactory.createDepartmentDao();

        System.out.println("==== TEST 1: department findById ====");
        Department department = departmentDao.findById(4);
        System.out.println(department);

        System.out.println("==== TEST 2: department findAll ====");
        List<Department> list = departmentDao.findAll();
        for (Department obj : list) {
            System.out.println(obj);
        }

        System.out.println("==== TEST 3: department insert ====");
        Department newDepartment = new Department(null, "Books");
        departmentDao.insert(newDepartment);
        System.out.println("Inserted! New Id: " + newDepartment.getId());

        System.out.println("==== TEST 4: department update ====");
        department = departmentDao.findById(4);
        department.setName("Mouses");
        departmentDao.update(department);
        System.out.println("Updated! New Id: " + department.getId());

        System.out.println("==== TEST 5: department delete ====");
        System.out.println("Enter id for delete test: ");
        int id = sc.nextInt();
        departmentDao.deleteById(id);
        System.out.println("Deleted! Id: " + id);

        sc.close();
    }
}