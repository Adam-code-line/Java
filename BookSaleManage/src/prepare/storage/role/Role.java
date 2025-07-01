package BookSaleManage.src.prepare.storage.role;
import BookSaleManage.src.prepare.storage.authority.*;
import BookSaleManage.src.prepare.storage.entity.*;
import BookSaleManage.src.prepare.storage.entity.ex.EX;

/*
 * 角色类
 * 角色可以是管理员或顾客
 * 管理员权限：入库、出库、添加图书、查询图书信息
 * 顾客权限：查询图书信息、购买图书、购买附赠品、结账
 */

public class Role {
    private String name; // 角色名称
    private storeMgr storeMgr = null; // 管理员权限
    private Normal normal = null; // 顾客权限

    public void setName(String name) {
        this.name = name;
    }
    public String getName() {
        return name;
    }
    public void setStoreMgr(storeMgr storeMgr) {
        this.storeMgr = storeMgr;
    }
    public storeMgr getStoreMgr() {
        return storeMgr;
    }
    public void setNormal(Normal normal) {
        this.normal = normal;
    }
    public Normal getNormal() {
        return normal;
    }
    
    // 购买图书
    public void in(int id, int buy_num) {
        if(storeMgr == null) {
            System.out.println("当前角色没有管理员权限，无法入库图书");
            return;
        }else {
            storeMgr.in(id, buy_num);
        }
    }

    // 出库图书
    public void out(int id, int buy_num) {
        if(storeMgr == null) {
            System.out.println("当前角色没有管理员权限，无法出库图书");
            return;
        }else {
            storeMgr.out(id, buy_num);
        }
    }

    // 添加图书
    public void add(Book book) {
        if(storeMgr == null) {
            System.out.println("当前角色没有管理员权限，无法添加图书");
            return;
        }else {
            storeMgr.add(book);
        }
    }

    // 查询图书信息
    public void query(){
        if(storeMgr == null && normal == null) {
            System.out.println("您没有登录,不能查询图书");
            return;
        }else if(storeMgr != null) {
            storeMgr.query();
        }else if(normal != null) {
            normal.query();
        }
    }

    //结账
    public void checkout(Book book) {
        if(normal == null) {
            System.out.println("您没有登录，无法结账");
            return;
        }else {
            normal.checkout(book);
        }
    }

    //购买图书
    public Book buy(int id, int buy_num) {
        if(normal == null) {
            System.out.println("您没有登录，无法购买图书");
            return null;
        }else {
            return normal.buy(id, buy_num);
        }
    }

    //购买附赠品
    public EX buyEx(int ex_id) {
        if(normal == null) {
            System.out.println("您没有登录，无法购买附赠品");
            return null;
        }else {
            return normal.buyEx(ex_id);
        }
    }
}
