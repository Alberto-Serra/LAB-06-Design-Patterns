import java.util.ArrayList;
import java.util.List;

public abstract class Bar {
    List<BarObserver> observers;

    protected Bar() {
        this.observers = new ArrayList<>();
    }

    public abstract Boolean isHappyHour();

    public abstract void startHappyHour();

    public abstract void endHappyHour();

    public void addObserver(BarObserver observer) {
        observers.add(observer);
    }

    public void removeObserver(BarObserver observer) {
        observers.remove(observer);
    }

    public void notifyObserver() {
        for (BarObserver observer : observers)
            if (isHappyHour())
                observer.happyHourStarted(this);
            else
                observer.happyHourEnded(this);
    }

}
