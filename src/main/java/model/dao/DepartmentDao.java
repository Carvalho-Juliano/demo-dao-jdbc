package main.java.model.dao;

import java.util.List;

import main.java.model.entities.Department;

public interface DepartmentDao {

  void insert(Department obj);
  void update(Department obj);
  void deletById(Integer id);
  Department findById(Integer id);
  List<Department> findAll();
}