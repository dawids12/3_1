public class Student {

  private String Name;
  private int Age;
  private String Birth;
  private String Nazwisko;

  public Student(String name, int age, String birth, String nazwisko) {
    Name = name;
    Age = age;
    Birth = birth;
    Nazwisko = nazwisko;
  }

  public String GetName() {return Name;}
  public int GetAge() {return Age;}
  public String GetBirth() {return Birth;}
  public String GetNazwisko() {return Nazwisko;}

  public String ToString() {
    return Name + " " + Integer.toString(Age) + " " + Birth + " " + Nazwisko  ;
  }

  public static Student Parse(String str) {
    String[] data = str.split(" ");
    if(data.length != 4) 
      return new Student("Parse Error", -1, "Parse Error","Parese Error");
    return new Student(data[0], Integer.parseInt(data[1]),data[2],data[3]);
  }
}