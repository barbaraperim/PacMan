import characters.GameContext;
import characters.Location;
import map.Maze;

import java.util.ArrayList;

public class Game implements GameContext {
    ArrayList<Location> ghostLocations;
    private ArrayList<Location> pacManLocations;
    private Maze maze;
    private Integer pastillesLeft;
    private Boolean hasEnded() {
        return false;
    }


    public void Play () {
        /*
            1 - Escolher Mapa e instanciar
            2 - Setar posição dos personagens
            3 - Pedir input, com input verificar: se mesma posição que fantasma, se pastilha, se pastilha especial
            4 - Verificar se acabou, se morreu ou se ganhou
        * */
    }

    @Override
    public ArrayList<Location> getGhostLocations() {
        return this.ghostLocations;
    }

    @Override
    public ArrayList<Location> getPacManLocations() {
        return this.pacManLocations;
    }

    @Override
    public Integer getColumnSize() {
        return this.maze.getColumnSize();
    }

    @Override
    public Integer getLineSize() {
        return this.maze.getLineSize();
    }

    @Override
    public boolean isValidLocation(double x, double y) throws Exception{
        return this.maze.isValidLocation(x,y);
    }

}
