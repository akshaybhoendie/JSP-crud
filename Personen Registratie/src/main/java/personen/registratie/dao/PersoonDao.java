package personen.registratie.dao;

import personen.registratie.entity.Persoon;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by abhoendie on 11/30/2016.
 */
public class PersoonDao {


    String url = "jdbc:mysql://localhost:3306/persoon";
    String password = "0000";
    String user = "root";
    Connection connection = null;
    Statement statement = null;

    public PersoonDao() {
        databaseConnection();
    }

    public void databaseConnection() {

        try {
            try {
                Class.forName("com.mysql.jdbc.Driver");
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
            connection = DriverManager.getConnection(url, user, password);
            if (connection != null) {
                System.out.println("Connected to the database!");
            }
        } catch (SQLException e) {
            System.out.println("Er is een SQL fout ontstaan");
            e.printStackTrace();
        }
    }

    public List<Persoon> selectAllPerson() {

        String sql = "select * from persoon";
        List<Persoon> persoonData = new ArrayList<>();

        try {
            statement = connection.createStatement();
            ResultSet result = statement.executeQuery(sql);
            while (result.next()) {
                Persoon persoon = new Persoon();
                persoon.setPersoonId(result.getInt("persoonId"));
                persoon.setNaam(result.getString("naam"));
                persoon.setVoornaam(result.getString("voornaam"));
                persoon.setAdress(result.getString("adress"));
                persoon.setGeboorteDatum(result.getString("geboortedatum"));
                persoonData.add(persoon);
            }

        } catch (SQLException e) {
            System.out.println("Er is een SQL fout opgetreden");
            e.printStackTrace();
        }

        return persoonData;
    }

   public Persoon selectPersonRecord(int persoonid){
        String sql = "select * from persoon.persoon where persoonid = ?";
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        Persoon persoon = new Persoon();

        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, persoonid);
            resultSet = preparedStatement.executeQuery();

            if (resultSet.next()){
                persoon.setPersoonId(resultSet.getInt("persoonid"));
                persoon.setNaam(resultSet.getString("naam"));
                persoon.setVoornaam(resultSet.getString("voornaam"));
                persoon.setAdress(resultSet.getString("adress"));
                persoon.setGeboorteDatum(resultSet.getString("geboortedatum"));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return persoon;
    }

    public int insertPerson(Persoon persoon) {
        String sql = "insert into persoon values (NULL,?,?,?,?)";
        PreparedStatement preparedStatement = null;
        int result = 0;
        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, persoon.getNaam());
            preparedStatement.setString(2, persoon.getVoornaam());
            preparedStatement.setString(3, persoon.getAdress());
            preparedStatement.setString(4, persoon.getGeboorteDatum());
            result = preparedStatement.executeUpdate();
            System.out.println("Added new person Succesful");
        } catch (SQLException e) {
            System.out.println("Insert unsuccessful");
            e.printStackTrace();
        }
        return result;
    }

    public int updatePerson(Persoon persoon) {
        String sql = "update persoon set naam = ?, voornaam = ?, adress = ?, geboortedatum = ? where persoonid = ?";
        PreparedStatement preparedStatement = null;
        int result = 0;
        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, persoon.getNaam());
            preparedStatement.setString(2, persoon.getVoornaam());
            preparedStatement.setString(3, persoon.getAdress());
            preparedStatement.setString(4, persoon.getGeboorteDatum());
            preparedStatement.setInt(5, persoon.getPersoonId());
            result = preparedStatement.executeUpdate();
            System.out.println("Update successful");
        } catch (SQLException e) {
            System.out.println("Update unsuccessful");
            e.printStackTrace();
        }
        return result;
    }

    public int deletePerson(int persoonId)  {
        String sql = "delete from persoon where persoonid=?";
        PreparedStatement preparedStatement = null;
        int result = 0;
        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, persoonId);
            result = preparedStatement.executeUpdate();
            if (result > 0) {
                System.out.println("Deleted person succesfull");
            }
        } catch (SQLException e) {
            System.out.println("Delete unsuccessfull");
            e.printStackTrace();
        }
            return result;
    }

    public void terminateConnection() {
        try {
            connection.close();
        } catch (SQLException e) {
            System.out.println("Connectie verbroken");
            e.printStackTrace();
        }

    }


}

