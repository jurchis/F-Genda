package com.milnesium.persistance;

import com.milnesium.domain.GendaElement;
import com.milnesium.transfer.CreateGendaElementRequest;
import com.milnesium.transfer.UpdateGendaElementRequest;

import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class GendaRepository {
    public void createGendaElement(CreateGendaElementRequest request) throws SQLException, IOException, ClassNotFoundException {
        String sql = "INSERT INTO fgenda_items (first_name, last_name, phone_no, comment, work_no) VALUES (?,?,?,?,?);";
        try (Connection connection = DataBaseConfiguration.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql);) {

            preparedStatement.setString(1, request.getFirstName());
            preparedStatement.setString(2, request.getSecondName());
            preparedStatement.setString(3, request.getPhoneNo());
            preparedStatement.setString(4, request.getComment());
            preparedStatement.setBoolean(5, request.isWorkNo());

            preparedStatement.executeUpdate();
        }
    }

    public List<GendaElement> getGendaElement() throws SQLException, IOException, ClassNotFoundException {

        String sql = "SELECT id, first_name, last_name, phone_no, comment, work_no FROM fgenda_items;";

        List<GendaElement> gendaElements = new ArrayList<>();

        try (Connection connection = DataBaseConfiguration.getConnection();
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(sql)) {
            while (resultSet.next()) {
                GendaElement gendaElement = new GendaElement();
                gendaElement.setId(resultSet.getLong("id"));
                gendaElement.setFirstName(resultSet.getString("first_name"));
                gendaElement.setLastName(resultSet.getString("last_name"));
                gendaElement.setPhoneNo(resultSet.getString("phone_no"));
                gendaElement.setComment(resultSet.getString("comment"));
                gendaElement.setWorkNo(resultSet.getBoolean("work_no"));
                gendaElements.add(gendaElement);
            }
        }
        return gendaElements;
    }

    //overloading deleteGendaElements so it can delete one item or up to 5 randomly selected or all items from the db
    public void deleteGendaElements(long id) throws SQLException, IOException, ClassNotFoundException {
        String sql = "DELETE FROM fgenda_items WHERE id=?;";
        try (Connection connection = DataBaseConfiguration.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setLong(1, id);
            preparedStatement.executeUpdate();
        }
    }

    public void deleteGendaElements(long id, long id1) throws SQLException, IOException, ClassNotFoundException {
        String sql = "DELETE FROM fgenda_items WHERE id IN (?,?);";
        try (Connection connection = DataBaseConfiguration.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setLong(1, id);
            preparedStatement.setLong(2, id1);

            preparedStatement.executeUpdate();
        }
    }

    public void deleteGendaElements(long id, long id1, long id2) throws SQLException, IOException, ClassNotFoundException {
        String sql = "DELETE FROM fgenda_items WHERE id IN (?,?,?);";
        try (Connection connection = DataBaseConfiguration.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setLong(1, id);
            preparedStatement.setLong(2, id1);
            preparedStatement.setLong(3, id2);

            preparedStatement.executeUpdate();
        }
    }

    public void deleteGendaElements(long id, long id1, long id2, long id3) throws SQLException, IOException, ClassNotFoundException {
        String sql = "DELETE FROM fgenda_items WHERE id IN (?,?,?,?);";
        try (Connection connection = DataBaseConfiguration.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setLong(1, id);
            preparedStatement.setLong(2, id1);
            preparedStatement.setLong(3, id2);
            preparedStatement.setLong(4, id3);

            preparedStatement.executeUpdate();
        }
    }

    public void deleteGendaElements(long id, long id1, long id2, long id3, long id4) throws SQLException, IOException, ClassNotFoundException {
        String sql = "DELETE FROM fgenda_items WHERE id IN (?,?,?,?,?);";
        try (Connection connection = DataBaseConfiguration.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setLong(1, id);
            preparedStatement.setLong(2, id1);
            preparedStatement.setLong(3, id2);
            preparedStatement.setLong(4, id3);
            preparedStatement.setLong(4, id4);

            preparedStatement.executeUpdate();
        }
    }

