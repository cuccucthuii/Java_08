package HomeWork.SX1;

import java.util.Scanner;

public class CategoryManagement {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        ICRUDIMP manager = new ICRUDIMP(100);

        while (true) {
            System.out.println("\n===== MENU =====");
            System.out.println("1. Them danh muc");
            System.out.println("2. Hien thi danh muc");
            System.out.println("3. Cap nhat danh muc");
            System.out.println("4. Xoa danh muc");
            System.out.println("5. Thoat");
            System.out.print("Lua chon: ");

            int choice = Integer.parseInt(sc.nextLine());

            switch (choice) {
                case 1:
                    System.out.print("Nhap ID: ");
                    int id = Integer.parseInt(sc.nextLine());
                    System.out.print("Nhap ten: ");
                    String name = sc.nextLine();
                    System.out.print("Nhap mo ta: ");
                    String desc = sc.nextLine();

                    manager.addCategory(new Category(id, name, desc));
                    break;

                case 2:
                    Category[] list = manager.findAll();
                    if (list.length == 0) {
                        System.out.println("Danh sach rong!");
                    } else {
                        for (Category c : list) {
                            System.out.println(c);
                        }
                    }
                    break;

                case 3:
                    System.out.print("Nhap ID can cap nhat: ");
                    int upId = Integer.parseInt(sc.nextLine());
                    System.out.print("Nhap ten moi: ");
                    String newName = sc.nextLine();
                    System.out.print("Nhap mo ta moi: ");
                    String newDesc = sc.nextLine();

                    manager.updateCategory(new Category(upId, newName, newDesc));
                    break;

                case 4:
                    System.out.print("Nhap ID can xoa: ");
                    int delId = Integer.parseInt(sc.nextLine());
                    manager.deleteById(delId);
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
