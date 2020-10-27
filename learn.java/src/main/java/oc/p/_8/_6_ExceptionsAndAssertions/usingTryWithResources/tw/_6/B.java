package oc.p._8._6_ExceptionsAndAssertions.usingTryWithResources.tw._6;

class B {

    static void m(){
        try{

        }catch (NullPointerException | IndexOutOfBoundsException | RE e){

        }
    }

    static void m2(){
//        try {
//        }catch (SQLException | ParseException e){
//        }
    }

    static void m3(){
        try(AC ac = new AC()){

        }catch (CE | RE | NullPointerException e){
            e.printStackTrace();
        }
    }
}
