package BookSaleManage.src.prepare.storage.entity.ex;

public class ExFactory {
    public static EX createEx(int id) {
        switch (id) {
            case 1:
                return new CD();
            case 2:
                return new Pen();
            case 3:
                return new Bag();
            default:
                return null; // 如果id不匹配任何已知的附赠品，返回null
        }
    } 
}
