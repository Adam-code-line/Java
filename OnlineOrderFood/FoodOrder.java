package OnlineOrderFood;

public class FoodOrder extends Order {
    private Dish dish;
    private int quantity;

    public FoodOrder(String customerName, Dish dish, int quantity, String deliveryTime, String deliveryAddress) {
        this.customerName = customerName;
        this.dish = dish;
        this.quantity = quantity;
        this.deliveryTime = deliveryTime;
        this.deliveryAddress = deliveryAddress;
        this.totalPrice = dish.getPrice() * quantity;
        this.orderStatus = 0;
    }

    @Override
    public void printOrder(int index) {
        System.out.println("订单编号：" + (index + 1));
        System.out.println("订餐人姓名：" + customerName);
        System.out.println("菜品信息：" + dish.getName() + " " + quantity + "份");
        System.out.println("送餐时间：" + deliveryTime);
        System.out.println("送餐地址：" + deliveryAddress);
        System.out.println("菜品总价格：￥" + totalPrice);
        System.out.println("订单状态：" + (orderStatus == 0 ? "已预定" : "已完成"));
        System.out.println("-------------------------");
    }

    public Dish getDish() {
        return dish;
    }
}
