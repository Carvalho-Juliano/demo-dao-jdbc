package main.java.model.dao.impl;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import main.java.db.DB;
import main.java.db.DbException;
import main.java.model.dao.DepartmentDao;
import main.java.model.entities.Department;

public class DepartmentDaoJDBC implements DepartmentDao {
  
  private Connection conn = null;

  public DepartmentDaoJDBC(Connection conn) {
    this.conn = conn;
  }

  @Override
  public void insert(Department obj) {
    PreparedStatement st = null;
    try {
      st = conn.prepareStatement(
            "INSERT INTO department "
            + "(Name) "
            + "VALUES "
            + "(?)",
          Statement.RETURN_GENERATED_KEYS);
      
      st.setString(1, obj.getName());

      int rowsAffected = st.executeUpdate();
      
      if (rowsAffected > 0) {
        ResultSet rs = st.getGeneratedKeys();
        if (rs.next()) {
          int id = rs.getInt(1);
          obj.setId(id);
        }
        DB.closeResultSet(rs);
      }
      
    } catch (SQLException e) {
      throw new DbException(e.getMessage());
    } finally {
      DB.closeStatement(st);
    }
  }

  @Override
  public void deleteById(Integer id) {
    PreparedStatement st = null;
    try {
      st = conn.prepareStatement(
        "DELETE FROM department "
        + "WHERE id = ? "
      );

      st.setInt(1, id);

      int rowsAffected = st.executeUpdate();
      if (rowsAffected == 0 ) {
        throw new DbException("Unexpected error! No rows affected");
      }
    } catch (SQLException e) {
      throw new DbException(e.getMessage());
    } finally {
      DB.closeStatement(st);
    }
  }

  @Override
  public void update(Department obj) {
    PreparedStatement st = null;
    try {
      st = conn.prepareStatement(
        "UPDATE department "
        + "SET Name = ? "
        + "WHERE Id = ? "
      );

      st.setString(1, obj.getName());
      st.setInt(2, obj.getId());

      st.executeUpdate();
    } catch (SQLException e) {
      throw new DbException(e.getMessage());
    } finally {
      DB.closeStatement(st);
    }
  }

  @Override
  public Department findById(Integer id) {
    PreparedStatement st = null;
    ResultSet rs = null;
    try {
      st = conn.prepareStatement(
        "SELECT * FROM department "
        + "WHERE id = ? "
        + "ORDER BY id");
      
      st.setInt(1, id);
      rs = st.executeQuery();
      if (rs.next()) {
        Department department = new Department();
        department.setId(rs.getInt("id"));
        department.setName(rs.getString("Name"));
        return department;
      }
      return null;
    } catch (SQLException e) {
      throw new DbException(e.getMessage());
    } finally {
      DB.closeStatement(st);
      DB.closeResultSet(rs);
    }

  }

  @Override
  public List<Department> findAll() {
    PreparedStatement st = null;
    ResultSet rs = null;

    try {
      st = conn.prepareStatement(
        "SELECT * FROM department "
        + "ORDER BY id "
      );

      rs = st.executeQuery();
      List<Department> departments = new ArrayList<>();
      
      while (rs.next()) {
          Department dp = new Department();
          dp.setId(rs.getInt("Id"));
          dp.setName(rs.getString("Name"));
          departments.add(dp);
      }
      return departments;
    } catch (SQLException e) {
      throw new DbException(e.getMessage());
    } finally {
      DB.closeStatement(st);
      DB.closeResultSet(rs);
    }
  }

  
}
