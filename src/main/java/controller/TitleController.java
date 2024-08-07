package controller;

import dao.DataAccessObject;
import model.Title;
import service.TitleService;

import java.util.List;

public class TitleController extends DataAccessObject<Title> {


    private final TitleService titleService;

    public TitleController(){
        this.titleService = new TitleService();
    }


    @Override
    public void create(Title title) {
        try{
            titleService.create(title);
            logger.info("Title created successfully");

        }catch (Exception e){
            logger.error("Error creating Title: {}", e.getMessage());
            throw new RuntimeException("Failed creating Title: ", e);
        }

    }

    @Override
    public List<Title> getAll() {
        try{
            return titleService.getAll();
        }catch (Exception e){
            logger.error("Error retrieving Title list: {}", e.getMessage());
            throw new RuntimeException("Failed retrieving Title list", e);
        }

    }

    @Override
    public Title getById(int id) {
        try{
            return titleService.getById(id);
        }catch (Exception e){
            logger.error("Error retrieving Title by ID: {} ", e.getMessage());
            throw new RuntimeException("Failed retrieving Title by ID", e);
        }
    }

    @Override
    public void update(Title title) {
        try{
            titleService.update(title);
            logger.info("Updating title data success");
        }catch (Exception e){
            logger.error("Error updating title data: {}", e.getMessage());
            throw new RuntimeException("Failed updating title data: ", e);
        }

    }

    @Override
    public void deleteById(int id) {
        try{
            titleService.deleteById(id);
            logger.info("Deleting title by ID success");
        }catch (Exception e){
            logger.error("Error deleting Title by ID: {}", e.getMessage());
            throw new RuntimeException("Failed deleting Title by ID:", e);
        }

    }
}
