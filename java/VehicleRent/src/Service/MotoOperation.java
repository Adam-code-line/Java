package VehicleRent.src.Service;

import VehicleRent.src.Model.MotoVehicle;
import VehicleRent.src.Model.Car;
import VehicleRent.src.Model.Bus;

public class MotoOperation {
    // 定义车辆数组
    public MotoVehicle motos[] = new MotoVehicle[8];

    public void init() {
        motos[0] = new Car("京NY28588", "Car", "宝马", "X6", 800.0, "轿车");    
        motos[1] = new Car("京CNY3284", "Car", "宝马", "550i", 600, "轿车");
        motos[2] = new Car("京NT37465", "Car", "别克", "林荫大道", 300, "轿车");
        motos[3] = new Car("京NT96968", "Car", "别克", "GL8", 600, "轿车");
        motos[4] = new Bus("京6566754", "Bus", "金杯", "16", 800, "16");
        motos[5] = new Bus("京8696997", "Bus", "金龙", "16", 800, "16");
        motos[6] = new Bus("京9696996", "Bus", "金杯", "34", 1500, "34");
        motos[7] = new Bus("京8696998", "Bus", "金龙", "34", 1500, "34");
    }

    //汽车租用
    public MotoVehicle motoLeaseOut(String vehicleType, String vehicleBrand, String vehicleModel) {
        
        MotoVehicle moto = null;
    
        for (MotoVehicle mymoto : motos) {
            if (mymoto instanceof Car) {
                Car car = (Car)mymoto;
                if (car.getVehicleBrand().equals(vehicleBrand) && car.getVehicleType().equals(vehicleType)) {
                    moto = car;
                    break;
                }
            } else if (mymoto instanceof Bus) {
                Bus bus = (Bus)mymoto;
                if (bus.getVehicleBrand().equals(vehicleBrand)
                        && bus.getVehicleType().equals(vehicleType)
                        && bus.getSeatCount() == vehicleModel) {
                    moto = bus;
                    break;
                }
            }
        }
        return moto;
    }
}
