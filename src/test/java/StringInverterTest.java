import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class StringInverterTest {

    @Test
    public void StringInverter() {
        StringDrink drink = new StringDrink("ABCD");
        StringInverter inverter = new StringInverter();
        inverter.execute(drink);
        assertEquals("DCBA", drink.getText());
    }
}
