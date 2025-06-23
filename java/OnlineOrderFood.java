import java.util.Scanner;

public class OnlineOrderFood {

    public static void main(String[] args) {
        String[] dishes = {"宫保鸡丁", "麻婆豆腐", "鱼香肉丝", "红烧茄子", "清炒时蔬"};
        double[] prices = {28.0, 18.0, 22.0, 16.0, 12.0};
        int[] likes = new int[dishes.length];
        String[] names = new String[dishes.length];
        String[] dishMsg = new String[dishes.length];
        String[] deliveryTimes = new String[dishes.length];
        String[] deliveryAddresses = new String[dishes.length];
        double[] totalPrices = new double[dishes.length];
        int[] orderStatus = new int[dishes.length];

        // 初始化订单
        names[0] = "张三";
        dishMsg[0] = "宫保鸡丁 2份";
        deliveryTimes[0] = "2023-10-02 12:00";
        deliveryAddresses[0] = "北京市海淀区";
        totalPrices[0] = prices[0] * 2;
        orderStatus[0] = 0;

        names[1] = "李四";
        dishMsg[1] = "麻婆豆腐 1份";
        deliveryTimes[1] = "2023-10-02 12:30";
        deliveryAddresses[1] = "上海市浦东新区";
        totalPrices[1] = prices[1] * 1;
        orderStatus[1] = 1;

        Scanner scanner = new Scanner(System.in);
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
            scanner.nextLine(); // 吸收回车

            switch (choice) {
                case 1:
                    System.out.println("======我要订餐======");
                    boolean isAdd = false;
                    for (int i = 0; i < names.length; i++) {
                        if (names[i] == null) {
                            isAdd = true;
                            System.out.print("请输入订餐人姓名：");
                            String name = scanner.nextLine();

                            printDishes(dishes, prices, likes);

                            System.out.print("请输入菜品编号（1-" + dishes.length + "）：");
                            int dishIndex = scanner.nextInt() - 1;
                            while (dishIndex < 0 || dishIndex >= dishes.length) {
                                System.out.print("无效的菜品编号，请重新输入（1-" + dishes.length + "）：");
                                dishIndex = scanner.nextInt() - 1;
                            }

                            System.out.print("请输入菜品份数：");
                            int quantity = scanner.nextInt();
                            while (quantity <= 0) {
                                System.out.print("菜品份数必须大于0，请重新输入：");
                                quantity = scanner.nextInt();
                            }
                            scanner.nextLine(); // 吸收回车

                            System.out.print("请输入送餐时间（格式：yyyy-MM-dd HH:mm）：");
                            String deliveryTime = scanner.nextLine();
                            while (deliveryTime.isEmpty()) {
                                System.out.print("送餐时间不能为空，请重新输入：");
                                deliveryTime = scanner.nextLine();
                            }

                            System.out.print("请输入送餐地址：");
                            String deliveryAddress = scanner.nextLine();
                            while (deliveryAddress.isEmpty()) {
                                System.out.print("送餐地址不能为空，请重新输入：");
                                deliveryAddress = scanner.nextLine();
                            }

                            names[i] = name;
                            dishMsg[i] = dishes[dishIndex] + " " + quantity + "份";
                            deliveryTimes[i] = deliveryTime;
                            deliveryAddresses[i] = deliveryAddress;
                            totalPrices[i] = prices[dishIndex] * quantity;
                            orderStatus[i] = 0;
                            System.out.println("订单成功！以下是您的订单信息：");
                            printOrder(i, names, dishMsg, deliveryTimes, deliveryAddresses, totalPrices, orderStatus);
                            break;
                        }
                    }
                    if (!isAdd) {
                        System.out.println("订单已满，无法继续添加！");
                    }
                    break;
                case 2:
                    System.out.println("======查看订单======");
                    boolean hasOrder = false;
                    for (int i = 0; i < names.length; i++) {
                        if (names[i] != null) {
                            hasOrder = true;
                            printOrder(i, names, dishMsg, deliveryTimes, deliveryAddresses, totalPrices, orderStatus);
                        }
                    }
                    if (!hasOrder) {
                        System.out.println("当前没有订单。");
                    }
                    break;
                case 3:
                    System.out.println("======签收订单======");
                    System.out.print("请输入要签收的订单编号（1-" + names.length + "）：");
                    int orderIndex = scanner.nextInt() - 1;
                    while (orderIndex < 0 || orderIndex >= names.length || names[orderIndex] == null || orderStatus[orderIndex] != 0) {
                        System.out.print("无效的订单编号或订单已完成，请重新输入（1-" + names.length + "）：");
                        orderIndex = scanner.nextInt() - 1;
                    }
                    orderStatus[orderIndex] = 1;
                    System.out.println("订单签收成功！以下是您的订单信息：");
                    printOrder(orderIndex, names, dishMsg, deliveryTimes, deliveryAddresses, totalPrices, orderStatus);
                    break;
                case 4:
                    System.out.println("======删除订单======");
                    System.out.print("请输入要删除的订单编号（1-" + names.length + "）：");
                    int deleteIndex = scanner.nextInt() - 1;
                    while (deleteIndex < 0 || deleteIndex >= names.length || names[deleteIndex] == null) {
                        System.out.print("无效的订单编号，请重新输入（1-" + names.length + "）：");
                        deleteIndex = scanner.nextInt() - 1;
                    }
                    if (orderStatus[deleteIndex] != 1) {
                        System.out.println("只能删除已完成的订单！");
                        break;
                    }
                    for (int i = deleteIndex; i < names.length - 1; i++) {
                        names[i] = names[i + 1];
                        dishMsg[i] = dishMsg[i + 1];
                        deliveryTimes[i] = deliveryTimes[i + 1];
                        deliveryAddresses[i] = deliveryAddresses[i + 1];
                        totalPrices[i] = totalPrices[i + 1];
                        orderStatus[i] = orderStatus[i + 1];
                    }
                    names[names.length - 1] = null;
                    dishMsg[dishMsg.length - 1] = null;
                    deliveryTimes[deliveryTimes.length - 1] = null;
                    deliveryAddresses[deliveryAddresses.length - 1] = null;
                    totalPrices[totalPrices.length - 1] = 0.0;
                    orderStatus[orderStatus.length - 1] = 0;
                    System.out.println("订单删除成功！");
                    break;
                case 5:
                    System.out.println("======我要点赞======");
                    printDishes(dishes, prices, likes);
                    System.out.print("请输入菜品编号（1-" + dishes.length + "）：");
                    int likeIndex = scanner.nextInt() - 1;
                    while (likeIndex < 0 || likeIndex >= dishes.length) {
                        System.out.print("无效的菜品编号，请重新输入（1-" + dishes.length + "）：");
                        likeIndex = scanner.nextInt() - 1;
                    }
                    likes[likeIndex]++;
                    System.out.println("点赞成功！当前点赞数：" + likes[likeIndex]);
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

    public static void printOrder(int i, String[] names, String[] dishMsg, String[] deliveryTimes, String[] deliveryAddresses, double[] totalPrices, int[] orderStatus) {
        System.out.println("订单编号：" + (i + 1));
        System.out.println("订餐人姓名：" + names[i]);
        System.out.println("菜品信息：" + dishMsg[i]);
        System.out.println("送餐时间：" + deliveryTimes[i]);
        System.out.println("送餐地址：" + deliveryAddresses[i]);
        System.out.println("菜品总价格：￥" + totalPrices[i]);
        System.out.println("订单状态：" + (orderStatus[i] == 0 ? "已预定" : "已完成"));
        System.out.println("-------------------------");
    }

    public static void printDishes(String[] dishes, double[] prices, int[] likes) {
        System.out.println("可选菜品：");
        System.out.println("序号\t菜品名称\t价格\t点赞数");
        for (int j = 0; j < dishes.length; j++) {
            String praise = likes[j] == 0 ? "无" : likes[j] + "赞";
            System.out.println((j + 1) + ". " + dishes[j] + " - ￥" + prices[j] + " (点赞数: " + praise + ")");
        }
    }
}