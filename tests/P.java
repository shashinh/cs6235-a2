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