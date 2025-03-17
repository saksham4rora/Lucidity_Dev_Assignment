import java.util.*;
import java.util.logging.Logger;
/**
 * The RouteOptimizationManager class is responsible for managing the route optimization strategy.
 * It allows setting a specific route strategy and optimizing the route based on the given strategy.
 */
class RouteOptimizationManager {
    private static final Logger logger = LoggerUtil.getLogger(RouteOptimizationManager.class);
    private RouteStrategy strategy;
    

    public void setStrategy(RouteStrategy strategy) {
        this.strategy = strategy;
    }

    /**
     * Optimizes the route for a driver based on the given list of orders.
     *
     * @param driver The location of the driver.
     * @param orders The list of orders to be delivered.
     * @return The calculated route time.
     * @throws IllegalStateException If no route strategy is set.
     */
    public double optimizeRoute(Location driver, List<Order> orders) {
        if (strategy == null){
            logger.severe("No route strategy set");
            throw new IllegalStateException("No route strategy set");
        }
        return strategy.calculateRouteTime(driver, orders);
    }
}