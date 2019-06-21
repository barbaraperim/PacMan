package characters.ghost;

import characters.Figures;
import map.Maze;

public class Random extends Figures implements Ghost {

    @Override
    public void move(Maze maze) {
        boolean moved = false;
        while(!moved){
            Integer min = 0;
            Integer max = maze.getColumnSize();
            Integer column = min + (int)(Math.random() * ((max - min) + 1));

            max = maze.getLineSize();
            Integer line = min + (int)(Math.random() * ((max - min) + 1));

            if (maze.isValidLocation(line, column)){
                this.location.setY(line);
                this.location.setX(column);
                moved = true;
            }
        }
    }
}
