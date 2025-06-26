package OnlineOrderFood;

public abstract class Order {
    protected String customerName;
    protected String deliveryTime;
    protected String deliveryAddress;
    protected double totalPrice;
    protected int orderStatus; // 0-未完成，1-已完成

    public abstract void printOrder(int index);

    public int getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(int status) {
        this.orderStatus = status;
    }
}
