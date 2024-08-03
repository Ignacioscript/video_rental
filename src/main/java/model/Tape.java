package model;

import interfaces.DataTransferObject;

public class Tape implements DataTransferObject {


    private int tapeId;
    private Title title;
    private char type;

    public Tape(int tapeId, Title title, char type) {
        this.tapeId = tapeId;
        this.title = title;
        this.type = type;
    }

    public Tape() {
    }



    public void setTapeId(int tapeId) {
        this.tapeId = tapeId;
    }

    public Title getTitle() {
        return title;
    }

    public void setTitle(Title title) {
        this.title = title;
    }

    public char getType() {
        return type;
    }

    public void setType(char type) {
        this.type = type;
    }

    @Override
    public int getId() {
        return this.tapeId;
    }
}
