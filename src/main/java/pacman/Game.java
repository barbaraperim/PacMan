import characters.Direction;
import characters.GameContext;
import characters.Location;
import characters.Pacman;
import characters.Figures;
import characters.ghost.*;
import characters.Score;
import imputOutput.Printer;
import map.Maze;

import java.util.ArrayList;
import java.util.Scanner;

public class Game implements GameContext {
    private ArrayList<Figures> ghostsList;
    private Pacman pacman;

    private Maze maze;
    private Score score;

    private char lastInput = 'w';

    void play() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Escolha o mapa 1, 2, 3 (ou digite qualquer número para randomizar): ");

        this.maze = new Maze(sc.nextInt());
        this.score = new Score (this);
        System.out.println(this.maze.toString());

        this.pacman = new Pacman(maze.getColumnSize()/2 + 5, maze.getLineSize()/2);

        this.ghostsList = new ArrayList<>();
        this.ghostsList.add(new Stalker (maze.getColumnSize()/2, maze.getLineSize()/2));
        this.ghostsList.add(new Evasive (maze.getColumnSize()/2, maze.getLineSize()/2));
        this.ghostsList.add(new Prestige (maze.getColumnSize()/2, maze.getLineSize()/2));
        this.ghostsList.add(new Random (maze.getColumnSize()/2, maze.getLineSize()/2));

        Printer printer = new Printer();
        printer.printFrame(this);

        while (!score.hasEnded() && pacman.isAlive()) {
            //imprimir o frame
            printer.printFrame(this);

            //ler o input do usuario e guarda-lo em lastInput
            this.lastInput = sc.next().charAt(0);

            //pacman se move (ele vai perguntar pro game, depois, qual foi o ultimo imput) e perde um "tempo" de power up, se tiver
            pacman.move(this);

            if (pacman.isPoweredUp()){pacman.passTimePowerUp();}

            //primeira conferência de sobreposição
            for (Figures f : this.ghostsList) {
                if (f.isAlive() && pacman.getLocation().equals(f.getLocation())) {
                    if (pacman.isPoweredUp ()) {
                        f.die();
                        score.scoreGhost();
                    }
                    else pacman.die();
                }
            }

            pacman.eat(this);

            //movimento dos fantasmas e segunda conferência de sobreposição
            for (Figures f : this.ghostsList) {
                if (f.isAlive()) {
                    f.move(this);
                    if (pacman.getLocation().equals(f.getLocation())) {
                        if (pacman.isPoweredUp ()) {
                            f.die();
                            score.scoreGhost();
                        }
                        else {
                            System.out.println("SE FUDEU");
                            pacman.die();
                            System.out.println(score.lifeCount());
                            System.out.println(pacman.isAlive());
                        }
                    }
                }
            }
        }

        printer.printFrame(this);
        sc.close();
    }

    //MÉTODOS DA INTERFACE GAMECONTEXT
    @Override
    public ArrayList<Location> getGhostLocations() {
        ArrayList<Location> ghostLocations = new ArrayList<Location>();
        for (Figures f : this.ghostsList) {
            if (f.isAlive())
                ghostLocations.add(f.getLocation());
        }
        return ghostLocations;
    }

    @Override
    public Location getPacManLocation() {
        return this.pacman.getLocation();
    }

    @Override
    public Maze getMaze () {return this.maze;}

    @Override
    public Score getScore () {return this.score;}

    @Override
    public Direction getInputDirection () {
        switch (this.lastInput) {
            case 'w':
                return Direction.UP;
            case 'a':
                return Direction.LEFT;
            case 's':
                return Direction.DOWN;
            case 'd':
                return Direction.RIGHT;
        }
        return Direction.LEFT;
    }

    @Override
    public ArrayList<Figures> getFiguresList(){
        ArrayList<Figures> figuresArrayList = new ArrayList<>();
        figuresArrayList.add(pacman);
        for (Figures f : this.ghostsList) {
            if (f.isAlive())
                figuresArrayList.add(f);
        }
        return figuresArrayList;
    }

}
