package model;

import java.io.*;
import java.sql.Connection;
import java.sql.SQLException;

import org.h2.tools.RunScript;


/**
 * Класс запускает скрипт для создания таблиц БД с данными, заполненными по умолчанию
 */
public class H2Script {

    public void executeScript(File file) throws IOException, SQLException {
        Connection connection = H2DAOFactory.createConnection();
        assert connection != null;
        RunScript.execute(connection, new FileReader(file));

    }
}
