public class Printer {
  private static Printer printer = null;

  private Printer () {
    //não sei o que colocar aqui
  }

  public Printer getInstance () {
    if (printer == null) printer = new Printer();
    return printer;
  }

  //https://www.quora.com/How-do-I-clear-console-screen-CMD-screen-in-Java-Is-there-any-function-in-Java-like-clrscr-and-system-cls-in-C
  private void clearScreen () {
    System.out.print("\033[H\033[2J");
    System.out.flush();
  }


  //temos que add outras coisas no frame, como tempo no power up, pontuação, vidas
  //podemos dividir isso em varios metodos, como buildFrame, printFrame, buildTitle...
  public void printFrame (Map map, Character[] charactersVector) {
    this.clearScreen();

    char[][] frame = map.printMap();
    //placing each character in the frame
    for (int i = 0; i < charactersVector.size(); i++)
      frame[charactersVector[i].getPosition().getX()][charactersVector[i].getPosition().gety()] = charactersVector[i].getRepresentation();

    for (int i = 0; i < charactersVector.size(); i++){
      for (int j = 0; j < charactersVector.size(); j++)
        System.out.print(frame);
      System.out.print("\n");
    }
  }
}
