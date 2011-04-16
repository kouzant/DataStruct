package booking;

import structures.*;

public class DTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		DoublyLinkedList<Integer> dll=new DoublyLinkedList<Integer>();
		System.out.println("Is empty: "+dll.isEmpty());
		dll.addHead(new Integer(2));
		dll.addTail(new Integer(3));
		dll.addHead(new Integer(1));
		dll.add(3, new Integer(4));
		dll.addHead(new Integer(0));
		dll.add(5, new Integer(5));
		dll.addTail(new Integer(6));
		System.out.println(dll);
		System.out.println("Length: "+dll.getLength());
		System.out.println("Head: "+dll.getNode(0));
		System.out.println("Tail: "+dll.getNode((dll.getLength()-1)));
		System.out.println("3rd Element: "+dll.getNode(4));
		System.out.println(dll);
		System.out.println("Length: "+dll.getLength());
		System.out.println("Head: "+dll.getNode(0));
		System.out.println("Tail: "+dll.getNode((dll.getLength()-1)));
		System.out.println(dll);
		System.out.println("Length: "+dll.getLength());
	}

}
