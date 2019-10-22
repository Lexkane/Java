
import java.io.IOException;

public class App
{
    public static void main( String[] args ){
        try {
            System.out.println("Property #1: " + new Util().getPropertyValue("prop1"));

            System.out.println("Property #1: " + new Util().getPropertyValue("prop2"));
        } catch (IOException e){
            System.out.println(e);
        }
    }
}
