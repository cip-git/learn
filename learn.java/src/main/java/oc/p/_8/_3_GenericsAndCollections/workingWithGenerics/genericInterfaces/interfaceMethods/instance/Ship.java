package oc.p._8._3_GenericsAndCollections.workingWithGenerics.genericInterfaces.interfaceMethods.instance;

interface Ship<T>
{
	T m(T t);

	<T> T m2(T t);

	<T, Q> T m3(T t, Q q);
}
