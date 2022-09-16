public class blueStrat implements Strategy{

    private boolean collision;

    public blueStrat (boolean collision) {
        this.collision = collision;
    }
    @Override
    public void move(Ball ball) {
        if (collision) {
            if (ball.getxVel() >= 0.01) ball.setxVel(ball.getxVel() - 0.01);
            else if (ball.getxVel() <= -0.01) ball.setxVel(ball.getxVel() + 0.01);
            if (ball.getyVel() >= 0.01) ball.setyVel(ball.getyVel() - 0.01);
            else if (ball.getyVel() <= -0.01) ball.setyVel(ball.getyVel() + 0.01);
        }

    }
    public String toString(){
        return "blueStrat";
    }
}
