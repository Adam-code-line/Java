package VehicleRent.src.Model;

//继承MotoVehicle类
public class Car extends MotoVehicle {
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    private String type; // 车辆类型

    public Car(String vehicleId, String vehicleType, String vehicleBrand, String vehicleModel, double rentalPrice, String type) {
        // 调用父类构造方法
        super(vehicleId, vehicleType, vehicleBrand, vehicleModel, rentalPrice);
        this.type = type;
    }

    @Override
    public double calcRent(int days) {

        double price = this.getRentalPrice()*days;
        if (days>7 && days <= 30) {
            // 如果租期在7天到30天之间，享受9折优惠
            price *= 0.9;
        } else if (days > 30 && days <=150) {
            price *= 0.8; // 如果租期在30天到150天之间，享受8折优惠
        }else if (days > 150) {
            price *= 0.7; // 如果租期超过150天，享受7折优惠
            
        }
        return price; // 返回总租金
    }
}
