package service;

import dao.DataAccessObject;
import dao.TitleDAO;
import model.Title;

import java.util.List;

public class TitleService extends DataAccessObject<Title> {


    private final TitleDAO titleDAO;

    public TitleService() {
        this.titleDAO = new TitleDAO();
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
    public void update(Title title) {
        titleDAO.update(title);
    }

    @Override
    public void deleteById(int id) {
        titleDAO.deleteById(id);
    }
}
