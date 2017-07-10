package pe.edu.utp.regionslist.controllers;

import org.atteo.evo.inflector.English;
import sun.rmi.runtime.Log;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static jdk.nashorn.internal.runtime.regexp.joni.Config.log;

/**
 * Created by GrupoUTP on 24/02/2017.
 */
@WebServlet(name = "BaseController")
public class BaseController extends HttpServlet {
    private Connection connection;
    private String entityName;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
    protected Connection getConnection() {
        if (connection == null) {
            try {
                InitialContext ctx = new InitialContext();
                DataSource dataSource = (DataSource) ctx.lookup("jdbc/MySQLDataSource");
                connection = dataSource.getConnection();
            } catch (NamingException | SQLException e) {
                e.printStackTrace();
            }
        }
        return connection;
    }

    public String getEntityName() {
        return entityName;
    }

    public void setEntityName(String entityName) {
        this.entityName = entityName;
    }


    protected String getUrl(String action) {
        if(Arrays.asList(new String[] {"index", "create", "update", "delete" })
                .contains(action.toLowerCase().trim())) {
            log("list" + English.plural(getEntityName()) + ".jsp");
            return "list" + English.plural(getEntityName()) + ".jsp";
        }
        if(Arrays.asList(new String[] {"show", "new", "edit" })
                .contains(action.toLowerCase().trim())) {
            return action + getEntityName() + ".jsp";
        }
        return "index.jsp";
    }

}
