package characters.ghost;

import characters.Direction;
import characters.Figures;
import characters.GameContext;
import characters.Location;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Evasive extends Figures {

    public Evasive (int x, int y) {
        super(x,y);
        this.setCharRep('V');
    }

    @Override
    public void move(GameContext gameContext){
        ArrayList<Location> ghostLocation = gameContext.getGhostLocations();
        double distance, biggestDistance = 0;
        Direction direction = null;
        Boolean moved = false;
        List<Direction> directions =  new LinkedList<Direction>(Arrays.asList(Direction.values()));

        while (!moved) {
            for (Direction d : directions) {
                Location newLocation = this.location.clone();
                distance = 0;
                switch (d){
                    case RIGHT:
                        newLocation = newLocation.right();
                        break;
                    case DOWN:
                        newLocation = newLocation.down();
                        break;
                    case LEFT:
                        newLocation = newLocation.left();
                        break;
                    case UP:
                        newLocation = newLocation.up();
                        break;
                }

                for (Location l : ghostLocation) {
                    distance += newLocation.distance(l);
                }

                if (distance >= biggestDistance) {
                    biggestDistance = distance;
                    direction = d;
                }
            }

            try {
                this.walk(direction, gameContext);
                moved = true;
            } catch (Exception e) {
                directions.remove(direction);
            }
        }
    }
}
