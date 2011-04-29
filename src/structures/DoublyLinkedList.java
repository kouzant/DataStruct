package structures;

class DNode<E>{
	private E value;
	private DNode<E> previousNode;
	private DNode<E> nextNode;
	
	DNode(E value){
		this.value=value;
	}
	void setPreviousNode(DNode<E> previousNode){
		this.previousNode=previousNode;
	}
	void setNextNode(DNode<E> nextNode){
		this.nextNode=nextNode;
	}
	E getValue(){
		return value;
	}
	DNode<E> getPreviousNode(){
		return previousNode;
	}
	DNode<E> getNextNode(){
		return nextNode;
	}
}

public class DoublyLinkedList<E> {
	private DNode<E> head=new DNode<E>(null);
	private DNode<E> tail=new DNode<E>(null);
	private int length=0;
	
	public DoublyLinkedList(){
		head.setPreviousNode(null);
		head.setNextNode(tail);
		tail.setPreviousNode(head);
		tail.setNextNode(null);
	}
	
	//Given an index, returns a node of the list
	public DNode<E> getNode(int index) throws IndexOutOfBoundsException{
		if(index<0 || index>length){
			System.err.println("Index out of bounds");
			throw new IndexOutOfBoundsException();
		}else{
			DNode<E> cursor=head;
			for(int i=0;i<index;i++)
				cursor=cursor.getNextNode();
			
			return cursor;
		}
	}
	
	//Given an index, returns the value of a node from the list
	public E getNodeValue(int index){
		DNode<E> cursor=getNode(index);
		
		return cursor.getValue();
	}
	
	//Given an index, removes a node from the list
	public E removeNode(int index) throws IndexOutOfBoundsException{
		if(index<0 || index>length){
			System.err.println("Index out of bounds");
			throw new IndexOutOfBoundsException();
		}else{
			DNode<E> resultNode=getNode(index);
			resultNode.getNextNode().setPreviousNode(resultNode.getPreviousNode());
			resultNode.getPreviousNode().setNextNode(resultNode.getNextNode());
			length--;
			
			return resultNode.getValue();
		}
	}
	
	//Adds a new node somewhere in the middle
	public void add(int index, E value){
		DNode<E> cursor=getNode(index);
		DNode<E> newNode=new DNode<E>(value);
		newNode.setPreviousNode(cursor);
		newNode.setNextNode(cursor.getNextNode());
		cursor.getNextNode().setPreviousNode(newNode);
		cursor.setNextNode(newNode);
		length++;
	}
	
	//Adds a new node in the front
	public void addHead(E value){
		DNode<E> cursor=head;
		DNode<E> newNode=new DNode<E>(value);
		newNode.setPreviousNode(cursor);
		newNode.setNextNode(cursor.getNextNode());
		cursor.getNextNode().setPreviousNode(newNode);
		cursor.setNextNode(newNode);
		length++;
	}
	
	//Adds a new node at the back
	public void addTail(E value){
		DNode<E> cursor=tail.getPreviousNode();
		DNode<E> newNode=new DNode<E>(value);
		newNode.setPreviousNode(cursor);
		newNode.setNextNode(cursor.getNextNode());
		cursor.getNextNode().setPreviousNode(newNode);
		cursor.setNextNode(newNode);
		length++;
	}
	
	//Returns the length of the list
	public int getLength(){
		return length;
	}
	
	//Checks if list is empty
	public boolean isEmpty(){
		return length==0?true:false;
	}
	
	@Override
	//Print all the list
	public String toString(){
		StringBuffer sb=new StringBuffer();
		sb.append("\n");
		DNode<E> tmpNode=head;
		while(tmpNode.getNextNode()!=tail){
			tmpNode=tmpNode.getNextNode();
			sb.append(tmpNode.getValue());
		}
		sb.append("\n");
		
		return sb.toString();
	}
}
