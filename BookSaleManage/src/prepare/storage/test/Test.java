package BookSaleManage.src.prepare.storage.test;

import java.util.*;

import BookSaleManage.src.prepare.storage.biz.*;
import BookSaleManage.src.prepare.storage.entity.*;
import BookSaleManage.src.prepare.storage.entity.ex.*;
import BookSaleManage.src.prepare.storage.user.*;

public class Test {
    Scanner input = new Scanner(System.in);

    public static void main(String[] args) {
        Test test = new Test();
        User user = new User();
        System.out.println("===========欢迎进入解忧书店===========");
        test.roleAuthority(user); //角色授权
        BookBiz.makeData(); //初始化图书数据
        if (user.getRole().getName().equals("管理员")) {
            test.adminOperation(user); //管理员操作
        } else if (user.getRole().getName().equals("顾客")) {
            test.customerOperation(user); //顾客操作
        }
    }

    //角色授权
    public void roleAuthority(User user) {
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

    //管理员操作
    public void adminOperation(User user) {
        while (true) {
            System.out.println("欢迎管理员进入解忧书店图书管理系统");
            user.query();
            System.out.println("请选择操作：1.图书入库 2.图书出库 3.查询全部图书 4.新增图书 5.退出");
            try {
                int choice = input.nextInt();
                switch (choice) {
                    case 1:
                        inBook(user); //图书入库
                        break;
                    case 2:
                        outBook(user); //图书出库
                        break;
                    case 3:
                        //queryAllBooks(user); //查询全部图书
                        break;
                    case 4:
                        user.add(inputBookInfo()); //新增图书
                        System.out.println("图书新增成功！");
                        user.query(); //查询全部图书
                        break;
                    case 5:
                        System.out.println("退出成功！");
                        return;
                    default:
                        System.out.println("输入错误，请输入正确的数字1~5！");
                }
            } catch (Exception e) {
                System.out.println("输入错误，请重新输入正确的数字1~5！");
                input.nextLine(); // 清除错误输入
            }
        }
    }

    //输入图书信息
    public Book inputBookInfo() {
        Book book = new Book();
        while (true) {
            try {
                System.out.println("请输入图书书名:");
                String name = input.next(); // 使用 next() 读取书名
                System.out.println("请输入图书作者:");
                String author = input.next(); // 使用 next() 读取作者
                System.out.println("请输入图书出版时间:");
                String pub_date = input.next();
                System.out.println("请输入图书价格:");
                double price = input.nextDouble();
                System.out.println("请输入图书数量:");
                int store = input.nextInt();
                book.setName(name);
                book.setAuthor(author);
                book.setPub_date(pub_date);
                book.setPrice(price);
                book.setStore(store);
                System.out.println("图书信息录入成功！");
                break; // 录入成功后退出循环
            } catch (Exception e) {
                System.out.println("图书信息录入失败，请检查输入信息是否正确！");
                input.nextLine(); // 清除错误输入
            }
        }
        return book;
    }

    //图书入库
    public void inBook(User user) {
        while (true) {
            try {
                System.out.println("请输入图书ID:");
                int bookId = input.nextInt();
                System.out.println("请输入入库数量:");
                int num = input.nextInt();
                user.in(bookId, num); //入库
                System.out.println("图书入库成功！");
                break; // 入库成功后退出循环
            } catch (Exception e) {
                System.out.println("图书入库失败，请检查输入信息是否正确！");
                input.nextLine(); // 清除错误输入
            }
        }
    }

    //图书出库
    public void outBook(User user) {
        while (true) {
            try {
                System.out.println("请输入图书ID:");
                int bookId = input.nextInt();
                System.out.println("请输入出库数量:");
                int num = input.nextInt();
                user.out(bookId, num); //出库
                System.out.println("图书出库成功！");
                break; // 出库成功后退出循环
            } catch (Exception e) {
                System.out.println("图书出库失败，请检查输入信息是否正确！");
                input.nextLine(); // 清除错误输入
            }
        }
    }

    //顾客的操作
    public void customerOperation(User user) {
        while (true) {
            System.out.println("欢迎顾客进入解忧书店！");
            user.query();
            System.out.println("请选择操作：1.查询图书 2.结账 3.退出");
            try {
                int choice = input.nextInt();
                switch (choice) {
                    case 1:
                        break;
                    case 2:
                        buyBook(user); // 结账
                        break;
                    case 3:
                        System.out.println("谢谢惠顾");
                        return;
                    default:
                        System.out.println("输入错误，请输入正确的数字1~3！");
                }
            } catch (Exception e) {
                System.out.println("输入错误，请重新输入正确的数字1~3！");
                input.nextLine(); // 清除错误输入
            }
        }
    }

    //购买图书
    public void buyBook(User user) {
        while (true) {
            try {
                System.out.println("请输入图书ID:");
                int bookId = input.nextInt();
                System.out.println("请输入购买数量:");
                int num = input.nextInt();
                Book book = user.buy(bookId, num); //购买图书
                if (book != null) {
                    while (true) {
                        try {
                            System.out.print("赠品: 1.CD  2.包装  3.钢笔  4.不需要，请输入相应的数字进行赠品购买:");
                            int giftChoice = input.nextInt();
                            if (giftChoice >= 1 && giftChoice <= 4) {
                                EX ex = user.buyEx(giftChoice);
                                book.setEx(ex); //设置赠品
                                user.checkout(book); //结账
                                System.out.println("购买成功！");
                                return;
                            }
                            System.out.println("输入错误，请输入1~4之间的数字！");
                        } catch (Exception e) {
                            System.out.println("输入错误，请重新输入正确的数字！");
                            input.nextLine(); // 清除错误输入
                        }
                    }
                } else {
                    System.out.println("购买失败，请检查图书信息！");
                    return;
                }
            } catch (Exception e) {
                System.out.println("购买图书失败，请检查输入信息是否正确！");
                input.nextLine(); // 清除错误输入
            }
        }
    }
}
