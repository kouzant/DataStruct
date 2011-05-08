package testing;

import structures.FifoQueue;

public class QTest {

	/**
	 * @param args
	 */
	public static void main(String[] args){
		// TODO Auto-generated method stub
		FifoQueue<Integer> fq=new FifoQueue<Integer>();
		System.out.println("Is Empty: "+fq.isEmpty());
		System.out.println("Length: "+fq.getLength());
		fq.enqueue(new Integer(1));
		fq.enqueue(new Integer(2));
		fq.enqueue(new Integer(3));
		fq.enqueue(new Integer(4));
		System.out.println("Length: "+fq.getLength());
		System.out.println(fq);
		int lala=fq.removeNode(2);
		System.out.println("Removed node is: "+lala);
		System.out.println(fq);
		lala=fq.dequeue();
		System.out.println("Dequeued value is: "+lala);
		lala=fq.dequeue();
		System.out.println(fq);
		System.out.println("Dequeued value is: "+lala);
		lala=fq.dequeue();
		System.out.println("Dequeued value is: "+lala);
		fq.enqueue(new Integer(5));
		fq.enqueue(new Integer(6));
		fq.enqueue(new Integer(7));
		lala=fq.dequeue();
		System.out.println("Dequeued value is: "+lala);
		System.out.println(fq);
		System.out.println("Is Empty: "+fq.isEmpty());
		System.out.println("Length: "+fq.getLength());
		System.out.println(fq);
		lala=fq.removeNode(1);
		System.out.println("Removed node is: "+lala);
		System.out.println(fq);
	}

}
