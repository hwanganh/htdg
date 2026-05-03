package entity;

public class Art extends Item {
    private String artist;

    public Art(String id, String name, double startingPrice, String artist) {
        super(id, name, startingPrice);
        this.artist = artist;
    }

    @Override
    public String getDetails() {
        return "Tác phẩm nghệ thuật: " + name + " - Tác giả: " + artist + " - Giá khởi điểm: $" + startingPrice;
    }
}