package dao;

import model.Tape;
import model.Title;
import util.DBUtil;

import org.slf4j.LoggerFactory;
import org.slf4j.Logger;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TapeDAO extends DataAccessObject<Tape>{

    private static final Logger logger = LoggerFactory.getLogger(TapeDAO.class);

    private final String INSERT = "INSERT INTO Tapes VALUES(?,?,?)";
    private final String UPDATE = "UPDATE Tapes SET Type=? WHERE TapeID=? AND TitleID=?";
    private final String DELETE = "DELETE FROM Tapes WHERE  TitleID=? AND TapeID";
    private final String GET_ALL = "SELECT * FROM Tapes";
    private final String GET_ONE = "SELECT * FROM Tapes WHERE TapeID =?";

    @Override
    public void create(Tape tape) {
        try(PreparedStatement statement = DBUtil.getConnection().prepareStatement(INSERT)){
            statement.setInt(1, tape.getId());
            statement.setInt(2, tape.getTitle().getId());
            statement.setString(3, String.valueOf(tape.getType()));
            statement.executeUpdate();
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
        char type;
        Title title;
        try(PreparedStatement statement = DBUtil.getConnection().prepareStatement(GET_ALL)){
            ResultSet rs = statement.executeQuery();

            while (rs.next()){

                type = rs.getString("type").charAt(0);
                int titleId = rs.getInt("TitleID");
               title = new TitleDAO().getById(titleId);

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

        return tapeList.stream().toList();
    }

    @Override
    public Tape getById(int id) {
        Tape tape;
        try(PreparedStatement statement = DBUtil.getConnection().prepareStatement(GET_ONE)){
            statement.setInt(1, id);
            ResultSet rs = statement.executeQuery();

            char type = rs.getString("type").charAt(0);
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
        try(PreparedStatement statement = DBUtil.getConnection().prepareStatement(UPDATE)){
            statement.setString(1, String.valueOf(tape.getType()));
            statement.setInt(2, tape.getTitle().getId());
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
        try(PreparedStatement statement = DBUtil.getConnection().prepareStatement(DELETE)){
            statement.setInt(1, id);
            statement.execute();
            logger.info("Deleting tape data completed");
        }catch (SQLException e){
            logger.error("Deleting tape data, unsuccessfully");
            throw new RuntimeException();
        }

    }
}
