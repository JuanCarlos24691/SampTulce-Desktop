package resource;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import interfaces.IConnectDatabase;

public class connectDatabase implements IConnectDatabase{
    
    private final String SERVER =   "127.0.0.1";
    private final String PORT =     "3306";
    private final String USERNAME = "root";
    private final String PASSWORD = "";
    private final String DATABASE = "db2";

    private Connection conection;
    
    @Override
    public Connection connect() throws SQLException {

        this.conection = DriverManager.getConnection("jdbc:mysql://" + this.SERVER + ":" + this.PORT + "/" + this.DATABASE + "?useSSL=false&useTimezone=true&serverTimezone=UTC&allowPublicKeyRetrieval=true", this.USERNAME, this.PASSWORD);
        return conection;
    }
}