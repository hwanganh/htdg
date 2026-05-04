package entity;

public class Vehicle extends Item {
    private int manufacturedYear;

    public Vehicle(int id, String name, double startingPrice, int manufacturedYear, String description) {
        super(id, name, startingPrice, description);
        this.manufacturedYear = manufacturedYear;
    }

    @Override
    public String getDetails() {
        return "Mẫu xe: " + name + " - Năm sản xuất: " + manufacturedYear + " - Giá khởi điểm: $" + startingPrice;
    }
}