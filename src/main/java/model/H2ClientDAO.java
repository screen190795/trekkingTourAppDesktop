package model;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class H2ClientDAO implements ClientDAO {

    @Override
    public void insertClient(Client client) {
        Connection connection = H2DAOFactory.createConnection();
        String sql = "INSERT INTO CLIENTS VALUES(null, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

        try {
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setString(1, client.getSurname());
            stm.setString(2, client.getName());
            stm.setString(3, client.getPatronimic());
            stm.setInt(4, client.getAge());
            stm.setInt(5, client.getPassportSerial());
            stm.setDouble(6, client.getPassportNumber());
            stm.setString(7, client.getPhone());
            stm.setString(8, client.getEmail());
            stm.setString(9, client.getDescription());
            stm.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    @Override
    public boolean deleteClient(int id) {
        String sql = "DELETE FROM CLIENTS WHERE CLIENT_ID = ?";
        try (Connection connection = H2DAOFactory.createConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, id);
            statement.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        System.out.println("Запись успешно удалена");
        return true;
    }

    @Override
    public Client selectClientById(int id) {
        String sql = "SELECT * FROM CLIENTS WHERE CLIENT_ID = ?";
        Client client = new Client();
        client.setId(id);

        try (Connection connection = H2DAOFactory.createConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, id);
            ResultSet rs = statement.executeQuery();
            if (rs.next()) {
                int clientId = rs.getInt(1);
                String surname = rs.getString(2);
                String name = rs.getString(3);
                String patronimic = rs.getString(4);
                int age = rs.getInt(5);
                int passportSerial = rs.getInt(6);
                double passportNumber = rs.getInt(7);
                String phone = rs.getString(8);
                String email = rs.getString(9);
                String description = rs.getString(10);
                client.setId(clientId);
                client.setSurname(surname);
                client.setName(name);
                client.setPatronimic(patronimic);
                client.setAge(age);
                client.setPassportSerial(passportSerial);
                client.setPassportNumber(passportNumber);
                client.setPhone(phone);
                client.setEmail(email);
                client.setDescription(description);
            }

        } catch (SQLException | NumberFormatException throwables) {
            throwables.printStackTrace();
        }
        return client;
    }



    @Override
    public boolean updateClient(Client client) {
        Connection connection = H2DAOFactory.createConnection();
        String sql = "UPDATE CLIENTS SET CLIENT_SURNAME=?, CLIENT_NAME=?, CLIENT_PATRONIMIC=?, CLIENT_AGE=?, CLIENT_PASSPORT_SERIAL=?, CLIENT_PASSPORT_NUMBER=?, CLIENT_PHONE=?, CLIENT_EMAIL=?, CLIENT_DESCRIPTION=? WHERE CLIENT_ID=?";
        try {
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setInt(10, client.getId());
            stm.setString(1, client.getSurname());
            stm.setString(2, client.getName());
            stm.setString(3, client.getPatronimic());
            stm.setInt(4, client.getAge());
            stm.setInt(5, client.getPassportSerial());
            stm.setDouble(6, client.getPassportNumber());
            stm.setString(7, client.getPhone());
            stm.setString(8, client.getEmail());
            stm.setString(9, client.getDescription());
            int rowsAffected = stm.executeUpdate();
            stm.close();
            System.out.println(rowsAffected + " Rows affected");
        } catch (SQLException | NumberFormatException throwables) {
            throwables.printStackTrace();
        }
        return true;
    }

    @Override
    public List<Client> findAllClients() {

        List<Client> clients = new ArrayList<>();
        String sql = "SELECT * FROM CLIENTS";
        try (Connection connection = H2DAOFactory.createConnection()) {
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery(sql);
            while (rs.next()) {
                int id = rs.getInt(1);
                String surname = rs.getString(2);
                String name = rs.getString(3);
                String patronimic = rs.getString(4);
                int age = rs.getInt(5);
                int passportSerial = rs.getInt(6);
                double passportNumber = rs.getInt(7);
                String phone = rs.getString(8);
                String email = rs.getString(9);
                String description = rs.getString(10);
                Client client = new Client();
                client.setId(id);
                client.setSurname(surname);
                client.setName(name);
                client.setPatronimic(patronimic);
                client.setAge(age);
                client.setPassportSerial(passportSerial);
                client.setPassportNumber(passportNumber);
                client.setPhone(phone);
                client.setEmail(email);
                client.setDescription(description);
                clients.add(client);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return clients;
    }

    public static void main(String[] args) {
        H2ClientDAO h2ClientDAO = new H2ClientDAO();
        Client client = h2ClientDAO.selectClientById(2);
        System.out.println(client.getSurname());
    }
}

