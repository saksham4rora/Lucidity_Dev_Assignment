/**
 * Represents an order with details about the consumer's location, restaurant's location, and preparation time.
 */
class Order {
    private final Location consumer;
    private final Location restaurant;
    private final int preparationTime;

    public Order(Location consumer, Location restaurant, int preparationTime) {
        this.consumer = consumer;
        this.restaurant = restaurant;
        this.preparationTime = preparationTime;
    }

    public Location getConsumerLocation() { return consumer; }
    public Location getRestaurantLocation() { return restaurant; }
    public int getPreparationTime() { return preparationTime; }
}