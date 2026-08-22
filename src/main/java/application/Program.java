package main.java.application;

import java.util.List;

import main.java.model.dao.DaoFactory;
import main.java.model.dao.SellerDao;
import main.java.model.entities.Department;
import main.java.model.entities.Seller;

public class Program {
  
  public static void main(String[] args) {

    SellerDao sellerDao = DaoFactory.createSellerDao();

    System.out.println("===== TESTE 1: seller findById =====");
    Seller seller = sellerDao.findById(3);
    System.out.println(seller);

    System.out.println("\n===== TESTE 2: seller findByDepartment =====");
    Department department = new Department(2, null);
    List<Seller> list = sellerDao.findByDepartment(department);
    for (Seller departmentSeller : list) {
      System.out.println(departmentSeller);
    }

    System.out.println("\n===== TESTE 3: seller findAll =====");
    list = sellerDao.findAll();
    for (Seller departmentSeller : list) {
      System.out.println(departmentSeller);
    }
  }
}
