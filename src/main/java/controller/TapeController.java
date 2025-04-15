package controller;

import dao.DataAccessObject;
import model.Tape;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import service.TapeService;

import java.util.List;

@Controller
public class TapeController extends DataAccessObject<Tape> {


    private final TapeService tapeService;

    public TapeController(JdbcTemplate jdbcTemplate, TapeService tapeService) {
        super(jdbcTemplate);
        this.tapeService = tapeService;
    }


    @Override
    public void create(Tape tape) {
        tapeService.create(tape);
    }

    @Override
    public List<Tape> getAll() {
        return tapeService.getAll();
    }

    @Override
    public Tape getById(int id) {
        return tapeService.getById(id);
    }

    @Override
    public void update(Tape tape, int id) {
        tapeService.update(tape, id);
    }

    @Override
    public void deleteById(int id) {
        tapeService.deleteById(id);
    }
}
