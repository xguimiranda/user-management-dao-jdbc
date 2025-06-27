package application;

import model.dao.DaoFactory;
import model.dao.DepartmentDao;
import model.entities.Department;

import java.util.List;
import java.util.Scanner;

public class Program2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        DepartmentDao dao = DaoFactory.createDepartmentDao();

        System.out.println("=== Test 1: findById ===");
        System.out.print("Enter Id you want to find: ");
        Integer id = sc.nextInt();
        Department department = dao.findById(id);
        System.out.println(department);

        System.out.println("=== Test 2: findAll ===");
        List<Department> departments = dao.findAll();
        for (Department d : departments) {
            System.out.println(d);
        }

        System.out.println("=== Test 3: update ===");
        System.out.print("Id want to update: ");
        int id2 = sc.nextInt();
        department = dao.findById(id2);
        System.out.print("Name you want to update: ");
        String name = sc.next();
        department.setName(name);
        dao.update(department);
        System.out.println("Updated completed");

        System.out.println("=== Test 4: insert ===");
        System.out.println("Enter da name for the new Department : ");
        String name2 = sc.next();
        Department newDepartment = new Department(null, name2);
        dao.insert(newDepartment);
        System.out.println("Inserted completed! New Id: " + newDepartment.getId());

        System.out.println("=== Test 5: delete ===");
        System.out.print("Id want to delete: ");
        int id3 = sc.nextInt();
        dao.deleteById(id3);
        System.out.println("Deleted completed");


        sc.close();
    }
}
