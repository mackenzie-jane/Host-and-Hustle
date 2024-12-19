package Wait_List_Project;

public class Person {
    // private Person next;  // next person
    private String name;
    private String phoneNumber;

    // constructors
    public Person(String nm, String number){
        name = nm;
        phoneNumber = number;
    }

    public String getName() {
    	return this.name;
    } 
    public String getNumber() {
    	return this.phoneNumber;
    }
    // displays person's id, name, and phone number
    public void displayPerson(){
        System.out.println(this.getName() + " (" + this.getNumber() + ")");
    }

    // end person class
}
