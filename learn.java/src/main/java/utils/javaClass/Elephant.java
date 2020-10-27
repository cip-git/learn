package utils.javaClass;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Elephant {

    static String AlphaNumericString =
            "0123456789"
                    + "ABCDEFGHIJKLMNOPQRSTUVWXYZ"
                    + "abcdefghijklmnopqrstuvxyz";

    static char[] chars = AlphaNumericString.toCharArray();
    private String name;
    private int weight;
    private Sex sex;
    public Elephant(String name, int weight, Sex sex) {
        this.name = name;
        this.weight = weight;
        this.sex = sex;
    }

    static List<String> alphaNumericList() {
        final List<String> lst = new ArrayList<>();
        for (char c : chars) {
            lst.add(String.valueOf(c));
        }
        return lst;
    }

    public static Elephant newOne() {
        Random r = new Random();
        final int size = alphaNumericList().size();
        String name = IntStream
                .generate(()-> r.nextInt(size))
                .limit(r.nextInt(size))
                .mapToObj(alphaNumericList()::get)
                .collect(Collectors.joining());
        name.replaceFirst(String.valueOf(name.charAt(0)), String.valueOf(name.charAt(0)).toUpperCase());

        return new Elephant(name, r.nextInt(Byte.MAX_VALUE), r.nextBoolean() ? Sex.FEMALE : Sex.MALE);
    }

    public String getName() {
        return name;
    }

    public int getWeight() {
        return weight;
    }

    @Override
    public String toString() {
        return "Elephant{" +
                "name='" + name + '\'' +
                ", weight=" + weight +
                ", sex=" + sex +
                '}';
    }

    public Sex getSex() {
        return sex;
    }

    public enum Sex {
        MALE,
        FEMALE
    }
}
