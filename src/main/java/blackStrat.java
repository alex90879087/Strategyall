import java.util.ArrayList;

public class blackStrat implements Strategy{
    @Override
    public void move(Ball ball) {

        double distanceToA = Math.hypot(ball.getxPos() - 0, ball.getyPos() - 0);
        double distanceToB = Math.hypot(ball.getxPos() - 0, ball.getyPos() - 600);
        double distanceToC = Math.hypot(ball.getxPos() - 800, ball.getyPos() - 600);
        double distanceToD = Math.hypot(ball.getxPos() - 800, ball.getyPos() - 0);

        ArrayList<Double> asd = new ArrayList<>();
        asd.add(distanceToA);
        asd.add(distanceToB);
        asd.add(distanceToC);
        asd.add(distanceToD);
        double shortest = Math.min(Math.min(distanceToA,distanceToB), Math.min(distanceToC, distanceToD));

        int coord = asd.indexOf(shortest);

        double coordX = coord == 2 ? 800 : coord == 3 ? 800 : 0;
        double coordY = coord == 1 ? 600 : coord == 2 ? 600: 0;

        double angle = Math.atan2(coordX - ball.getxPos(), coordY - ball.getyPos());

        double factor = (ball.getxVel() > 3) ? 0.4:0.30;

        double speedX = factor * Math.sin(angle);
        double speedY = factor * Math.cos(angle);

        ball.setxPos(ball.getxPos() + speedX);
        ball.setyPos(ball.getyPos() + speedY);

    }


}
