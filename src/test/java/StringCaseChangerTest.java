import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class StringCaseChangerTest {

    @Test
    public void stringCaseChanger(){
        StringDrink drink = new StringDrink("aBcD");
        StringCaseChanger caseChanger = new StringCaseChanger();
        caseChanger.execute(drink);
        assertEquals("AbCd", drink.getText());
    }
}
