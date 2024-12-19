package Wait_List_Project;

public class WaitTable {
	   public TimeList[] hashArray;
	   private int arraySize;

	    public WaitTable(int size){
	        arraySize = size;
	        hashArray = new TimeList[arraySize];
	        for(int j = 0; j < arraySize; j++){
	            hashArray[j] = new TimeList(2);
	        }
	    }

	    public void displayTable(){
	        for(int j=0; j<arraySize; j++) {
	        	if(!hashArray[j].isEmpty()) {
		        	System.out.println(getTime(j) + ""); // display cell number 
		            hashArray[j].display(); // display list
		            System.out.println("_______________________________");
	        	}       
	        }
	    }
	    
	    public int insertPerson(int key, Person newPerson){
	        int newKey = key;
	    	while(hashArray[newKey].isFull() == true){
	            newKey++;
	        }
	        if (newKey != key) {
	        	System.out.println("Sorry that time was not available.");
	        }
	        hashArray[newKey].insert(newPerson);
	        return newKey;
	    }

	    public Person delete(int key){
	        return hashArray[key].remove();
	    }
	    

		public static String getTime(int key) {
			String[] hours = {"5:00", "5:15", "5:30", "5:45",
					 	"6:00", "6:15", "6:30", "6:45",
					 	"7:00", "7:15", "7:30", "7:45",
						 "8:00", "8:15", "8:30", "8:45",
						 "9:00"};
			String time = hours[key];
			return time;
		}


}
