package VehicleRent.src.Model;

//租车父类 抽象类
public abstract class MotoVehicle {
    private String vehicleId; // 车辆编号
    private String vehicleType; // 车辆类型
    private String vehicleBrand; // 车辆品牌
    private String vehicleModel; // 车辆型号
    private double rentalPrice; // 租金

    public MotoVehicle(String vehicleId, String vehicleType, String vehicleBrand, String vehicleModel, double rentalPrice) {
        this.vehicleId = vehicleId;
        this.vehicleType = vehicleType;
        this.vehicleBrand = vehicleBrand;
        this.vehicleModel = vehicleModel;
        this.rentalPrice = rentalPrice;
    }

    public String getVehicleId() {
        return vehicleId;
    }

    public void setVehicleId(String vehicleId) {
        this.vehicleId = vehicleId;
    }

    public String getVehicleType() {
        return vehicleType;
    }

    public void setVehicleType(String vehicleType) {
        this.vehicleType = vehicleType;
    }

    public String getVehicleBrand() {
        return vehicleBrand;
    }

    public void setVehicleBrand(String vehicleBrand) {
        this.vehicleBrand = vehicleBrand;
    }

    public String getVehicleModel() {
        return vehicleModel;
    }

    public void setVehicleModel(String vehicleModel) {
        this.vehicleModel = vehicleModel;
    }

    public double getRentalPrice() {
        return rentalPrice;
    }

    public void setRentalPrice(double rentalPrice) {
        this.rentalPrice = rentalPrice;
    }

    //使用抽象方法计算租金
    public abstract double calcRent(int days);

}
