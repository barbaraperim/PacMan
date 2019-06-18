package map;
//map should be implemented as singleton.
//first we don't have to pass it as argument to every object
//second we should only have one at any time

public class Map {
  private MapPoint pointMatriz[][];
  //TODO: quando criar o mapa, lembra de contar esses dois atributos;
  private static int pastilleCounter, specialPastilleCounter;
  private static int mapSize = 40;
  private static Map map = null;

  //methods for "singleton"
  private static void MapRandom(){
      //creates random map
  }

  private Map (int numberOfFile) {
    //creates based on the number of the file
    //same number of the file ("map0.txt", "map1.txt"...)
    //if there's no such file with this number, we shoud return a random map
  }

  public static Map getInstance (int numberOfFile) {
    if (map == null) map = new Map(numberOfFile);
    return map;
  }

  public char[][] print () {
    char map[][] = new char[mapSize][mapSize];
    for(int i = 0; i < mapSize; i ++)
      for(int j = 0; j < mapSize; j++)
        map[i][j] = this.pointMatriz[i][j].getRepresentation();
    return map;
  }

  public boolean isWall (Point p) {
    //exceção de estar fora do mapa
    return this.pointMatriz[p.getX()][p.getY()].isWall();
  }

  public int getPastilleCounter () {
    return Map.pastilleCounter;
  }
  public int getSpecialPastilleCounter () {
    return Map.specialPastilleCounter;
  }
  public static int getSize () {
    return Map.mapSize;
  }
}
