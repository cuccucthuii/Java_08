package HomeWork.G1;

import java.text.DecimalFormat;

public class CurrencyConverter {
    private static double rate = 0;

    private CurrencyConverter() {

    }

    public static void setRate(double r) {
        if (r <= 0) {
            throw new IllegalArgumentException("Ti gia phai lon hon 0");
        }
        rate = r;
    }

    public static double getRate() {
        return rate;
    }

    public static double toUSD(int vnd) {
        if (vnd < 0) {
            throw new IllegalArgumentException("So tien VND khong hop le");
        }
        if (rate <= 0) {
            throw new IllegalStateException("Chua thiet lap ti gia");
        }
        return vnd / rate;
    }

    public static String formatUSD(double usd) {
        DecimalFormat df = new DecimalFormat("#,##0.00");
        return df.format(usd) + " USD";
    }
}

//// main
//public class CurrencyConverterMain {
//    public static void main(String[] args) {
//        CurrencyConverter.setRate(25000);
//        int vnd = 100000;
//
//        double usd = CurrencyConverter.toUSD(vnd);
//
//        System.out.println("VND: " + vnd);
//        System.out.println("USD: " + CurrencyConverter.formatUSD(usd));
//    }
//}

