package dao;

import model.Tape;
import model.Title;
import util.DBUtil;

import org.slf4j.LoggerFactory;
import org.slf4j.Logger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TapeDAO extends DataAccessObject<Tape>{

    private static final Logger logger = LoggerFactory.getLogger(TapeDAO.class);

    private final String INSERT = "INSERT INTO Tapes VALUES(?,?,?)";
    private final String UPDATE = "UPDATE Tapes SET  TitleID=?, Type=? WHERE TapeID=? ";
    private final String DELETE = "DELETE FROM Tapes WHERE  TitleID=? AND TapeID =?  ";
    private final String GET_ALL = "SELECT * FROM Tapes LIMIT 100 OFFSET 0";
    private final String GET_ONE = "SELECT * FROM Tapes WHERE TapeID =?";
    //private final String GET_ONE = "SELECT * FROM  t.tape_id, t.type, title.title_id, title.title, title.year, title.price, title.url" + "FROM tape t " + "JOIN title ON t.title_id = title.title_id" + "WHERE t.tape_id = ?";

    @Override
    public void create(Tape tape) {
        try(Connection connection = DBUtil.getConnection();
                PreparedStatement statement = connection.prepareStatement(INSERT)){
            statement.setInt(1, tape.getId());
            statement.setInt(2, tape.getTitle().getId());
            statement.setString(3, tape.getType());
            statement.execute();
            logger.info("New data was inserted into tape table");
        }catch (SQLException e){
            logger.error("Creation of a new title has failed");
            throw new RuntimeException();
        }

    }

    @Override
    public List<Tape> getAll() {
        List<Tape> tapeList = new ArrayList<>();
        Tape tape;
        String type;
        Title title;
        int titleID;
        try(Connection connection = DBUtil.getConnection();
                PreparedStatement statement = connection.prepareStatement(GET_ALL)){
            ResultSet rs = statement.executeQuery();

            while (rs.next()){

                type = rs.getString("type");
                titleID = rs.getInt("TitleID");
                title = new TitleDAO().getById(titleID);

                tape = new Tape(
                        rs.getInt("TapeID"),
                        title,
                        type);
                tapeList.add(tape);

            }
            logger.info("Retrieving Tape list data was a success");

        }catch (SQLException e){
            logger.error("Retrieving tape list failed");
            throw new RuntimeException();
        }

        return tapeList;
    }

    @Override
    public Tape getById(int id) {
        Tape tape;
        try(Connection connection = DBUtil.getConnection();
                PreparedStatement statement = connection.prepareStatement(GET_ONE)){
            statement.setInt(1, id);
            ResultSet rs = statement.executeQuery();
            rs.absolute(1);

            String type = rs.getString("type");
            int titleId = rs.getInt("TitleID");
            Title title = new TitleDAO().getById(titleId);

            tape = new Tape(
                    rs.getInt("TapeID"),
                    title,
                    type);

            logger.info("Retrieving Tape data was a success");
        }catch (SQLException e){
            logger.error("Retrieving Tape data failed");
            throw new RuntimeException();
        }

        return tape;


    }

    @Override
    public void update(Tape tape) {
        try(Connection connection = DBUtil.getConnection();
                PreparedStatement statement = connection.prepareStatement(UPDATE)){

            statement.setInt(1, tape.getTitle().getId());
            statement.setString(2, tape.getType());
            statement.setInt(3, tape.getId());

            statement.executeUpdate();
            logger.info("Updating Tape data was a success");
        }catch (SQLException e){
            logger.error("Updating  Tape data failed");
            throw new RuntimeException();
        }

    }

    @Override
    public void deleteById(int id) {
        try(Connection connection = DBUtil.getConnection();
                PreparedStatement statement = connection.prepareStatement(DELETE)){
            int titleID = this.getById(id).getTitle().getId();
            statement.setInt(1, titleID);
            statement.setInt(2, id);
            statement.execute();
            logger.info("Deleting tape data completed");
        }catch (SQLException e){
            logger.error("Deleting tape data, unsuccessfully");
            throw new RuntimeException();
        }

    }


}
