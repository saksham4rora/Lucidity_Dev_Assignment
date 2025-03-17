import java.util.*;

/**
 * ShortestPathStrategy is a strategy for calculating the shortest path for a driver to deliver orders.
 *
 * The strategy sorts the orders based on the distance from the driver's starting location to the restaurant location
 * of each order, and then computes the travel time for the entire route, including the preparation time for each order.
 * 
 * @see RouteStrategy
 * @see Location
 * @see Order
 */
class ShortestPathStrategy implements RouteStrategy {

    /**
     * Computes the travel time between two locations.
     *
     * @param from the starting location
     * @param to the destination location
     * @return the travel time in minutes
     */
    private double computeTravelTime(Location from, Location to) {
        return (from.calculateDistanceTo(to) / Constants.AVERAGE_SPEED_KMH) * 60;
    }

    @Override
    public double calculateRouteTime(Location driver, List<Order> orders) {
        double totalTime = 0;
        Location current = driver;
        
        final Location start = current;
        orders.sort(Comparator.comparingDouble(o -> start.calculateDistanceTo(o.getRestaurantLocation())));
        
        for (Order order : orders) {
            totalTime += computeTravelTime(current, order.getRestaurantLocation());
            totalTime += order.getPreparationTime();
            totalTime += computeTravelTime(order.getRestaurantLocation(), order.getConsumerLocation());
            current = order.getConsumerLocation();
        }
        
        return totalTime;
    }
}