package oc.p._8._4_FunctionalProgramming.workingWithPrimitives.learningTheFunctionalInterfacesForPrimitives;

import java.util.function.BooleanSupplier;

/**
 * @FunctionalInterface
 * public interface BooleanSupplier {
 *
 * boolean getAsBoolean();
 *
 * }
 */
class FunctionalInterfacesForBoolean {

    static void m() {
        BooleanSupplier booleanSupplier= ()->true;
    }
}

