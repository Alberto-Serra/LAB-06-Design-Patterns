import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class StringReplacerTest {

    @Test
    public void stringReplacer() {
        StringDrink drink = new StringDrink("ABCDABCD");
        StringReplacer replacer = new StringReplacer('A', 'X');
        replacer.execute(drink);
        assertEquals("XBCDXBCD", drink.getText());
    }
}
