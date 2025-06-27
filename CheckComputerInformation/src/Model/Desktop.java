package CheckComputerInformation.src.Model;

public class Desktop extends Computer{
    private String hostType;

    public Desktop(String name,String brand, String cpu, String memory, String hardDisk, String monitor, String hostType) {
        super(name, brand, cpu, memory, hardDisk, monitor);
        this.hostType = hostType;
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
                hostType
        );
    }

    public String getHostType() {
        return hostType;
    }
    
}
