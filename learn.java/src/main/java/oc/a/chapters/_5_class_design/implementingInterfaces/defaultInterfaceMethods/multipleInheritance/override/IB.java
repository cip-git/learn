package oc.a.chapters._5_class_design.implementingInterfaces.defaultInterfaceMethods.multipleInheritance.override;

import oc.a.chapters._5_class_design.implementingInterfaces.defaultInterfaceMethods.multipleInheritance.B;

public interface IB {

	default B m(){
		return new B();
	}
	
}
