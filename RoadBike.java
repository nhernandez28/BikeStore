public class RoadBike extends Bike{
    
     private int numGears;
    private double weight;

    //constructors
    public RoadBike(String modelNum, double purchaseCost, double retailCost, String color, int numInv, int minAge, int maxAge, int numGears, double weight) {
        super(modelNum, purchaseCost, retailCost, color, numInv, minAge, maxAge);
        this.numGears = numGears;
        this.weight = weight;
    }
    public RoadBike(String modelNum, String purchaseCost, String retailCost, String color, String numInv, String minAge, String maxAge, String numGears, String weight) {
        super(modelNum, purchaseCost, retailCost, color, numInv, minAge, maxAge);
        this.numGears = Integer.parseInt(numGears);
        this.weight = Double.parseDouble(weight);
    }

    //setters
    public void setNumGears(int numGears) {
        this.numGears = numGears;
    }
    public void setWeight(double weight) {
        this.weight = weight;
    }

    //getters
    public int getNumGears() {
        return this.numGears;
    }
    public double getWeight() {
        return this.weight;
    }

    //toString method with override to bike toString method
    @Override
    public String toString() {
        return super.toString() + " Number of gears: " + numGears + " Weight: " + weight + "\n";
    }
    
}