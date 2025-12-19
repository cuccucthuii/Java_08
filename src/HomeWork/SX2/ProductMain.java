package HomeWork.SX2;

import java.util.Scanner;

public class ProductMain {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        ProductManagement manager = new ProductManagement(10);

        while (true) {
            System.out.println("\n===== QUAN LY KHO =====");
            System.out.println("1. Them san pham");
            System.out.println("2. Hien thi danh sach");
            System.out.println("3. Tim san pham theo khoang gia");
            System.out.println("4. Thong ke so san pham");
            System.out.println("5. Thoat");
            System.out.print("Lua chon: ");

            int choice = Integer.parseInt(sc.nextLine());

            switch (choice) {
                case 1:
                    System.out.print("Nhap ten san pham: ");
                    String name = sc.nextLine();
                    System.out.print("Nhap gia: ");
                    double price = Double.parseDouble(sc.nextLine());

                    manager.addProduct(new Product(name, price));
                    break;

                case 2:
                    manager.showAll();
                    break;

                case 3:
                    System.out.print("Gia tu: ");
                    double min = Double.parseDouble(sc.nextLine());
                    System.out.print("Gia den: ");
                    double max = Double.parseDouble(sc.nextLine());

                    manager.findByPrice(min, max);
                    break;

                case 4:
                    System.out.println("Tong so san pham da tao: "
                            + Product.getTotalProducts());
                    break;

                case 5:
                    System.out.println("Thoat chuong trinh!");
                    return;

                default:
                    System.out.println("Lua chon khong hop le!");
            }
        }
    }
}
