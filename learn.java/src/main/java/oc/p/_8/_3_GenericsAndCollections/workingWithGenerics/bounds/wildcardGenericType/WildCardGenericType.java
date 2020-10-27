package oc.p._8._3_GenericsAndCollections.workingWithGenerics.bounds.wildcardGenericType;

/**
 * Unbounded wildcard:  ? -> List<?> l =new ArrayList<String>();
 *
 *
 * Wildcard with an upper bound: ? extends type -> List<? extends Exception> l =new ArrayList<RuntimeException>();
 *
 *
 * Wildcard with a lower bound:  ? super type -> List<? super Exception> l =new ArrayList<Object>();
 */
