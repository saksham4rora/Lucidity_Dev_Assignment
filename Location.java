/**
 * Represents a geographical location defined by its latitude and longitude.
 */
class Location {
    private final double latitude;
    private final double longitude;

    public Location(double latitude, double longitude) {
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public double getLatitude() { return latitude; }
    public double getLongitude() { return longitude; }

    /**
     * Calculates the distance from this location to another location using the Haversine formula.
     * src: https://www.geeksforgeeks.org/haversine-formula-to-find-distance-between-two-points-on-a-sphere/
     *
     * @param other The other location to which the distance is calculated.
     * @return The distance to the other location in kilometers.
     */
    public double calculateDistanceTo(Location other) {
        double dLat = Math.toRadians(other.latitude - this.latitude);
        double dLon = Math.toRadians(other.longitude - this.longitude);
        double a = Math.pow(Math.sin(dLat / 2), 2) +
                   Math.pow(Math.sin(dLon / 2), 2) *
                   Math.cos(Math.toRadians(this.latitude)) *
                   Math.cos(Math.toRadians(other.latitude));
        double c = 2 * Math.asin(Math.sqrt(a));
        return Constants.EARTH_RADIUS_KM * c;
    }
}