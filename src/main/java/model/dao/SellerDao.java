package main.java.model.dao;

import java.util.List;

import main.java.model.entities.Department;
import main.java.model.entities.Seller;

public interface SellerDao {

  public void insert(Seller obj);
  public void update(Seller obj);
  public void deleteById(Integer id);
  public Seller findById(Integer id);
  public List<Seller> findAll();
  public List<Seller> findByDepartment(Department department); 
}
