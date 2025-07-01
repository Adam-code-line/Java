package BookSaleManage.src.prepare.storage.authority;
import BookSaleManage.src.prepare.storage.entity.Book;

/*
 * 管理员权限
 */

public interface storeMgr {
    public void in(int id, int num); //入库图书
    public void out(int id, int num); //出库图书
    public void add(Book book); //添加图书
    public void query(); //查询图书信息

}
