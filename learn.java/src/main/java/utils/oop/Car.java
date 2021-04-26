package utils.oop;

public class Car {
    protected String model;
    protected static String engineType = "4 inline pistons";

    public void drive() {
        System.out.println(this.model + " is running");
    }

    public void brake() {
        System.out.println(this.model + " is stopping");
    }

    public Car(String model) {
        this.model = model;
    }

    public static void main(String[] args) {
        Car myCar = new Car("Ford");
    }
}

