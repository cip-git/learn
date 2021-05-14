package oc.p._11._7_Concurrency.Review_Questions.qs._15;

import java.util.stream.Collectors;
import java.util.stream.Stream;

class R {

    static void m() {
        var cats = Stream.of("leopard", "lynx", "ocelot", "puma").parallel();
        var bears = Stream.of("panda", "grizzly", "polar");

        var data = Stream
                .of(cats, bears)
                .flatMap(s -> s)
                .collect(Collectors
                        .groupingByConcurrent(s -> !s.startsWith("p")));

        System.out.println(data.get(false) + " " + data.get(true));
    }

    public static void main(String[] args) {
        m();
    }
}
