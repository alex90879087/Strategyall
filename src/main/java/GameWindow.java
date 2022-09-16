import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.Pane;
import javafx.util.Duration;
import javafx.scene.control.Label;
import org.w3c.dom.Text;

import java.awt.*;

class GameWindow {
    private final GraphicsContext gc;
    private Scene scene;
    private BallPit model;
    private Pane pane;
    private Label blue;
    private Label black;
    private Label red;

    GameWindow(BallPit model) {
        this.model = model;

        pane = new Pane();
        this.scene = new Scene(pane, model.getWidth(), model.getHeight());
        Canvas canvas = new Canvas(model.getWidth(), model.getHeight());
        gc = canvas.getGraphicsContext2D();

        blue = new Label();
        black = new Label();
        black.setTranslateX(0);
        black.setTranslateY(30);
        red = new Label();
        red.setTranslateX(0);
        red.setTranslateY(60);

        pane.getChildren().addAll(blue, black, red, canvas);

    }

    Scene getScene() {
        return this.scene;
    }

    void run() {
        Timeline timeline = new Timeline(new KeyFrame(Duration.millis(17),
                t -> this.draw()));

        timeline.setCycleCount(Timeline.INDEFINITE);
        timeline.play();
    }

    private void draw() {
        model.tick();

        gc.clearRect(0, 0, model.getWidth(), model.getHeight());
//        Label test = new Label("set");
//        this.pane.getChildren().add(test);
        for (Ball ball: model.getBalls()) {
            gc.setFill(ball.getColour());
            gc.fillOval(ball.getxPos() - ball.getRadius(),
                        ball.getyPos() - ball.getRadius(),
                        ball.getRadius() * 2,
                        ball.getRadius() * 2);
            ball.getObservers().get(0).printCoordinate();
            if (ball.getCol().equalsIgnoreCase("blue")) {
                blue.setText(ball.getObservers().get(0).printCoordinate()[0] + "\n" + ball.getObservers().get(0).printCoordinate()[1]);
            }
            else if (ball.getCol().equalsIgnoreCase("black"))
                black.setText(ball.getObservers().get(0).printCoordinate()[0] + "\n" + ball.getObservers().get(0).printCoordinate()[1]);

            else if (ball.getCol().equalsIgnoreCase("red"))
                red.setText(ball.getObservers().get(0).printCoordinate()[0] + "\n" + ball.getObservers().get(0).printCoordinate()[1]);
        }
    }
}
