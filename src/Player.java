public class Player {
    private Integer lives;
    private Integer points;
    private Integer[][] position;

    public Player() {
        lives = 0;
        points = 0;
    }

    public Integer getLives() {
        return lives;
    }

    public void setLives(Integer lives) {
        this.lives = lives;
    }

    public Integer getPoints() {
        return points;
    }

    public Integer[][] getPosition() {
        return position;
    }

    public void setPosition(Integer[][] position) {
        this.position = position;
    }

    public void setPoints(Integer points) {
        this.points += points;
        if (this.points > 100000){
            this.lives++;
            this.points -= 10000;
        }
    }
}
