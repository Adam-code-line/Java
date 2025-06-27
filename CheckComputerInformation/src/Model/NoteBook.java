package CheckComputerInformation.src.Model;

public class NoteBook extends Computer {
    private String battery; //电池芯数

    public NoteBook(String name,String brand, String cpu, String memory, String hardDisk, String monitor, String battery) {
        super(name, brand, cpu, memory, hardDisk, monitor);
        this.battery = battery;
    }

    @Override
    public void printInfo(int index) {
        System.out.printf("%-4d%-12s%-8s%-14s%-8s%-10s%-12s%-10s\n",
                index,
                getName(),
                getBrand(),
                getCpu(),
                getMemory(),
                getHardDisk(),
                getMonitor(),
                battery
        );
    }
    
    //getter方法
    public String getBattery() {
        return battery;
    }


}
