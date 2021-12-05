public class StringReplacer implements StringTransformer {
    private char original;
    private char toReplace;

    public StringReplacer(char original, char toReplace) {
        this.original = original;
        this.toReplace = toReplace;
    }

    @Override
    public void execute(StringDrink drink) {
        drink.setText(drink.getText().replace(original, toReplace));
    }
}
