package HomeWork.SX2;

public class ProductManagement {
    private Product[] products;
    private int size = 0;

    public ProductManagement(int capacity) {
        products = new Product[capacity];
    }

    public void addProduct(Product product) {
        if (size >= products.length) {
            System.out.println("Kho da day!");
            return;
        }
        products[size++] = product;
        System.out.println("Them san pham thanh cong!");
    }

    public void showAll() {
        if (size == 0) {
            System.out.println("Kho rong!");
            return;
        }
        for (int i = 0; i < size; i++) {
            System.out.println(products[i]);
        }
    }

    public void findByPrice(double min, double max) {
        boolean found = false;
        for (int i = 0; i < size; i++) {
            double price = products[i].getPrice();
            if (price >= min && price <= max) {
                System.out.println(products[i]);
                found = true;
            }
        }
        if (!found) {
            System.out.println("Khong co san pham trong khoang gia!");
        }
    }
}
