package map;

public enum MapTile {
    PASTILLE('.'),
    SPECIAL_PASTILLE('0'),
    WALL('='),
    EMPTY('E');

    public char charRep;
    MapTile(char c){this.charRep = c;}
}
