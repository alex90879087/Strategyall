public class Observer implements ObserverInterface{

    private final Subject subject;
    private final String col;
    private double xpos;
    private double ypos;

    public Observer(Subject subject){
        this.subject = subject;
        this.col = subject.getCol();
        this.xpos = subject.getxPos();
        this.ypos = subject.getyPos();
    }
    @Override
    public void update() {
        this.xpos = subject.getxPos();
        this.ypos = subject.getyPos();
        System.out.printf("%s ball x position: %s\n", this.col, this.xpos);
        System.out.printf("%s ball y position: %s\n", this.col, this.ypos);

    }

    @Override
    public String getcol() {
        return this.col;
    }

    @Override
    public double getxPos() {
        return this.xpos;
    }

    @Override
    public double getyPos() {
        return this.ypos;
    }
}
