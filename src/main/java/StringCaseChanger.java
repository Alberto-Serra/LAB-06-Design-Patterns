import java.util.Locale;

public class StringCaseChanger implements StringTransformer {
    @Override
    public void execute(StringDrink drink) {
        char[] chars = drink.getText().toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if (Character.isLowerCase(chars[i]))
                chars[i] = Character.toUpperCase(chars[i]);
            else {
                chars[i] = Character.toLowerCase(chars[i]);
            }
        }
        drink.setText(String.valueOf(chars));
    }
}