import java.util.*;

/**
 * ShortestPathStrategy is a strategy for calculating the shortest path for a driver to deliver orders.
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

    //The number of orders is small (only 2 in our example), hence an optimal Greedy Strategy has been used for simplicity as mentioned in the assignment. 
    //We could have used Djikstra in case we had multiple nodes/traffic conditions
    @Override
    public double calculateRouteTime(Location driver, List<Order> orders) {
        orders.sort(Comparator.comparingDouble(order ->
            order.getRestaurantLocation().calculateDistanceTo(driver) +
            computeTravelTime(order.getRestaurantLocation(), order.getConsumerLocation()) +
            order.getPreparationTime()));

        double totalTime = 0.0;
        Location currentLocation = driver;

        for (Order order : orders) {
            double travelTime = computeTravelTime(currentLocation, order.getRestaurantLocation());
            double prepTime = order.getPreparationTime();
            double deliveryTime = computeTravelTime(order.getRestaurantLocation(), order.getConsumerLocation());
            totalTime += Math.max(travelTime, prepTime) + deliveryTime;
            currentLocation = order.getConsumerLocation();
        }
        return totalTime;
    }
}