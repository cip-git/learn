package oc.a.chapters._5_class_design.implementingInterfaces.defaultInterfaceMethods.multipleInheritance.compilerError;

/**
 * Compiler error if the methods with the same signature (either dbInstance or default) is not redeclared
 */
interface IIAIC extends IA, IC
{
	//	void createAndPopulate();  //redeclare ok

	default void m()
	{
	} // ok, too
}

