package model;

import interfaces.DataTransferObject;

public class Tape implements DataTransferObject {


    private int tapeId;
    private Title title;
    private String type;
    private int titleId;

    public Tape(int tapeId, Title title, String type) {
        this.tapeId = tapeId;
        this.title = title;
        this.type = type;
        this.titleId = title.getId();
    }

    public Tape() {
    }

    public Tape(int tapeId, int titleId, String type){
        this.tapeId = tapeId;
        this.titleId = titleId;
        this.type = type;
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

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public int getId() {
        return this.tapeId;
    }

    @Override
    public String toString() {
        return "Tape{" +
                "tapeId=" + tapeId +
                ", titleID=" + titleId +
                ", type=" + type +
                '}';
    }
}
