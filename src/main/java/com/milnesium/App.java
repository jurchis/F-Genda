package com.milnesium;

import com.milnesium.domain.GendaElement;
import com.milnesium.persistance.GendaRepository;
import com.milnesium.transfer.CreateGendaElementRequest;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

/**
 * Hello world!
 */

public class App {
    public static void main(String[] args) throws SQLException, IOException, ClassNotFoundException {
        CreateGendaElementRequest request = new CreateGendaElementRequest();
        request.setFirstName("George");
        request.setSecondName("Wash");
        request.setPhoneNo("+6678477396");
        request.setComment("My friend since I was born");
        request.setWorkNo(false);

        GendaRepository gendaRepository = new GendaRepository();
        gendaRepository.createGendaElement(request);

        List<GendaElement> gendaElement = gendaRepository.getGendaElement();
        System.out.println(gendaElement);

        gendaRepository.deleteGendaElements((long) 7);

        gendaRepository.updateElementNumber(3, "+796784648638");
        gendaRepository.updateElementName(3, "Cosmin");
        gendaRepository.updateElementSurname(3, "Olaru");
        gendaRepository.updateElement(3, "Facility Department");
        gendaRepository.updateElement(3, true);

        gendaRepository.deleteGendaElements(13, 14, 15);

        System.out.println("Printing Selected Search by Name or Surname Elements...");
        List<GendaElement> gendaSelectedElement = gendaRepository.getSelectedName("Cosm%");
        System.out.println(gendaSelectedElement);

//        gendaRepository.deleteGendaElements();

    }
}
