package testing;

import structures.SimplyLinkedList;

public class STest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SimplyLinkedList<Integer> sll=new SimplyLinkedList<Integer>();
		System.out.println("Is empty: "+sll.isEmpty());
		sll.addHead(new Integer(2));
		sll.addHead(new Integer(1));
		sll.addTail(new Integer(3));
		sll.add(3, new Integer(4));
		sll.add(4, new Integer(5));
		sll.addHead(new Integer(0));
		sll.addTail(new Integer(6));
		System.out.println(sll);
		System.out.println("Length: "+sll.getLength());
		int tmp=sll.removeHead();
		System.out.println("Head: "+tmp);
		tmp=sll.removeTail();
		System.out.println("Tail: "+tmp);
		System.out.println(sll);
		System.out.println("Length: "+sll.getLength());
		tmp=sll.removeNode(2);
		System.out.println("3rd Element: "+tmp);
		tmp=sll.removeTail();
		System.out.println("Tail: "+tmp);
		System.out.println(sll);
		System.out.println("Length: "+sll.getLength());
		System.out.println("Is empty: "+sll.isEmpty());
	}

}
