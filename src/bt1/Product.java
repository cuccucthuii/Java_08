package bt1;

import java.util.Scanner;

import static bt1.ProductManagement.arrProducts;
import static bt1.ProductManagement.currentIndex;

public class Product {
    /**
     * Mã sản phẩm kiểu: int, tăng tự động
     * * + Tên sản phẩm: 6-50 kỹ tự không trùng lặp
     * * + Giá nhập sản phẩm Float: > 0
     * * + Giá xuất: Float: >30% so với nhập
     * * + Lợi nhuận: Float
     * * + Tiêu đề sản phẩm: String: max 200 text
     * * + Trạng thái: Enum: CONHANG | HETHANG | KHONGBAN
     */
    private int maSP;
    private String tenSanPham;
    private float giaNhap;
    private float giaXuat;
    private float loiNhuan;
    private String tieuDe;
    private TrangThai trangThai;

    public Product() {
    }

    public Product(int maSP, String tenSanPham, float giaNhap, float giaXuat, float loiNhuan, String tieuDe, TrangThai trangThai) {
        this.maSP = maSP;
        this.tenSanPham = tenSanPham;
        this.giaNhap = giaNhap;
        this.giaXuat = giaXuat;
        this.loiNhuan = loiNhuan;
        this.tieuDe = tieuDe;
        this.trangThai = trangThai;
    }

    public int getMaSP() {
        return maSP;
    }

    public void setMaSP(int maSP) {
        this.maSP = maSP;
    }

    public String getTenSanPham() {
        return tenSanPham;
    }

    public void setTenSanPham(String tenSanPham) {
        this.tenSanPham = tenSanPham;
    }

    public float getGiaNhap() {
        return giaNhap;
    }

    public void setGiaNhap(float giaNhap) {
        this.giaNhap = giaNhap;
    }

    public float getGiaXuat() {
        return giaXuat;
    }

    public void setGiaXuat(float giaXuat) {
        this.giaXuat = giaXuat;
    }

    public float getLoiNhuan() {
        return loiNhuan;
    }

    public void setLoiNhuan(float loiNhuan) {
        this.loiNhuan = loiNhuan;
    }

    public String getTieuDe() {
        return tieuDe;
    }

    public void setTieuDe(String tieuDe) {
        this.tieuDe = tieuDe;
    }

    public TrangThai getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(TrangThai trangThai) {
        this.trangThai = trangThai;
    }

    /**
     * * + InputData(Scanner scanner): Nhập các thông tin sản phẩm ( trừ lợi nhuận )
     * * + displayData(): Hiển thị thông tin sản phẩm
     * * + calProgit(): Tính lợi nhuận sản phẩm
     * * * + Mã sản phẩm kiểu: int, tăng tự động
     * * * + Tên sản phẩm: 6-50 kỹ tự không trùng lặp
     * * * + Giá nhập sản phẩm Float: > 0
     * * * + Giá xuất: Float: >30% so với nhập
     * * * + Lợi nhuận: Float
     * * * + Tiêu đề sản phẩm: String: max 200 text
     * * * + Trạng thái: Enum: CONHANG | HETHANG | KHONGBAN
     */

    public void displayProducts() {
        System.out.printf("MaSP: %s -- TenSanPham: %s -- GiaNhap: %.1f -- GiaXuat: %.1f -- TieuDeSanPham: %s -- TrangThaiSanPham: %s \n"
                , this.maSP, this.tenSanPham, this.giaNhap, this.giaXuat, this.tieuDe, this.trangThai);
    }

    public void inputData(Scanner scanner) {
        this.tenSanPham = inputTenSanPham(scanner);
        this.giaNhap = inputGiaNhap(scanner);
        this.giaXuat = inputGiaXuat(scanner, this.giaNhap);
        this.tieuDe = inputTieuDeSanPham(scanner);
        this.trangThai = inputTrangThaiSanPham(scanner);
    }

    // Tim kiem max ma sp
    public static int findMaxMaSP() {
        do {
            int max = 0;
            for (int i = 1; i < currentIndex; i++) {
                if (arrProducts[i] != null && arrProducts[i].getMaSP() > max) {
                    max = arrProducts[i].getMaSP();
                }
            }
            return max;
        } while (true);
    }

    // Khai bao bien tu dong them ma = max + 1
    public static int autoInsertMaSP() {
        return findMaxMaSP() + 1;
    }

    // Ten san pham
    public static String inputTenSanPham(Scanner scanner) {
        System.out.println("Ten san pham:");
        do {
            String tenSanPham = scanner.nextLine();
            boolean isExist = false;

            for (int i = 0; i < currentIndex; i++) {
                if (arrProducts[i].getTenSanPham().equalsIgnoreCase(tenSanPham)) {
                    isExist = true;
                    break;
                }
            }
            if (isExist) {
                System.err.println("Ten san pham da ton tai. vui long nhap lai!");
                continue;
            }

            if (tenSanPham.equals("")) {
                System.err.println("Ten san pham can't be empty");
                continue;
            }
            if (tenSanPham.length() < 6 || tenSanPham.length() > 50) {
                System.err.println("Ten san pham phai tu 6 - 50. Vui long nhap lai!");
                continue;
            }
            return tenSanPham;
        } while (true);
    }

    //Gia Nhap San Pham
    public static float inputGiaNhap(Scanner scanner) {
        System.out.println("Gia nhap:");
        do {
            float giaNhap = Float.parseFloat(scanner.nextLine());
            if (giaNhap < 0) {
                System.err.println("Gia nhap can't be negative! Try again!");
            }
            return giaNhap;
        } while (true);
    }

    // Gia xuat san pham
    public static float inputGiaXuat(Scanner scanner, float giaNhap) {
        System.out.println("Gia xuat:");
        do {
            float giaXuat = Float.parseFloat(scanner.nextLine());
            if (giaXuat >= giaNhap * 1.3f) {
                return giaXuat;
            } else {
                System.err.println("Gia xuat can't be greater than 1.3!. Try again!");
            }
        } while (true);
    }

    // Loi nhuan
    public static float calProgit(float giaNhap, float giaXuat) {
        float loiNhuan = giaXuat - giaNhap;
        System.out.println("Loi Nhuan:" + loiNhuan);
        return loiNhuan;
    }

    // Tieu de san pham
    public static String inputTieuDeSanPham(Scanner scanner) {
        System.out.println("Tieu de san pham:");
        do {
            String tieuDeSanPham = scanner.nextLine();

            if (tieuDeSanPham.equals("")) {
                System.err.println("Tieu de san pham can't be empty. Try again!");
                continue;
            }
            if (tieuDeSanPham.length() > 200) {
                System.err.println("Tieu de san pham < 200. Try again!");
                continue;
            }
                return tieuDeSanPham;
        } while (true);
    }

    // TrangThai
    public static TrangThai inputTrangThaiSanPham(Scanner scanner) {
        System.out.println("Trang thai san pham:");
        do {
            // CONHANG | HETHANG | KHONGBAN
            System.out.println("1. CONHANG");
            System.out.println("2. HETHANG");
            System.out.println("3. KHONGBAN");
            System.out.println("Lua chon cua ban: ");
            int choice = Integer.parseInt(scanner.nextLine());
            switch (choice) {
                case 1:
                    return TrangThai.CONHANG;
                case 2:
                    return TrangThai.HETHANG;
                case 3:
                    return TrangThai.KHONGBAN;
                default:
                    System.err.println("404. Try again!");
            }
        } while (true);

    }


}
