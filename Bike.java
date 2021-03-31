public class Bike{
    private String modelNum;
    private double purchaseCost;
    private double retailCost;
    private String color;
    private int numInv;
    private int minAge;
    private int maxAge;

    //contructors
    public Bike(String modelNum, double purchaseCost, double retailCost, String color, int numInv, int minAge, int maxAge) {
        this.modelNum = modelNum;
        this.purchaseCost = purchaseCost;
        this.retailCost = retailCost;
        this.color = color;
        this.numInv = numInv;
        this.minAge = minAge;
        this.maxAge = maxAge;
    }
    public Bike(String modelNum, String purchaseCost, String retailCost, String color, String numInv, String minAge, String maxAge) {
        this.modelNum = modelNum;
        this.purchaseCost = Double.parseDouble(purchaseCost);
        this.retailCost = Double.parseDouble(retailCost);
        this.color = color;
        this.numInv = Integer.parseInt(numInv);
        this.minAge = Integer.parseInt(minAge);
        this.maxAge = Integer.parseInt(maxAge);
    }

    //setters  
    public void setMinAger(int minAge) {
        this.minAge = minAge;
    }
    public void setMaxAge(int MaxAge) {
        this.maxAge = maxAge;
    }
    public void setNumInv(int numInv) {
        this.numInv = numInv;
    }
    public void setPurchaseCost(double purchaseCost) {
        this.purchaseCost = purchaseCost;
    }
    public void setRetailCost(double retailCost) {
        this.retailCost = retailCost;
    }
    public void setModelNum(String modelNum) {
        this.modelNum = modelNum;
    }
    public void setColor(String color) {
        this.color = color;
    }

    //getters
    public int getMinAge() {
        return this.minAge;
    }
    public int getMaxAge() {
        return this.maxAge;
    }
    public int getNumInv() {
        return this.numInv;
    }
    public double getPurchaseCost() {
        return this.purchaseCost;
    }
    public double getRetailCost() {
        return this.retailCost;
    }
    public String getModelNum() {
        return this.modelNum;
    }
    public String getColor() {
        return this.color;
    }
    
    //toString method
    public String toString() {
        String s = "Bike: " + this.getClass() + " Model number: " + modelNum + " Purchase cost: " + purchaseCost + " Retail cost: " + retailCost + " Color: " + color + " Inventory: " + numInv + " Age range " + minAge + "-" + maxAge;
        return s;
    }
}