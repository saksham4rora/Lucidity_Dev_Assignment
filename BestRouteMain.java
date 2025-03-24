import java.util.Arrays;
import java.util.List;
import java.util.logging.Logger;

/**
 * The BestRouteMain class is the entry point for the route optimization application.
 * It initializes the logger, sets up locations for Aman, restaurants, and consumers,
 * and calculates the optimal delivery time using a specified strategy.
 * 
 * The optimizer uses the ShortestPathStrategy to calculate the optimal delivery time.
 * The result is logged in minutes and seconds.
 */
public class BestRouteMain {
    private static final Logger logger = LoggerUtil.getLogger(BestRouteMain.class);
    private static RouteOptimizationManager optimizer = new RouteOptimizationManager();

    public static void main(String[] args) {
        logger.info("Constants: EARTH_RADIUS_KM = " + Constants.EARTH_RADIUS_KM + ", AVERAGE_SPEED_KMH = " + Constants.AVERAGE_SPEED_KMH);

        Location aman = new Location(12.9352, 77.6245); // Aman’s position (Koramangala, Bangalore)

        List<Order> orders = Arrays.asList(
            new Order(new Location(12.9081, 77.6510), new Location(12.8995, 77.6601), 10),
            new Order(new Location(12.9802, 77.6500), new Location(12.9705, 77.6402), 15),
            new Order(new Location(12.9201, 77.6420), new Location(12.9155, 77.6502), 12)
        );

        // optimizer.setStrategy(null);
        optimizer.setStrategy(new ShortestPathStrategy());
        
        double optimalTime = optimizer.optimizeRoute(aman, orders);
        logger.info(String.format("Optimal Delivery Time: %d minutes %d seconds", (int) optimalTime, (int) ((optimalTime - (int) optimalTime) * 60)));
    
    }
}
