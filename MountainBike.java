public class MountainBike extends Bike{
    
   private String userLevel;
    private int wheelSize;

    //constructors
    public MountainBike(String modelNum, double purchaseCost, double retailCost, String color, int numInv, int minAge, int maxAge, String userLevel, int wheelSize) {
        super(modelNum, purchaseCost, retailCost, color, numInv, minAge, maxAge);
        this.userLevel = userLevel;
        this.wheelSize = wheelSize;
    }
    public MountainBike(String modelNum, String purchaseCost, String retailCost, String color, String numInv, String minAge, String maxAge, String userLevel, String wheelSize) {
        super(modelNum, purchaseCost, retailCost, color, numInv, minAge, maxAge);
        this.userLevel = userLevel;
        this.wheelSize = Integer.parseInt(wheelSize);
    }

    //setters
    public void setUserLevel(String userLevel) {
        this.userLevel = userLevel;
    }
    public void setWheelSize(int wheelSize) {
        this.wheelSize = wheelSize;
    }

    //getters
    public String getUserLevel() {
        return this.userLevel;
    }
    public int getWheelSize() {
        return this.wheelSize;
    }

    //toString method with override to bike toString method
    @Override
    public String toString() {
        return super.toString() + " User level: " + userLevel + " Wheel size: " + wheelSize + "\n";

    }
    
}