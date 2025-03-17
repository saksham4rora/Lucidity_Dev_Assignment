# Route Optimization Application

This project is a route optimization application that calculates the optimal delivery time for a driver to deliver orders using a specified strategy.

## Project Structure

```
BestRouteMain.java
Constants.java
Location.java
LoggerUtil.java
Order.java
RouteOptimizationManager.java
RouteStrategy.java
ShortestPathStrategy.java
.vscode/
    launch.json
```

## Classes

- **BestRouteMain**: The entry point for the application. It initializes the logger, sets up locations for Aman, restaurants, and consumers, and calculates the optimal delivery time using a specified strategy.
- **Constants**: Holds constant values used throughout the application.
- **Location**: Represents a geographical location defined by its latitude and longitude. It includes a method to calculate the distance to another location using the Haversine formula.
- **LoggerUtil**: Utility class for obtaining a logger instance for a given class.
- **Order**: Represents an order with details about the consumer's location, restaurant's location, and preparation time.
- **RouteOptimizationManager**: Manages the route optimization strategy. It allows setting a specific route strategy and optimizing the route based on the given strategy.
- **RouteStrategy**: Interface for calculating the total time required for a driver to complete a route that includes multiple orders.
- **ShortestPathStrategy**: A strategy for calculating the shortest path for a driver to deliver orders. It sorts the orders based on the distance from the driver's starting location to the restaurant location of each order and computes the travel time for the entire route.

## Usage

1. Clone the repository.
2. Open the project in your preferred IDE (e.g., Visual Studio Code).
3. Ensure you have the necessary Java development environment set up.
4. Run the `BestRouteMain` class to execute the application.

## Configuration

The `.vscode/launch.json` file contains the configuration for launching the application in Visual Studio Code.

## Example

The `BestRouteMain` class sets up locations for Aman, restaurants, and consumers, and calculates the optimal delivery time using the `ShortestPathStrategy`. The result is logged in minutes and seconds.

For simplicity, the strategy sorts the orders based on the distance from the driver's starting location to the restaurant location of each order.
If required, we can add a constraint for taking preparation time in consideration later on. 
Although in current example BTM Layout being close to Koramangla, preparation time would have to upto a few hours to make a difference.
