package characters;

import map.Maze;
import java.util.ArrayList;

public class GameContext {

    ArrayList<Location> ghostLocations;
    ArrayList<Location> pacManLocations;
    Integer columnSize, lineSize;
    Maze maze;

    public Integer getColumnSize() {
        return columnSize;
    }

    public Integer getLineSize() {
        return lineSize;
    }

    public boolean isValidLocation(Integer x, Integer y){
        return maze.isValidLocation(x, y);
    }
}
