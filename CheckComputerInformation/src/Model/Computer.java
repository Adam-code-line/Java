package CheckComputerInformation.src.Model;

public abstract class Computer {
    private String name; //电脑名称
    private String brand; //电脑品牌
    private String cpu; //电脑cpu
    private String memory; //电脑内存
    private String hardDisk; //电脑硬盘
    private String monitor; //电脑显示器

    public Computer(String name,String brand, String cpu, String memory, String hardDisk, String monitor) {
        this.name = name;
        this.brand = brand;
        this.cpu = cpu;
        this.memory = memory;
        this.hardDisk = hardDisk;
        this.monitor = monitor;
    }

    public String getName() {
        return name;
    }

    public String getBrand() {
        return brand;
    }

    public String getCpu() {
        return cpu;
    }

    public String getMemory() {
        return memory;
    }

    public String getHardDisk() {
        return hardDisk;
    }

    public String getMonitor() {
        return monitor;
    }

    public abstract void printInfo( int index );
}
