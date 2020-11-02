package org.example.model;

import javax.sql.RowSet;
import java.util.Collection;
import java.util.List;

public interface GroupDAO {
    void insertGroup(Group group);
    boolean deleteGroup(int clientId, int routeTypeId);
    List<Group> findAllGroups();
    List<Group> findGroupByType(int id);
}
