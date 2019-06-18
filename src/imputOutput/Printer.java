package imputOutput;

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

  private void printTitleBar () {
    int size = Map.getSize();
    Score score = Score.getInstance();
    String s = "  Score : " + score.getScore() + "     Extra lifes : " + score.lifeCount()-1;
    System.out.println(s);
  }
  private void printMap (Character[] cVector) {
    Map map = Map.getInstance();
    char[][] frame = map.printMap();

    //placing each character in the frame
    for (int i = 0; i < cVector.size(); i++)
      frame[cVector[i].getPosition().getX()][cVector[i].getPosition().getY()] = cVector[i].getRepresentation();

    //actual printing
    for (int i = 0; i < cVector.size(); i++){
      for (int j = 0; j < cVector.size(); j++)
        System.out.print(frame);
      System.out.print("\n");
    }
  }
  public void printFrame (Character[] cVector) {
    this.clearScreen();
    this.printTitleBar ();
    this.printMap(cVector);
  }

  public void printMenu () {
    this.clearScreen();
    System.out.print(Menu.getInstance().toString());
  }
  public void printEndScreen () {
    this.clearScreen();
    System.out.print(EndScreen.getInstance().toString());
  }
}
