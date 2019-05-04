import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class Main{
	
	
	public static void main (String [] args) throws ClassNotFoundException, 
											InstantiationException, IllegalAccessException, NoSuchMethodException, SecurityException, 
											IllegalArgumentException, InvocationTargetException, CloneNotSupportedException,IOException {
		//Creating object with new keyword
		Teacher t1 = new Teacher();
		

		System.out.println("********");
		System.out.println("Creating object with new keyword");
		//Creating object with new Instance
		
		System.out.println("********");
		System.out.println("Creating object with new Instance");
		
		Teacher t2=(Teacher)Class.forName("Teacher").newInstance();
		
		Teacher t3= Teacher.class.newInstance();
		
		System.out.println("********");
		System.out.println("Creating object with newInstance of constructor");
		
		//Creating object with newInstance of constructor 
		Constructor <Teacher> constr=Teacher.class.getConstructor();
		Teacher t4=constr.newInstance();

		System.out.println("********");
		System.out.println("Creating object with object clone");
		
		//Creating object with object clone
		Teacher t5=(Teacher)t4.clone();
		
		System.out.println("********");
		
		//Creating object with deserilisation
		System.out.println("Creating object with deserilisation");
		FileOutputStream fos=new FileOutputStream("text.txt");
		
		//Serilisation
		ObjectOutputStream oos=new ObjectOutputStream(fos);
		Teacher ts= new Teacher();
		oos.writeObject(ts);
		
		
		//Deserilisation
		
		FileInputStream fis=new FileInputStream("text.txt");
		ObjectInputStream ois =new ObjectInputStream(fis);
		
		//Getting Object
		Teacher t6=(Teacher) ois.readObject();
	}
}














