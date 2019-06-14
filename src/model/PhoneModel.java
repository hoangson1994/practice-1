package model;

import entity.Phone;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PhoneModel {

    public static Connection connection;

    static{
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost/java", "root", "");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public ArrayList<Phone> list() {
        ArrayList<Phone> listPhones = new ArrayList<>();
        try{
            PreparedStatement preparedStatement = connection.prepareStatement("select * from phones");
            ResultSet rs = preparedStatement.executeQuery();
            Phone phone = null;
            while (rs.next()) {
                phone = new Phone();
                phone.setId(rs.getInt(1));
                phone.setName(rs.getString(2));
                phone.setBrand(rs.getString(3));
                phone.setPrice(rs.getInt(4));
                phone.setDescription(rs.getString(5));
                listPhones.add(phone);
            }
            return listPhones;

        } catch (Exception e) {
            System.out.println(e);
        }
        return null;
    }

    public boolean insert(Phone phone) {
        try{
            PreparedStatement preparedStatement = connection.prepareStatement("insert into phones (name, brand, price, description) values (?,?,?,?)");
            preparedStatement.setString(1, phone.getName());
            preparedStatement.setString(2, phone.getBrand());
            preparedStatement.setInt(3, phone.getPrice());
            preparedStatement.setString(4, phone.getDescription());
            preparedStatement.execute();
            return true;
        }catch (Exception e) {
            System.out.println(e);
        }
        return false;
    }
}
