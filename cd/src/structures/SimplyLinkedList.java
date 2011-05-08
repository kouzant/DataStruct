package structures;

/**
 * Κλάση που αντιπροσωπεύει ένα κόμβο στη μονά συνδεδεμένη λίστα.
 * Κρατάει πληροφορίες για την τιμή του κόμβου και για τον επόμενο κόμβο.
 *
 * @param <E> Ο τύπος των δεδομένων που θα αποθηκεύονται στον κόμβο.
 */
class SNode<E>{
	private E value;
	private SNode<E> nextNode;
	
	/**
	 * Constructor με τον οποίο ορίζουμε την τιμή του κόμβου.
	 * 
	 * @param value Η τιμή του κόμβου.
	 */
	SNode(E value){
		this.value=value;
	}
	
	/**
	 * Ορίζουμε τον επόμενο κόμβο στη λίστα.
	 * 
	 * @param nextNode Ο επόμενος κόμβος στη λίστα.
	 */
	void setNextNode(SNode<E> nextNode){
		this.nextNode=nextNode;
	}
	
	/**
	 * Παίρνουμε την τιμή του κόμβου.
	 * 
	 * @return Την τιμή του κόμβου.
	 */
	E getValue(){
		return value;
	}
	
	/**
	 * Παίρνουμε τον επόμενο κόμβο από τη λίστα.
	 * 
	 * @return Τον επόμενο κόμβο από τη λίστα.
	 */
	SNode<E> getNextNode(){
		return nextNode;
	}
}

/**
 * Κλάση που υλοποιεί τη μονά συνδεδεμένη λίστα.
 *
 * @param <E> Ο τύπος δεδομένων που θα χειρίζεται η λίστα.
 */
public class SimplyLinkedList<E> {
	//Ο πρώτος κόμβος
	private SNode<E> head;
	//Το μέγεθος της λίστας
	private int length;
	
	/**
	 * Constructor με τον οποίο αρχικοποιούμε τον πρώτο κόμβο
	 * σε null και το μέγεθος της λίστας σε μηδέν.
	 */
	public SimplyLinkedList(){
		head=null;
		length=0;
	}
	
	/**
	 * Του δίνουμε ένα δείκτη και παίρνουμε τον συγκεκριμένο κόμβο χωρίς
	 * να τον διαγράψουμε από τη λίστα.
	 * 
	 * @param index Ο δείκτης του κόμβου που μας ενδιαφέρει.
	 * @return Ο κόμβος που μας ενδιαφέρει σύμφωνα με το δείκτη.
	 * @throws IndexOutOfBoundsException Σε περίπτωση που ο δείκτης είναι
	 * μικρότερος του μηδέν ή μεγαλύτερος του μεγέθους της λίστας.
	 * @see SNode#getNextNode()
	 */
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
	
