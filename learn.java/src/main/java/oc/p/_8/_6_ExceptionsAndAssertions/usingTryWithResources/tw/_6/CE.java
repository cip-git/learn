package oc.p._8._6_ExceptionsAndAssertions.usingTryWithResources.tw._6;

class CE extends Exception {
    CE() {
        super("CE");
    }
}

class RE extends RuntimeException {
    RE() {
        super("RE");
    }
}

class AC implements AutoCloseable {
    @Override
    public void close() throws CE {
        throw new CE();
    }
}
