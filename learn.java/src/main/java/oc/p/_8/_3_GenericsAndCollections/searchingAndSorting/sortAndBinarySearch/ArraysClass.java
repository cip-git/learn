package oc.p._8._3_GenericsAndCollections.searchingAndSorting.sortAndBinarySearch;

import java.util.Arrays;
import java.util.Comparator;


/**
 * static void	sort(Object[] a)
 * <p>
 * static <T> void	sort(T[] a, Comparator<? super T> c)
 * <p>
 * static int	binarySearch(Object[] a, Object key)
 * <p>
 * static <T> int	binarySearch(T[] a, T key, Comparator<? super T> c)
 */
class ArraysClass {

    static Tmp[] tmps = {new Tmp("c"), new Tmp("b")};

    static void m(){
//        Collections.sort(tmps)  //

        System.out.println(Arrays.toString(tmps));
        Arrays.sort(tmps, Comparator.comparing(Tmp::getName).reversed());
        System.out.println(Arrays.toString(tmps));
    }

    static void m2(){
//        Collections.binarySearch(tmps, new Tmp("a"));  //

//        Collections.sort(tmps, Comparator.comparing(Tmp::getName));  //without it, the result is undefined since the list is not sorted
        final int a = Arrays.binarySearch(tmps, new Tmp("a"), Comparator.comparing(Tmp::getName, String::compareTo));
        final int d = Arrays.binarySearch(tmps, new Tmp("d"), (s, s2) -> s.getName().compareTo(s2.getName()));

        System.out.println(a);  // -1
        System.out.println(d);  // -3
    }

    public static void main(String[] args) {
//        m();
        m2();
    }
}
