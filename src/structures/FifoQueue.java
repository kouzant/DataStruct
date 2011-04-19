package structures;

class QNode<E>{
	private E value;
	private QNode<E> nextNode;
	
	QNode(E value){
		this.value=value;
	}
	void setNextNode(QNode<E> nextNode){
		this.nextNode=nextNode;
	}
	E getValue(){
		return value;
	}
	QNode<E> getNextNode(){
		return nextNode;
	}
}
public class FifoQueue<E> {
	private QNode<E> head;
	private QNode<E> tail;
	private int length;
	
	public FifoQueue(){
		head=null;
		tail=null;
		length=0;
	}
	public void enqueue(E value){
		if(head==null){
			head=new QNode<E>(value);
			head.setNextNode(null);
			tail=head;
		}else{
			QNode<E> newNode=new QNode<E>(value);
			newNode.setNextNode(null);
			tail.setNextNode(newNode);
			tail=newNode;
		}
		length++;
	}
	public E dequeue() throws IndexOutOfBoundsException{
		if(length==0){
			System.err.println("Queue is empty!");
			throw new IndexOutOfBoundsException();
		}else{
			E value=head.getValue();
			head=head.getNextNode();
			length--;
			
			return value;
		}
	}
	public int getLength(){
		return length;
	}
	public boolean isEmpty(){
		return length==0?true:false;
	}
	@Override
	public String toString(){
		if(length==0){
			return "Queue is empty!";
		}else{
			StringBuilder sb=new StringBuilder();
			QNode<E> tmpNode=head;
			while(tmpNode.getNextNode()!=null){
				sb.append(tmpNode.getValue()).append(" - ");
				tmpNode=tmpNode.getNextNode();
			}
			sb.append(tmpNode.getValue());
			
			return sb.toString();
		}
	}
}
