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
    }

    public String[] printCoordinate(){
        String x = new String(this.col + " ball's x coordinate is "+ (int) this.xpos);
        String y = new String(this.col + " ball's y coordinate is "+ (int) this.ypos);
        return new String[] {x,y};
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
