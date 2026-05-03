package auction;

import user.*;
import java.util.List;

public class AuctionManager {
    // Singleton instance
    private static AuctionManager instance;
    
    private List<Auction> activeAuction;
    private List<User> users;

    // Private constructor to prevent instantiation
    private AuctionManager() {
    }

    public static AuctionManager getInstance() {
        if (instance == null) {
            instance = new AuctionManager();
        }
        return instance;
    }
}