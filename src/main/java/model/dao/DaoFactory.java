package main.java.model.dao;

import main.java.db.DB;
import main.java.model.dao.impl.SellerDaoJDBC;

public class DaoFactory {
  
  public static SellerDao createSellerDao() {
    return new SellerDaoJDBC(DB.getConnection());
  }
}
