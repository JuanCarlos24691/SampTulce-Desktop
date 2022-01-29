package interfaces;

import java.sql.ResultSet;
import java.sql.SQLException;

public interface IManagerData {
    
    public void select(String query) throws SQLException;
    
    public void select(String query, String database) throws SQLException;
    
    public void select(String query, String database, String server, String port) throws SQLException;
    
    public void select(String query, String database, String server, String port, String username, String password) throws SQLException;
    
    public void executeQuery(String query) throws SQLException;
    
    public void executeQuery(String query, String database) throws SQLException;
    
    public void executeQuery(String query, String database, String server, String port) throws SQLException;
    
    public void executeQuery(String query, String database, String server, String port, String username, String password) throws SQLException;
    
    public void SQLClose();
    
    public ResultSet getRs();
}