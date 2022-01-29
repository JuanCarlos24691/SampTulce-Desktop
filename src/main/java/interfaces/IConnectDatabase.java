package interfaces;

import java.sql.Connection;
import java.sql.SQLException;

public interface IConnectDatabase {
    
    Connection connect() throws SQLException;
    
    Connection connect(String database) throws SQLException;
    
    Connection connect(String database, String server, String port) throws SQLException;
    
    Connection connect(String database, String server, String port, String username, String password) throws SQLException;
}
