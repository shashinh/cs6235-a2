package cs6235.a2;


import java.util.Arrays;

import cs6235.a2.submission.MHPAnalysis;
import soot.PackManager;
import soot.Transform;

public class Driver {
	public static void main (String [] args) {

		String classPath = "tests";
		String queriesPath = "Q.txt";
		String mainClass = "P";
		if(args != null && args.length > 0) {
			int i = 0;
			while(true) {
				if(args[i].equals("-cp")) {
					classPath = args[i+1];
					i += 2;
				} else if (args[i].equals("-mainClass")) {
					mainClass = args[i + 1];
					i += 2;
				} else if (args[i].equals("-qp")) {
					queriesPath = args[i + 1];
					i += 2;
				}
				
				if(i + 1 > args.length) break;
			}
		}
		

		Options.queriesPath = queriesPath;
		
		String [] sootArgs = {
				"-v",
				"-cp", classPath,
				"-pp",
				"-w", "-app",
				"-src-prec", "java",
				"-p", "cg.cha", "enabled:true",
				"-p", "cg.spark", "enabled:false",
				"-f", "J",
				//"-d", "output",
				mainClass
				
		};
		
		//System.out.println("The soot arguments are " + Arrays.toString(sootArgs));
		
		MHPAnalysis mhpA = new MHPAnalysis();
		//load in the queries
		mhpA.loadQueries();
		
		PackManager.v().getPack("wjtp").add(new Transform("wjtp.mhpA", mhpA));
		soot.Main.main(sootArgs);
		
		//emit the output string
		String analysisResult = mhpA.getResultString();
		System.out.println(analysisResult);
		
	}
}
