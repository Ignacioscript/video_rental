package dao;

import model.Title;

import org.slf4j.LoggerFactory;
import org.slf4j.Logger;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class TitleDAO extends DataAccessObject<Title>{


    private static final Logger logger = LoggerFactory.getLogger(TitleDAO.class);

    private final String INSERT = "Insert into Titles(TitleID, Title, Year, Price, URL, Image) Values (?,?,?,?,?,?)";
    private final String UPDATE = "UPDATE Titles SET Title=?, Year=?, Price=?, URL=?, Image=? WHERE TitleID = ? ";
    private final String DELETE = "DELETE from Titles WHERE TitleID = ?";
    private final String GET_ONE = "SELECT * FROM Titles WHERE TitleID = ?";
    private final String GET_ALL = "SELECT * FROM Titles";

    public TitleDAO(JdbcTemplate jdbcTemplate) {
        super(jdbcTemplate);
    }


    @Override
    public void create(Title title) {
        jdbcTemplate.update(INSERT,
                title.getId(),
                title.getTitle(),
                title.getYear(),
                title.getPrice(),
                title.getURL(),
                title.getImage()
                );
    }

    @Override
    public List<Title> getAll() {
        return jdbcTemplate.query(GET_ALL, titleRowMapper());
    }

    @Override
    public Title getById(int id) {
        return jdbcTemplate.queryForObject(GET_ONE, new Object[]{id}, titleRowMapper());
    }

    @Override
    public void update(Title title, int id) {
        jdbcTemplate.update(UPDATE,
                title.getId(),
                title.getTitle(),
                title.getYear(),
                title.getImage(),
                title.getURL(),
                title.getImage(),
                id
                );
    }

    @Override
    public void deleteById(int id) {
        jdbcTemplate.update(DELETE, id);

    }

    public RowMapper<Title> titleRowMapper(){
        return (rs, rowNum) -> new Title(
                rs.getInt("TitleID"),
                rs.getString("Title"),
                rs.getInt("Year"),
                rs.getDouble("Price"),
                rs.getString("URL"),
                rs.getString("Image")

        );
    }
}



