
public class StringBar extends Bar {
    private boolean isHappyHour;

    public StringBar() {
        this.isHappyHour = false;
    }

    @Override
    public Boolean isHappyHour() {
        return isHappyHour;
    }

    @Override
    public void startHappyHour() {
        isHappyHour = true;
        notifyObserver();
    }

    @Override
    public void endHappyHour() {
        isHappyHour = false;
        notifyObserver();
    }

    public void order(StringDrink drink, StringRecipe recipe){
        recipe.mix(drink);
    }
}
