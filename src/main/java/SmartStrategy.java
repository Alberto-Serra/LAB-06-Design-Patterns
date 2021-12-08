import java.util.ArrayList;
import java.util.List;

public class SmartStrategy implements OrderingStrategy {
    private List<StringDrink> wantedDrinks = new ArrayList<>();
    private List<StringRecipe> wantedRecipes = new ArrayList<>();

    @Override
    public void wants(StringDrink drink, StringRecipe recipe, StringBar bar) {
        if (bar.isHappyHour())
            bar.order(drink, recipe);
        else {
            wantedDrinks.add(drink);
            wantedRecipes.add(recipe);
        }
    }

    @Override
    public void happyHourStarted(StringBar bar) {
        for (int i = 0; i < wantedDrinks.size(); i++)
            bar.order(wantedDrinks.get(i), wantedRecipes.get(i));
    }

    @Override
    public void happyHourEnded(StringBar bar) {

    }
}
