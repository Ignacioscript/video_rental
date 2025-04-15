package service;

import dao.DataAccessObject;
import dao.TapeDAO;
import model.Tape;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TapeService extends DataAccessObject<Tape> {


    private final TapeDAO tapeDAO;

    public TapeService(JdbcTemplate jdbcTemplate, TapeDAO tapeDAO) {
        super(jdbcTemplate);
        this.tapeDAO = tapeDAO;
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
    public void update(Tape tape, int id) {
        tapeDAO.update(tape, id);
    }

    @Override
    public void deleteById(int id) {
        tapeDAO.deleteById(id);
    }
}

