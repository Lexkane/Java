

class MyThread extends Thread{

	public void run() {
		for ( int i=0;i<=10;i++) {
		System.out.println("I am child thread");
		}
	}
}
public class Test {

	public static void main(String [] argv) {
		MyThread m = new MyThread();
		m.start();

		for ( int i=0;i<=10;i++) {
		System.out.println("I am in main ");
		}
	}
}
