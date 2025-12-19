package HomeWork.G1;

public class CurrencyConverterMain {
    public static void main(String[] args) {
        CurrencyConverter.setRate(25000);
        int vnd = 100000;

        double usd = CurrencyConverter.toUSD(vnd);

        System.out.println("VND: " + vnd);
        System.out.println("USD: " + CurrencyConverter.formatUSD(usd));
    }
}
