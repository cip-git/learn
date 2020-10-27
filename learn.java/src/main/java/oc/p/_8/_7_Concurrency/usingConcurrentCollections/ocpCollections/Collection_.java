package oc.p._8._7_Concurrency.usingConcurrentCollections.ocpCollections;

import java.util.Collection;
import java.util.Collections;

class Collection_ {

    Collection <Ocp> collection = Collections.synchronizedCollection(Ocp.TREE_SET);
}
