package VehicleRent.src.Model;
/*
 * 客车
 */

//继承MotoVehicle类
public class Bus extends MotoVehicle {
    //座位数
    private String seatCount;

    public String getSeatCount() {
        return seatCount;
    }

    public void setSeatCount(String seatCount) {
        this.seatCount = seatCount;
    }

    public Bus(String vehicleId, String vehicleType, String vehicleBrand, String vehicleModel, double rentalPrice, String seatCount) {
        // 调用父类构造方法
        super(vehicleId, vehicleType, vehicleBrand, vehicleModel, rentalPrice);
        this.seatCount = seatCount;
    }

    /*
     * 重写计算租金
     */

    @Override
    public double calcRent(int days) {
        double price = this.getRentalPrice()*days;
        if (days > 7 && days <= 30) {
            // 如果租期在7天到30天之间，享受9折优惠
            price *= 0.9;
        } else if (days > 30 && days <= 150) {
            // 如果租期在30天到150天之间，享受8折优惠
            price *= 0.8;
        } else if (days > 150) {
            // 如果租期超过150天，享受7折优惠
            price *= 0.7;
        }
        return price; // 返回总租金
    }
}

