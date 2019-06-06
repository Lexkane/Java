package menu;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Main {

    public static void main(String[] args) {
	List<Dog> dogs= new ArrayList<>();

	      dogs.add(new Dog("Fildo"));
        dogs.add(new Dog("Snoopy"));
        dogs.add(new Dog("Alpine"));
        dogs.add(new Dog("Cerberus"));

        Collections.sort(dogs,new CompareDogs());
        System.out.println(dogs);
    }

    public static class CompareDogs implements Comparator<Dog> {
        @Override
        public int compare(Dog thisone, Dog other){
            return thisone.getName().compareTo(other.getName());
        }
    }
}
