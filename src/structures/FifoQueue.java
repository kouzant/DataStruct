package structures;

/**
 * Κλάση που αντιπροσωπεύει ένα κόμβο στην ουρά αναμονής
 * Κρατάει την τιμή του κόμβου και τον επόμενο κόμβο
 *
 * @param <E> Ο τύπος των δεδομένων που θα αποθηκεύονται στο κόμβο
 */
class QNode<E>{
	private E value;
	private QNode<E> nextNode;
	
	/**
	 * Constructor με τον οποίο ορίζουμε την τιμή του κόμβου
	 * 
	 * @param value Η τίμη του κόμβου
	 */
	QNode(E value){
		this.value=value;
	}
	
	/**
	 * Ορίζουμε τον επόμενο κόμβο στην ουρά
	 * 
	 * @param nextNode Ο επόμενος κόμβος
	 */
	void setNextNode(QNode<E> nextNode){
		this.nextNode=nextNode;
	}
	
	/**
	 * Παίρνουμε την τιμή του κόμβου
	 * 
	 * @return Την τιμή του κόμβου
	 */
	E getValue(){
		return value;
	}
	
	/**
	 * Παίρνουμε τον επόμενο κόμβο από την ουρά
	 * 
	 * @return Τον επόμενο κόμβο από την ουρά
	 */
	QNode<E> getNextNode(){
		return nextNode;
	}
}

/**
 * Κλάση που υλοποιεί την ουρά αναμονής
 *
 * @param <E> Ο τύπος δεδομένων που θα χειρίζεται η ουρά
 */
public class FifoQueue<E> {
	//Ο πρώτος και ο τελευταίος κόμβος στην ουρά
	private QNode<E> head;
	private QNode<E> tail;
	//Το μήκος της ουράς
	private int length;
	
	/**
	 * Constructor που αρχικοποιεί τον πρώτο και τον τελευταίο
	 * κόμβο σε null και το μήκος σε μηδέν
	 */
	public FifoQueue(){
		head=null;
		tail=null;
		length=0;
	}

	/**
	 * Βάζει μία τιμή στην ουρά αναμονής
	 * 
	 * @param value Η τιμή του νέου κόμβου στην ουρά
	 * @see QNode#QNode(Object)
	 * @see QNode#setNextNode(QNode)
	 */
	public void enqueue(E value){	
		if(head==null){
			//Ο νέος κόμβος είναι ο πρώτος κόμβος
			//που μπαίνει στην ουρά
			head=new QNode<E>(value);
			head.setNextNode(null);
			tail=head;
		}else{
			//Ο νέος κόμβος μπαίνει μετά τον τελευταίο κόμβο
			QNode<E> newNode=new QNode<E>(value);
			newNode.setNextNode(null);
			tail.setNextNode(newNode);
			tail=newNode;
		}
		length++;
	}
	
	/**
	 * Παίρνουμε τον πρώτο κόμβο από τη FIFO ουρά και τον διαγράφουμε
	 * 
	 * @return Την τιμή του πρώτου κόμβου
	 * @throws IndexOutOfBoundsException Σε περίπτωση που η λίστα είναι άδεια
	 * @see QNode#getValue()
	 * @see QNode#getNextNode()
	 */
	public E dequeue() throws IndexOutOfBoundsException{
		if(length==0){
			System.err.println("Queue is empty!");
			throw new IndexOutOfBoundsException();
		}else{
			E value=head.getValue();
			//Ορίζουμε ως πρώτο κόμβο, τον επόμενο
			head=head.getNextNode();
			length--;
			
			return value;
		}
	}
	
	/**
	 * Παίρνουμε ένα συγκεκριμένο κόμβο από την ουρά σύμφωνα 
	 * με τον δείκτη χωρίς να τον διαγράψουμε
	 * 
	 * @param index Ο δείκτης του κόμβου που μας ενδιαφέρει
	 * @return Τον κόμβο σύμφωνα με το δείκτη
	 * @throws IndexOutOfBoundsException Σε περίπτωση που ο δείκτης είναι
	 * μικρότερος του μηδέν ή μεγαλύτερος του μήκους της ουράς
	 * @see QNode#getNextNode()
	 */
	public QNode<E> getNode(int index) throws IndexOutOfBoundsException{
		if(index<0 || index>length){
			System.err.println("Index out of bounds");
			throw new IndexOutOfBoundsException();
		}else{
			QNode<E> cursor=head;
			for(int i=0;i<index;i++)
				cursor=cursor.getNextNode();
			
			return cursor;
		}
	}
	
	/**
	 * Παίρνει την τιμή από έναν ενδιάμεσο κόμβο από την ουρά
	 * και τον αφαιρεί
	 * 
	 * @param index Ο δείκτης του κόμβου που μας ενδιαφέρει
	 * @return Την τιμή του κόμβου που μας ενδιαφέρει
	 * @throws IndexOutOfBoundsException Σε περίπτωση που ο δείκτης είναι μικρότερος
	 * του μηδέν ή μεγαλύτερος του μήκους της ουράς
	 * @see FifoQueue#dequeue()
	 * @see FifoQueue#getNode(int)
	 * @see QNode#getNextNode()
	 * @see QNode#getValue()
	 * @see QNode#setNextNode(QNode)
	 */
	public E removeNode(int index) throws IndexOutOfBoundsException{
		if(index<0 || index>length){
			System.err.println("Index out of bounds");
			throw new IndexOutOfBoundsException();
		}else if(index==0){
			return dequeue();
		}else{
			QNode<E> tmpNode=getNode(index-1);
			E value=tmpNode.getNextNode().getValue();
			tmpNode.setNextNode(tmpNode.getNextNode().getNextNode());
			length--;
			
			return value;
		}
	}

	public E getNodeValue(int index) throws IndexOutOfBoundsException{
		if(index<0 || index>length){
			System.err.println("Index out of bounds");
			throw new IndexOutOfBoundsException();
		}else if(index==0){
			return head.getValue();
		}else{
			QNode<E> tmpNode=getNode(index-1);
			E value=tmpNode.getValue();
			
			return value;
		}
	}
	/**
	 * Παίρνουμε το μήκος της ουράς
	 * 
	 * @return Το μήκος της ουράς
	 */
	public int getLength(){
		return length;
	}
	
	/**
	 * Ελέγχουμε αν η ουρά είναι άδεια
	 * 
	 * @return true αν η ουρά είναι άδεια, false αν η ουρά έχει κόμβους
	 */
	public boolean isEmpty(){
		return length==0?true:false;
	}
	
	/**
	 * Επιστρέφει τις τιμές κάθε κόμβου στην ουρά αναμονής
	 * 
	 * @return Τις τιμές κάθε κόμβου στην ουρά αναμονής
	 */
	public String toString(){
		if(length==0){
			return "Queue is empty!";
		}else{
			StringBuilder sb=new StringBuilder();
			sb.append("\n");
			QNode<E> tmpNode=head;
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
