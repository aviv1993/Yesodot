package System.Logic;

public interface Subject {
    void attach(Observer user);
    void deattach(Observer user);
    void notifyObservers();
}
