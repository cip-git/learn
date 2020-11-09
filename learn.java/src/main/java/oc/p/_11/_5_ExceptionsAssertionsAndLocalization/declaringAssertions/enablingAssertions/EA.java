package oc.p._11._5_ExceptionsAssertionsAndLocalization.declaringAssertions.enablingAssertions;

import oc.p._11._2.Annotations.Rule;

@Rule(
        value = "java -ea/-enableassertions",
        effect = "enable assertions for all classes except system classes")

@Rule(
        value = "java -enableassertions Rectangle",
        effect = "enable assertion for class Rectangle")
@Rule(
        value = "java -ea Rectangle",
        effect = "enable assertion for class Rectangle")

@Rule(
        value = "java -ea:com.demos… my.programs.Main",
        effect = {
                "(...) means any class in the specified package or subpackages"})

@Rule(
        value = "java -ea:com.demos.Test my.program.Main",
        effect = "Enable assertions for com.demos.Test class")

class EA {
}
