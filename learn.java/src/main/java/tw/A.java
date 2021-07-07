package tw;

import java.util.Optional;

class A {

    public static void main(String[] args) {
        Optional.ofNullable("a").filter(s -> s.startsWith("b")).orElseThrow(() -> new RuntimeException("Nu incepe cu b"));
    }
}
