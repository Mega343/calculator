package database;

import com.mysql.jdbc.Driver;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DBWorker {
    public  int counter = 0;
    private final String URL = "jdbc:mysql://localhost:3306/calculationresult";
    private final String USERNAME = "root";
    private final String PASSWORD = "3433905";
    private final String INSERT_NEW = "INSERT INTO results VALUES(?,?,?)";
    private Connection connection;
    private PreparedStatement preparedStatement;


    public void addFormulaToDatabase(String userInput, String calculateFormulaResult) {

        try {
            Driver driver = new Driver();
            DriverManager.registerDriver(driver);
            connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            preparedStatement = connection.prepareStatement(INSERT_NEW);
            preparedStatement.setInt(1, counter++);
            preparedStatement.setString(2, userInput);
            preparedStatement.setString(3, calculateFormulaResult);
            preparedStatement.executeUpdate();
            connection.commit();
            connection.close();
        }

        catch (SQLException e){
            System.out.println("Couldn't download class driver");
        }

    }


    public Connection getConnection() {
        return connection;
    }



}
