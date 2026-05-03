package entity;

public class Electronics extends Item {
    private int warrantyMonths;

    public Electronics(String id, String name, double startingPrice, int warrantyMonths) {
        super(id, name, startingPrice);
        this.warrantyMonths = warrantyMonths;
    }

    @Override
    public String getDetails() {
        return "Đồ điện tử: " + name + " - Bảo hành: " + warrantyMonths + " tháng - Giá khởi điểm: $" + startingPrice;
    }
}