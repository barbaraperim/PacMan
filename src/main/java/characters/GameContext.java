package characters;

import map.Maze;
import java.util.ArrayList;

public class GameContext {

    private ArrayList<Location> ghostLocations;
    private ArrayList<Location> pacManLocations;
    private Integer columnSize, lineSize;
    private Maze maze;

    public ArrayList<Location> getGhostLocations() {
        return ghostLocations;
    }

    public ArrayList<Location> getPacManLocations() {
        return pacManLocations;
    }

    public Integer getColumnSize() {
        return columnSize;
    }

    public Integer getLineSize() {
        return lineSize;
    }

    public boolean isValidLocation(double x, double y) throws Exception{
        return maze.isValidLocation(x, y);
    }
}
