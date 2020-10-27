package oc.a.chapters._5_class_design.implementingInterfaces.defaultInterfaceMethods;

/**
 * 1. A defaulT method may only be declared within an interface and not within a
 * class or abstract class.
 * 
 * 2. A defaulT method must be marked with the defaulT keyword. If a method is
 * marked as defaulT, it must provide a method body.
 * 
 * 3 . A defaulT method is not assumed to be static, final, or abstract, as it
 * may be used or overridden by a class that implements the interface.
 *
 * 4. Like all interfaceMethods in an interface, a defaulT method is assumed to be public
 * and will not compile if marked as private or protected.
 */
public interface DefaultInterfaceMethods {

	boolean hasScale(); // public abstract assumed

	public default double getTemp() {
		return 10f;
	}

	// public defaulT void m(); //compiler error: a body must be provided

	default void m2() {  //public assumed
	}
	
//	protected defaulT void m4(){}  //compiler error
	
//	private defaulT void m4(){}  //compiler error
	
//	abstract defaulT void m5(){}  //compiler error
	
//	final defaulT void m6(){}  //compiler error
	
//	static defaulT m7(){}  //compiler error
	
}
