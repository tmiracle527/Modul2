package menu;

import check.Check;

public class MainMenu {
    private Check check = new Check();
    private ProductMenu productMenu = new ProductMenu();

    public void mainMenu() {
        int choice = -1;
        do {
            String menu = "---- CHƯƠNG TRÌNH QUẢN LÍ SẢN PHẨM ----\n" +
                    "Chọn chức năng theo số ( để tiếp tục)\n" +
                    "1. Xem danh sách\n" +
                    "2. Thêm mới\n" +
                    "3. Cập nhật\n" +
                    "4. Xóa\n" +
                    "5. Sắp xếp\n" +
                    "6. Tìm sản phẩm có giá đắt nhất\n" +
                    "9. Thoát";

            System.out.println(menu);
            System.out.println("----------");
            String str = "Nhập Lựa Chọn: ";
            choice = check.checkInputNumber(str);

            switch (choice) {
                case 1:
                    productMenu.showAllProducts();
                    break;
                case 2:
                    productMenu.addProduct();
                    break;
                case 3:
                    productMenu.updateProduct();
                    break;
                case 4:
                    productMenu.deleteProduct();
                    break;
                case 5:
                    productMenu.sortProduct();
                    break;
                case 6:
                    productMenu.mostExpensiveProduct();
                    break;
                case 9:
                    break;
                default:
                    System.out.println("Không Có Lựa Chọn !!!");

                    break;
            }
        } while (choice != 9);
    }
}
