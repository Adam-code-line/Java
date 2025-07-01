package BookSaleManage.src.prepare.storage.biz;

import java.util.ArrayList;
import java.util.List;

import BookSaleManage.src.prepare.storage.entity.*;
import BookSaleManage.src.prepare.storage.entity.ex.EX;
import BookSaleManage.src.prepare.storage.entity.ex.ExFactory;

public class BookBiz {
    // 图书书架
    private static List<Book> books = new ArrayList<>();

    // 初始化图书信息
    public static void makeData() {
        books.add(new Book(1, "Java编程思想", "Bruce Eckel", "2006-01-01", 100, 99.00, 0));
        books.add(new Book(2, "Effective Java", "Joshua Bloch", "2008-05-28", 50, 89.00, 0));
        books.add(new Book(3, "Head First Java", "Kathy Sierra", "2005-10-01", 75, 79.00, 0));
        books.add(new Book(4, "Java核心技术", "Cay S. Horstmann", "2012-08-01", 60, 120.00, 0));
        books.add(new Book(5, "Java并发编程实战", "Brian Goetz", "2013-05-01", 30, 110.00, 0));
    }

    // 图书入库
    public void inBook(int bookId, int num) {
        Book book = findBookById(bookId);
        if (book == null) {
            System.out.println("没有此ID的图书,请选择新增图书");
            return;
        } else {
            book.setStore(book.getStore() + num);
            System.out.println("图书入库成功！" + book.getName() + "入库数量：" + num + "本");
        }
    }

    // 图书出库
    public void outBook(int bookId, int num) {
        Book book = findBookById(bookId);
        if (book == null) {
            System.out.println("没有此ID的图书");
            return;
        } else {
            if (book.getStore() < num) {
                System.out.println("库存不足，无法出库");
            } else {
                book.setStore(book.getStore() - num);
                System.out.println("图书出库成功！" + book.getName() + "出库数量：" + num + "本");
            }
        }
    }

    // 根据ID查找图书
    public Book findBookById(int bookId) {
        for (Book book : books) {
            if (book.getId() == bookId) {
                return book;
            }
        }
        return null;
    }

    // 新增图书
    public void addBook(Book book) {
        if (book == null) {
            System.out.println("图书添加失败，图书信息为空！");
            return;
        }
        int newId = books.isEmpty() ? 1 : books.get(books.size() - 1).getId() + 1; // 自动生成ID
        book.setId(newId);
        books.add(book);
        System.out.println("图书添加成功！" + book.getName() + " 已添加到书架");
    }

    // 查询全部图书信息
    public void query() {
        if (books.isEmpty()) {
            System.out.println("当前书架没有图书信息！");
            return;
        }
        for (Book book : books) {
            System.out.println("ID: " + book.getId() + ", 名称: " + book.getName() + ", 作者: " + book.getAuthor() +
                               ", 出版日期: " + book.getPub_date() + ", 库存: " + book.getStore() + ", 价格: " + book.getPrice());
        }
    }

    // 购买图书
    public Book buyBook(int bookId, int num) {
        Book book = findBookById(bookId);
        if (book == null) {
            System.out.println("没有此ID的图书");
            return null;
        }
        if (book.getStore() < num) {
            System.out.println("库存不足，无法购买");
            return null;
        }
        book.setBuy_num(num);
        return book;
    }

    // 购买附赠品
    public EX buyEx(int ex_id) {
        EX ex = ExFactory.createEx(ex_id);
        if (ex == null) {
            System.out.println("没有此ID的附赠品");
            return null;
        }
        System.out.println("附赠品购买成功！" + ex.getEx_name() + "已添加到您的购物车");
        System.out.println("==============商品信息==============");
        return ex;
    }

    // 结账
    public void checkout(Book book) {
        if (book == null) {
            System.out.println("没有购买图书，无法结账");
            return;
        }
        book.setStore(book.getStore() - book.getBuy_num()); // 更新库存
        double price = book.cost(); // 计算图书价格
        System.out.println("总价格为: " + price + "元");
    }
}
