package interfaces;

import java.sql.Connection;
import java.sql.SQLException;

public interface IConnectDatabase {
    
    Connection connect() throws SQLException;
}
