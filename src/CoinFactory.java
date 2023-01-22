public class CoinFactory {
    public static Coin getCoinInstance(Coins coin) {
        switch (coin) {
            case ILS:
                return new ILS();
            case USD:
                return new USD();
            default: // we won't get into this part since coin is in type Coins
                return null;
        }
    }
}
