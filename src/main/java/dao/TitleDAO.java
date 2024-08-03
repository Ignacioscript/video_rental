package dao;

import model.Title;
import util.DBUtil;

import org.slf4j.LoggerFactory;
import org.slf4j.Logger;

import java.io.*;
import java.sql.Blob;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TitleDAO extends DataAccessObject<Title>{


    private static final Logger logger = LoggerFactory.getLogger(TitleDAO.class);

    private final String INSERT = "Insert into Titles Values (?,?,?,?,?,?)";
    private final String UPDATE = "UPDATE Titles SET Title=?, Year=?, Price=?, URL=?, image=? WHERE TitleID = ? ";
    private final String DELETE = "DELETE from Titles WHERE TitleID = ?";
    private final String GET_ONE = "SELECT * FROM Titles WHERE TitleID = ?";
    private final String GET_ALL = "SELECT * FROM Titles";


    @Override
    public void create(Title title) {
        try(PreparedStatement statement = DBUtil.getConnection().prepareStatement(INSERT)){
            statement.setInt(1, title.getId());
            statement.setString(2, title.getTitle());
            statement.setInt(3, title.getYear());
            statement.setDouble(4, title.getPrice());
            statement.setString(5, title.getURL());
            statement.setBlob(6, convertImageToBlob(title.getImage()));

            statement.executeUpdate();
            logger.info("Title created successfully");

        }catch (SQLException e){
            logger.error("Title creation failed", e);
            throw new RuntimeException();
        }

    }

    @Override
    public List<Title> getAll() {
        List<Title> titleList = new ArrayList<>();
        Title title;
        try(PreparedStatement statement = DBUtil.getConnection().prepareStatement(GET_ALL)){
            ResultSet rs = statement.executeQuery();

            while (rs.next()){
                title = new Title(
                        rs.getInt(1),
                        rs.getString(2),
                        rs.getInt(3),
                        rs.getDouble(4),
                        rs.getString(5),
                        rs.getBlob(6).toString());
                titleList.add(title);
            }
            logger.info("Retrieving All data from table success");

        }catch (SQLException e){
            logger.error("Operation failed");
        }
        return titleList.stream().toList();
    }

    @Override
    public Title getById(int id) {
        Title title;
        try(PreparedStatement statement = DBUtil.getConnection().prepareStatement(GET_ONE)){
            ResultSet rs = statement.executeQuery();

            title = new Title(
                    rs.getInt("TitleID"),
                    rs.getString("Title"),
                    rs.getInt("Year"),
                    rs.getDouble("Price"),
                    rs.getString("URL"),
                    rs.getBlob("image").toString());
            return title;
        }catch (SQLException e){
            logger.error("Retrieving title failed.", e);
            throw new RuntimeException("Retrieving title failed", e);
        }
    }

    @Override
    public void update(Title title) {
        try(PreparedStatement statement = DBUtil.getConnection().prepareStatement(UPDATE)){
            statement.setString(1, title.getTitle());
            statement.setInt(2, title.getYear());
            statement.setDouble(3, title.getPrice());
            statement.setString(4, title.getURL());
            statement.setBlob(5, convertImageToBlob(title.getImage()));

            statement.setInt(6, title.getId());

            statement.executeUpdate();
            logger.info("Updating title successfully");

        }catch (SQLException e){
            logger.error("Updating title failed", e);
            throw new RuntimeException();
        }

    }

    @Override
    public void deleteById(int id) {

        try(PreparedStatement statement = DBUtil.getConnection().prepareStatement(DELETE)){
            statement.setInt(1, id);
            logger.info("Deleting a customer-Operarion Sucessfully ");

        }catch (SQLException e){
            logger.error("Operation failed: ", e);
            throw new RuntimeException("Operation failed", e);
        }

    }

    protected Blob convertImageToBlob(String imagePath){
        try{
            return (Blob) new FileInputStream(imagePath);

        }catch (IOException e){
            logger.error("Converting image failed");
            throw new RuntimeException("Converting image to Blob failed", e);
        }

    }

    protected void retrieveImage(int titleId, String outputPath) throws SQLException, IOException {

        Title title = getById(titleId);
        Blob blob = convertImageToBlob(title.getImage());
        InputStream inputStream = blob.getBinaryStream();
                FileOutputStream outputStream = new FileOutputStream(outputPath);
                byte[] buffer = new byte[1024];
                int bytesRead = -1;

                while ((bytesRead = inputStream.read(buffer)) != -1) {
                    outputStream.write(buffer, 0, bytesRead);
                }

    }

}



