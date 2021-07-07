package iq.pentalog;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.concurrent.ConcurrentSkipListMap;
import java.util.function.Function;
import java.util.stream.Collectors;

class R {


//    List<String> input = List.of("a", "b", "a", "b", "a", "c", "c", "d", "d", "d", "d", "e", "e", "e", "e");
    List<String> input = null;


    void m(){
        final Map<String, Long> map = input
                .stream()
                .parallel()
                .collect(Collectors.groupingByConcurrent(Function.identity(), Collectors.counting()));


        final var reverseMap = new TreeMap<Long, String>();
        map.forEach((k, v) -> {
            reverseMap.merge(v, k, (e, e2) -> e + ";" + e2);
        });

        final Map.Entry<Long, String> entry = reverseMap.lastEntry();

        System.out.println(String.format("Longest lines is: %s. Lines: %s", entry.getKey(), Arrays.toString(entry.getValue().split(";"))));

    }



    static String frequency(List<String> input) {
        return input
                .stream()
                .parallel()
                .collect(Collectors.groupingByConcurrent(Function.identity(), Collectors.counting()))
                .entrySet()
                .stream()
                .parallel()
                .collect(Collectors.groupingByConcurrent(Map.Entry::getValue, ConcurrentSkipListMap::new, Collectors.mapping(Map.Entry::getKey, Collectors.toList())))
                .descendingMap()
                .firstEntry()
                .getValue()
                .stream()
                .filter(s -> !s.equals(""))
                .findFirst()
                .orElse("nothing");
    }


    void m3(){

            //Initialize array
            int [] arr = new int [] {1, 2, 8, 3, 2, 2, 2, 5, 1};
            //Array fr will store frequencies of element
            int [] fr = new int [arr.length];
            int visited = -1;

            for(int i = 0; i < arr.length; i++){
                int count = 1;
                for(int j = i+1; j < arr.length; j++){
                    if(arr[i] == arr[j]){
                        count++;
                        //To avoid counting same element again
                        fr[j] = visited;
                    }
                }
                if(fr[i] != visited)
                    fr[i] = count;
            }

            //Displays the frequency of each element present in array
            System.out.println("---------------------");
            System.out.println(" Element | Frequency");
            System.out.println("---------------------");
            for(int i = 0; i < fr.length; i++){
                if(fr[i] != visited)
                    System.out.println("    " + arr[i] + "    |    " + fr[i]);
            }
            System.out.println("---------------------");
    }

    public static void main(String[] args) {
        final R r = new R();
//        r.m();
//        r.m2();

//        r.m3();
    }
}
