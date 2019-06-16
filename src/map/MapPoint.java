package map;

public class MapPoint extends Point {
  private int x, y;
  boolean isPastille, isSpecialPastille, isWall;

  public MapPoint (int x, int y, boolean isPastille, boolean isSpecialPastille, boolean isWall) {
    super(x, y);
    this.isPastille = isPastille;
    this.isSpecialPastille = isSpecialPastille;
    this.isWall = isWall;
  }

  public boolean isWall () {
    return this.isWall;
  }

  public boolean isSpecialPastille () {
    return this.isSpecialPastille;
  }

  public boolean removePastille () {
    boolean dumb = (this.isSpecialPastille || this.isPastille);
    this.isSpecialPastille = false;
    this.isPastille = false;
    return dumb;
  }

  public char getRepresentation () {
    if (isSpecialPastille) return '0';
    if (isPastille) return 'o';
    if (isWall) return '#';
    return ' ';
  }
}
