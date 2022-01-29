package resource;

import interfaces.IManagerData;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class managerData implements IManagerData{
    
    private PreparedStatement pstmt;
    private ResultSet rs;
    
    @Override
    public void select(String query) throws SQLException {
        this.pstmt = new connectDatabase().connect().prepareStatement(query);
        this.rs = this.pstmt.executeQuery();
    }

    @Override
    public void select(String query, String database) throws SQLException {
        this.pstmt = new connectDatabase().connect(database).prepareStatement(query);
        this.rs = this.pstmt.executeQuery();
    }

    @Override
    public void select(String query, String database, String server, String port) throws SQLException {
        this.pstmt = new connectDatabase().connect(database, server, port).prepareStatement(query);
        this.rs = this.pstmt.executeQuery();
    }

    @Override
    public void select(String query, String database, String server, String port, String username, String password) throws SQLException {
        this.pstmt = new connectDatabase().connect(database, server, port, username, password).prepareStatement(query);
        this.rs = this.pstmt.executeQuery();
    }
    
    @Override
    public void executeQuery(String query) throws SQLException {
        this.pstmt = new connectDatabase().connect().prepareStatement(query);
        this.pstmt.executeUpdate();
    }

    @Override
    public void executeQuery(String query, String database) throws SQLException {
        this.pstmt = new connectDatabase().connect(database).prepareStatement(query);
        this.pstmt.executeUpdate();
    }

    @Override
    public void executeQuery(String query, String database, String server, String port) throws SQLException {
        this.pstmt = new connectDatabase().connect(database, server, port).prepareStatement(query);
        this.pstmt.executeUpdate();
    }
    
    @Override
    public void executeQuery(String query, String database, String server, String port, String username, String password) throws SQLException {
        this.pstmt = new connectDatabase().connect(database, server, port, username, password).prepareStatement(query);
        this.pstmt.executeUpdate();
    }
    
    @Override
    public void SQLClose() {
        try {
            if (this.pstmt != null) {
                this.pstmt.close();
            }else if (this.rs != null) {
                this.rs.close();
            } else if (new connectDatabase().connect() != null) {
                new connectDatabase().connect().close();
            }
        } catch(SQLException ex) {
            ex.printStackTrace(System.out);
            System.exit(1);
        }
        
        this.pstmt = null;
        this.rs = null;
    }

    @Override
    public ResultSet getRs() {
        return this.rs;
    }
}