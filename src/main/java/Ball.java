import javafx.scene.paint.Paint;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Random;

public class Ball implements Subject {
    private double xPos;
    private double yPos;
    private double radius;
    private double xVel;
    private double yVel;
    private Paint colour;
    private Strategy strat;
    private String col;
    private int timer;

    public List<ObserverInterface> getObservers() {
        return observers;
    }

    private List<ObserverInterface> observers = new ArrayList<>();

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
        if (timer % 120 == 0) this.alert();
        timer += 1;
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

    public double getxPos() {
        return xPos;
    }

    public double getyPos() {
        return yPos;
    }

    Paint getColour() {
        return colour;
    }

    @Override
    public void attach(ObserverInterface observer) { observers.add(observer); }

    @Override
    public void detach(ObserverInterface observer) { observers.remove(observer); }

    @Override
    public void alert() {
        for (ObserverInterface observer: observers){
            observer.update();
            observer.printCoordinate();
        }
    }

    public String getCol() {return col;}

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
