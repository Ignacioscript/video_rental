package service;

import dao.DataAccessObject;
import dao.TapeDAO;
import model.Tape;

import java.util.List;

public class TapeService extends DataAccessObject<Tape> {


    private final TapeDAO tapeDAO;

    public TapeService(){
        this.tapeDAO = new TapeDAO();
    }

    @Override
    public void create(Tape tape) {
        tapeDAO.create(tape);
    }

    @Override
    public List<Tape> getAll() {
        return tapeDAO.getAll();
    }

    @Override
    public Tape getById(int id) {
        return tapeDAO.getById(id);
    }

    @Override
    public void update(Tape tape) {
        tapeDAO.update(tape);
    }

    @Override
    public void deleteById(int id) {
        tapeDAO.deleteById(id);
    }
}
