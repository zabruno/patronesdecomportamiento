package Observer;

public interface Subject {
    void addObserver (Observer o);
    void removeObserver (Observer o);
    void notifyObservers(String mensaje);
}
