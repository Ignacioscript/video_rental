package model;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class TapeTest {

    private Tape tape;
    private  Title title;


@BeforeEach
    public void setTape() {
    title = new Title(1, "Lord of the Rings", 2001, 10.5, "lotro.com", "images");
    tape = new Tape(1, title, 'A');

    }

@Test
    public void testGetId(){
        assertEquals(1, tape.getId());

    }

    @Test
    public void testGetTape(){
        assertEquals(this.title, tape.getTitle());
    }

    @Test
    public void testGetType(){
    assertEquals('A', tape.getType());
    }

@Test
    public void testSetId(){
        tape.setTapeId(3);
        assertEquals(3, tape.getId());

    }



    @Test
    public void testSetTape(){
        title = new Title(1, "Lord of the Rings", 2001, 10.5, "lotro.com", "images");
    tape.setTitle(title);
        assertEquals(this.title, tape.getTitle());
    }

    @Test
    public void testSetType(){
    tape.setType('B');
    assertEquals('B', tape.getType());
    }

}