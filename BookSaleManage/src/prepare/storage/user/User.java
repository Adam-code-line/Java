package BookSaleManage.src.prepare.storage.user;
import BookSaleManage.src.prepare.storage.authority.*;
import BookSaleManage.src.prepare.storage.authority.impl.DefaultCustomer;
import BookSaleManage.src.prepare.storage.authority.impl.DefaultStoreMgr;
import BookSaleManage.src.prepare.storage.entity.*;
import BookSaleManage.src.prepare.storage.entity.ex.*;
import BookSaleManage.src.prepare.storage.role.*;

public class User {
    private Role role = null; // 用户角色

    //登录方法
    public boolean login( String username, String password ) {
        //登录逻辑
        if(username.equals(password)) {
            if(username.equals("admin")) {
                Role storeManager = new Role();// 创建管理员角色
                storeManager.setName("管理员");
                //分配管理员权限
                storeMgr dfStoreMgr = new DefaultStoreMgr();//创建管理员权限
                storeManager.setStoreMgr(dfStoreMgr);
                //为用户授权角色
                setRole(storeManager);
            }else {
                Role customer = new Role(); // 创建顾客角色
                customer.setName("顾客");
                //分配顾客权限
                Normal dfCustomer = new DefaultCustomer(); // 创建顾客权限
                customer.setNormal(dfCustomer);
                //为用户授权角色
                setRole(customer);
            }
            return true; // 登录成功
        }
        return false; // 登录失败
    }

    //设置角色
    public void setRole(Role role) {
        this.role = role;
    }

    //获取角色
    public Role getRole() {
        return role;
    }

    //图书入库
    public void in(int id, int num) {
        role.in(id, num);
    }

    //图书出库
    public void out(int id, int num) {
        role.out(id, num);
    }

    //添加图书
    public void add(Book book) {
        role.add(book);
    }

    //查询图书信息
    public void query() {
        role.query();
    }

    //结账
    public void checkout(Book book) {
        role.checkout(book);
    }

    //购买图书
    public Book buy(int id, int buy_num) {
        return role.buy(id, buy_num);
    }

    //购买附赠品
    public EX buyEx(int ex_id) {
        return role.buyEx(ex_id);
    }
}
