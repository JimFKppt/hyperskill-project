package machine;

public enum Coffee {

    ESPRESSO(250, 0, 16, 4),
    LATTE(350, 75, 20, 7),
    CAPPUCCINO(200, 100, 12, 6);

    private int waterConsumption; // ml
    private int milkConsumption; // ml
    private int beansConsumption; // g
    private double cost; // $

    Coffee(int waterConsumption, int milkConsumption, int beansConsumption, double cost) {
        this.waterConsumption = waterConsumption;
        this.milkConsumption = milkConsumption;
        this.beansConsumption = beansConsumption;
        this.cost = cost;
    }

    public int getWaterConsumption() {
        return waterConsumption;
    }

    public int getMilkConsumption() {
        return milkConsumption;
    }

    public int getBeansConsumption() {
        return beansConsumption;
    }

    public double getCost() {
        return cost;
    }
}
