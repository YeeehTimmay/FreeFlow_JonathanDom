import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class FieldTest {
  @Test
  public void createField() {
    Field f = new Field(5, 8, Type.LINE, Colors.RED);
    assertEquals(Type.LINE, f.getType());
    assertEquals(Colors.RED, f.getColor());
    assertEquals(5, f.getX());
    assertEquals(8, f.getY());
  }

  @Test
  public void getColor() {
    Field f = new Field(0, 0, Type.CIRCLE);
    Field f2 = new Field(0, 0, Type.EMPTY, Colors.RED);
    assertEquals(null, f.getColor());
    assertEquals(Colors.RED, f2.getColor());
  }
}
