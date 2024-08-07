package dao;

import interfaces.DataTransferObject;
import org.slf4j.LoggerFactory;
import org.slf4j.Logger;
import util.DBUtil;
import java.util.List;

public abstract class DataAccessObject <T extends DataTransferObject>{

    //adding a logger for being uses in all subclasses
    protected static final Logger logger = LoggerFactory.getLogger(DataAccessObject.class);

    public DataAccessObject(){
        DBUtil.getConnection();
    }


    //CRUD
    public abstract void create(T t);
    public abstract List<T> getAll();
    public abstract T getById(int id);
    public abstract void update(T t);
    public abstract void deleteById(int id);
}