	/**
	 * Προσθέτει ένα νέο κόμβο στο τέλος της λίστας.
	 * 
	 * @param value Η τιμή του νέου κόμβου.
	 * @see SNode#SNode(Object)
	 * @see SNode#setNextNode(SNode)
	 * @see SimplyLinkedList#getNode(int)
	 */
	public void addTail(E value){
		if(length==0){
			//Αν το μέγεθος είναι μηδέν τότε 
			//ο νέος κόμβος γίνεται και η αρχή της λίστας
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
	
	/**
	 * Προσθέτει ένα νέο κόμβο στην αρχή της λίστας.
	 * 
	 * @param value Η τιμή του νέου κόμβου.
	 * @see SNode#SNode(Object)
	 * @see SNode#setNextNode(SNode)
	 */
	public void addHead(E value){
		if(length==0){
			//Αν το μέγεθος είναι μηδέν τότε
			//ο νέος κόμβος γίνεται και η αρχή της λίστας
			head=new SNode<E>(value);
			head.setNextNode(null);
		}else{
			SNode<E> newNode=new SNode<E>(value);
			newNode.setNextNode(head);
			head=newNode;
		}
		length++;
	}
	
	/**
	 * Προσθέτει ένα νέο κόμβο στο ενδιάμεσο της λίστας
	 * σύμφωνα με τον δείκτη.
	 * @param index Η θέση που θέλουμε να βάλουμε τον κόμβο.
	 * @param value Η τιμή του νέου κόμβου.
	 * @see SimplyLinkedList#addHead(Object)
	 * @see SimplyLinkedList#addTail(Object)
	 * @see SimplyLinkedList#getNode(int)
	 * @see SNode#SNode(Object)
	 * @see SNode#setNextNode(SNode)
	 * @see SNode#getNextNode()
	 */
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
	
	/**
	 * Παίρνουμε την τιμή του πρώτου κόμβου από τη λίστα και τον αφαιρούμε.
	 * 
	 * @return Την τιμή του πρώτου κόμβου.
	 * @throws IndexOutOfBoundsException Σε περίπτωση που η λίστα είναι άδεια.
	 * @see SNode#getValue()
	 * @see SNode#getNextNode()
	 */
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
	
	/**
	 * Παίρνουμε την τιμή ενός συγκεκριμένου κόμβου χωρίς να τον
	 * αφαιρέσουμε από τη λίστα.
	 * 
	 * @param index Η θέση του κόμβου που μας ενδιαφέρει.
	 * @return Την τιμή του κόμβου που μας ενδιαφέρει.
	 * @see SimplyLinkedList#getNode(int)
	 * @see SNode#getValue()
	 */
	public E getNodeValue(int index){
		SNode<E> cursor=getNode(index);
		
		return cursor.getValue();
	}
	
	/**
	 * Παίρνουμε την τιμή του τελευταίου κόμβου στη λίστα
	 * και τον διαγράφουμε.
	 * 
	 * @return Την τιμή του τελευταίου κόμβου στη λίστα.
	 * @throws IndexOutOfBoundsException Σε περίπτωση που η λίστα
	 * είναι άδεια.
	 * @see SimplyLinkedList#getNode(int)
	 * @see SNode#setNextNode(SNode)
	 * @see SNode#getNextNode()
	 * @see SNode#getValue()
	 */
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
	
	/**
	 * Παίρνουμε την τιμή ενός κόμβου που μας ενδιαφέρει σύμφωνα με
	 * τον δείκτη και τον αφαιρούμε από τη λίστα.
	 * 
	 * @param index Η θέση του κόμβου που μας ενδιαφέρει.
	 * @return Την τιμή του κόμβου που μας ενδιαφέρει.
	 * @throws IndexOutOfBoundsException Σε περίπτωση που ο δείκτης είναι
	 * μικρότερος του μηδέν ή μεγαλύτερος του μεγέθους της λίστας.
	 * @see SimplyLinkedList#removeHead()
	 * @see SimplyLinkedList#removeTail()
	 * @see SimplyLinkedList#getNode(int)
	 * @see SNode#getNextNode()
	 * @see SNode#getValue()
	 * @see SNode#setNextNode(SNode)
	 */
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
	
	/**
	 * Παίρνουμε τον πρώτο κόμβο από τη λίστα χωρίς να τον διαγράψουμε.
	 * 
	 * @return Τον πρώτο κόμβο από τη λίστα.
	 * @see SimplyLinkedList#getNode(int)
	 */
	public SNode<E> getFirstNode(){
		return getNode(0);
	}
	
	/**
	 * Παίρνουμε τον τελευταίο κόμβο από τη λίστα χωρίς να τον διαγράψουμε.
	 * 
	 * @return Τον τελευταίο κόμβο από τη λίστα.
	 * @see SimplyLinkedList#getNode(int)
	 */
	public SNode<E> getLastNode(){
		return getNode(length-1);
	}
	
	/**
	 * Παίρνουμε το μέγεθος της λίστας.
	 * 
	 * @return Το μέγεθος της λίστας.
	 */
	public int getLength(){
		return length;
	}
	
	/**
	 * Ελέγχουμε αν η λίστα είναι άδεια.
	 * 
	 * @return true αν η λίστα είναι άδεια, false αν η λίστα έχει κόμβους.
	 */
	public boolean isEmpty(){
		return length==0?true:false;
	}
	
	/**
	 * Επεστρέφει τις τιμές κάθε κόμβου στη λίστα.
	 * 
	 * @return Τις τιμές κάθε κόμβου στη λίστα.
	 * @see SNode#getValue()
	 * @see SNode#getNextNode()
	 */
	@Override
	public String toString(){
		if(length==0){
			return "List is empty";
		}else{
			StringBuilder sb=new StringBuilder();
			sb.append("\n");
			SNode<E> tmpNode=head;
			while(tmpNode.getNextNode()!=null){
				sb.append(tmpNode.getValue()).append(" - ");
				tmpNode=tmpNode.getNextNode();
			}
			sb.append(tmpNode.getValue());
			sb.append("\n");
			
			return sb.toString();
		}
	}
}
