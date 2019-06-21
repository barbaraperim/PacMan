package map;

public class MapPoint extends Point {

  private char charRep;
  private MapPointTiles tile;

  public MapPoint (int x, int y, char ch) {
    super(x, y);

    this.charRep = ch;
    for (MapPointTiles tiles : MapPointTiles.values()){
     if (tiles.charRep == ch){
       this.tile = tiles;
     }
    }
  }

  @Override
  public String toString() {
    return String.valueOf(charRep);
  }

  public char getRepresentation () {
    return this.charRep;
  }
}
