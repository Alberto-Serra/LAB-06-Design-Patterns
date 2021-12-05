public interface Cliente extends BarObserver {

    void wants(StringDrink drink, StringRecipe recipe, StringBar bar);
}
