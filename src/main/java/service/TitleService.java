package service;

import dao.DataAccessObject;
import dao.TitleDAO;
import model.Title;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TitleService extends DataAccessObject<Title> {


    private final TitleDAO titleDAO;

    public TitleService(JdbcTemplate jdbcTemplate, TitleDAO titleDAO) {
        super(jdbcTemplate);
        this.titleDAO = titleDAO;
    }

    @Override
    public void create(Title title) {
        titleDAO.create(title);
    }

    @Override
    public List<Title> getAll() {
        return titleDAO.getAll();
    }

    @Override
    public Title getById(int id) {
        return titleDAO.getById(id);
    }

    @Override
    public void update(Title title, int id) {
        titleDAO.update(title, id);
    }

    @Override
    public void deleteById(int id) {
        titleDAO.deleteById(id);
    }
}
