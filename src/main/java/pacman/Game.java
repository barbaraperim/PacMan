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
    //lista de fantasmas, para não perdermos eles de vista
    private ArrayList<Figures> ghostsList;
    private Pacman pacman;

    private Maze maze;
    private Score score;

    private char lastInput = 'w';

    public void play() {
        /*
            1 - Escolher Mapa e instanciar
            2 - Setar posição dos personagens
            3 - Pedir input, com input verificar: se mesma posição que fantasma, se pastilha, se pastilha especial
            4 - Verificar se acabou, se morreu ou se ganhou
        * */
        Scanner sc = new Scanner(System.in);
        System.out.println("Escolha o mapa 1, 2, 3: ");

        this.maze = new Maze(sc.nextInt());
        this.score = new Score (this.maze);
        System.out.println(this.maze.toString());


        //criando o pacman dois abaixo dos fantasmas
        this.pacman = new Pacman(maze.getColumnSize()/2 + 5, maze.getLineSize()/2);

        this.ghostsList = new ArrayList<>();

        //adicionando os fantasmas no meio do mapa

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
                if (f.isAlive() && pacman.location.equals(f.location)) {
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
                    if (pacman.location.equals(f.location)) {
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

    @Override
    public ArrayList<Location> getGhostLocations() {
        ArrayList<Location> ghostLocations = new ArrayList<Location>();
        for (Figures f : this.ghostsList) {
            if (f.isAlive())
                ghostLocations.add(f.location);
        }
        return ghostLocations;
    }

    //TEM QUE VER ESSE MÉTODO. A gnt fez ele baseando na flexibilidade de ter mais de um pacman em campo. Apesar de eu também querer fazer isso, creio que esse é o único momento que deixamos essa flexibilidade. Teríamos que tratar de vários inputs ao mesmo tempo e ai as coisas ficam infernais.
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
