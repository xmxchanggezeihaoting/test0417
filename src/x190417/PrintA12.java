package x190417;
class p12 implements Runnable{
	private Object obj;
	
	public p12(Object obj) {
		this.obj = obj;
	}
	@Override
	public void run() {
		
			synchronized (obj) {
				for (int i = 1; i <= 52; i++) {
					System.out.print(i);
					if (i % 2 == 0 && i!=52) {
						obj.notify();
						try {
							
								
								obj.wait();
							
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
				}
			}
		
	}
	
}
class pAZ implements Runnable{
	private Object obj;
	
	public pAZ(Object obj) {
		this.obj = obj;
	}

	@Override
	public void run() {
		
			synchronized (obj) {
				
				for (char i = 'a'; i <= 'z'; i++) {
					System.out.print(i);
					obj.notify();
					try {
						if(i!='z') {
							
							obj.wait();
						}
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
		
	}
	
}
public class PrintA12 {

	public static void main(String[] args) {
		Object o = new Object();
		p12 num = new p12(o);
		pAZ word = new pAZ(o);
		Thread a = new Thread(num);
		Thread b = new Thread(word);
		a.start();
		b.start();
	}

}
