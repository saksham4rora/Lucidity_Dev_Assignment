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
    /**
    * The number of orders is small (only 2 in our example), hence an optimal Greedy Strategy has been used for simplicity as mentioned in the assignment. 
    * We could have used Djikstra in case we had multiple nodes/traffic conditions
    */
    @Override
    public double calculateRouteTime(Location driver, List<Order> orders) {
        double totalTime = 0.0;
        Location currentLocation = driver;
        List<Order> remainingOrders = new ArrayList<>(orders);
        
        while (!remainingOrders.isEmpty()) {
            final Location finalCurrentLocation = currentLocation; 

            Order nextOrder = remainingOrders.stream()
                .min(Comparator.comparingDouble(order -> {
                    double travelToRestaurant = computeTravelTime(finalCurrentLocation, order.getRestaurantLocation());
                    double deliveryTime = computeTravelTime(order.getRestaurantLocation(), order.getConsumerLocation());
                    return Math.max(travelToRestaurant, order.getPreparationTime()) + deliveryTime;
                }))
                .orElseThrow();
            
            double travelTime = computeTravelTime(currentLocation, nextOrder.getRestaurantLocation());
            double prepTime = nextOrder.getPreparationTime();
            double deliveryTime = computeTravelTime(nextOrder.getRestaurantLocation(), nextOrder.getConsumerLocation());
            
            totalTime += Math.max(travelTime, prepTime) + deliveryTime;
            currentLocation = nextOrder.getConsumerLocation();
            remainingOrders.remove(nextOrder);
        }
        return totalTime;
    }
}