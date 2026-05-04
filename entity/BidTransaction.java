package entity;

import java.time.LocalDateTime;

import auction.Auction;
import user.*;

public class BidTransaction extends Entity {
    private Bidder bidder;
    private Auction auction;
    private double bidAmount;
    private LocalDateTime timeStamp;
}