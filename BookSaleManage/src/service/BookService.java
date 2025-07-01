package BookSaleManage.src.service;

import java.util.Scanner;

import BookSaleManage.src.prepare.storage.entity.Book;
import BookSaleManage.src.prepare.storage.entity.ex.EX;
import BookSaleManage.src.prepare.storage.user.User;

public class BookService {
    private User user;
    private Scanner input;

    public BookService(User user, Scanner input) {
        this.user = user;
        this.input = input;
    }

    // 角色授权
    public void roleAuthority() {
        System.out.println("请输入用户名：");
        String username = input.nextLine();
        System.out.println("请输入密码：");
        String password = input.nextLine();
        if (user.login(username, password)) {
            System.out.println("登录成功！");
        } else {
            System.out.println("登录失败，请检查用户名或密码！");
        }
    }

    // 管理员操作
    public void adminOperation() {
        while (true) {
            System.out.println("欢迎管理员进入解忧书店图书管理系统");
            user.query();
            System.out.println("请选择操作：1.图书入库 2.图书出库 3.查询全部图书 4.新增图书 5.退出");
            int choice = getValidIntInput("请输入操作编号：");
            switch (choice) {
                case 1:
                    inBook();
                    break;
                case 2:
                    outBook();
                    break;
                case 3:
                    user.query();
                    break;
                case 4:
                    user.add(inputBookInfo());
                    System.out.println("图书新增成功！");
                    break;
                case 5:
                    System.out.println("退出成功！");
                    return;
                default:
                    System.out.println("输入错误，请输入正确的数字1~5！");
            }
        }
    }

    // 输入图书信息
    public Book inputBookInfo() {
        Book book = new Book();
        System.out.println("请输入图书书名:");
        book.setName(input.nextLine());
        System.out.println("请输入图书作者:");
        book.setAuthor(input.nextLine());
        System.out.println("请输入图书出版时间:");
        book.setPub_date(input.nextLine());
        book.setPrice(getValidDoubleInput("请输入图书价格:"));
        book.setStore(getValidIntInput("请输入图书数量:"));
        System.out.println("图书信息录入成功！");
        return book;
    }

    // 图书入库
    public void inBook() {
        int bookId = getValidIntInput("请输入图书ID:");
        int num = getValidIntInput("请输入入库数量:");
        user.in(bookId, num);
        System.out.println("图书入库成功！");
    }

    // 图书出库
    public void outBook() {
        int bookId = getValidIntInput("请输入图书ID:");
        int num = getValidIntInput("请输入出库数量:");
        user.out(bookId, num);
        System.out.println("图书出库成功！");
    }

    // 顾客操作
    public void customerOperation() {
        while (true) {
            System.out.println("欢迎顾客进入解忧书店！");
            user.query();
            System.out.println("请选择操作：1.查询图书 2.结账 3.退出");
            int choice = getValidIntInput("请输入操作编号：");
            switch (choice) {
                case 1:
                    user.query();
                    break;
                case 2:
                    buyBook();
                    break;
                case 3:
                    System.out.println("谢谢惠顾");
                    return;
                default:
                    System.out.println("输入错误，请输入正确的数字1~3！");
            }
        }
    }

    // 购买图书
    public void buyBook() {
        int bookId = getValidIntInput("请输入图书ID:");
        int num = getValidIntInput("请输入购买数量:");
        Book book = user.buy(bookId, num);
        if (book != null) {
            int giftChoice = getValidIntInput("赠品: 1.CD  2.包装  3.钢笔  4.不需要，请输入相应的数字进行赠品购买:");
            if (giftChoice >= 1 && giftChoice <= 4) {
                EX ex = user.buyEx(giftChoice);
                book.setEx(ex);
                user.checkout(book);
                System.out.println("购买成功！");
            } else {
                System.out.println("输入错误，请输入1~4之间的数字！");
            }
        } else {
            System.out.println("购买失败，请检查图书信息！");
        }
    }

    // 获取有效的整数输入
    private int getValidIntInput(String prompt) {
        while (true) {
            try {
                System.out.println(prompt);
                return input.nextInt();
            } catch (Exception e) {
                System.out.println("输入错误，请输入一个有效的整数！");
                input.nextLine(); // 清除错误输入
            }
        }
    }

    // 获取有效的浮点数输入
    private double getValidDoubleInput(String prompt) {
        while (true) {
            try {
                System.out.println(prompt);
                return input.nextDouble();
            } catch (Exception e) {
                System.out.println("输入错误，请输入一个有效的数字！");
                input.nextLine(); // 清除错误输入
            }
        }
    }
}
