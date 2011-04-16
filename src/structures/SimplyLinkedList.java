package structures;

class SNode<E>{
	private E value;
	private SNode<E> nextNode;
	
	SNode(E value){
		this.value=value;
	}
	
	void setNextNode(SNode<E> nextNode){
		this.nextNode=nextNode;
	}
	
	E getValue(){
		return value;
	}
	
	SNode<E> getNextNode(){
		return nextNode;
	}
}
public class SimplyLinkedList<E> {
	private SNode<E> head;
	private int length;
	
	public SimplyLinkedList(){
		head=null;
		length=0;
	}
	
	//Given an index, returns a node
	public SNode<E> getNode(int index) throws IndexOutOfBoundsException{
		if(index<0 || index>length){
			System.err.println("Index out of bounds");
			throw new IndexOutOfBoundsException();
		}else{
			SNode<E> cursor=head;
			for(int i=0;i<index;i++)
				cursor=cursor.getNextNode();
			
			return cursor;
		}
	}
	
	//Adds a new node at the back
	public void addTail(E value){
		if(length==0){
			head=new SNode<E>(value);
			head.setNextNode(null);
		}else{
			SNode<E> newNode=new SNode<E>(value);
			SNode<E> cursor=getNode(length-1);
			newNode.setNextNode(null);
			cursor.setNextNode(newNode);
		}
		length++;
	}
	
	//Adds a new node in the front
	public void addHead(E value){
		if(length==0){
			head=new SNode<E>(value);
			head.setNextNode(null);
		}else{
			SNode<E> newNode=new SNode<E>(value);
			newNode.setNextNode(head);
			head=newNode;
		}
		length++;
	}
	
	//Adds a node somewhere in the middle
	public void add(int index, E value){
		if(index==0){
			addHead(value);
		}else if(index==length-1){
			addTail(value);
		}else{
			SNode<E> newNode=new SNode<E>(value);
			SNode<E> cursor=getNode(index-1);
			newNode.setNextNode(cursor.getNextNode());
			cursor.setNextNode(newNode);
			length++;
		}
	}
	
	//Gets the first node of the list
	public E removeHead() throws IndexOutOfBoundsException{
		if(length==0){
			System.err.println("List is empty");
			throw new IndexOutOfBoundsException();
		}else{
			E value=head.getValue();
			head=head.getNextNode();
			length--;
			
			return value;
		}
	}
	
	//Gets the last node of the list
	public E removeTail() throws IndexOutOfBoundsException{
		if(length==0){
			System.err.println("List is empty");
			throw new IndexOutOfBoundsException();
		}else{
			SNode<E> tailNode=getNode(length-2);
			E value=tailNode.getNextNode().getValue();
			tailNode.setNextNode(null);
			length--;
			
			return value;
		}
	}
	
	//Given an index, removes a node from the list
	public E removeNode(int index) throws IndexOutOfBoundsException{
		if(index<0 || index>length){
			System.err.println("Index out of bounds");
			throw new IndexOutOfBoundsException();
		}else if(index==0){
			return removeHead();
		}else if(index==length-1){
			return removeTail();
		}else{
			SNode<E> tmpNode=getNode(index-1);
			E value=tmpNode.getNextNode().getValue();
			tmpNode.setNextNode(tmpNode.getNextNode().getNextNode());
			length--;
			
			return value;
		}
	}
	
	//Gets the first node
	public SNode<E> getFirstNode(){
		return getNode(0);
	}
	
	//Gets the last node
	public SNode<E> getLastNode(){
		return getNode(length-1);
	}
	
	//Gets the length of the list
	public int getLength(){
		return length;
	}
	
	//Checks if list is empty
	public boolean isEmpty(){
		return length==0?true:false;
	}
	
	@Override
	//Prints all the list
	public String toString(){
		if(length==0){
			return "(head) - (tail)";
		}else{
			StringBuilder sb=new StringBuilder();
			SNode<E> tmpNode=head;
			while(tmpNode.getNextNode()!=null){
				sb.append(tmpNode.getValue()).append(" - ");
				tmpNode=tmpNode.getNextNode();
			}
			sb.append(tmpNode.getValue());
			
			return sb.toString();
		}
	}
}
