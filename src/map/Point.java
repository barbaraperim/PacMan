package map;

public class Point {
  private int x, y;

  public Point (int x, int y) {
    this.x = x;
    this.y = y;
  }

  public boolean isEqual(Point other) {
    return (this.x == other.x && this.y == other.y);
  }

  public int getX () {
    return this.x;
  }
  public int getY () {
    return this.y;
  }
  
  public Point up () {
    return new Point (this.x - 1, this.y);
  }
  public Point left () {
    return new Point (this.x, this.y - 1);
  }
  public Point down () {
    return new Point (this.x + 1, this.y);
  }
  public Point right () {
    return new Point (this.x, this.y + 1);
  }
}
