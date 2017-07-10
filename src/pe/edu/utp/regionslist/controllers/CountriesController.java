package pe.edu.utp.regionslist.controllers;

import pe.edu.utp.regionslist.models.BaseEntity;
import pe.edu.utp.regionslist.models.Country;
import pe.edu.utp.regionslist.models.Region;
import pe.edu.utp.regionslist.services.HrService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * Created by GrupoUTP on 24/02/2017.
 */
@WebServlet(name = "CountriesController", urlPatterns = "/countries")
public class CountriesController extends BaseController {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest("Post", request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest("Get", request, response);
    }

    private void processRequest(String method, HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        String url = "index.jsp";
        setEntityName("Country");
        if(method.equals("Get") && action == null) { action = "index"; }
        if(method.equals("Post") && action.equalsIgnoreCase("index")) return;
        if(method.equals("Get") && action.equalsIgnoreCase("create")) return;
        if(method.equals("Get") && action.equalsIgnoreCase("update")) return;
        HrService service = new HrService();
        service.setConnection(getConnection());
        // action = index
        if(action.equalsIgnoreCase("index")) {
            List<Country> countries = service.findAllCountries();
            request.setAttribute("countries", countries);
        }
        // action = show
        if(action.equalsIgnoreCase("show")) {
            String id = request.getParameter("id");
            request.setAttribute("country", service.findCountryById(id));
        }
        // action = new
        if(action.equalsIgnoreCase("new")) {
            request.setAttribute("regions", service.findAllRegions());
        }
        // action = create
        if(action.equalsIgnoreCase("create")) {
            String id = request.getParameter("id");
            String name = request.getParameter("name");
            int regionId = Integer.parseInt(request.getParameter("regionId"));

            Country country = service.createCountry(id, name, regionId);
            request.setAttribute("countries", service.findAllCountries());
        }
        // action = edit
        if(action.equalsIgnoreCase("edit")) {
            String id = request.getParameter("id");
            request.setAttribute("regions", service.findAllRegions());
            request.setAttribute("country", service.findCountryById(id));
        }

        // action = delete
        if(action.equalsIgnoreCase("delete")) {
            String id = request.getParameter("id");
            boolean result = service.deleteCountry(id);
            request.setAttribute("countries", service.findAllCountries());
        }
        // action = update
        if(action.equalsIgnoreCase("update")) {
            String id = request.getParameter("id");
            String name = request.getParameter("name");
            Region region = service.findRegionById(Integer.parseInt(request.getParameter("regionId")));
            boolean result = service.updateCountry(new Country(id, name, region));
            request.setAttribute("countries", service.findAllCountries());
        }
        request.getRequestDispatcher(getUrl(action)).forward(request, response);
    }
}
