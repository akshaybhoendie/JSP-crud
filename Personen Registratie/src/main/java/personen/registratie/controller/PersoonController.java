package personen.registratie.controller;

import personen.registratie.entity.Persoon;
import personen.registratie.service.PersoonService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * Created by abhoendie on 12/2/2016.
 */
public class PersoonController extends HttpServlet {
    public static final long serialVersionUID = 1L;
    private static String INSERT_OR_EDIT = "/persoon.jsp";
    private static String LIST_USER = "/personenlijst.jsp";
    private static PersoonService persoonService = new PersoonService();

    public PersoonController() {

    }


    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String forward = "";
        String action = request.getParameter("action");

        if (action.equalsIgnoreCase("delete")) {
            int persoonid = Integer.parseInt(request.getParameter("persoonid"));
            persoonService.deletePerson(persoonid);
            forward = LIST_USER;
            request.setAttribute("personen", persoonService.selectAll());
        } else if (action.equalsIgnoreCase("edit")) {
            forward = INSERT_OR_EDIT;
            int persoonid = Integer.parseInt(request.getParameter("persoonid"));
            Persoon persoon = persoonService.selectPersonRecord(persoonid);
            request.setAttribute("persoon", persoon);
        } else if (action.equalsIgnoreCase("personenlijst")) {
            forward = LIST_USER;
            List<Persoon> personen = persoonService.selectAll();
            request.setAttribute("personen",personen );
        } else {
            forward = INSERT_OR_EDIT;
        }

        RequestDispatcher view = request.getRequestDispatcher(forward);
        view.forward(request, response);
    }


    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Persoon persoon = new Persoon();
        String persoonid = request.getParameter("persoonid");
        persoon.setNaam(request.getParameter("naam"));
        persoon.setVoornaam(request.getParameter("voornaam"));
        persoon.setAdress(request.getParameter("adress"));
        persoon.setGeboorteDatum(request.getParameter("geboortedatum"));

        if (persoonid == null || persoonid.isEmpty()) {
            persoonService.insertPersoon(persoon);
        } else {
            persoon.setPersoonId(Integer.parseInt(persoonid));
            persoonService.updatePerson(persoon);
        }
        RequestDispatcher view = request.getRequestDispatcher(LIST_USER);
        request.setAttribute("personen", persoonService.selectAll());
        view.forward(request, response);

    }
}
