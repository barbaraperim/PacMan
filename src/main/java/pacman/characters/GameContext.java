package characters;

import java.util.ArrayList;

public interface GameContext {

    ArrayList<Location> getGhostLocations();

    ArrayList<Location> getPacManLocations();

    Integer getColumnSize();

    Integer getLineSize();

    boolean isValidLocation(double x, double y) throws Exception;
}
