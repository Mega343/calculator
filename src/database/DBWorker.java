package database;
import com.mysql.fabric.jdbc.FabricMySQLDriver;

import java.sql.*;

public class DBWorker {
    public  int counter = 0;
    private final String URL = "jdbc:mysql://localhost:3306/calculationresult";
    private final String USERNAME = "root";
    private final String PASSWORD = "3433905";
    private final String INSERT_NEW = "INSERT INTO results VALUES(?,?,?)";


    public void addFormulaToDatabase(String userInput, String result) {
        Connection connection;
        PreparedStatement preparedStatement;


        try {
            Driver driver = new FabricMySQLDriver();
            DriverManager.registerDriver(driver);
            connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            preparedStatement = connection.prepareStatement(INSERT_NEW);
            preparedStatement.setInt(1, counter++);
            preparedStatement.setString(2, userInput);
            preparedStatement.setString(3, result);
            preparedStatement.execute();
            connection.close();

        }

        catch (SQLException e){
            System.out.println("Couldn't download class driver");
        }

    }

  public static void main(String[] args) {
      DBWorker dbWorker = new DBWorker();
      dbWorker.addFormulaToDatabase("123.12 + 34 * (12 - 10)", "191.12");
    }


}
