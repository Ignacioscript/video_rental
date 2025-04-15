package controller;

import dao.DataAccessObject;
import model.Title;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import service.TitleService;

import java.util.List;

@Controller
public class TitleController extends DataAccessObject<Title> {


    private final TitleService titleService;

    public TitleController(JdbcTemplate jdbcTemplate, TitleService titleService) {
        super(jdbcTemplate);
        this.titleService = titleService;
    }

    @Override
    public void create(Title title) {
        titleService.create(title);
    }

    @Override
    public List<Title> getAll() {
        return titleService.getAll();
    }

    @Override
    public Title getById(int id) {
        return titleService.getById(id);
    }

    @Override
    public void update(Title title, int id) {
        titleService.update(title, id);
    }

    @Override
    public void deleteById(int id) {
        titleService.deleteById(id);
    }
}
