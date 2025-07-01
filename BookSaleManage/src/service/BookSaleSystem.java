package BookSaleManage.src.service;

import java.util.Scanner;

import BookSaleManage.src.prepare.storage.biz.BookBiz;
import BookSaleManage.src.prepare.storage.user.User;

public class BookSaleSystem {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        User user = new User();
        BookService bookService = new BookService(user, input);

        System.out.println("===========欢迎进入解忧书店===========");
        bookService.roleAuthority(); // 角色授权
        BookBiz.makeData(); // 初始化图书数据

        if (user.getRole().getName().equals("管理员")) {
            bookService.adminOperation(); // 管理员操作
        } else if (user.getRole().getName().equals("顾客")) {
            bookService.customerOperation(); // 顾客操作
        }
    }
}
