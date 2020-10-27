package oc.p._8._3_GenericsAndCollections.searchingAndSorting.sortAndBinarySearch;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * static <T extends Comparable<? super T>> void sort(List<T> list)
 *
 * static <T> void	sort(List<T> list, Comparator<? super T> c)
 *
 * static <T> int	binarySearch(List<? extends Comparable<? super T>> list, T key)
 *
 * static <T> int	binarySearch(List<? extends T> list, T key, Comparator<? super T> c)
 */
class CollectionsClass {

    static List<Tmp> tmps = Arrays.asList(new Tmp("c"), new Tmp("b"));

    static void m(){
//        Collections.sort(tmps)  //

        System.out.println(tmps);
        Collections.sort(tmps, Comparator.comparing(Tmp::getName).reversed());
        System.out.println(tmps);
    }

    static void m2(){
//        Collections.binarySearch(tmps, new Tmp("a"));  //

//        Collections.sort(tmps, Comparator.comparing(Tmp::getName));  //without it, the result is undefined since the list is not sorted
        final int a = Collections.binarySearch(tmps, new Tmp("a"), Comparator.comparing(Tmp::getName, String::compareTo));
        final int d = Collections.binarySearch(tmps, new Tmp("d"), (s, s2) -> s.getName().compareTo(s2.getName()));

        System.out.println(a);  // -1
        System.out.println(d);  // -3
    }

    public static void main(String[] args) {
//        m();
        m2();
    }

}
