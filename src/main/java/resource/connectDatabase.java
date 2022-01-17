package resource;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import interfaces.IConnectDatabase;

public class connectDatabase implements IConnectDatabase {
    
    private String SERVER =   "52.167.129.168";
    private String PORT =     "3306";
    private String USERNAME = "server";
    private String PASSWORD = "Divclassphp900";
    private String DATABASE = "server";

    private Connection conection;
    
    public String getSERVER() {
        return this.SERVER;
    }

    public void setSERVER(String SERVER) {
        this.SERVER = SERVER;
    }

    public String getPORT() {
        return this.PORT;
    }

    public void setPORT(String PORT) {
        this.PORT = PORT;
    }

    public String getUSERNAME() {
        return this.USERNAME;
    }

    public void setUSERNAME(String USERNAME) {
        this.USERNAME = USERNAME;
    }

    public String getPASSWORD() {
        return this.PASSWORD;
    }

    public void setPASSWORD(String PASSWORD) {
        this.PASSWORD = PASSWORD;
    }

    public String getDATABASE() {
        return this.DATABASE;
    }

    public void setDATABASE(String DATABASE) {
        this.DATABASE = DATABASE;
    }

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
    
    
}