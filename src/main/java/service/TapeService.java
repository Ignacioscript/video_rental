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
        try {
            tapeDAO.update(tape);
            logger.info("Creating Tape was success");
        }catch (Exception e){
            logger.error("Error creating Tape data: {}", e.getMessage());
            throw new RuntimeException("Failed creating Tape data: ", e);
        }
    }

    @Override
    public List<Tape> getAll() {
        try {
            return tapeDAO.getAll();

        }catch (Exception e){
            logger.error("Error retrieving Tape list data: {}", e.getMessage());
            throw new RuntimeException("Failed retrieving Tape list data: ", e);
        }
    }

    @Override
    public Tape getById(int id) {
        try {
            return tapeDAO.getById(id);
        }catch (Exception e){
            logger.error("Error retrieving Tape by ID: {}", e.getMessage());
            throw new RuntimeException("Failed retrieving Tape by ID: ", e);
        }
    }

    @Override
    public void update(Tape tape) {
        try {
            tapeDAO.update(tape);
            logger.info("Updating Tape was success");
        }catch (Exception e){
            logger.error("Error updating Tape data: {}", e.getMessage());
            throw new RuntimeException("Failed updating Tape data: ", e);
        }
    }

    @Override
    public void deleteById(int id) {
        try {
            tapeDAO.deleteById(id);
            logger.info("Deleting Tape by ID was a success");
        }catch (Exception e){
            logger.error("Error deleting Tape by ID: {}", e.getMessage());
            throw new RuntimeException("Failed deleting Tape by ID: ", e);
        }
    }
    }

