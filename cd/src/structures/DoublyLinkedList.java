package structures;

/**
 * Κλάση που αντιπροσωπεύει ένα κόμβο στη διπλά συνδεδεμένη λίστα.
 * Κρατάει την τιμή του κόμβου, τον επόμενο και τον προηγούμενο.
 * 
 * @param <E> Ο τύπος των δεδομένων που θα αποθηκεύονται στο κόμβο.
 */
class DNode<E>{
	private E value;
	private DNode<E> previousNode;
	private DNode<E> nextNode;
	
	/**
	 * Ο constructor με τον οποίο ορίζουμε την
	 * τιμή του κόμβου.
	 * 
	 * @param value Η τιμή του κόμβου.
	 */
	DNode(E value){
		this.value=value;
	}
	
	/**
	 * Ορίζουμε τον προηγούμενο κόμβο στη λίστα.
	 * 
	 * @param previousNode Ο προηγούμενος κόμβος στη λίστα.
	 */
	void setPreviousNode(DNode<E> previousNode){
		this.previousNode=previousNode;
	}
	
	/**
	 * Ορίζουμε τον επόμενο κόμβο στη λίστα.
	 * 
	 * @param nextNode Ο επόμενος κόμβος στη λίστα.
	 */
	void setNextNode(DNode<E> nextNode){
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
	 * Παίρνουμε τον προηγούμενο κόμβο από τη λίστα.
	 * 
	 * @return Τον προηγούμενο κόμβο από τη λίστα.
	 */
	DNode<E> getPreviousNode(){
		return previousNode;
	}
	
	/**
	 * Παίρνουμε τον επόμενο κόμβο από τη λίστα.
	 * 
	 * @return Τον επόμενο κόμβο από τη λίστα.
	 */
	DNode<E> getNextNode(){
		return nextNode;
	}
}

/**
 * Κλάση που υλοποιεί την διπλά συνδεδεμένη λίστα.
 *
 * @param <E> Τον τύπο δεδομένων που θα χειρίζεται η λίστα.
 */
public class DoublyLinkedList<E> {
	//Δύο βοηθητικοί κόμβοι που αντιπροσωπεύουν
	//την αρχή και το τέλος της λίστας
	private DNode<E> head=new DNode<E>(null);
	private DNode<E> tail=new DNode<E>(null);
	//Το μήκος της λίστας
	private int length=0;
	
	/**
	 * Constructor με τον οποίο ορίζουμε ότι ο προηγούμενος
	 * κόμβος του πρώτου είναι το null, ο επόμενός του είναι
	 * ο τελευταίος, ο προηγούμενος του τελευταίου είναι ο
	 * πρώτος και ο επόμενος του τελευταίου είναι το null.
	 */
	public DoublyLinkedList(){
		head.setPreviousNode(null);
		head.setNextNode(tail);
		tail.setPreviousNode(head);
		tail.setNextNode(null);
	}
	
	/**
	 * Του δίνουμε ένα δείκτη και παίρνουμε τον συγκεκριμένο κόμβο.
	 * 
	 * @param Ο δείκτης του κόμβου που μας ενδιαφέρει.
	 * @return Τον κόμβο σύμφωνα με τον δείκτη.
	 * @throws IndexOutOfBoundsException Σε περίπτωση που ο δείκτης είναι
	 * μικρότερος του μηδέν ή μεγαλύτερος του μήκους της λίστας.
	 */
	public DNode<E> getNode(int index) throws IndexOutOfBoundsException{
		if(index<0 || index>length){
			System.err.println("Index out of bounds");
			throw new IndexOutOfBoundsException();
		}else{
			//Παίρνουμε τον επόμενο κόμβο μέχρι τον δείκτη που ορίσαμε
			DNode<E> cursor=head;
			for(int i=0;i<index;i++)
				cursor=cursor.getNextNode();
			
			return cursor;
		}
	}
	
	/**
	 * Παίρνουμε την τιμή ενός κόμβου χωρίς όμως να τον αφαιρέσουμε από τη λίστα.
	 * 
	 * @param index Ο δείκτης για τον κόμβο που θέλουμε.
	 * @return Την τιμή του κόμβου που θέλουμε.
	 * @see DoublyLinkedList#getNode(int)
	 */
	public E getNodeValue(int index){
		DNode<E> cursor=getNode(index);
		
		return cursor.getValue();
	}
	
