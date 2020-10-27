package oc.p._8._3_GenericsAndCollections.workingWithGenerics.genericInterfaces.interfaceMethods.default_;

interface Ship<T>
{

	default T m(T t)
	{
		System.out.println("default method in interface Ship");
		return t;
	}

	default <T> T m2(T t)  //in this case T in the overiden method is not replaced with the supplied type
	{
		return null;
	}

	default <T, Q> T m3(T t, Q q)
	{
		return null;
	}
}
