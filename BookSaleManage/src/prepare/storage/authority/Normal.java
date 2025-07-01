package BookSaleManage.src.prepare.storage.authority;
import BookSaleManage.src.prepare.storage.entity.Book;
import BookSaleManage.src.prepare.storage.entity.ex.EX;

/*
 * 顾客权限
 */

public interface Normal {
    public void query(); //查询图书信息
    public Book buy(int id, int num); //购买图书

    public EX buyEx(int ex_id); //购买附赠品

    public void checkout(Book book); //结账
}
