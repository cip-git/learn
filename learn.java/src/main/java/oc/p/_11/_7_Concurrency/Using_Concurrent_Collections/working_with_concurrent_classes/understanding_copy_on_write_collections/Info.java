package oc.p._11._7_Concurrency.Using_Concurrent_Collections.working_with_concurrent_classes.understanding_copy_on_write_collections;

import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.CopyOnWriteArraySet;

import oc.p._11._2.Annotations.POC;


/**
 * {@link CopyOnWriteArrayList},
 * {@link CopyOnWriteArraySet}.
 *
 * These classes copy all of their elements to a new underlying structure anytime an element is
 *
 * ADDED,
 * MODIFIED, or
 * REMOVED
 *
 * from the collection.
 * By a modified element, we mean that the reference in the collection is changed.
 * Modifying the actual contents of objects within the collection will not cause a new structure to be allocated.
 *
 */
class Info {
}
