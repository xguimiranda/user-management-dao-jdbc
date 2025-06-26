package application;

import model.dao.DaoFactory;
import model.dao.SellerDao;
import model.entities.Department;
import model.entities.Seller;

import java.util.List;

public class Program {
    public static void main(String[] args) {

        SellerDao sellerDao = DaoFactory.createSellerDao();

        System.out.println("=== TEST 1: seller findById ===");
        Seller seller = sellerDao.findById(3);
        System.out.println(seller);

        System.out.println("\n === TEST 2: seller findByDepartment ===");
        List<Seller> list = sellerDao.findByDepartment(new Department(null, 2));
        for (Seller obj : list) {
            System.out.println(obj);
        }

        System.out.println("\n === TEST 3: seller findAll ===");
        list = sellerDao.findAll();
        for (Seller obj : list) {
            System.out.println(obj);
        }

        System.out.println("\n === TEST 4: seller findAll ===");
        Seller newSeller = new Seller(null, "Greg", "greg@gmail.com", 4000.0, new java.util.Date(), new Department(null, 2));
        sellerDao.insert(newSeller);
        System.out.println("Inserted! New id = " + newSeller.getId());

    }
}
