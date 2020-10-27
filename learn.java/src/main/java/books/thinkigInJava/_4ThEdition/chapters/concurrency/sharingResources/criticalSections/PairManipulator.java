package books.thinkigInJava._4ThEdition.chapters.concurrency.sharingResources.criticalSections;

class PairManipulator implements Runnable {
    private PairManager pm;

    public PairManipulator(PairManager pm) {
        this.pm = pm;
    }

    @Override
    public void run() {
        while(true){
            pm.increment();
        }
    }

    @Override
    public String toString() {
        return "Pair: " + pm.getPair() +
                " ATOMIC_INTEGER = " + pm.atomicInteger.get();
    }
}
