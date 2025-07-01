package BookSaleManage.src.prepare.storage.authority.impl;

import BookSaleManage.src.prepare.storage.authority.Normal;
import BookSaleManage.src.prepare.storage.biz.*;
import BookSaleManage.src.prepare.storage.entity.Book;
import BookSaleManage.src.prepare.storage.entity.ex.EX;

/*
 * 普通顾客
 */

public class DefaultCustomer implements Normal {
    BookBiz bookBiz = new BookBiz();

    //查询图书
    @Override
    public void query() {
        bookBiz.query();
    }

    //购买图书
    @Override
    public Book buy(int id, int num) {
        return bookBiz.buyBook(id, num);
    }

    //购买附赠品
    @Override
    public EX buyEx(int ex_id) {
        return bookBiz.buyEx(ex_id);
    }

    //结账
    @Override
    public void checkout(Book book) {
        bookBiz.checkout(book);
    }
    
}
