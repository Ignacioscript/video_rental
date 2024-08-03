package dao;

import model.Tape;
import util.DBUtil;

import org.slf4j.LoggerFactory;
import org.slf4j.Logger;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public class TapeDAO extends DataAccessObject<Tape>{

    private static final Logger logger = LoggerFactory.getLogger(TapeDAO.class);

    private final String INSERT = "INSERT INTO Tapes VALUES(?,?,?)";
    private final String UPDATE = "UPDATE Tapes SET Type=? WHERE TapeID=? AND TitleID=?";
    private final String DELETE = "DELETE FROM Tapes WHERE TapeID=? AND TitleID=?";
    private final String GET_ALL = "SELECT * FROM Tapes";
    private final String GET_ONE = "SELECT * FROM Tapes WHERE TapeID =? AND TitleID=?";

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
        return List.of();
    }

    @Override
    public Tape getById(int id) {
        return null;
    }

    @Override
    public void update(Tape tape) {

    }

    @Override
    public void deleteById(int id) {

    }
}
