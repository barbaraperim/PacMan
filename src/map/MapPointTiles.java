package map;

public enum MapPointTiles{
    PASTILLE('.'),
    SPECIAL_PASTILLE('0'),
    WALL('='),
    EMPTY('E');

    public char charRep;
    MapPointTiles(char c){this.charRep = c;}
}
