package of2.praktisk.lf;

public class CarModel {

    private String model;
    private String brand;
    private double weight;
    private double maxVelocityForward;
    private double maxVelocityBackward;

    public CarModel(String model, String brand, double weight, double maxVelocityForward, double maxVelocityBackward) {
        this.requireNotNegative(weight);
        this.requireNotNegative(maxVelocityForward);
        this.requireNotNegative(maxVelocityBackward);

        this.model = model;
        this.brand = brand;
        this.weight = weight;
        this.maxVelocityForward = maxVelocityForward;
        this.maxVelocityBackward = maxVelocityBackward;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.requireNotNegative(weight);

        this.weight = weight;
    }

    public double getMaxVelocityForward() {
        return maxVelocityForward;
    }

    public void setMaxVelocityForward(double maxVelocityForward) {
        this.requireNotNegative(maxVelocityForward);

        this.maxVelocityForward = maxVelocityForward;
    }

    public double getMaxVelocityBackward() {
        return maxVelocityBackward;
    }

    public void setMaxVelocityBackward(double maxVelocityBackward) {
        this.requireNotNegative(maxVelocityBackward);

        this.maxVelocityBackward = maxVelocityBackward;
    }

    @Override
    public String toString() {
        return "CarModel [brand=" + brand +
                ", maxVelocityBackward=" + maxVelocityBackward +
                ", maxVelocityForward=" + maxVelocityForward +
                ", model=" + model +
                ", weight=" + weight + "]";
    }

    // Hjelpemetoder

    private void requireNotNegative(double number) {
        if (number < 0) {
            throw new IllegalArgumentException(number + " er ikke et positivt tall!");
        }
    }
}
