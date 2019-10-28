package com.milnesium.persistance;

import com.milnesium.domain.GendaElement;
import com.milnesium.transfer.CreateGendaElementRequest;

import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class GendaRepository {
    public void createGendaElement(CreateGendaElementRequest request) throws SQLException, IOException, ClassNotFoundException {
        String sql = "INSERT INTO fgenda_items (first_name, last_name, phone_no, comment, work_no) VALUES (?,?,?,?,?);";
        try (Connection connection = DataBaseConfiguration.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql);) {

            preparedStatement.setString(1, request.getFirst_name());
            preparedStatement.setString(2, request.getSecond_name());
            preparedStatement.setString(3, request.getPhone_no());
            preparedStatement.setString(4, request.getComment());
            preparedStatement.setBoolean(5, request.isWork());

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
                gendaElement.setFirst_name(resultSet.getString("first_name"));
                gendaElement.setLast_name(resultSet.getString("last_name"));
                gendaElement.setPhone_no(resultSet.getString("phone_no"));
                gendaElement.setComment(resultSet.getString("comment"));
                gendaElement.setWork_no(resultSet.getBoolean("work_no"));
                gendaElements.add(gendaElement);
            }
        }
        return gendaElements;
    }

    public void deleteGendaElement(long id) throws SQLException, IOException, ClassNotFoundException {
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
        try(Connection connection=DataBaseConfiguration.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(sql)){
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
                gendaSelectedElement.setFirst_name(resultSelectedSet.getString("first_name"));
                gendaSelectedElement.setLast_name(resultSelectedSet.getString("last_name"));
                gendaSelectedElement.setPhone_no(resultSelectedSet.getString("phone_no"));
                gendaSelectedElement.setComment(resultSelectedSet.getString("comment"));
                gendaSelectedElement.setWork_no(resultSelectedSet.getBoolean("work_no"));
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

