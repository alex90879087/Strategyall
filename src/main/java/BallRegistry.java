import java.util.HashMap;
import java.util.Locale;

public class BallRegistry {

    private HashMap<String, Ball> existing = new HashMap<>();

    public BallRegistry() {
        Ball red = new Ball(100, 100, 20, "RED", new redStrat());
        Ball black = new Ball(200, 200, 20, "BLACK", new blackStrat());
        Ball blue = new Ball(300, 300, 20, "BLUE", new blackStrat());
        existing.put("red", red);
        existing.put("blue", blue);
        existing.put("black", black);
    }

    public Ball addBall(String colour) {
        return (Ball) (existing.get(colour.toLowerCase(Locale.ROOT))).copy();
    }
}
