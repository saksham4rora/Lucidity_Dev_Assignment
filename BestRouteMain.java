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
        Location r1 = new Location(12.9716, 77.5946); // Restaurant 1 (MG Road, Bangalore)
        Location c1 = new Location(12.9141, 77.6476); // Consumer 1 (HSR Layout, Bangalore)
        Location r2 = new Location(12.9279, 77.6271); // Restaurant 2 (BTM Layout, Bangalore)
        Location c2 = new Location(12.9611, 77.6387); // Consumer 2 (Indiranagar, Bangalore)

        List<Order> orders = Arrays.asList(
            new Order(c1, r1, 10),
            new Order(c2, r2, 15)
        );
        
        optimizer.setStrategy(null);
        // optimizer.setStrategy(new ShortestPathStrategy());

        double optimalTime = optimizer.optimizeRoute(aman, orders);
        int minutes = (int) optimalTime;
        int seconds = (int) ((optimalTime - minutes) * 60);
        
        logger.info(String.format("Optimal Delivery Time: %d minutes %d seconds", minutes, seconds));
    }
}
