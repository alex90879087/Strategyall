public class blueStrat implements Strategy{

    private boolean collision;

    public blueStrat (boolean collision) {
        this.collision = collision;
    }
    @Override
    public void move(Ball ball) {
        if (collision){
            ball.setxVel(ball.getxVel() - 0.017);
            ball.setyVel(ball.getyVel() - 0.017);
        }

    }
    public String toString(){
        return "blueStrat";
    }
}
