package dao;

import model.Tape;
import model.Title;

import org.slf4j.LoggerFactory;
import org.slf4j.Logger;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public class TapeDAO extends DataAccessObject<Tape>{

    private final TitleDAO titleDAO;

    private static final Logger logger = LoggerFactory.getLogger(TapeDAO.class);

    private final String INSERT = "INSERT INTO Tapes VALUES(?,?,?)";
    private final String UPDATE = "UPDATE Tapes SET  TitleID=?, Type=? WHERE TapeID=?";
    private final String DELETE = "DELETE FROM Tapes WHERE  TitleID=? AND TapeID =?  ";
    private final String GET_ALL = "SELECT * FROM Tapes LIMIT 100 OFFSET 0";
    private final String GET_ONE = "SELECT * FROM Tapes WHERE TapeID =?";

    public TapeDAO(JdbcTemplate jdbcTemplate, TitleDAO titleDAO) {
        super(jdbcTemplate);
        this.titleDAO = titleDAO;
    }

    @Override
    public void create(Tape tape) {
        jdbcTemplate.update(INSERT,
                tape.getId(),
                tape.getTitle().getId(),
                tape.getType()
                );

    }

    @Override
    public List<Tape> getAll() {
        return jdbcTemplate.query(GET_ALL, tapeRowMapper());
    }

    @Override
    public Tape getById(int id) {
        return jdbcTemplate.queryForObject(GET_ONE, new Object[]{id}, tapeRowMapper());
    }

    @Override
    public void update(Tape tape, int id) {
        jdbcTemplate.update(UPDATE,
                tape.getId(),
                tape.getTitle().getId(),
                tape.getType(),
                id
        );
    }

    @Override
    public void deleteById(int id) {
        jdbcTemplate.update(DELETE, id);

    }

    public RowMapper<Tape> tapeRowMapper(){
        return (rs, rowNum) ->{
            Title title;
            try{
                title = titleDAO.getById(rs.getInt("TitleID"));
            }catch (Exception e){
                e.printStackTrace();
                throw new RuntimeException("Error fetching title ", e);
            }
            return new Tape(
                    rs.getInt("TapeID"),
                    title,
                    rs.getString("Type")
            );
        };
    }


}
