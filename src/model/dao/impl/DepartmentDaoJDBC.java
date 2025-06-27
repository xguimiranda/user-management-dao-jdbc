package model.dao.impl;

import DB.DB;
import DB.DbException;
import model.dao.DepartmentDao;
import model.entities.Department;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DepartmentDaoJDBC implements DepartmentDao {

    private Connection conn;

    public DepartmentDaoJDBC(Connection conn) {
        this.conn = conn;
    }

    @Override
    public void insert(Department obj) {
        PreparedStatement st = null;
        try{
            st = conn.prepareStatement(
                    "INSERT INTO department (Name) VALUES (?)",
                    Statement.RETURN_GENERATED_KEYS);

            st.setString(1, obj.getName());

            int rows = st.executeUpdate();
            if (rows > 0) {
                ResultSet rs = st.getGeneratedKeys();
                if (rs.next()){
                    int id = rs.getInt(1);
                    obj.setId(id);
                }
                DB.closeResultSet(rs);
            }
        }
        catch(SQLException e){
            throw new DbException(e.getMessage());
        }
        finally{
            DB.closeStatement(st);
        }
    }

    @Override
    public void update(Department obj) {
        PreparedStatement st = null;
        try{
            st = conn.prepareStatement(
                    "UPDATE department SET Name = ? WHERE Id = ?");

            st.setString(1, obj.getName());
            st.setInt(2, obj.getId());

            int rows = st.executeUpdate();
            if (rows == 0) {
                throw new DbException("Invalid Id number");
            }
        }
        catch (SQLException e){
            throw new DbException(e.getMessage());
        }
        finally{
            DB.closeStatement(st);
        }
    }

    @Override
    public void deleteById(Integer id) {
        PreparedStatement st = null;
        try {
            st = conn.prepareStatement("DELETE FROM department WHERE Id = ?");

            st.setInt(1, id);
            int rows = st.executeUpdate();
            if (rows == 0) {
                throw new DbException("Invalid Id number");
            }
        }
        catch (SQLException e){
            throw new DbException(e.getMessage());
        }
        finally{
            DB.closeStatement(st);
        }
    }

    @Override
    public Department findById(Integer id) {
        PreparedStatement st = null;
        ResultSet rs = null;
        try{
            st = conn.prepareStatement("SELECT * FROM department WHERE Id = ?");

            st.setInt(1, id);
            rs = st.executeQuery();
            if (rs.next()){
                Department obj = instantiateDepartment(rs);
                return obj;
            }
            else {
                return null;
            }
        }
        catch (SQLException e){
            throw new DbException(e.getMessage());
        }
        finally{
            DB.closeResultSet(rs);
            DB.closeStatement(st);
        }
    }

    @Override
    public List<Department> findAll() {
        PreparedStatement st = null;
        ResultSet rs = null;
        try{
            st = conn.prepareStatement("SELECT * FROM department ORDER BY Name");

            rs = st.executeQuery();
            List<Department> list = new ArrayList<>();
            while (rs.next()){
                Department obj = instantiateDepartment(rs);
                list.add(obj);
            }
            return list;
        }
        catch (SQLException e){
            throw new DbException(e.getMessage());
        }
        finally{
            DB.closeResultSet(rs);
            DB.closeStatement(st);
        }
    }

    private Department instantiateDepartment(ResultSet rs) throws SQLException{
        Department dep = new Department();
        dep.setId(rs.getInt("Id"));
        dep.setName(rs.getString("Name"));
        return dep;
    }
}
