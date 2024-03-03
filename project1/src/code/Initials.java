package code;

public class Initials {
    private int unitPriceFood,unitPriceMaterials,unitPriceEnergy,amountRequestFood,
            delayRequestFood,amountRequestMaterials,delayRequestMaterials,amountRequestEnergy,
            delayRequestEnergy,priceBUILD1,foodUseBUILD1,materialsUseBUILD1,energyUseBUILD1,
            prosperityBUILD1,priceBUILD2,foodUseBUILD2,materialsUseBUILD2,energyUseBUILD2,prosperityBUILD2;

    private int prosperity,food,materials,energy;

    public Initials(String initialState) {
        String[] parts = initialState.split("[;,]");

        if (parts.length == 23) {
            this.prosperity = Integer.parseInt(parts[0]);
            this.food = Integer.parseInt(parts[1]);
            this.materials = Integer.parseInt(parts[2]);
            this.energy = Integer.parseInt(parts[3]);

            this.unitPriceFood = Integer.parseInt(parts[4]);
            this. unitPriceMaterials = Integer.parseInt(parts[5]);
            this.unitPriceEnergy = Integer.parseInt(parts[6]);

            this.amountRequestFood = Integer.parseInt(parts[7]);
            this.delayRequestFood = Integer.parseInt(parts[8]);
            this.amountRequestMaterials = Integer.parseInt(parts[9]);
            this.delayRequestMaterials = Integer.parseInt(parts[10]);
            this.amountRequestEnergy = Integer.parseInt(parts[11]);
            this.delayRequestEnergy = Integer.parseInt(parts[12]);

            this.priceBUILD1 = Integer.parseInt(parts[13]);
            this.foodUseBUILD1 = Integer.parseInt(parts[14]);
            this.materialsUseBUILD1 = Integer.parseInt(parts[15]);
            this.energyUseBUILD1 = Integer.parseInt(parts[16]);
            this.prosperityBUILD1 = Integer.parseInt(parts[17]);

            this.priceBUILD2 = Integer.parseInt(parts[18]);
            this.foodUseBUILD2 = Integer.parseInt(parts[19]);
            this.materialsUseBUILD2 = Integer.parseInt(parts[20]);
            this.energyUseBUILD2 = Integer.parseInt(parts[21]);
            this.prosperityBUILD2 = Integer.parseInt(parts[22]);
        }
    }

    //empty constructor
    public Initials() {
    }

    public int getUnitPriceFood() {
        return unitPriceFood;
    }

    public int getUnitPriceMaterials() {
        return unitPriceMaterials;
    }

    public int getUnitPriceEnergy() {
        return unitPriceEnergy;
    }

    public int getAmountRequestFood() {
        return amountRequestFood;
    }

    public int getDelayRequestFood() {
        return delayRequestFood;
    }

    public int getAmountRequestMaterials() {
        return amountRequestMaterials;
    }

    public int getDelayRequestMaterials() {
        return delayRequestMaterials;
    }

    public int getAmountRequestEnergy() {
        return amountRequestEnergy;
    }

    public int getDelayRequestEnergy() {
        return delayRequestEnergy;
    }

    public int getPriceBUILD1() {
        return priceBUILD1;
    }

    public int getFoodUseBUILD1() {
        return foodUseBUILD1;
    }

    public int getMaterialsUseBUILD1() {
        return materialsUseBUILD1;
    }

    public int getEnergyUseBUILD1() {
        return energyUseBUILD1;
    }

    public int getProsperityBUILD1() {
        return prosperityBUILD1;
    }

    public int getPriceBUILD2() {
        return priceBUILD2;
    }

    public int getFoodUseBUILD2() {
        return foodUseBUILD2;
    }

    public int getMaterialsUseBUILD2() {
        return materialsUseBUILD2;
    }

    public int getEnergyUseBUILD2() {
        return energyUseBUILD2;
    }

    public int getProsperityBUILD2() {
        return prosperityBUILD2;
    }

    public int getProsperity() {
        return prosperity;
    }

    public int getFood() {
        return food;
    }

    public int getMaterials() {
        return materials;
    }

    public int getEnergy() {
        return energy;
    }

    public void setProsperity(int prosperity) {
        this.prosperity = prosperity;
    }

    public void setFood(int food) {
        this.food = food;
    }

    public void setMaterials(int materials) {
        this.materials = materials;
    }

    public void setEnergy(int energy) {
        this.energy = energy;
    }

}
