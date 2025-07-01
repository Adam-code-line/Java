package BookSaleManage.src.prepare.storage.entity;
import BookSaleManage.src.prepare.storage.entity.ex.*;

public class Book {
    private int id;//图书编号
    private String name;//图书名称
    private String author;//图书作者
    private String pub_date;//图书出版日期
    private int store;//图书库存
    private double price;//图书价格
    private int buy_num;//图书购买数量
    private EX ex;// 附赠品

    public Book() {};

    public Book(int id, String name, String author, String pub_date, int store, double price, int buy_num) {
        this.id = id;
        this.name = name;
        this.author = author;
        this.pub_date = pub_date;
        this.store = store;
        this.price = price;
        this.buy_num = buy_num;

    }

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getAuthor() {
        return author;
    }
    public void setAuthor(String author) {
        this.author = author;
    }
    public String getPub_date() {
        return pub_date;
    }
    public void setPub_date(String pub_date) {
        this.pub_date = pub_date;   
    }
    public int getStore() {
        return store;
    }
    public void setStore(int store) {
        this.store = store;
    }
    public double getPrice() {
        return price;
    }
    public void setPrice(double price) {
        this.price = price;
    }
    public int getBuy_num() {
        return buy_num;
    }
    public void setBuy_num(int buy_num) {
        this.buy_num = buy_num;
    }
    public EX getEx() {
        return ex;
    }
    public void setEx(EX ex) {
        this.ex = ex;
    }

    public double cost() {
        System.out.println(this.getName() + ":" + this.getPrice() + "元" + "\t购买数量：" + this.getBuy_num());
        System.out.println("小计:" + this.getPrice() * this.getBuy_num() + "元");
        System.out.println("============附赠品===========");
        if(ex != null) {
            System.out.println("附赠品：" + ex.getEx_name() + "\t" + ex.getPrice() + "元");
            return this.getPrice() * this.getBuy_num() + ex.cost();
        } else {
            return this.getPrice() * this.getBuy_num();
        }
    }
};
