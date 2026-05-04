package entity;

public class Electronics extends Item {
    private int warrantyMonths;

    public Electronics(int id, String name, double startingPrice, int warrantyMonths, String description) {
        super(id, name, startingPrice, description);
        this.warrantyMonths = warrantyMonths;
    }

    @Override
    public String getDetails() {
        return "Đồ điện tử: " + name + " - Bảo hành: " + warrantyMonths + " tháng - Giá khởi điểm: $" + startingPrice;
    }
}