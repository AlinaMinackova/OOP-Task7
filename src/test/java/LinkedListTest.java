import L7.Exceptions.NotFoundException;
import L7.LinkedList;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class LinkedListTest {

    @Test
    @DisplayName("add")
    void addIntegerTest() {
        LinkedList<Integer> list = new LinkedList<>();
        list.add(4);
        list.add(5);
        list.add(6);
        Assertions.assertEquals(list.getHead().getValue(), 4);
        Assertions.assertEquals(list.getTail().getValue(), 6);
        Assertions.assertEquals(list.size(), 3);
    }

    @Test
    @DisplayName("delete")
    void deleteIntegerTest() {
        LinkedList<Integer> list = new LinkedList<>();
        list.add(4);
        list.add(5);
        list.add(6);
        list.delete();
        Assertions.assertEquals(list.size(), 2);
        Assertions.assertEquals(list.getTail().getValue(), 5);
        list.delete();
        list.delete();
        Assertions.assertEquals(list.size(), 0);
    }

    @Test
    @DisplayName("delete(T value)")
    void deleteValueIntegerTest() {
        LinkedList<Integer> list = new LinkedList<>();
        list.add(4);
        list.add(5);
        list.add(6);
        list.delete(5);
        Assertions.assertEquals(list.size(), 2);
        assertThrows(NotFoundException.class,
                () -> list.delete(5));
    }

    @Test
    @DisplayName("findByValue")
    void findByValueIntegerTest() {
        LinkedList<Integer> list = new LinkedList<>();
        list.add(4);
        list.add(5);
        list.add(6);
        Assertions.assertEquals(list.findByValue(5).getValue(), 5);
        assertThrows(NotFoundException.class,
                () -> list.findByValue(7));
    }

    @Test
    @DisplayName("add")
    void addStringTest() {
        LinkedList<String> list = new LinkedList<>();
        list.add("Hello");
        list.add("world");
        list.add("!");
        Assertions.assertEquals(list.getHead().getValue(), "Hello");
        Assertions.assertEquals(list.getTail().getValue(), "!");
        Assertions.assertEquals(list.size(), 3);
    }

    @Test
    @DisplayName("delete")
    void deleteStringTest() {
        LinkedList<String> list = new LinkedList<>();
        list.add("Hello");
        list.add("world");
        list.add("!");
        list.delete();
        Assertions.assertEquals(list.size(), 2);
        Assertions.assertEquals(list.getTail().getValue(), "world");
        list.delete();
        list.delete();
        Assertions.assertEquals(list.size(), 0);
    }

    @Test
    @DisplayName("delete(T value)")
    void deleteValueStringTest() {
        LinkedList<String> list = new LinkedList<>();
        list.add("Hello");
        list.add("world");
        list.add("!");
        list.delete("world");
        Assertions.assertEquals(list.size(), 2);
        assertThrows(NotFoundException.class,
                () -> list.delete("world"));
    }

    @Test
    @DisplayName("findByValue")
    void findByValueStringTest() {
        LinkedList<String> list = new LinkedList<>();
        list.add("Hello");
        list.add("world");
        list.add("!");
        Assertions.assertEquals(list.findByValue("world").getValue(), "world");
        assertThrows(NotFoundException.class,
                () -> list.findByValue("!!"));
    }

}
