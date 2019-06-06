package menu;

public class Dog {

  private String Name;

  public String getName() {
    return Name;
  }

  public void setName(String name) {
    Name = name;
  }
public Dog(String name) {
    this.Name=name;
}

  @Override
  public String toString() {
    return "Dog{" +
        "Name='" + Name + '\'' +
        '}';
  }





}
