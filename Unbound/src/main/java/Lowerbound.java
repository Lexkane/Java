import java.util.ArrayList;
import java.util.List;

public class Lowerbound {
public static void main(String[] args) {
	
	List<Object> objectList= new ArrayList<Object>();
	List<Integer> intList=new ArrayList<Integer>();
	
    addNumbers(intList);
	
}

private static void addNumbers(List <? super Integer> list) {
	for (int i=1;i<=10;i++) {
		list.add(i);
	}
	System.out.println(list);
}
	
}
