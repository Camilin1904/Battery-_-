package model;

public class Company{
	
    public static final int MAX_BATTERIES = 10;
	private Battery[] batteries;

	public Company() {
        this.batteries = new Battery[MAX_BATTERIES];
	}

    public Company(Battery[] batteries){
        this.batteries = batteries;
    }
	

    public void registerBattery(String name, double voltage, double cost, double capacity){
        int emtyPos = getEmptyPosition();
        if(emtyPos<MAX_BATTERIES){
            batteries[emtyPos] = new Battery(name, voltage, cost, capacity);
        }

    }

    public void registerRechargeableBattery(String name, double voltage, double cost, double capacity, int chargerNumber, char type) {
        int emtyPos = getEmptyPosition();
        if(emtyPos<MAX_BATTERIES){
            Type bType = null;
            switch (type){
                case ('l'):
                    bType = Type.BATTERY_LITIO;
                    break;
                case ('n'):
                    bType = Type.BATTERY_NIQUEL_CADMIO;
                    break;
            }
            batteries[emtyPos] = new RechargeableBattery(name, voltage, cost, capacity, chargerNumber ,bType);
        }
        
    }
    
    private int getEmptyPosition() {
        int pos = MAX_BATTERIES;
        for (int i = 0; i < MAX_BATTERIES; i++) {
            if (batteries[i] == null) {
                pos = i;
            }
        }
        return pos;
    }

    public String showTotalBatteries() {
        return getEmptyPosition() + "";
    }
    
    public String showBatteriesInfo() {
    	String message = "";
        for (int counter=0; counter<getEmptyPosition(); counter++){
            message+=batteries[counter].toString();
        }
    	return message;
    }
    

	public double calculateAverageUsefulLifeCost(){
        double average = 0;
        int numRBatteries = 0;
        for ( int counter=0; counter<MAX_BATTERIES; counter++){
            if(batteries[counter] instanceof RechargeableBattery){
                average += batteries[counter].calculateUsefulLifeCost();
                numRBatteries++;
            }
        }
        average = average/numRBatteries;
		return average;
	}

}
