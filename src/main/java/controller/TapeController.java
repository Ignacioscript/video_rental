package controller;

import dao.DataAccessObject;
import model.Tape;
import service.TapeService;

import java.util.List;

public class TapeController extends DataAccessObject<Tape> {


    private final TapeService tapeService;

    private TapeController(){
        this.tapeService = new TapeService();
    }

    @Override
    public void create(Tape tape) {
        try{
            tapeService.create(tape);
            logger.info("Tape data was created successfully");
        }catch (Exception e){
            logger.error("Error creating Tape data: {}", e.getMessage());
            throw new RuntimeException("Failed creating Tape data: ", e);
        }


    }

    @Override
    public List<Tape> getAll() {
        try{
            return tapeService.getAll();
        }catch (Exception e){
            logger.error("Error retrieving Tape list: {}", e.getMessage());
            throw new RuntimeException("Failed retrieving Tape list: ", e);
        }

    }

    @Override
    public Tape getById(int id) {
        try{
            return tapeService.getById(id);
        }catch (Exception e){
            logger.error("Error retrieving Tape: {}", e.getMessage());
            throw new RuntimeException("Failed retrieving Tape:", e);
        }

    }

    @Override
    public void update(Tape tape) {
        try{
            tapeService.update(tape);
            logger.info("Tape updated succesfully");
        }catch (Exception e){
            logger.error("Error updating Tape data: {}", e.getMessage());
            throw new RuntimeException("Failed updating Tape data: ", e);
        }

    }

    @Override
    public void deleteById(int id) {
        try{
            tapeService.deleteById(id);
            logger.info("Deleting Tape data success");
        }catch (Exception e){
            logger.error("Error deleting Tape data {}", e.getMessage());
            throw new RuntimeException("Failed deleting tape data", e);
        }

    }
}
