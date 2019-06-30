package imputOutput;

import characters.GameContext;
import characters.Score;
import characters.Figures;
import map.Maze;

import java.util.ArrayList;

public class Printer {

  public Printer () {
  }

  //https://www.quora.com/How-do-I-clear-console-screen-CMD-screen-in-Java-Is-there-any-function-in-Java-like-clrscr-and-system-cls-in-C
  private void clearScreen () {
    System.out.print("\033[H\033[2J");
    System.out.flush();
  }

  private void printTitleBar (GameContext gameContext) {
    Score score = gameContext.getScore();
    String s = "  Score : " + score.getScore() + "     Extra lifes : " + (score.lifeCount()-1);
    System.out.println(s);
  }
  private void printMap (GameContext gameContext) {
    Maze maze = gameContext.getMaze();
    StringBuilder frame = new StringBuilder().append(maze.toString());
    ArrayList<Figures> figuresArrayList = gameContext.getFiguresList();

    //placing each character in the frame
    for (Figures f : figuresArrayList)
      frame.setCharAt((int) (f.getLocation().getX()*(2*maze.getLineSize()+1) + 2*f.getLocation().getY()), f.getCharRep());

    System.out.print(frame);
  }

  public void printFrame (GameContext gameContext) {
    this.clearScreen();
    this.printTitleBar (gameContext);
    this.printMap(gameContext);
  }

//  public void printMenu () {
//    this.clearScreen();
//    System.out.print(Menu.getInstance().toString());
//  }
//  public void printEndScreen () {
//    this.clearScreen();
//    System.out.print(EndScreen.getInstance().toString());
//  }
}
