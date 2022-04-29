package model;

public class Battery {
    private String name;
    protected double voltage;
    protected double cost;
    protected double capacity;

    public Battery(String name, double voltage, double cost, double capacity){
        this.name = name;
        this.voltage = voltage;
        this.cost = cost;
        this.capacity = capacity;
    }
    public double calculateUsefulLifeCost(){
        return 0;
    }

    public String toString(){
        boolean isRechargeable = false;
        if (this instanceof RechargeableBattery){
            isRechargeable = true;
        }
        return "\nNombre: " + name + "\nCosto de vida util: " + calculateUsefulLifeCost() + "\nIs it rechargeable?: " + isRechargeable;
    }
}
