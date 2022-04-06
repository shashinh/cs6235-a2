package cs6235.a2.submission;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import cs6235.a2.AnalysisBase;
import soot.Local;
import soot.PointsToAnalysis;
import soot.PointsToSet;
import soot.RefType;
import soot.Scene;
import soot.SootClass;
import soot.SootMethod;
import soot.Type;
import soot.jimple.spark.sets.DoublePointsToSet;

public class MHPAnalysis extends AnalysisBase {

	@Override
	public String getResultString() {
		// TODO Auto-generated method stub
		return "I am the reference MHP-A";
	}

	@Override
	protected void internalTransform(String phaseName, Map<String, String> options) {
		
		/*************************************************************************/
//		//say we want to obtain all classes in the scene that extend Thread
//		SootClass threadClass = Scene.v().getSootClass("java.lang.Thread");
//		List<SootClass> classes = Scene.v().getActiveHierarchy().getSubclassesOf(threadClass);
//		System.out.println(classes + " extend Thread");
//		System.out.println();
//		
//
//		//observe that it returned a bunch of library classes as well - you may filter them out by library classes, like so
//		//create a copy, because getSubclassesOf returns an unmodifiable collection
//		List<SootClass> filteredClasses = new LinkedList<SootClass>(classes);
//		filteredClasses.removeIf(c -> c.isLibraryClass());
//
//
//		System.out.println(filteredClasses);
//		System.out.println();

		/*************************************************************************/
		
		
//		//say we want to know the runtime types of each local in Main.main
//		SootMethod mainMethod = Scene.v().getMainMethod();
//		PointsToAnalysis pta = Scene.v().getPointsToAnalysis();
//		
//		for(Local local : mainMethod.getActiveBody().getLocals()) {
//			PointsToSet pts = pta.reachingObjects(local);
//			//cg.spark returns an instance of DoublePointsToSet
//			DoublePointsToSet doublePTS = (DoublePointsToSet) pta.reachingObjects(local);
//			
//			Set<Type> types = pts.possibleTypes();
//			System.out.println(local + ": types are " + types);
//			
//			//if you want to obtain the Soot Class corresponding to each of the ref types
//			for(Type type : types) {
//				if(type instanceof RefType) {
//					RefType ref = (RefType) type;
//					SootClass sC = ref.getSootClass();
//				}
//				System.out.println(type);
//			}
//			System.out.println();
//		}
		/*************************************************************************/
		
		
//		//now lets try to determine if two locals, say t1 and t2 are aliases
//
//		Local t1 = null;
//		Local t2 = null;
//		for(Local local : mainMethod.getActiveBody().getLocals()) {
//			if(local.getName().equals("t1"))
//				t1 = local;
//			else if(local.getName().equals("t2"))
//				t2 = local;
//			else 
//				continue;
//		}
//		
//
//		PointsToSet pts_t1 = pta.reachingObjects(t1);
//		PointsToSet pts_t2 = pta.reachingObjects(t2);
//		
//		boolean isAlias = pts_t1.hasNonEmptyIntersection(pts_t2);
//		System.out.println(isAlias);

		/*************************************************************************/
		
		
//		//interprocedural
//		//for the attached test case, lets check if t1.b and t2.b are the same object
//		//(it indeed should be, since it is the object used for synchronization)
//		SootMethod bRun = Scene.v().getSootClass("B").getMethodByName("run");
//		SootMethod cRun = Scene.v().getSootClass("C").getMethodByName("run");
//		
//		Local t1b = null;
//		Local t2b = null;
//		
//		for(Local local : bRun.getActiveBody().getLocals()) {
//			if (local.getName().equals("temp$0")) {
//				t1b = local;
//				break;
//			}
//		}
//		
//		for(Local local : cRun.getActiveBody().getLocals()) {
//			if (local.getName().equals("temp$0")) {
//				t2b = local;
//				break;
//			}
//		}
//		
//		PointsToSet pts_t1b = pta.reachingObjects(t1b);
//		PointsToSet pts_t2b = pta.reachingObjects(t2b);
//		System.out.println(pts_t1b.hasNonEmptyIntersection(pts_t2b));

		/*************************************************************************/

	}

}
