public class USD extends Coin {
    final double value = 3.52;

    @Override
    public double getValue() {
        return value;
    }

    @Override
    public double calculate(double value) {
        return getValue() * value;
    }
}
