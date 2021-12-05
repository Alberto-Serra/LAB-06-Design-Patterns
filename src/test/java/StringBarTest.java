import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class StringBarTest {

    @Test
    public void happyHour() {
        Bar bar = new StringBar();
        assertFalse(bar.isHappyHour());
        bar.startHappyHour();
        assertTrue(bar.isHappyHour());
        bar.endHappyHour();
        assertFalse(bar.isHappyHour());

    }

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
    public void orderStringRecipe() {
        StringBar stringBar = new StringBar();
        StringDrink drink = new StringDrink("AbCd-aBcD");
        StringRecipe recipe = getRecipe();
        stringBar.order(drink, recipe);
        assertEquals("dCbX-DcBa", drink.getText());
    }
}

