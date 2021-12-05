public class HumanClient implements Cliente{

    @Override
    public void happyHourStarted(Bar bar) {
        bar.isHappyHour();
    }

    @Override
    public void happyHourEnded(Bar bar) {
        bar.endHappyHour();
    }

    @Override
    public void wants(StringDrink drink, StringRecipe recipe, StringBar bar) {

    }
}
