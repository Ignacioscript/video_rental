package dao;

import interfaces.DataTransferObject;
import org.slf4j.LoggerFactory;
import org.slf4j.Logger;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;


public abstract class DataAccessObject <T extends DataTransferObject>{

    public static final Logger logger = LoggerFactory.getLogger(DataAccessObject.class);

    protected JdbcTemplate jdbcTemplate;


    public DataAccessObject(JdbcTemplate jdbcTemplate){
        this.jdbcTemplate = jdbcTemplate;

    }


    //CRUD
    public abstract void create(T t);
    public abstract List<T> getAll();
    public abstract T getById(int id);
    public abstract void update(T t, int id);
    public abstract void deleteById(int id);
}
