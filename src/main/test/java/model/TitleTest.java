package model;

import model.resolvers.TitleParameterResolver;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(TitleParameterResolver.class)
class TitleTest {



    @Test
    void getTitle(Title title) {
        assertEquals("Lord of the Rings", title.getTitle());
    }

    @Test
    void getYear(Title title) {
        assertEquals(2001, title.getYear());
    }

    @Test
    void getPrice(Title title) {
        assertEquals(25.5, title.getPrice());
    }

    @Test
    void getURL(Title title) {
        assertEquals("No url", title.getURL());
    }

    @Test
    void getImage(Title title) {
        assertEquals("No image", title.getImage());
    }

    @Test
    void getId(Title title) {
        assertEquals(1, title.getId());
    }
}