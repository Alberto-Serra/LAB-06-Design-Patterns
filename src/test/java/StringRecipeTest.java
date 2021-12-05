import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class StringRecipeTest {

    @Test
    public void stringRecipe() {
        StringDrink drink = new StringDrink("AbCd-aBcD");

        StringInverter inverter = new StringInverter();
        StringCaseChanger caseChanger = new StringCaseChanger();
        StringReplacer replacer = new StringReplacer('A', 'X');

        List<StringTransformer> transformers = new ArrayList<>();
        transformers.add(inverter);
        transformers.add(caseChanger);
        transformers.add(replacer);

        StringRecipe recipe = new StringRecipe(transformers);
        recipe.mix(drink);
        assertEquals("dCbX-DcBa", drink.getText());
    }
}
