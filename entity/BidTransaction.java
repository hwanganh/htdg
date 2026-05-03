import java.time.LocalDateTime;

public class BidTransaction extends Entity {
    private Bidder bidder;
    private Auction auction;
    private double bidAmount;
    private LocalDateTime timeStamp;
}