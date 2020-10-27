package oc.a.chapters._5_class_design.implementingInterfaces.inheritingAnInterface.case2;

public class C implements IO, IH {

	@Override
	public int eatPlants(int a) {
		return 0;
	}

	@Override
	public void eatPlants() {
	}

	/*
	 * Although this method is defined both in File and IH interfaces, it's
	 * implemented only once because an abstract method (one defined either in
	 * an interface or an abstract class) defines the behavior that the
	 * implementing class must have
	 */
	@Override
	public void m() {
	}
}
