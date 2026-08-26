package main.java.application;

import java.util.ArrayList;
import java.util.List;

import main.java.model.dao.DaoFactory;
import main.java.model.dao.DepartmentDao;
import main.java.model.entities.Department;

public class Program2 {
  
  public static void main(String[] args) {
   
    DepartmentDao departmentDao = DaoFactory.createDepartmentDao();

    System.out.println("\n===== TESTE 1: department findAll =====");
    List<Department> list = new ArrayList<>();
    list = departmentDao.findAll();
    for (Department department : list) {
      System.out.println(department);
    }

    System.out.println("\n===== TESTE 2: department findById =====");
    Department department = departmentDao.findById(2);
    System.out.println(department);

    System.out.println("\n===== TESTE 3: insert department =====");
    Department newDepartment = new Department(null, "Food");
    departmentDao.insert(newDepartment);
    System.out.println(newDepartment);

    System.out.println("\n===== TESTE 4: update department =====");
    department = departmentDao.findById(8);
    department.setName("Leo do frango");
    departmentDao.update(department);
    System.out.println("Update completed");

    System.out.println("\n===== TESTE 5: department deleteById =====");
    departmentDao.deleteById(7);
    System.out.println("Delete completed");


  }
}
