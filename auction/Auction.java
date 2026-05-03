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
    
}