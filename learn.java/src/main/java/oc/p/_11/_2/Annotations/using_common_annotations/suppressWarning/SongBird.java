package oc.p._11._2.Annotations.using_common_annotations.suppressWarning;

import java.util.ArrayList;
import java.util.List;

class SongBird {

    @Deprecated
    static void sing(int volume){}

    static Object chirp(List<String> data){
        return data.size();
    }
}

class Nightingale{

    @SuppressWarnings("deprecated")
    void wakeUp(){
        SongBird.sing(10);
    }

    @SuppressWarnings("unchecked")
    void goToBed(){
        final Object chirp = SongBird.chirp(new ArrayList());
        System.out.println(chirp);
    }

    public static void main(String[] args) {
        final Nightingale n = new Nightingale();
        n.wakeUp();
        n.goToBed();
    }

}
