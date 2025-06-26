package OnlineOrderFood;

public class Dish {
    private String name;
    private double price;
    private int likes;

    public Dish(String name, double price) {
        this.name = name;
        this.price = price;
        this.likes = 0;
    }
    public String getName() { return name; }
    public double getPrice() { return price; }
    public int getLikes() { return likes; }
    public void like() { likes++; }

}
