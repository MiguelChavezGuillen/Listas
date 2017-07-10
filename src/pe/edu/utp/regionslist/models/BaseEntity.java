package pe.edu.utp.regionslist.models;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class BaseEntity {
    private Connection connection;

    public Connection getConnection() {
        try{
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://:3306/hr","root","admin");
        }
        catch(SQLException ex   ){
            System.out.println("Error al conectar a la base de datos");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        return connection;
    }

    public void setConnection(Connection connection) { this.connection = connection;}
}
