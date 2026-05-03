package user;

import auction.Auction;

public class Bidder extends User {
    private double accountBalance;

    public void placeBid(Auction auction, double amount) {
        // TODO: Implement logic
    }

    public void setupAutoBid(Auction auction, double maxBid, double increment) {
        // TODO: Implement logic
    }
}

class Seller extends User {
    private String storeName;

    public Item createItem() {
        // TODO: Implement logic
        return null;
    }

    public Auction createAuction(Item item) {
        // TODO: Implement logic
        return null;
    }
}

class Admin extends User {
    public void banUser(String userId) {
        // TODO: Implement logic
    }

    public void cancelAuction(String auctionId) {
        // TODO: Implement logic
    }
}