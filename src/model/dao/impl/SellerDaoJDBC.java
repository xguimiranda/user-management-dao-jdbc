package model.dao.impl;

import model.dao.SellerDao;
import model.entities.Department;
import model.entities.Seller;

import java.util.List;

public class SellerDaoJDBC implements SellerDao {


    @Override
    public void insert(Seller obj) {
        // Implementation for inserting a Seller into the database
    }

    @Override
    public void update(Seller obj) {
        // Implementation for updating a Seller in the database
    }

    @Override
    public void deleteById(Integer id) {
        // Implementation for deleting a Seller by ID from the database
    }

    @Override
    public Seller findById(Integer id) {
        // Implementation for finding a Seller by ID in the database
        return null; // Placeholder return statement
    }

    @Override
    public List<Seller> findAll() {
        // Implementation for finding all Sellers in the database
        return null; // Placeholder return statement
    }

    @Override
    public List<Seller> findByDepartment(Department department) {
        // Implementation for finding Sellers by Department in the database
        return null; // Placeholder return statement
    }
}
