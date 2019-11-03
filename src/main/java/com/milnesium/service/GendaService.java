package com.milnesium.service;

import com.milnesium.domain.GendaElement;
import com.milnesium.persistance.GendaRepository;
import com.milnesium.transfer.CreateGendaElementRequest;
import com.milnesium.transfer.UpdateGendaElementRequest;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public class GendaService {

    private GendaRepository gendaRepository = new GendaRepository();

    public void createGendaElement(CreateGendaElementRequest request) throws SQLException, IOException, ClassNotFoundException {
        System.out.println("Creating fgenda-items: " + request);
        gendaRepository.createGendaElement(request);
    }

    public void updateGendaElement(long id, UpdateGendaElementRequest request) throws SQLException, IOException, ClassNotFoundException {
        System.out.println("Updating fgenda-item: " + request);
        gendaRepository.updateElement(id, request.isWorkNo());
    }

//    public void deleteAllGendaElements() throws SQLException, IOException, ClassNotFoundException {
//        System.out.println("Deleting all items");
//        gendaRepository.deleteGendaElements();
//    }

    public void deleteAllGendaElements(long id) throws SQLException, IOException, ClassNotFoundException {
        System.out.println("Deleting fgenda-item: " + id + "...");
        gendaRepository.deleteGendaElements(id);
    }

    public void deleteAllGendaElements(long id, long id1) throws SQLException, IOException, ClassNotFoundException {
        System.out.println("Deleting fgenda-items: " + id + " " + id1 + "...");
        gendaRepository.deleteGendaElements(id, id1);
    }

    public void deleteAllGendaElements(long id, long id1, long id2) throws SQLException, IOException, ClassNotFoundException {
        System.out.println("Deleting fgenda-items: " + id + ", " + id1 + ", " + id2 + "...");
        gendaRepository.deleteGendaElements(id, id1, id2);
    }

    public void deleteAllGendaElements(long id, long id1, long id2, long id3) throws SQLException, IOException, ClassNotFoundException {
        System.out.println("Deleting fgenda-items: " + id + ", " + id1 + ", " + id2 + ", " + id3 + "...");
        gendaRepository.deleteGendaElements(id, id1, id2, id3);
    }

    public void deleteAllGendaElements(long id, long id1, long id2, long id3, long id4) throws SQLException, IOException, ClassNotFoundException {
        System.out.println("Deleting fgenda-items: " + id + ", " + id1 + ", " + id2 + ", " + id3 + ", " + id4 + "...");
        gendaRepository.deleteGendaElements(id, id1, id2, id3, id4);
    }

    public List<GendaElement> getGendaElement() throws SQLException, IOException, ClassNotFoundException {
        System.out.println("Retrieving fgenda-items...");
        return gendaRepository.getGendaElement();
    }

    public List<GendaElement> getSelectedName(String nameOrSurname) throws SQLException, IOException, ClassNotFoundException {
        System.out.println("Retrieving only selected fgenda-items...");
        return gendaRepository.getSelectedName(nameOrSurname);
    }

}
