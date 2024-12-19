package Wait_List_Project;

public class TimeList {
    private int maxSize;
    private Person[] queArray;
    private int front;
    private int rear;

    // constructor
    public TimeList(int s){
        maxSize = s+1;
        queArray = new Person[maxSize];
        front = 0;
        rear = -1;
    }

    public void insert(Person newPerson){
        if(rear == maxSize - 1){
            rear = -1;
        }
        queArray[++rear] = newPerson;
    }

    public Person remove(){
        Person temp = queArray[front++]; 
        if(front == maxSize){
            front = 0; 
        }
        return temp; 
    }

    public Person peek(){
        return queArray[front];
    }

    public boolean isEmpty(){
        return ( rear+1==front || (front+maxSize-1==rear) );
    }

    public boolean isFull(){
        return ( rear+2==front || (front+maxSize-2==rear) );
    }

    public int size(){
        if(rear >= front){
            return rear - front + 1;
        }
        else{
            return (maxSize-front) + (rear+1);
        }
    }

    
    public void display(){
        System.out.println("Waitlist at this time: ");
        
        int i = front;
//        while(queArray[front] != null)

        for(int k = 0; k < this.size(); k++) {
        	if(i > this.size()) {

        		i = 0;
        	}
        	if(queArray[i] != null) {
        		queArray[i++].displayPerson();
        	}
        }
        
    }
    
}
