import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ImpatientStrategyTest {

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
    public void impatientStrategy() {
        StringBar stringBar = new StringBar();
        StringDrink drink = new StringDrink("AbCd-aBcD");
        StringRecipe recipe = getRecipe();
        ImpatientStrategy strategy = new ImpatientStrategy();
        HumanClient client = new HumanClient(strategy);
        client.wants(drink, recipe, stringBar);
        assertEquals("dCbX-DcBa", drink.getText());
    }

}
