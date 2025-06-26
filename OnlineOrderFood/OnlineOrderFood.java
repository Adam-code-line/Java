package OnlineOrderFood;

import java.util.*;

public class OnlineOrderFood {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // 用集合管理菜品和订单
        List<Dish> dishes = new ArrayList<>();
        dishes.add(new Dish("宫保鸡丁", 28.0));
        dishes.add(new Dish("麻婆豆腐", 18.0));
        dishes.add(new Dish("鱼香肉丝", 22.0));
        dishes.add(new Dish("红烧茄子", 16.0));
        dishes.add(new Dish("清炒时蔬", 12.0));

        List<Order> orders = new ArrayList<>();

        boolean flag = false;
        System.out.println("======欢迎使用在线订餐系统！======");

        do {
            System.out.println("======在线订餐系统菜单======");
            System.out.println("1. 我要订餐");
            System.out.println("2. 查看订单");
            System.out.println("3. 签收订单");
            System.out.println("4. 删除订单");
            System.out.println("5. 我要点赞");
            System.out.println("6. 退出系统");
            System.out.println("===========================");
            System.out.print("请输入您的选择: ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1: // 下单
                    System.out.print("请输入订餐人姓名：");
                    String name = scanner.nextLine();
                    printDishes(dishes);

                    System.out.print("请输入菜品编号（1-" + dishes.size() + "）：");
                    int dishIndex = scanner.nextInt() - 1;
                    while (dishIndex < 0 || dishIndex >= dishes.size()) {
                        System.out.print("无效的菜品编号，请重新输入（1-" + dishes.size() + "）：");
                        dishIndex = scanner.nextInt() - 1;
                    }

                    System.out.print("请输入菜品份数：");
                    int quantity = scanner.nextInt();
                    while (quantity <= 0) {
                        System.out.print("菜品份数必须大于0，请重新输入：");
                        quantity = scanner.nextInt();
                    }
                    scanner.nextLine();

                    System.out.print("请输入送餐时间（格式：yyyy-MM-dd HH:mm）：");
                    String deliveryTime = scanner.nextLine();
                    System.out.print("请输入送餐地址：");
                    String deliveryAddress = scanner.nextLine();

                    orders.add(new FoodOrder(name, dishes.get(dishIndex), quantity, deliveryTime, deliveryAddress));
                    System.out.println("订单成功！以下是您的订单信息：");
                    orders.get(orders.size() - 1).printOrder(orders.size() - 1);
                    break;
                case 2: // 查看订单
                    if (orders.isEmpty()) {
                        System.out.println("当前没有订单。");
                    } else {
                        for (int i = 0; i < orders.size(); i++) {
                            orders.get(i).printOrder(i);
                        }
                    }
                    break;
                case 3: // 签收订单
                    System.out.print("请输入要签收的订单编号（1-" + orders.size() + "）：");
                    int orderIndex = scanner.nextInt() - 1;
                    while (orderIndex < 0 || orderIndex >= orders.size()
                            || orders.get(orderIndex).getOrderStatus() != 0) {
                        System.out.print("无效的订单编号或订单已完成，请重新输入（1-" + orders.size() + "）：");
                        orderIndex = scanner.nextInt() - 1;
                    }
                    orders.get(orderIndex).setOrderStatus(1);
                    System.out.println("订单签收成功！以下是您的订单信息：");
                    orders.get(orderIndex).printOrder(orderIndex);
                    break;
                case 4: // 删除订单
                    System.out.print("请输入要删除的订单编号（1-" + orders.size() + "）：");
                    int deleteIndex = scanner.nextInt() - 1;
                    while (deleteIndex < 0 || deleteIndex >= orders.size()) {
                        System.out.print("无效的订单编号，请重新输入（1-" + orders.size() + "）：");
                        deleteIndex = scanner.nextInt() - 1;
                    }
                    if (orders.get(deleteIndex).getOrderStatus() != 1) {
                        System.out.println("只能删除已完成的订单！");
                        break;
                    }
                    orders.remove(deleteIndex);
                    System.out.println("订单删除成功！");
                    break;
                case 5: // 点赞
                    printDishes(dishes);
                    System.out.print("请输入菜品编号（1-" + dishes.size() + "）：");
                    int likeIndex = scanner.nextInt() - 1;
                    while (likeIndex < 0 || likeIndex >= dishes.size()) {
                        System.out.print("无效的菜品编号，请重新输入（1-" + dishes.size() + "）：");
                        likeIndex = scanner.nextInt() - 1;
                    }
                    dishes.get(likeIndex).like();
                    System.out.println("点赞成功！当前点赞数：" + dishes.get(likeIndex).getLikes());
                    break;
                case 6:
                    System.out.println("感谢使用在线订餐系统，再见！");
                    flag = true;
                    break;
                default:
                    System.out.println("无效的选择，请重新输入！");
                    break;
            }
        } while (!flag);

        scanner.close();
    }

    // 打印菜品
    public static void printDishes(List<Dish> dishes) {
        System.out.println("可选菜品：");
        System.out.println("序号\t菜品名称\t价格\t点赞数");
        for (int j = 0; j < dishes.size(); j++) {
            String praise = dishes.get(j).getLikes() == 0 ? "无" : dishes.get(j).getLikes() + "赞";
            System.out.println((j + 1) + ". " + dishes.get(j).getName() + " - ￥" + dishes.get(j).getPrice() + " (点赞数: "
                    + praise + ")");
        }
    }
}
