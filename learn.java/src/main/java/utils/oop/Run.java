package utils.oop;

class Run {

    public static void main(String[] args) {
        Car ford = new Car("Ford");
        ford.drive();
        ford.brake();

        Car aston = new AutonomousCar("Aston Martin", 2);
        aston.drive();
        aston.brake();
    }
}


