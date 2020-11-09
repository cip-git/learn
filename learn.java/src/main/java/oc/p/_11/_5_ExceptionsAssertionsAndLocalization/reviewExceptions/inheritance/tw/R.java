package oc.p._11._5_ExceptionsAssertionsAndLocalization.reviewExceptions.inheritance.tw;

import java.io.IOException;
import java.io.NotSerializableException;

class R {

    static void m() {
        try {

//        }catch (Exception e){ }
//        }catch (RuntimeException e){}
//        }catch (Throwable t) { }
//        }catch (IOException e) {}  //CE
//        }catch (NumberFormatException e){}
//        }catch (IllegalArgumentException e){}
//        }catch (NotSerializableException e){}  //CE
//        }catch (CE e){ }  //CE
//        }catch (CRE e){}
        }catch (IllegalArgumentException e){}

    }

    class CE extends Exception{

    }
        class CRE extends RuntimeException{

        }
}
