package imputOutput;

import java.util.Scanner;

public class Reader {
  private Scanner scanner;
  private static Reader reader = null;

  private Reader () {
    this.scanner = new Scanner(System.in);
  }
  public Reader getInstance () {
    if (reader == null) reader = new Reader ();
    return reader;
  }

  public String readString () {
    return this.scanner.nextLine();
  }
}
