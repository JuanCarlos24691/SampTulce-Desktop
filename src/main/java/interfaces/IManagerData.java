package interfaces;

import java.sql.ResultSet;
import java.sql.SQLException;

public interface IManagerData {
    
    public void select(String query) throws SQLException;
    
    public void executeQuery(String query) throws SQLException;
    
    public void SQLClose();
    
   public ResultSet getRs();
    
}