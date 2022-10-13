import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.StackPane;
import javafx.util.Duration;
import javafx.scene.control.Label;
import javafx.scene.control.Button;


class GameWindow implements EventHandler<ActionEvent> {
    private final GraphicsContext gc;
    private Scene scene;
    private BallPit model;
    private StackPane pane;
    private Label blue;
    private Label black;
    private Label red;
    private Button redButton = new Button("Generate a red ball");
    private Button blueButton = new Button("Generate a blue ball");
    private Button blackButton = new Button("Generate a black ball");

    private BallRegistry ballRegistry;
    private EventHandler<ActionEvent> rb;

    GameWindow(BallPit model)  {
        this.model = model;
        ballRegistry = new BallRegistry();

        pane = new StackPane();
        this.scene = new Scene(pane, model.getWidth(), model.getHeight() + 50);
        Canvas canvas = new Canvas(model.getWidth(), model.getHeight());
        gc = canvas.getGraphicsContext2D();

        blue = new Label();
        black = new Label();
        red = new Label();


        pane.getChildren().add(red);
        pane.setAlignment(red, Pos.TOP_LEFT);

        pane.getChildren().add(black);
        pane.setAlignment(black, Pos.TOP_CENTER);

        pane.getChildren().add(blue);
        pane.setAlignment(blue, Pos.TOP_RIGHT);



        pane.getChildren().add(redButton);
        pane.setAlignment(redButton, Pos.BOTTOM_LEFT);
        pane.getChildren().add(blueButton);
        pane.setAlignment(blueButton, Pos.BOTTOM_CENTER);
        pane.getChildren().add(blackButton);
        pane.setAlignment(blackButton, Pos.BOTTOM_RIGHT);

        redButton.setOnAction(this);
        blackButton.setOnAction(this);
        blueButton.setOnAction(this);

        pane.getChildren().add(canvas);
    }



    Scene getScene() {
        return this.scene;
    }

    void run() {
        Timeline timeline = new Timeline();
        KeyFrame kf = new KeyFrame(Duration.millis(17),
                a -> {
                    this.draw();

                });
        timeline.getKeyFrames().addAll(kf, new KeyFrame(Duration.millis(17)));
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
//            ball.getObservers().get(0).printCoordinate();
//            if (ball.getCol().equalsIgnoreCase("blue")) {
//                blue.setText(ball.getObservers().get(0).printCoordinate()[0] + "\n" + ball.getObservers().get(0).printCoordinate()[1]);
//            }
//            else if (ball.getCol().equalsIgnoreCase("black"))
//                black.setText(ball.getObservers().get(0).printCoordinate()[0] + "\n" + ball.getObservers().get(0).printCoordinate()[1]);
//
//            else if (ball.getCol().equalsIgnoreCase("red"))
//                red.setText(ball.getObservers().get(0).printCoordinate()[0] + "\n" + ball.getObservers().get(0).printCoordinate()[1]);
        }
    }

    @Override
    public void handle(ActionEvent event) {
        if (event.getSource() == redButton) {
            this.model.spawnBall("red");
        }
        if (event.getSource() == blackButton) {
            this.model.spawnBall("black");
        }
        if (event.getSource() == blueButton) {
            this.model.spawnBall("blue");
        }
    }
}
