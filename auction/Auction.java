package auction;

import entity.Item;
import entity.BidTransaction;
import user.Bidder;
import exception.AuctionClosedException;
import exception.InvalidBidException;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class Auction {
    private Item item;
    private LocalDateTime startTime;
    private LocalDateTime endTime;
    private double currentHighestBid;
    private Bidder highestBidder;
    private AuctionStatus status;
    private List<BidTransaction> bidHistory;

    public Auction(Item item, LocalDateTime startTime, LocalDateTime endTime) {
        this.item = item;
        this.startTime = startTime;
        this.endTime = endTime;
        this.currentHighestBid = item.getStartingPrice(); 
        this.status = AuctionStatus.OPEN;
        this.bidHistory = new ArrayList<>();
    }
    
    // xu li luog an toan
    public synchronized boolean placeBid(Bidder bidder, double amount) 
            throws InvalidBidException, AuctionClosedException {
        
        LocalDateTime now = LocalDateTime.now();

        if (this.status != AuctionStatus.RUNNING) {
            throw new AuctionClosedException("Phiên đấu giá không trong trạng thái hoạt động!");
        }
        if (now.isAfter(this.endTime)) {
            closeAuction();
            throw new AuctionClosedException("Phiên đấu giá đã kết thúc!");
        }
        if (amount <= this.currentHighestBid) {
            throw new InvalidBidException("Giá đặt (" + amount + ") phải lớn hơn giá hiện tại (" + this.currentHighestBid + ")");
        }

        // Cap nhat gia ...
        return true;
    }
    public synchronized void closeAuction() {
        if (this.status != AuctionStatus.FINISHED) {
            this.status = AuctionStatus.FINISHED;
            System.out.println("Đóng phiên.");
        }
    }

}