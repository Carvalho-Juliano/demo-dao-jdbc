package main.java.model.dao;

import main.java.model.dao.impl.SellerDaoJDBC;

public class DaoFactory {
  
  public static SellerDao createSellerDao() {
    return new SellerDaoJDBC();
  }
}
