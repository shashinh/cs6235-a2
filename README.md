# CS6235-A2
Base repository for CS6235 A2 - a Soot-based flow-sensitive MHP Analysis of Java Programs.

## Notes
* You will need to implement your analysis by extending the `AnalysisBase` class.
  * This will force you to implement two abstract methods:
    * `internalTransform` - where you will implement your actual analysis.
    * `getResultString` - where you will emit your analysis' output in the required string format.
* For your convenience, a placeholder analysis - `cs6235.a1.submission.MHPAnalysis` is already provided, you are welcome to add your code in there.
* Ensure that any code you write is within the `cs6235.a1.submission` package.
* You will eventually submit only an archive containing the code for the `cs6235.a1.submission` package.
* Even if you submit other items, we will only copy over the `cs6235.a1.submission` package during evaluation - so make sure all your submission code is within that package.

## Input/Output
* Consider the following program provided as input in `tests/P.java`
```
class P{
	public static void main(String []args){
			B t1;
			C t2;
			Buf b;
		try {
			t1 = new B();
			t2 = new C();
			b = new Buf();
			t1.b = b;
			t2.b = b;

			t1.start();
			t2.start();
			t1.join();
			t2.join();
		} catch (Exception e){}
	}	
}
class Buf{
}
class B extends Thread {
	Buf b;
	public void run() {
	try {
		synchronized (b){
			this.bar();
		}
		this.foo();
	
	} catch (Exception e){}
	}
	public void foo(){ } 
	public void bar(){ } 
}

class C extends Thread {
	Buf b;
	public void run() {
	try {
		synchronized (b) {
			this.f2();
		}
		this.f3();

	} catch (Exception e){}
	}
	public void f2(){}
	public void f3(){}
}
```

Your analysis will need to answer some MHP queries, which will ask if certain methods in this program may run in parallel. These queries will be provided in an input queries file, `Q.txt`. This query file will have 0 or more lines, each line containing a comma-separated pair of qualified method names - an example is shown below:
```
B:foo,C:f2
B:foo,C:f3
B:bar,C:f2
B:bar,C:f3
```
The above queries file has 4 MHP queries, to be interpreted as follows:
* `B:foo` MHP `C:f2` ?
* `B:foo` MHP `C:f3` ?
* `B:bar` MHP `C:f2` ?
* `B:bar` MHP `C:f3` ?

These queries will be loaded behind the scenes, and will be available to you via the `getQueries` method of your analysis. Simply execute `List <Query> queries = this.getQueries()`, and you will obtain an ordered list of Query objects that you can then iterate over to fetch the lhs and rhs methods of each query.

You will be required to answer either `YES` or `NO` as answers for each of the MHP queries, in order. For the above program and queries file, the `getResultString()` method of your analysis should return the following string:
```
YES
YES
NO
YES
```
You are not required to print anything to STDIO, doing so will be considered incorrect output. Simply ensure that the `getResultString()` returns the string containing your answer.

## Cheat Sheet
For performing MHP Analysis, you will need to consume points-to information to infer types of objects. For this purpose, you are permitted - and encouraged to use Soot's inbuilt Points-To Analysis (via `cg.spark`). The `MHPAnalysis` class contains some commented code that illustrates how to invoke and consume `cg.spark`. There is also some code that illustrates how to obtain all `Thread` classes defined in the current program.
