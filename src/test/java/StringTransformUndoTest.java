import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class StringTransformUndoTest {

    @Test
    public void transformUndo() {
        StringDrink drink = new StringDrink("AbCd-aBcD");
        StringInverter inverter = new StringInverter();
        StringCaseChanger caseChanger = new StringCaseChanger();
        StringReplacer replacer = new StringReplacer('A', 'X');
        inverter.execute(drink);
        caseChanger.execute(drink);
        replacer.execute(drink);
        replacer.undo(drink);
        assertEquals("dCbA-DcBa", drink.getText());
        caseChanger.undo(drink);
        assertEquals("DcBa-dCbA", drink.getText());
        inverter.undo(drink);
        assertEquals("AbCd-aBcD", drink.getText());
    }

}
