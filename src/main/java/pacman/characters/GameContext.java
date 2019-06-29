package characters;

import java.util.ArrayList;
import map.Maze;

public interface GameContext {

    ArrayList<Location> getGhostLocations();

    Location getPacManLocation();

    Maze getMaze();

    Score getScore();

    Direction getInputDirection();

    ArrayList<Figures> getFiguresList();

    }
