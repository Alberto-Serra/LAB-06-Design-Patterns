import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AlienClientTest {

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
    public void ferengiAlreadyOpened() {
        StringBar stringBar = new StringBar();
        StringDrink drink = new StringDrink("AbCd-aBcD");
        StringRecipe recipe = getRecipe();
        FerengiClient client = new FerengiClient(new SmartStrategy());
        stringBar.startHappyHour();
        client.wants(drink, recipe, stringBar);
        assertEquals("dCbX-DcBa", drink.getText());
    }

    @Test
    public void ferengiAlreadyClosed() {
        StringBar stringBar = new StringBar();
        StringDrink drink = new StringDrink("AbCd-aBcD");
        StringRecipe recipe = getRecipe();
        FerengiClient client = new FerengiClient(new SmartStrategy());
        stringBar.addObserver(client);
        client.wants(drink, recipe, stringBar);
        assertEquals("AbCd-aBcD", drink.getText());
        stringBar.startHappyHour();
        assertEquals("dCbX-DcBa", drink.getText());
    }

    @Test
    public void romulan() {
        StringBar stringBar = new StringBar();
        StringDrink drink = new StringDrink("AbCd-aBcD");
        StringRecipe recipe = getRecipe();
        RomulanClient client = new RomulanClient(new ImpatientStrategy());
        client.wants(drink, recipe, stringBar);
        assertEquals("dCbX-DcBa", drink.getText());
    }
}
