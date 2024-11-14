// Define the base interface for all celestial bodies
interface CelestialBody {
    void updatePosition(double time);
    double getX();
    double getY();
    double getMass();
    String getName();
}

// Interface for objects that can orbit other bodies
interface Orbitable {
    void setOrbitCenter(CelestialBody center);
    double getOrbitalPeriod();
    double getOrbitRadius();
}

// Concrete implementation of a planet
class Planet implements CelestialBody, Orbitable {
    private String name;
    private double mass;
    private double x, y;
    private double orbitalPeriod;
    private double orbitRadius;
    private CelestialBody centerBody;
    
    public Planet(String name, double mass, double orbitalPeriod, double orbitRadius) {
        this.name = name;
        this.mass = mass;
        this.orbitalPeriod = orbitalPeriod;
        this.orbitRadius = orbitRadius;
    }
    
    @Override
    public void updatePosition(double time) {
        double angle = (2 * Math.PI * time) / orbitalPeriod;
        x = centerBody.getX() + orbitRadius * Math.cos(angle);
        y = centerBody.getY() + orbitRadius * Math.sin(angle);
    }
    
    @Override
    public void setOrbitCenter(CelestialBody center) {
        this.centerBody = center;
    }
    
    @Override
    public double getX() { return x; }
    
    @Override
    public double getY() { return y; }
    
    @Override
    public double getMass() { return mass; }
    
    @Override
    public String getName() { return name; }
    
    @Override
    public double getOrbitalPeriod() { return orbitalPeriod; }
    
    @Override
    public double getOrbitRadius() { return orbitRadius; }
}

// Fixed celestial body (like the Sun)
class Star implements CelestialBody {
    private String name;
    private double mass;
    private double x, y;
    
    public Star(String name, double mass, double x, double y) {
        this.name = name;
        this.mass = mass;
        this.x = x;
        this.y = y;
    }
    
    @Override
    public void updatePosition(double time) {
        // Stars are fixed in this simple simulation
    }
    
    @Override
    public double getX() { return x; }
    
    @Override
    public double getY() { return y; }
    
    @Override
    public double getMass() { return mass; }
    
    @Override
    public String getName() { return name; }
}

// Demo class showing usage
class SolarSystemSimulation {
    public static void main(String[] args) {
        // Create the sun at the center
        CelestialBody sun = new Star("Sun", 1.989e30, 0, 0);
        
        // Create planets
        Planet earth = new Planet("Earth", 5.972e24, 365.26, 149.6e6);
        Planet mars = new Planet("Mars", 6.39e23, 687, 227.9e6);
        
        // Set up orbits
        earth.setOrbitCenter(sun);
        mars.setOrbitCenter(sun);
        
        // Simulate for a few time steps
        for (double time = 0; time < 100; time += 10) {
            earth.updatePosition(time);
            mars.updatePosition(time);
            
            System.out.printf("Time: %.1f days\n", time);
            System.out.printf("Earth position: (%.2f, %.2f)\n", 
                earth.getX() / 1e6, earth.getY() / 1e6);
            System.out.printf("Mars position: (%.2f, %.2f)\n\n", 
                mars.getX() / 1e6, mars.getY() / 1e6);
        }
    }
}