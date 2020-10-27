package books.thinkigInJava._4ThEdition.chapters.concurrency.coopertationBetweenTasks.producersAndConsumers.tw._2;

class Meal {

    private int orderNb;

    public Meal(int orderNb) {
        this.orderNb = orderNb;
    }

    @Override
    public String toString() {
        return "Meal{" +
                "orderNb=" + orderNb +
                '}';
    }
}
