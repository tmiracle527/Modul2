package menu;

import check.Check;
import management.ProductManagement;
import model.Product;

import java.util.Scanner;

public class ProductMenu {
    private ProductManagement productManagement = new ProductManagement();
    private Check check = new Check();
    private Scanner scanner= new Scanner(System.in);

    public void showAllProducts() {
        System.out.println("***** Danh Sách Sản Phẩm *****");

        int start = 1;
        int count = 0;

        while (count < 5 && start <= productManagement.getAll().size()) {
            int num = start;
            while (num <= start + 4 && num <= productManagement.getAll().size()) {
                System.out.println(productManagement.getAll().get(num - 1));
                System.out.println("--------");
                num++;
            }
            System.out.println("Enter");
            Scanner scanner = new Scanner(System.in);
            scanner.nextLine();
            start += 5;
            count++;
        }

    }

    public void addProduct() {
        System.out.println("+++++ Thêm Sản Phẩm +++++");
        String productId;
        while (true) {
            String str = "Nhập ID Sản Phẩm(vd: p01/P01): ";
            productId = check.checkRegex(str, Check.PRODUCT_ID);
            if (productManagement.findIndexById(productId) == -1) {
                break;
            }
            System.out.println("ID Sản Phẩm Đã Có !!!");
        }

        String productName;
        while (true) {
            String str = "Nhập Tên Sản Phẩm: ";
            productName = check.checkRegex(str, Check.STRING);
            break;
        }

        double price;
        while (true) {
            String str = "Nhập Giá Sản Phẩm: ";
            price = check.checkInputNumber(str);
            break;
        }

        int quantity;
        while (true) {
            String str = "Nhập Số Lượng Sản Phẩm: ";
            quantity = check.checkInputNumber(str);
            break;
        }

        String detail;
        while (true) {
            String str = "Nhập Mô Tả Sản Phẩm: ";
            detail = check.checkRegex(str, Check.STRING);
            break;
        }

        Product product = new Product(productId, productName, price, quantity, detail);
        productManagement.add(product);

        System.out.println("//////////");
    }

    public void updateProduct() {
        System.out.println("=====Sửa Sản Phẩm=====");

        String str = "Nhập ID Sản Phẩm(vd: p01/P01): ";
        String productId = check.checkRegex(str, Check.PRODUCT_ID);
        if (productManagement.findIndexById(productId) == -1) {
            System.out.println("Không Tìm Được Sản Phẩm Với Mã Sản Phẩm Trên !!!");
        } else {
            System.out.println("----------");
            System.out.println(productManagement.getAll().get(productManagement.findIndexById(productId)).toString());

            String productName;
            while (true) {
                String str1 = "Nhập Tên Sản Phẩm: ";
                productName = check.checkRegex(str1, Check.STRING);
                break;
            }

            double price;
            while (true) {
                String str2 = "Nhập Giá Sản Phẩm: ";
                price = check.checkInputNumber(str2);
                break;
            }

            int quantity;
            while (true) {
                String str3 = "Nhập Số Lượng Sản Phẩm: ";
                quantity = check.checkInputNumber(str3);
                break;
            }

            String detail;
            while (true) {
                String str4 = "Nhập Mô Tả Sản Phẩm: ";
                detail = check.checkRegex(str4, Check.STRING);
                break;
            }

            Product product = new Product(productId, productName, price, quantity, detail);
            productManagement.edit(productId, product);

            System.out.println("//////////");
        }
    }

    public void deleteProduct() {
        System.out.println("+++++ Xóa Sản Phẩm +++++");
        String productId;
        String str;
        str = "Nhập ID Sản Phẩm muốn xóa(vd: p01/P01): ";
        productId = check.checkRegex(str, Check.PRODUCT_ID);
        if (productManagement.findIndexById(productId) == -1) {
            System.out.println("Không tìm thấy ID sản phẩm vừa nhập !!!");
        } else {
            System.out.println("Bạn có muốn xóa sản phẩm này (Nhập y để xóa)");
            String select = scanner.nextLine();
            if (select.equalsIgnoreCase("y")) {
                productManagement.delete(productId);
                System.out.println("Xóa không thành công");
            }
        }
    }



    public void sortProduct() {
        int choice = -1;
        do {
            String menu = "----- SẮP XẾP SẢN PHẨM -----\n" +
                    "Chọn chức năng theo số ( để tiếp tục)\n" +
                    "1. Sắp Xếp Tăng Dần\n" +
                    "2. Sắp Xếp Giảm Dần\n" +
                    "3. Thoát";

            System.out.println(menu);
            System.out.println("----------");
            String str = "Nhập Lựa Chọn: ";
            choice = check.checkInputNumber(str);

            switch (choice) {
                case 1:
                    System.out.println("Sắp Xếp Tăng Dần");
                    for (Product product : productManagement.sortAscProduct()) {
                        System.out.println(product.toString());
                        System.out.println("**********");
                    }
                    System.out.println("//////////");
                    break;
                case 2:
                    System.out.println("Sắp Xếp Giảm Dần");
                    for (Product product : productManagement.sortDecProduct()) {
                        System.out.println(product.toString());
                        System.out.println("**********");
                    }
                    System.out.println("//////////");
                    break;
                case 3:
                    break;
                default:
                    System.out.println("Không Có Lựa Chọn !!!");
                    break;
            }
        } while (choice != 3);
    }

    public void mostExpensiveProduct() {
        System.out.println("%%%%% Tìm Sản Phẩm Có Giá Đắt Nhất %%%%%");
        for (Product product : productManagement.getAll()) {
            if (product.getPrice() == productManagement.sortDecProduct().get(0).getPrice()) {
                System.out.println(product.toString());
            }
        }
    }
}