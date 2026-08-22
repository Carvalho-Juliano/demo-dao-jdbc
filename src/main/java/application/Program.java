package main.java.application;

import main.java.model.dao.DaoFactory;
import main.java.model.dao.SellerDao;
import main.java.model.entities.Seller;

public class Program {
  
  public static void main(String[] args) {

    SellerDao sellerDao = DaoFactory.createSellerDao();

    Seller seller = sellerDao.findById(3);

    System.out.println(seller);
  }
}
