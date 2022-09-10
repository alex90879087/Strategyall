import javafx.scene.paint.Paint;

import java.util.Locale;
import java.util.Random;

public class Ball {
    private double xPos;
    private double yPos;
    private double radius;
    private double xVel;
    private double yVel;
    private Paint colour;
    private Strategy strat;
    private String col;

    Ball(double startX, double startY, double startRadius, String colour) {
        this.xPos = startX;
        this.yPos = startY;
        this.radius = startRadius;
        this.colour = Paint.valueOf(colour);
        this.col = colour.toLowerCase(Locale.ROOT);
        xVel = new Random().nextInt(5);
        yVel = new Random().nextInt(5);
    }

    void tick() {
        xPos += xVel ;
        yPos += yVel;
    }

    public void move(Strategy strat){
        strat.move(this);
    }

    void setxVel(double xVel) {
        this.xVel = xVel;
    }

    void setyVel(double yVel) {
        this.yVel = yVel;
    }

    double getRadius() {
        return radius;
    }

    double getxPos() {
        return xPos;
    }

    double getyPos() {
        return yPos;
    }

    Paint getColour() {
        return colour;
    }

    String getCol() {return col;}

    double getxVel() {
        return xVel;
    }

    double getyVel() {
        return yVel;
    }

    void setxPos(double xPos) {
        this.xPos = xPos;
    }

    void setyPos(double yPos) {
        this.yPos = yPos;
    }

    void think(boolean blueCollision) {
        // Here is where the strategy should have some effect.
        // You can add parameters to the think method so the ball knows something about its
        // world to make decisions with, or you can inject things upon construction for it to query
        if (getCol().equalsIgnoreCase("black")) {
            this.move(new blackStrat());
        }
        else if (getCol().equalsIgnoreCase("red")){
            this.move(new redStrat());
        }
        else if (getCol().equalsIgnoreCase("blue")){
            this.move(new blueStrat(blueCollision));
        }else{
            System.out.println("New coloured ball detected!");
        }
    }
}
