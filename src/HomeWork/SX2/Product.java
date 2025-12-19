package HomeWork.SX2;

public class Product {
    public static final String WAREHOUSE_CODE = "KHO-01";

    private static int AUTO_ID = 1;
    private static int totalProducts = 0;

    private int id;
    private String name;
    private double price;

    public Product() {
        this.id = AUTO_ID++;
        totalProducts++;
    }

    public Product(String name, double price) {
        this();
        this.name = name;
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public static int getTotalProducts() {
        return totalProducts;
    }

    @Override
    public String toString() {
        return "Kho: " + WAREHOUSE_CODE +
                " | ID: " + id +
                " | Ten: " + name +
                " | Gia: " + price;
    }
}
