package model;

public class RechargeableBattery extends Battery {
    private int quantityOfCharges;
    public final double FACTOR_LITIO = 0.92;
    public final double FACTOR_NIQUEL_CADMIO = 0.8;
    private Type type;

    public RechargeableBattery(String name, double voltage, double cost, double capacity, int quantityOfCharges, Type type){
        super(name, voltage, cost, capacity);
        this.quantityOfCharges = quantityOfCharges;
        this.type = type;
    }

    @Override
    public double calculateUsefulLifeCost(){
        double usefulLifeCost = 0;
        switch (type){
            case BATTERY_LITIO:
                usefulLifeCost = (super.cost*super.voltage*super.capacity)/(1000*quantityOfCharges*FACTOR_LITIO);
                break;
            case BATTERY_NIQUEL_CADMIO:
                usefulLifeCost = (super.cost*super.voltage*super.capacity)/(1000*quantityOfCharges*FACTOR_NIQUEL_CADMIO);
                break;
        }
        return usefulLifeCost;
    }

    @Override
    public String toString(){
        return super.toString() + "\nTipo: " + type;
    }
}
