package resource;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import interfaces.IConnectDatabase;

public class connectDatabase implements IConnectDatabase {
    
    private final String SERVER =   "52.167.129.168";
    private final String PORT =     "3306";
    private final String USERNAME = "server";
    private final String PASSWORD = "Divclassphp900";
    private final String DATABASE = "server";

    private Connection conection;
    
    @Override
    public Connection connect() {
        try {
            this.conection = DriverManager.getConnection("jdbc:mysql://" + this.SERVER + ":" + this.PORT + "/" + this.DATABASE + "?useSSL=false&useTimezone=true&serverTimezone=UTC&allowPublicKeyRetrieval=true", this.USERNAME, this.PASSWORD);
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
            System.exit(1);
        }
        return this.conection;
    }

    @Override
    public Connection connect(String database) {
        try {
            this.conection = DriverManager.getConnection("jdbc:mysql://" + this.SERVER + ":" + this.PORT + "/" + database + "?useSSL=false&useTimezone=true&serverTimezone=UTC&allowPublicKeyRetrieval=true", this.USERNAME, this.PASSWORD);
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
            System.exit(1);
        }
        return this.conection;
    }

    @Override
    public Connection connect(String database, String server, String port) {
        try {
            this.conection = DriverManager.getConnection("jdbc:mysql://" + server + ":" + port + "/" + database + "?useSSL=false&useTimezone=true&serverTimezone=UTC&allowPublicKeyRetrieval=true", this.USERNAME, this.PASSWORD);
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
            System.exit(1);
        }
        return this.conection;
    }
    
    @Override
    public Connection connect(String database, String server, String port, String username, String password) {
        try {
            this.conection = DriverManager.getConnection("jdbc:mysql://" + server + ":" + port + "/" + database + "?useSSL=false&useTimezone=true&serverTimezone=UTC&allowPublicKeyRetrieval=true", username, password);
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
            System.exit(1);
        }
        return this.conection;
    }
}