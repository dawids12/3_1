public class Student {

  private String Name;
  private int Age;
  private String Birth;

  public Student(String name, int age, String birth) {
    Name = name;
    Age = age;
    Birth = birth;
  }

  public String GetName() {return Name;}
  public int GetAge() {return Age;}
  public String GetBirth() {return Birth;}

  public String ToString() {
    return Name + " " + Integer.toString(Age) + " " + Birth;
  }

  public static Student Parse(String str) {
    String[] data = str.split(" ");
    if(data.length != 3) 
      return new Student("Parse Error", -1, "Parse Error");
    return new Student(data[0], Integer.parseInt(data[1]),data[2]);
  }
}