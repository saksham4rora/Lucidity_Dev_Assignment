import java.util.*;

interface RouteStrategy {
    /**
     * Calculates the total time required for a driver to complete a route
     * that includes multiple orders.
     *
     * @param driver The location of the driver.
     * @param orders The list of orders to be delivered.
     * @return The total time required to complete the route.
     */
    double calculateRouteTime(Location driver, List<Order> orders);
}