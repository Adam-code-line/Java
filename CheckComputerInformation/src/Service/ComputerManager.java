package CheckComputerInformation.src.Service;

import CheckComputerInformation.src.Model.*;
import java.util.*;

public class ComputerManager {
    public static void main(String[] args) {
        List<Computer> computers = new ArrayList<>();

        // 添加一些电脑对象
        computers.add(new NoteBook("T61", "IBM", "Intel酷睿2", "2GB", "160GB", "14.1英寸", "6芯"));
        computers.add(new NoteBook("X60", "IBM", "Intel酷睿2", "512MB", "60GB", "12.1英寸", "6芯"));
        computers.add(new Desktop("530MT", "戴尔", "Intel酷睿2", "512MB", "80GB", "19英寸", "卧式"));
        computers.add(new Desktop("Lenovo5050", "联想", "AMD速龙64", "1GB", "160GB", "22英寸", "立式"));
        computers.add(new NoteBook("u4000", "华硕", "酷睿i5", "4G", "160G", "14英寸", "9芯"));
        computers.add(new Desktop("Lenovo天逸", "联想", "酷睿i5", "8GB", "1T", "22英寸", "立式"));

        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("\n请用户选择操作: 1: 查看电脑信息  2: 增加电脑信息  3: 删除电脑信息  4: 退出");
            String op = sc.nextLine().trim();

            if ("1".equals(op)) {
                // 打印表头
                System.out.printf("%-4s%-12s%-8s%-14s%-8s%-10s%-12s%-10s%-10s\n",
                        "序号", "型号名称", "品牌", "CPU", "内存", "硬盘", "显示器", "电池芯片", "机箱类型");
                // 打印内容
                for (int i = 0; i < computers.size(); i++) {
                    Computer c = computers.get(i);
                    if (c instanceof NoteBook) {
                        NoteBook n = (NoteBook) c;
                        System.out.printf("  %-4d  %-12s  %-8s%-14s%-8s%-10s %-12s      %-10s %-10s\n",
                                i + 1, n.getName(), n.getBrand(), n.getCpu(), n.getMemory(), n.getHardDisk(), n.getMonitor(), n.getBattery(), "");
                    } else if (c instanceof Desktop) {
                        Desktop d = (Desktop) c;
                        System.out.printf("  %-4d  %-12s  %-8s%-14s%-8s%-10s %-12s      %-10s %-10s\n",
                                i + 1, d.getName(), d.getBrand(), d.getCpu(), d.getMemory(), d.getHardDisk(), d.getMonitor(), "", d.getHostType());
                    }
                }
            } else if ("2".equals(op)) {
                System.out.print("请选择电脑类型: 1: 笔记本 2: 台式机: ");
                String type = sc.nextLine().trim();
                System.out.print("型号名称: ");
                String name = sc.nextLine();
                System.out.print("品牌: ");
                String brand = sc.nextLine();
                System.out.print("CPU: ");
                String cpu = sc.nextLine();
                System.out.print("内存: ");
                String memory = sc.nextLine();
                System.out.print("硬盘: ");
                String hardDisk = sc.nextLine();
                System.out.print("显示器: ");
                String monitor = sc.nextLine();
                if ("1".equals(type)) {
                    System.out.print("电池芯数(如6芯/9芯): ");
                    String battery = sc.nextLine();
                    computers.add(new NoteBook(name, brand, cpu, memory, hardDisk, monitor, battery));
                } else {
                    System.out.print("机箱类型(立式/卧式): ");
                    String hostType = sc.nextLine();
                    computers.add(new Desktop(name, brand, cpu, memory, hardDisk, monitor, hostType));
                }
                System.out.println("添加成功！");
            } else if ("3".equals(op)) {
                System.out.print("请输入要删除的电脑序号: ");
                int idx = Integer.parseInt(sc.nextLine());
                if (idx > 0 && idx <= computers.size()) {
                    computers.remove(idx - 1);
                    System.out.println("删除成功！");
                } else {
                    System.out.println("不存在，请重新输入：");
                }
            } else if ("4".equals(op)) {
                System.out.println("感谢使用！");
                break;
            } else {
                System.out.println("无效操作，请重新输入！");
            }
        }
        sc.close();
    }
}