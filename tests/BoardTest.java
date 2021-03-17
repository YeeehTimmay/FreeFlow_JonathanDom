import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

public class BoardTest {
  @Test
  public void createBoard() {
    Board b = new Board(5);
    assertEquals(Type.EMPTY, b.getField(0, 0).getType());
    assertThrows(IllegalArgumentException.class, () -> new Board(0));
    assertThrows(IllegalArgumentException.class, () -> new Board(-7));
  }

  @Test
  public void cantGetWrongField() {
    Board b = new Board(5);
    assertThrows(IllegalArgumentException.class, () -> b.getField(-5, 0));
    assertThrows(IllegalArgumentException.class, () -> b.getField(0, -5));
    assertThrows(IllegalArgumentException.class, () -> b.getField(5, 0));
    assertThrows(IllegalArgumentException.class, () -> b.getField(0, 5));
  }

  @Test
  public void getField() {
    Board b = new Board(5);
    assertEquals(b.getField(0, 0).getColor(), null);
    assertEquals(b.getField(0, 0).getType(), Type.EMPTY);
  }

  @Test
  public void cantSetWrongField() {
    Board b = new Board(5);
    assertThrows(IllegalArgumentException.class, () -> b.setField(-5, 0, Type.CIRCLE, Colors.BLUE));
    assertThrows(IllegalArgumentException.class, () -> b.setField(0, -5, Type.CIRCLE, Colors.BLUE));
    assertThrows(IllegalArgumentException.class, () -> b.setField(5, 0, Type.CIRCLE, Colors.BLUE));
    assertThrows(IllegalArgumentException.class, () -> b.setField(5, 5, Type.CIRCLE, Colors.BLUE));
  }

  @Test
  public void setField() {
    Board b = new Board(5);
    b.setField(4, 3, Type.LINE, Colors.GREEN);
    assertEquals(Type.LINE, b.getField(4, 3).getType());
    assertEquals(Colors.GREEN, b.getField(4, 3).getColor());
  }

  @Test
  public void checkValidField() {
    Board b = new Board(5);
    assertFalse(b.checkValidField(-5, 0));
    assertFalse(b.checkValidField(0, -5));
    assertFalse(b.checkValidField(5, 0));
    assertFalse(b.checkValidField(0, 5));
    assertTrue(b.checkValidField(0, 0));
  }

  @Test
  public void checkForEmptyFields() {
    Board b = new Board(2);
    assertTrue(b.checkForEmptyFields());
    b.setField(0, 0, Type.CIRCLE, Colors.GREEN);
    b.setField(1, 0, Type.CIRCLE, Colors.GREEN);
    b.setField(0, 1, Type.CIRCLE, Colors.GREEN);
    b.setField(1, 1, Type.CIRCLE, Colors.GREEN);
    assertFalse(b.checkForEmptyFields());
  }
}
