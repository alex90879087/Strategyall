public interface Subject {

    void attach(ObserverInterface observer);
    void detach(ObserverInterface observer);
    void alert();
    String getCol();
    double getxPos();
    double getyPos();
}