//    !!!
//    //Good In theory but deactivating it as it might seriously damage the DB during a wrong request
//    public void deleteGendaElements() throws SQLException, IOException, ClassNotFoundException {
//        String sql = "DELETE FROM fgenda_items;";
//        try (Connection connection = DataBaseConfiguration.getConnection();
//             Statement statement = connection.createStatement()) {
//            statement.executeUpdate(sql);
//        }
//    }

    public void updateElementName(long id, String first_name) throws SQLException, IOException, ClassNotFoundException {
        String sql = "UPDATE fgenda_items SET first_name=? WHERE id=?";
        try (Connection connection = DataBaseConfiguration.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setString(1, first_name);
            preparedStatement.setLong(2, id);
            preparedStatement.executeUpdate();
        }
    }

    public void updateElementSurname(long id, String last_name) throws SQLException, IOException, ClassNotFoundException {
        String sql = "UPDATE fgenda_items SET last_name=? WHERE id=?";
        try (Connection connection = DataBaseConfiguration.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setString(1, last_name);
            preparedStatement.setLong(2, id);
            preparedStatement.executeUpdate();
        }
    }

    public void updateElement(long id, String comment) throws SQLException, IOException, ClassNotFoundException {
        String sql = "UPDATE fgenda_items SET comment=? WHERE id=?";
        try (Connection connection = DataBaseConfiguration.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setString(1, comment);
            preparedStatement.setLong(2, id);
            preparedStatement.executeUpdate();
        }
    }

    public void updateElementNumber(long id, String phone_no) throws SQLException, IOException, ClassNotFoundException {
        String sql = "UPDATE fgenda_items SET phone_no=? WHERE id=?";
        try (Connection connection = DataBaseConfiguration.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setString(1, phone_no);
            preparedStatement.setLong(2, id);
            preparedStatement.executeUpdate();
        }
    }

    public void updateElement(long id, boolean work_no) throws SQLException, IOException, ClassNotFoundException {
        String sql = "UPDATE fgenda_items SET work_no=? WHERE id=?";
        try (Connection connection = DataBaseConfiguration.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setBoolean(1, work_no);
            preparedStatement.setLong(2, id);
            preparedStatement.executeUpdate();
        }
    }

    public void updateAllElement(long id, UpdateGendaElementRequest request) throws SQLException, IOException, ClassNotFoundException {
        String sql = "UPDATE fgenda_items SET first_name=?, last_name=?, phone_no=?, comment=?, work_no=?  WHERE id=?";
        try (Connection connection = DataBaseConfiguration.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {

            preparedStatement.setString(1, request.getFirstName());
            preparedStatement.setString(2, request.getLastName());
            preparedStatement.setString(3, request.getPhoneNo());
            preparedStatement.setString(4, request.getComment());
            preparedStatement.setBoolean(5, request.isWorkNo());
            preparedStatement.setLong(6, id);

            preparedStatement.executeUpdate();
        }
    }

    public List<GendaElement> getSelectedName(String nameOrSurname) throws SQLException, IOException, ClassNotFoundException {

        String sql = "SELECT id, first_name, last_name, phone_no, comment, work_no FROM fgenda_items " +
                "WHERE first_name LIKE ? OR last_name LIKE ?";

        List<GendaElement> gendaSelectedElements = new ArrayList<>();

        try (Connection connection = DataBaseConfiguration.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {

            preparedStatement.setString(1, nameOrSurname);
            preparedStatement.setString(2, nameOrSurname);

            ResultSet resultSelectedSet = preparedStatement.executeQuery();

            while (resultSelectedSet.next()) {
                GendaElement gendaSelectedElement = new GendaElement();
                gendaSelectedElement.setId(resultSelectedSet.getLong("id"));
                gendaSelectedElement.setFirstName(resultSelectedSet.getString("first_name"));
                gendaSelectedElement.setLastName(resultSelectedSet.getString("last_name"));
                gendaSelectedElement.setPhoneNo(resultSelectedSet.getString("phone_no"));
                gendaSelectedElement.setComment(resultSelectedSet.getString("comment"));
                gendaSelectedElement.setWorkNo(resultSelectedSet.getBoolean("work_no"));
                gendaSelectedElements.add(gendaSelectedElement);
            }
        }
        return gendaSelectedElements;
    }

//    public List<GendaElement> getSelectedSurnameElements(String last_name) throws SQLException, IOException, ClassNotFoundException {
//
//        String sql = "SELECT id, first_name, last_name, phone_no, comment, work_no FROM fgenda_items " +
//                "WHERE last_name=?";
//
//        List<GendaElement> gendaSelectedSurnameElements = new ArrayList<>();
//
//        try (Connection connection = DataBaseConfiguration.getConnection();
//             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
//
//            preparedStatement.setString(1, last_name);
//
//            ResultSet resultSelectedSurnameSet = preparedStatement.executeQuery();
//
//            while (resultSelectedSurnameSet.next()) {
//                GendaElement gendaSelectedSurnameElement = new GendaElement();
//                gendaSelectedSurnameElement.setId(resultSelectedSurnameSet.getLong("id"));
//                gendaSelectedSurnameElement.setFirst_name(resultSelectedSurnameSet.getString("first_name"));
//                gendaSelectedSurnameElement.setLast_name(resultSelectedSurnameSet.getString("last_name"));
//                gendaSelectedSurnameElement.setPhone_no(resultSelectedSurnameSet.getString("phone_no"));
//                gendaSelectedSurnameElement.setComment(resultSelectedSurnameSet.getString("comment"));
//                gendaSelectedSurnameElement.setWork_no(resultSelectedSurnameSet.getBoolean("work_no"));
//                gendaSelectedSurnameElements.add(gendaSelectedSurnameElement);
//            }
//        }
//
//        return gendaSelectedSurnameElements;
//    }
}

