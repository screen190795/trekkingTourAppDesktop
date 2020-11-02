package org.example.model;


import javax.sql.RowSet;
import java.util.Collection;
import java.util.List;

public interface ClientDAO {
    void insertClient(Client client);
    boolean deleteClient(int id);
    Client selectClientById(int id);
    boolean updateClient(Client client);
    List<Client> findAllClients();
}
