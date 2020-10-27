package oc.p._11._2.Annotations.applying_annotations.arrayOfValues;

@interface Music {
    String[] genres();
}

@interface Rhythm {
    String[] value();
}

class Giraffe {
    @Music(genres = {"rock"})  //regular form
            String mostDisliked;

    @Music(genres = "classical")  //shorthand annotation
            String favorite;

    @Music(genres = {})
    String ok;

//    @Music(genres = null) String nOk;

//    @Music(genres = ) String nOk;
}

class C {
    @Rhythm(value = {"Swing"})
    String fav;

    @Rhythm(value = "R&B")
    String secFav;

    @Rhythm({"Classical"})
    String mostDisliked;

    @Rhythm("Country")
    String lastDisliked;
}

