package application;

import model.entities.Department;
import model.entities.Seller;

import java.util.Date;

public class Program {
    public static void main(String[] args) {

        Department obj = new Department("Books", 1);

        Seller seller = new Seller(1, "Bob", "bob@gamil.com", 3000.0, new Date(), obj);
        System.out.println(seller);
    }
}