	/**
	 * Αφαιρεί ένα συγκεκριμένο κόμβο από τη λίστα και παίρνουμε την τιμή του
	 * σύμφωνα με τον δείκτη που δώσαμε.
	 * 
	 * @param index Ο δείκτης για τον κόμβο που θέλουμε.
	 * @return Την τίμη του κόμβου που θέλουμε.
	 * @throws IndexOutOfBoundsException Σε περίπτωση που ο δείκτης είναι
	 * μικρότερος του μηδέν ή μεγαλύτερος του μήκους της λίστας.
	 * @see DoublyLinkedList#getNode(int)
	 * @see DNode#getNextNode()
	 * @see DNode#setPreviousNode(DNode)
	 * @see DNode#getPreviousNode()
	 * @see DNode#setNextNode(DNode)
	 */
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
	
	/**
	 * Προσθέτει ένα κόμβο στη λίστα σε συγκεκριμένη θέση.
	 * 
	 * @param index Η θέση που θέλουμε να βάλουμε τον κόμβο.
	 * @param value Η τιμή που θέλουμε να έχει ο κόμβος.
	 * @see DoublyLinkedList#getNode(int)
	 * @see DNode#DNode(Object)
	 * @see DNode#setPreviousNode(DNode)
	 * @see DNode#setNextNode(DNode)
	 * @see DNode#getNextNode()
	 */
	public void add(int index, E value){
		DNode<E> cursor=getNode(index);
		DNode<E> newNode=new DNode<E>(value);
		newNode.setPreviousNode(cursor);
		newNode.setNextNode(cursor.getNextNode());
		cursor.getNextNode().setPreviousNode(newNode);
		cursor.setNextNode(newNode);
		length++;
	}
	
	/**
	 * Προσθέτει ένα νέο κόμβο στην αρχή της λίστας.
	 * 
	 * @param value Η τιμή που θέλουμε να έχει ο νέος κόμβος.
	 * @see DNode#DNode(Object)
	 * @see DNode#setPreviousNode(DNode)
	 * @see DNode#setNextNode(DNode)
	 * @see DNode#getNextNode()
	 */
	public void addHead(E value){
		DNode<E> cursor=head;
		DNode<E> newNode=new DNode<E>(value);
		newNode.setPreviousNode(cursor);
		newNode.setNextNode(cursor.getNextNode());
		cursor.getNextNode().setPreviousNode(newNode);
		cursor.setNextNode(newNode);
		length++;
	}
	
	/**
	 * Προσθέτει ένα νέο κόμβο στο τέλος της λίστας.
	 * 
	 * @param value Η τιμή που θέλουμε να έχει ο νέος κόμβος.
	 * @see DNode#DNode(Object)
	 * @see DNode#getPreviousNode()
	 * @see DNode#setPreviousNode(DNode)
	 * @see DNode#getNextNode()
	 * @see DNode#setNextNode(DNode)
	 */
	public void addTail(E value){
		DNode<E> cursor=tail.getPreviousNode();
		DNode<E> newNode=new DNode<E>(value);
		newNode.setPreviousNode(cursor);
		newNode.setNextNode(cursor.getNextNode());
		cursor.getNextNode().setPreviousNode(newNode);
		cursor.setNextNode(newNode);
		length++;
	}
	
	/**
	 * Μας επιστρέφει το μήκος της λίστας.
	 * 
	 * @return Tο μήκος της λίστας.
	 */
	public int getLength(){
		return length;
	}
	
	/**
	 * Ελέγχει αν η λίστα είναι άδεια.
	 * 
	 * @return true αν η λίστα είναι άδεια, false αν
	 * η λίστα έχει κόμβους.
	 */
	public boolean isEmpty(){
		return length==0?true:false;
	}
	
	/**
	 * Επιστρέφει τις τιμές κάθε κόμβου της λίστας.
	 * 
	 * @return Tις τιμές κάθε κόμβου της λίστας.
	 */
	@Override
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
