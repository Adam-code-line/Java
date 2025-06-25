package VehicleRent.src.Service;
import VehicleRent.src.Model.MotoVehicle;
import java.util.Scanner;

/*
 * 汽车租借管理类
 */

public class RentMgrSys {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        MotoOperation motoMgr = new MotoOperation();
        motoMgr.init();
        MotoVehicle moto = null;

        System.out.println("************欢迎光临汽车租赁公司************");
        System.out.println("1、轿车\t2、客车");
        System.out.print("请选择你要租赁的汽车类型：");
        int motovehicleType = input.nextInt();
        String vehicleBrand = "";
        String vehicleType = "";
        String vehicleModel = "";

        if (motovehicleType == 1) {
            vehicleType = "Car";
            System.out.println("请选择你要租赁的车的品牌: 1、别克 2、宝马");
            int choose2 = input.nextInt();
            vehicleBrand = (choose2 == 1) ? "别克" : "宝马";
            if (vehicleBrand.equals("别克")) {
                System.out.println("请选择你要租赁的汽车的型号：1、林荫大道 2、GL8");
                vehicleModel = (input.nextInt() == 1) ? "林荫大道" : "GL8";
            } else {
                System.out.print("请选择你要租赁的汽车型号：1、X6  2、550i：");
                vehicleModel = (input.nextInt() == 1) ? "X6" : "550i";
            }
        } else if (motovehicleType == 2) {
            vehicleType = "Bus";
            System.out.print("请选择你要租赁的汽车品牌：1、金龙 2、金杯：");
            vehicleBrand = (input.nextInt() == 1) ? "金龙" : "金杯";
            System.out.print("请选择你要租赁的汽车座位数：1、16座 2、34座：");
            vehicleModel = (input.nextInt() == 1) ? "16" : "34";
        }

        moto = motoMgr.motoLeaseOut(vehicleType, vehicleBrand, vehicleModel);

        //租赁天数
        System.out.println("请输入你要租赁的天数：");
        int days = input.nextInt();
        //多态计算租金
        double money = moto.calcRent(days);
        System.out.println("您的车牌号是：" + moto.getVehicleId());
        System.out.print("您需要支付的租金为：" + money + "元");
        input.close();//关闭输入流
    }


}
