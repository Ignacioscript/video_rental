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
        try {
            titleDAO.update(title);
            logger.info("Creating title was success");
        }catch (Exception e){
            logger.error("Error creating title data: {}", e.getMessage());
            throw new RuntimeException("Failed creating title data: ", e);
        }

    }

    @Override
    public List<Title> getAll() {
        try {
            return titleDAO.getAll();

        }catch (Exception e){
            logger.error("Error retrieving title list data: {}", e.getMessage());
            throw new RuntimeException("Failed retrieving title list data: ", e);
        }
    }

    @Override
    public Title getById(int id) {

        try {
            return titleDAO.getById(id);
        } catch (Exception e) {
            logger.error("Error retrieving title by ID: {}", e.getMessage());
            throw new RuntimeException("Failed retrieving title by ID: ", e);
        }
    }

    @Override
    public void update(Title title) {
        try {
            titleDAO.update(title);
            logger.info("Updating title was success");
        }catch (Exception e){
            logger.error("Error updating title data: {}", e.getMessage());
            throw new RuntimeException("Failed updating title data: ", e);
        }
    }

    @Override
    public void deleteById(int id) {
        try {
            titleDAO.deleteById(id);
            logger.info("Deleting title by ID was a success");
        }catch (Exception e){
            logger.error("Error deleting title by ID: {}", e.getMessage());
            throw new RuntimeException("Failed deleting title by ID: ", e);
        }
    }
}
