package oc.p._8._2_PatternsAndPrinciples.introducingFunctionalProgramming;

interface Old
{
	boolean action(Animal animal);

	class CanWalk implements Old{
		@Override public boolean action(Animal animal)
		{
			return animal.isWalk();
		}
	}

	class CanSwim implements Old{
		@Override public boolean action(Animal animal)
		{
			return animal.swim;
		}
	}
}
