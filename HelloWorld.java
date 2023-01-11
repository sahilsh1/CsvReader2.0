import java.util.function.Supplier;
class Employee{
	
	private int id;
	private String name;
	private String lastName;
	
	Employee(int id,String name,String lastName){
		this.id=id;
		this.name= name;
		this.lastName = lastName;
	}
	
	 @Override
    public String toString() {
        return "Student [id=" + id + ", name=" + name + "]";
    }
}
public class HelloWorld{

    public static void main(String[] args){
	   System.out.println("hello world");
	 
	   
	   Supplier sup = () -> new Employee(1,"sahil","siddiqui");
	   
	   Employee emp = (Employee) sup.get();
	   
	   System.out.println(emp.toString());
	}

}