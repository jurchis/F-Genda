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

        String[] ids = req.getParameterValues("id");

        try {
            for (String i : ids
            ) {
                gendaService.deleteAllGendaElements(Long.parseLong(i));
            }

        } catch (SQLException | ClassNotFoundException e) {
            resp.sendError(500, "Internal Server Error: " + e.getMessage());
        }
    }

    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String id = req.getParameter("id");

        UpdateGendaElementRequest request =
                ObjectMapperConfiguration.getObjectMapper()
                        .readValue(req.getReader(), UpdateGendaElementRequest.class);

        try {
            gendaService.updateAllGendaElement(Long.parseLong(id), request);
        } catch (SQLException | ClassNotFoundException e) {
            resp.sendError(500, "Internal Server Error: " + e.getMessage());
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {

        String nameOrSurname = req.getParameter("nameOrSurname");

        if (nameOrSurname != null && !nameOrSurname.isEmpty()) {
            try {
                List<GendaElement> gendaElements = gendaService.getSelectedName(nameOrSurname);
                String response = ObjectMapperConfiguration.getObjectMapper()
                        .writeValueAsString(gendaElements);
                resp.getWriter().print(response);
            } catch (SQLException | ClassNotFoundException e) {
                resp.sendError(500, "Internal Server Error: " + e.getMessage());
            }
        } else {

            try {
                List<GendaElement> gendaElements = gendaService.getSelectedName();
                String response = ObjectMapperConfiguration.getObjectMapper()
                        .writeValueAsString(gendaElements);
                resp.getWriter().print(response);

            } catch (SQLException | ClassNotFoundException e) {
                resp.sendError(500, "Internal Server Error: " + e.getMessage());
            }
        }
    }
}
