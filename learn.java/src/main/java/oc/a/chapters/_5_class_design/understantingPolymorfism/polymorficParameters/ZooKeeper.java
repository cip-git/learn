package oc.a.chapters._5_class_design.understantingPolymorfism.polymorficParameters;

class ZooKeeper {

	static void feed(Reptile r){
		System.out.println("feeding: "+ r.getName());
	}
	
	public static void main(String[] args) {
		feed(new Reptile());
		feed(new Alligator());
		feed(new Crocodile());
	}
}
