package bt1;

import java.util.Scanner;

public class ProductManagement {
    /**
     * 1. Xây dựng lớp Product gồm các thông tin:
     * - Thuộc tính
     * + Mã sản phẩm kiểu: int, tăng tự động
     * + Tên sản phẩm: 6-50 kỹ tự không trùng lặp
     * + Giá nhập sản phẩm Float: > 0
     * + Giá xuất: Float: >30% so với nhập
     * + Lợi nhuận: Float
     * + Tiêu đề sản phẩm: String: max 200 text
     * + Trạng thái: Enum: CONHANG | HETHANG | KHONGBAN
     * -- 2 contructor: 0 =, full
     * -- Get/set
     * -- Có các PT:
     * + InputData(Scanner scanner): Nhập các thông tin sản phẩm ( trừ lợi nhuận )
     * + displayData(): Hiển thị thông tin sản phẩm
     * + calProgit(): Tính lợi nhuận sản phẩm
     * 2. Xây dựng ProductManagament hiển thị các chức năng theo menu
     * 1. Hieển thị danh sách sp
     * 2. Thêm mới snả phẩm ( 1 sp )
     * 3. Update
     * 4. Delete: Xoá các sản phẩm có trạng thái là KHONGBAN
     * 5. Tìm kiếm sản phẩm theo tên gần đúng
     * 6. Sắp xếp sản phẩm theo lợi nhuận giảm dần
     * 7. Tìm kiếm sản phẩm theo khoảng giá.
     * 8. Tính lợi nhuận các sản phẩm
     * 9. Thoát
     */
    public static Product[] arrProducts = new Product[100];
    public static int currentIndex = 0;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        do {
            System.out.println("************************** MENU **************************");
            System.out.println("1. Hiển thị danh sách sản phẩm");
            System.out.println("2. Thêm mới sẩn phẩm ( 1 sp )");
            System.out.println("3. Update sản phẩm");
            System.out.println("4. Delete: Xoá các sản phẩm có trạng thái là KHONGBAN");
            System.out.println("5. Tìm kiếm sản phẩm theo tên gần đúng");
            System.out.println("6. Sắp xếp sản phẩm theo lợi nhuận giảm dần");
            System.out.println("7. Tìm kiếm sản phẩm theo khoảng giá.");
            System.out.println("8. Tính lợi nhuận các sản phẩm");
            System.out.println("**********************************************************");
            System.out.print("Lựa chọn của bạn: ");
            int choice = Integer.parseInt(scanner.nextLine());
            System.out.println("");
            switch (choice) {
                case 1:
                    displayProducts();
                    break;
                case 2:
                    addProduct(scanner);
                    break;
                case 3:
                    break;
                case 4:
                    break;
                case 5:
                    break;
                case 6:
                    break;
                case 7:
                    break;
                case 8:
                    break;
                case 9:
                    System.out.println("Kết thúc chương trình!");
                    System.exit(0);
                    break;
                default:
                    System.out.println("404 Not found!. Try again!");
            }
        } while (true);
    }

    public static void displayProducts(){
        if (currentIndex == 0){
            System.out.println("Product doesn't exist!");
            return;
        }
        for (int i = 0; i < currentIndex; i++){
            arrProducts[i].displayProducts();
        }
    }

    public static void addProduct(Scanner scanner){
        System.out.println("Nhap vao thong tin san pham: ");
        Product product = new Product();
        product.setMaSP(Product.autoInsertMaSP());
        product.inputData(scanner);
        arrProducts[currentIndex] = product;
        currentIndex++;
    }

    public static void updateProduct(Scanner scanner){
        System.out.println("Nhap vao ma san pham: ");
        do {
            int maSP = Integer.parseInt(scanner.nextLine());
            if (maSP.equals("")){
                System.err.println("Vui long nhap vao thong tin san pham! Try again!");
                continue;
            }


        }while (true);
    }

    // search sp
    public static int searchSanPham(int id){
        for (int i = 0; i < currentIndex; i++) {
            if (arrProducts[i].getMaSP() == id) {
                return i;
            }
            return -1;
        }

    }
}
