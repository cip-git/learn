package oc.p._11._5_ExceptionsAssertionsAndLocalization.reviewQuestions.q._25;

class R {

    static class WalkToSchool implements AutoCloseable{
        @Override
        public void close() {
            throw new RuntimeException("flurry");
        }
    }

    public static void main(String[] args) {
        WalkToSchool walk = new WalkToSchool();
        try(walk; var walk2 = new WalkToSchool()){
            throw new RuntimeException("Blizzard");
        }catch (Exception e){
            System.out.println(e.getMessage() + "  " + e.getSuppressed().length);
        }

//        walk = null;
    }
}
