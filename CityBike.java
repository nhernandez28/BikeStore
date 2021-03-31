public class CityBike extends Bike{
    
     private int numBaskets;
    private String brakeType;

    //constructors
    public CityBike(String modelNum, double purchaseCost, double retailCost, String color, int numInv, int minAge, int maxAge, int numBaskets, String brakeType) {
        super(modelNum, purchaseCost, retailCost, color, numInv, minAge, maxAge);
        this.numBaskets = numBaskets;
        this.brakeType = brakeType;
    }
    public CityBike(String modelNum, String purchaseCost, String retailCost, String color, String numInv, String minAge, String maxAge, String numBaskets, String brakeType) {
        super(modelNum, purchaseCost, retailCost, color, numInv, minAge, maxAge);
        this.numBaskets = Integer.parseInt(numBaskets);
        this.brakeType = brakeType;
    }
    
    //setters
    public void setNumBasekts(int numBaskets) {
        this.numBaskets = numBaskets;
    }
    public void setBrakeType(String brakeType) {
        this.brakeType = brakeType;
    }
    
    //getters
    public int getNumBaskets() {
        return this.numBaskets;
    }
    public String getBrakeType() {
        return this.brakeType;
    }
    
    //toString method with override to bike toString method
    @Override
    public String toString() {
        return super.toString() + " Baskets: " + numBaskets + " Brake type: " + brakeType + "\n";
    }
}