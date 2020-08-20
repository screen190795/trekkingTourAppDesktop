package model;

import java.io.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import model.ScriptText;
import org.h2.tools.RunScript;



public class H2Script {

    StringBuilder stringBuilder = new StringBuilder();
    String line;
    public void executeScript(File file) throws IOException, SQLException {


        Connection connection = H2DAOFactory.createConnection();
            RunScript.execute(connection, new FileReader(file));

    }
}
