package main.java.application;

import java.time.LocalDateTime;

import main.java.model.entities.Department;
import main.java.model.entities.Seller;

public class Program {
  
  public static void main(String[] args) {

    LocalDateTime current = LocalDateTime.now();
    
    Department obj = new Department(1, "Books");

    Seller seller = new Seller(21, "Juliano", "Juliano@email.com", current, 3000.0, obj);

    System.out.println(seller);
    System.out.println(obj);
  }
}
