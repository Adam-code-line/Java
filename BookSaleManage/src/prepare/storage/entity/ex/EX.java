package BookSaleManage.src.prepare.storage.entity.ex;

public abstract class EX {
    private double price; // 商品价格
    private String ex_name; // 商品名称

    public EX() {}

    public EX(double price, String ex_name) {
        this.price = price;
        this.ex_name = ex_name;
    }

    public double getPrice() {
        return price;
    }
    public void setPrice(double price) {
        this.price = price;
    }
    public String getEx_name() {
        return ex_name;
    }
    public void setEx_name(String ex_name) {
        this.ex_name = ex_name;
    }

    public double cost() {
        System.out.println("======================");
        return price;

    }
}
