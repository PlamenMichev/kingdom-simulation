import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import utility.collection.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

public class ArrayListTest {

    @Test
    public void list_is_initialized_with_size_0() {
        // Arrange and Act
        var list = new ArrayList<Integer>();

        // Assert
        assertEquals(0,list.size());
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 10, 100, 1000})
    public void list_adds_element(int amountOfElements) {
        // Arrange
        var list = new ArrayList<Integer>();

        // Act
        for (int i = 0; i < amountOfElements; i++) {
            list.add(i);
        }

        // Assert
        assertEquals(amountOfElements, list.size());
        for (int i = 0; i < amountOfElements; i++) {
            assertEquals(i, list.get(i));
        }
    }

    @Test
    public void list_adds_element_at_index() {
        // Arrange
        var list = new ArrayList<Integer>();
        list.add(0);
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);

        // Act
        list.add(2, 10);

        // Assert
        assertEquals(6, list.size());
        assertEquals(0, list.get(0));
        assertEquals(1, list.get(1));
        assertEquals(10, list.get(2));
        assertEquals(2, list.get(3));
        assertEquals(3, list.get(4));
    }

    @Test
    public void list_throw_exception_when_adding_element_at_index_out_of_bounds() {
        // Arrange
        var list = new ArrayList<Integer>();
        list.add(0);
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);

        // Act and Assert
        assertThrows(IndexOutOfBoundsException.class, () -> {
            list.add(10, 10);
        });
    }

    @Test
    public void list_removes_element() {
        // Arrange
        var list = new ArrayList<Integer>();
        list.add(0);
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);

        // Act
        list.remove(2);

        // Assert
        assertEquals(4, list.size());
        assertEquals(0, list.get(0));
        assertEquals(1, list.get(1));
        assertEquals(3, list.get(2));
        assertEquals(4, list.get(3));
    }

    @Test
    public void list_removes_element_by_value() {
        // Arrange
        var list = new ArrayList<String>();
        list.add("a");
        list.add("b");
        list.add("c");

        // Act
        list.remove("b");

        // Assert
        assertEquals(2, list.size());
        assertEquals("a", list.get(0));
        assertEquals("c", list.get(1));
    }

    @Test
    public void list_throws_exception_when_removing_element_out_of_bounds() {
        // Arrange
        var list = new ArrayList<Integer>();
        list.add(0);
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);

        // Act and Assert
        assertThrows(IndexOutOfBoundsException.class, () -> {
            list.remove(10);
        });
    }

    @Test
    public void list_contains_element() {
        // Arrange
        var list = new ArrayList<Integer>();
        list.add(0);
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);

        // Act and Assert
        assertTrue(list.contains(0));
        assertTrue(list.contains(1));
        assertTrue(list.contains(2));
        assertTrue(list.contains(3));
        assertTrue(list.contains(4));
        assertFalse(list.contains(10));
    }

    @Test
    public void list_gets_element() {
        // Arrange
        var list = new ArrayList<Integer>();
        list.add(0);
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);

        // Act and Assert
        assertEquals(0, list.get(0));
        assertEquals(1, list.get(1));
        assertEquals(2, list.get(2));
        assertEquals(3, list.get(3));
        assertEquals(4, list.get(4));
    }

    @Test
    public void list_throw_exception_when_getting_element_out_of_bounds() {
        // Arrange
        var list = new ArrayList<Integer>();
        list.add(0);
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);

        // Act and Assert
        assertThrows(IllegalStateException.class, () -> {
            list.get(10);
        });
    }

    @Test
    public void list_index_of_element() {
        // Arrange
        var list = new ArrayList<Integer>();
        list.add(0);
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);

        // Act and Assert
        assertEquals(0, list.indexOf(0));
        assertEquals(1, list.indexOf(1));
        assertEquals(2, list.indexOf(2));
        assertEquals(3, list.indexOf(3));
        assertEquals(4, list.indexOf(4));
        assertEquals(-1, list.indexOf(10));
    }

    @Test
    public void list_is_empty() {
        // Arrange
        var list = new ArrayList<Integer>();

        // Act and Assert
        assertTrue(list.isEmpty());
        list.add(0);
        assertFalse(list.isEmpty());
    }

    @Test
    public void list_is_full() {
        // Arrange
        var list = new ArrayList<Integer>();

        // Act and Assert
        assertTrue(list.isFull());

        for (int i = 0; i < 1000; i++) {
            list.add(i);
        }

        assertTrue(list.isFull());
    }

    @Test
    public void list_set_element() {
        // Arrange
        var list = new ArrayList<Integer>();
        list.add(0);
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);

        // Act
        list.set(2, 10);

        // Assert
        assertEquals(5, list.size());
        assertEquals(0, list.get(0));
        assertEquals(1, list.get(1));
        assertEquals(10, list.get(2));
        assertEquals(3, list.get(3));
        assertEquals(4, list.get(4));
    }

    @Test
    public void list_set_throws_exception_when_setting_element_out_of_bounds() {
        // Arrange
        var list = new ArrayList<Integer>();
        list.add(0);
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);

        // Act and Assert
        assertThrows(IndexOutOfBoundsException.class, () -> {
            list.set(10, 10);
        });
    }

    @Test
    public void list_size() {
        // Arrange
        var list = new ArrayList<Integer>();

        // Act and Assert
        assertEquals(0, list.size());
        list.add(0);
        assertEquals(1, list.size());
        list.add(1);
        assertEquals(2, list.size());
        list.add(2);
        assertEquals(3, list.size());
        list.add(3);
        assertEquals(4, list.size());
        list.add(4);
        assertEquals(5, list.size());
    }

    @Test
    public void list_toString() {
        // Arrange
        var list = new ArrayList<Integer>();

        // Act and Assert
        assertEquals("{}", list.toString());
        list.add(0);
        assertEquals("{0}", list.toString());
        list.add(1);
        assertEquals("{0, 1}", list.toString());
        list.add(2);
        assertEquals("{0, 1, 2}", list.toString());
        list.add(3);
        assertEquals("{0, 1, 2, 3}", list.toString());
        list.add(4);
        assertEquals("{0, 1, 2, 3, 4}", list.toString());
    }

    @Test
    public void list_to_string_works_with_string_elements() {
        // Arrange
        var list = new ArrayList<String>();

        // Act
        list.add("a");
        list.add("b");
        list.add("c");

        // Assert
        assertEquals("{a, b, c}", list.toString());
    }
}
