package pe.edu.utp.regionslist.controllers;

import pe.edu.utp.regionslist.models.BaseEntity;
import pe.edu.utp.regionslist.models.Location;
import pe.edu.utp.regionslist.models.Country;
import pe.edu.utp.regionslist.services.HrService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;


/**
 * Created by User on 02/07/2017.
 */
@WebServlet(name = "LocationsController", urlPatterns = "/locations")
public class LocationsController extends BaseController {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
          processRequest("Post",request,response);
       }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest("Get",request,response);
    }
    private void processRequest(String method, HttpServletRequest request, HttpServletResponse response) throws ServletException,IOException {
        String action =request.getParameter("action");
        String url ="index.jsp";
        setEntityName("Location");
        if(method.equals("Get") && action == null) { action = "index"; }
        if(method.equals("Post") && action.equalsIgnoreCase("index")) return;
        if(method.equals("Get") && action.equalsIgnoreCase("create")) return;
        if(method.equals("Get") && action.equalsIgnoreCase("update")) return;
        HrService service = new HrService();
        service.setConnection(getConnection());
        //action=index
        if(action.equalsIgnoreCase("index")){
                List<Location> locations= service.findAllLocation();
                request.setAttribute("locations",locations);
        }
        //action show
        if(action.equalsIgnoreCase("show")){
            int id = Integer.parseInt(request.getParameter("id"));
            request.setAttribute("location",service.findLocationById(id));
        }
        //action new
        if (action.equalsIgnoreCase("new")){
            request.setAttribute("locations",service.findAllLocation());
        }
        //action create
        if(action.equalsIgnoreCase("create")){
            int id = Integer.parseInt(request.getParameter("id"));
            String address=request.getParameter("address");
            String postal_code=request.getParameter("postal_code");
            String city = request.getParameter("city");
            String province = request.getParameter("province");
            Country country = service.findCountryById(request.getParameter("country_id"));
            boolean result = service.updateLocation(new Location(id,address,postal_code,city,province,country));
            request.setAttribute("locations",service.findAllLocation());
        }
        request.getRequestDispatcher(getUrl(action)).forward(request,response);
    }
}
