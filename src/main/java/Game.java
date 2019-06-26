import characters.GameContext;
import characters.Location;
import map.Maze;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.Scanner;

public class Game implements GameContext, KeyListener {
    ArrayList<Location> ghostLocations;
    private ArrayList<Location> pacManLocations;
    private Maze maze;
    private Integer pastillesLeft;
    private Boolean hasEnded() {
        return false;
    }

    @Override
    public void keyTyped(KeyEvent keyEvent) {

    }

    @Override
    public void keyPressed(KeyEvent keyEvent) {
        System.out.println(keyEvent.getKeyChar());
    }

    @Override
    public void keyReleased(KeyEvent keyEvent) {

    }

    public void Play () {
        /*
            1 - Escolher Mapa e instanciar
            2 - Setar posição dos personagens
            3 - Pedir input, com input verificar: se mesma posição que fantasma, se pastilha, se pastilha especial
            4 - Verificar se acabou, se morreu ou se ganhou
        * */
//        Scanner sc = new Scanner(System.in);
//        System.out.println("Escolha o mapa 1, 2, 3: ");

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
