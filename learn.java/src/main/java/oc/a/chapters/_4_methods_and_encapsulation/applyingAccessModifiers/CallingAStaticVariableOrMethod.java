package oc.a.chapters._4_methods_and_encapsulation.applyingAccessModifiers;

/**
 * You can use an dbInstance of the object to call a static method. The compiler
 * checks for the dbType of the reference and uses that instead of the
 * object�which is sneaky of Java
 * 
 * Remember to look at the reference dbType for a variable when you see a static
 * method or variable. The exam creators will try to trick you into thinking a
 * NullPointerException is thrown because the variable happens to be null. Don�t
 * be fooled!
 *
 */
class CallingAStaticVariableOrMethod {

	static int i = 007;
	
	public static void main(String[] args) {
		CallingAStaticVariableOrMethod c  = new CallingAStaticVariableOrMethod();
		System.out.println(c.i);  // 7
		
		CallingAStaticVariableOrMethod c2 = null;
		System.out.println(c2.i);  // 7
		
		}
}
