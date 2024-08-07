package dao;

import interfaces.DataTransferObject;
import util.DBUtil;
import java.util.List;

public abstract class DataAccessObject <T extends DataTransferObject>{


    //atributte to create loggers into all the subclases
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
