import java.io.Serializable;

public class Teacher implements Cloneable,Serializable {

	String name;
	int  id;
	
	public Teacher() {
		System.out.println("Created teacher object");
	}
	
	@Override
	protected Object clone() throws CloneNotSupportedException{
		return super.clone();
	}
}
