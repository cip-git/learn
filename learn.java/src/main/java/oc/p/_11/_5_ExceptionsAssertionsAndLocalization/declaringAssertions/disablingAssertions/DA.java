package oc.p._11._5_ExceptionsAssertionsAndLocalization.declaringAssertions.disablingAssertions;

import oc.p._11._2.Annotations.Rule;

@Rule("By default assertions are disabled")

@Rule("java -disableassertions")

@Rule("java -da")

@Rule(
        value = "java -ea:com.demos... -da:com.demos.Test my.program.Main",
        effect = "Enable assertions for demo package and subpackages bu disables them for Test class")
class DA {
}
