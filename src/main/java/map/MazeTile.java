package map;

public enum MazeTile {
    PASTILLE('.'),
    SPECIAL_PASTILLE('0'),
    WALL('='),
    EMPTY('E');

    public char charRep;
    MazeTile(char c){this.charRep = c;}
}
