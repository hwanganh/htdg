package entity;

public class Vehicle extends Item {
    private int manufacturedYear;

    public Vehicle(String id, String name, double startingPrice, int manufacturedYear) {
        super(id, name, startingPrice);
        this.manufacturedYear = manufacturedYear;
    }

    @Override
    public String getDetails() {
        return "Mẫu xe: " + name + " - Năm sản xuất: " + manufacturedYear + " - Giá khởi điểm: $" + startingPrice;
    }
}