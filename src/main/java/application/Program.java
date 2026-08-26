package main.java.application;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Scanner;

import main.java.model.dao.DaoFactory;
import main.java.model.dao.SellerDao;
import main.java.model.entities.Department;
import main.java.model.entities.Seller;

public class Program {
  
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

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

    System.out.println("\n===== TESTE 4: seller insert =====");
    Seller newSeller = new Seller(null, "Greg", "greg@gmail.com", LocalDateTime.now(), 4000.0, department);
    sellerDao.insert(newSeller);
    System.out.println("Inserted! New id = " + newSeller.getId());


    System.out.println("\n===== TESTE 5: seller update =====");
    seller = sellerDao.findById(1);
    seller.setName("Martha Waine");
    sellerDao.update(seller);
    System.out.println("Update completed");

    System.out.println("\n===== TESTE 6: seller delete =====");
    System.out.print("Enter id for delete test: ");
    int id = sc.nextInt();
    sellerDao.deletById(id);
    System.out.println("Delete completed");

    sc.close();
  }
}
