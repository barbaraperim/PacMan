package imputOutput;

import characters.GameContext;
import characters.Score;
import characters.Figures;
import map.Maze;

import javax.imageio.metadata.IIOMetadataNode;
import java.util.ArrayList;

public class Printer {

  public Printer () {
  }

  private void clearScreen () {
    System.out.print("\033[H\033[2J");
    System.out.flush();
  }

  private void printTitleBar (GameContext gameContext) {
    Score score = gameContext.getScore();
    int lifeCount = (score.lifeCount()-1);
    String lifeCountStr = (lifeCount >= 0) ? Integer.toString(lifeCount) : "VOCÊ MORREU x(";
    String s = "  Score : " + score.getScore() + "     Extra lifes : " + lifeCountStr;
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
