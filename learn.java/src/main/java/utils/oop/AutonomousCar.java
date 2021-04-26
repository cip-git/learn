package utils.oop;

import oc.a.topics.init.simpleClass.A;

public class AutonomousCar extends Car {

    private int autonomousLevel;

    public AutonomousCar(String model, int autonomousLevel) {
        super(model);
        this.autonomousLevel = autonomousLevel;
    }

    @Override
    public void drive() {
        System.out.println(this.model + " is running with an autonomous level of " + autonomousLevel);
    }

    public static void main(String[] args) {
        AutonomousCar tesla = new AutonomousCar("A.M.", 2);

        tesla.drive();
        tesla.brake();
    }
}
