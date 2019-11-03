package com.milnesium.web;

import com.milnesium.config.ObjectMapperConfiguration;
import com.milnesium.domain.GendaElement;
import com.milnesium.service.GendaService;
import com.milnesium.transfer.CreateGendaElementRequest;
import com.milnesium.transfer.UpdateGendaElementRequest;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;


@WebServlet("/fgenda-elements")

public class GendaElementServlet extends HttpServlet {

    private GendaService gendaService = new GendaService();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        CreateGendaElementRequest request =
                ObjectMapperConfiguration.getObjectMapper()
                        .readValue(req.getReader(), CreateGendaElementRequest.class);
        try {
            gendaService.createGendaElement(request);
        } catch (SQLException | ClassNotFoundException e) {
            resp.sendError(500, "Internal Server Error: " + e.getMessage());
        }
    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String id = req.getParameter("id");

        try {
            gendaService.deleteAllGendaElements(Long.parseLong(id));
        } catch (SQLException | ClassNotFoundException e) {
            resp.sendError(500, "Internal Server Error: " + e.getMessage());
        }
    }

    //Trying to do doDelete but there is already a doDelete with same params as in the case where I want to delete
    //more than one. Instead of String id should I create a list of ids?

    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String id = req.getParameter("id");

        UpdateGendaElementRequest request =
                ObjectMapperConfiguration.getObjectMapper()
                        .readValue(req.getReader(), UpdateGendaElementRequest.class);

        try {
            gendaService.updateGendaElement(Long.parseLong(id), request);
        } catch (SQLException | ClassNotFoundException e) {
            resp.sendError(500, "Internal Server Error: " + e.getMessage());
        }
    }

    //how I will update name or surname? Can I do it in the same doPut? Should I create an if else
    //if from Postman there is surname mentioned in JSON then go with the surname else go with something else
    //should I check somehow if name of Var is mentioned then go with a specific part of if else?


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        try {
            List<GendaElement> toDoItems = gendaService.getGendaElement();

            String response = ObjectMapperConfiguration.getObjectMapper()
                    .writeValueAsString(toDoItems);

            resp.getWriter().print(response);

        } catch (SQLException | ClassNotFoundException e) {
            resp.sendError(500, "Internal Server Error: " + e.getMessage());
        }
    }

    //How to create a doGet for getting the list of rows where name or surname are matching a specific character
    //as getting another doGet will have the same form as above

}
