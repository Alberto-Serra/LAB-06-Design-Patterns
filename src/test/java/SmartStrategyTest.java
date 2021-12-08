import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SmartStrategyTest {

    private StringRecipe getRecipe() {
        StringInverter inverter = new StringInverter();
        StringCaseChanger caseChanger = new StringCaseChanger();
        StringReplacer replacer = new StringReplacer('A', 'X');
        List<StringTransformer> transformers = new ArrayList<>();
        transformers.add(inverter);
        transformers.add(caseChanger);
        transformers.add(replacer);
        StringRecipe recipe = new StringRecipe(transformers);
        return recipe;
    }

    @Test
    public void smartStrategyStartOpened() {
        StringBar stringBar = new StringBar();
        StringDrink drink = new StringDrink("AbCd-aBcD");
        StringRecipe recipe = getRecipe();
        SmartStrategy strategy = new SmartStrategy();
        HumanClient client = new HumanClient(strategy);
        stringBar.startHappyHour();
        client.wants(drink, recipe, stringBar);
        assertEquals("dCbX-DcBa", drink.getText());
    }

    @Test
    public void smartStrategyStartClosed() {
        StringBar stringBar = new StringBar();
        StringDrink drink = new StringDrink("AbCd-aBcD");
        StringRecipe recipe = getRecipe();
        SmartStrategy strategy = new SmartStrategy();
        HumanClient client = new HumanClient(strategy);
        stringBar.addObserver(client);
        client.wants(drink, recipe, stringBar);
        assertEquals("AbCd-aBcD", drink.getText());

        stringBar.startHappyHour();
        assertEquals("dCbX-DcBa", drink.getText());
    }
}
