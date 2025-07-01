package BookSaleManage.src.prepare.storage.authority.impl;

import BookSaleManage.src.prepare.storage.authority.storeMgr;
import BookSaleManage.src.prepare.storage.biz.*;
import BookSaleManage.src.prepare.storage.entity.Book;

/*
 * 管理员类
 */

public class DefaultStoreMgr implements storeMgr {
    BookBiz bookBiz = new BookBiz();

    //图书入库
    @Override
    public void in(int id, int num) {
        bookBiz.inBook(id, num);
    }

    //图书出库
    @Override
    public void out(int id, int num) {
        bookBiz.outBook(id, num);
    }

    //新增图书
    @Override
    public void add(Book book) {
        bookBiz.addBook(book);
    }

    //查询图书
    @Override
    public void query() {
        bookBiz.query();
    }

}
