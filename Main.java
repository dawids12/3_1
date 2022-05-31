import java.io.IOException;
import java.util.Scanner;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.text.ParseException;

class WrongStudentName extends Exception {}
class WrongAge extends Exception {}
class WrongDateOfBirth extends Exception {}

class Main {

    public static Scanner scan = new Scanner(System.in);

    public static String ReadName() throws WrongStudentName{
    System.out.println("Podaj imie:");
    String imie = scan.nextLine();
    if(imie.contains(" ")) throw new WrongStudentName();
    return imie;
  }

  
    public static int ReadAge() throws WrongAge{
    System.out.println("Podaj wiek:");
    int wiek = scan.nextInt();
    scan.nextLine();
    if(wiek < 0 || wiek > 100) throw new WrongAge();
    return wiek;
  }

  public static String ReadDateOfBirth() throws WrongDateOfBirth {
    System.out.println("Podaj datę urodzenia w formie:  DD-MM-YYY");
    String date = scan.nextLine();
    try {
    DateFormat format = new SimpleDateFormat("dd-MM-yyyy");
    format.parse(date);
    return date;
    } catch(ParseException e){
    throw new WrongDateOfBirth();
    }
  }

  
  public static void main(String[] args) {
    
      Service1 s = new Service1();
      //Scanner scan = new Scanner(System.in);
      int opcja = 10;
      int wiek;
      String imie,data_urodz,nazwisko;
      System.out.println("1 - Dodanie studenta");
      System.out.println("2 - Wypisanie aktualnej listy studentów");
      System.out.println("3 - Wyszukiwanie studenta po imieniu");
      System.out.println("0 - Wyjście z programu");
      while(opcja != 0){
        try{
        System.out.println("Podaj opcje:");
        opcja = scan.nextInt();
        scan.nextLine();
        switch(opcja){
          case 1:
            //System.out.println("Podaj imie: ");
            imie = ReadName();
            System.out.println("Podaj nazwisko: ");
            nazwisko = scan.nextLine();
            //System.out.println("Podaj wiek: ");
            wiek = ReadAge();
            scan.nextLine();
           // System.out.println("Podaj date urodzenia: ");
            data_urodz = ReadDateOfBirth();
            s.addStudent(new Student(imie, wiek,data_urodz,nazwisko));
            break;
          case 2:
            var students = s.getStudents();
            for(Student current : students) {
            System.out.println(current.ToString());
              }
            break;
            case 3:
            System.out.println("Podaj szukane imie:");
            String szukane_imie = scan.nextLine();
if(s.findStudentByName(szukane_imie)==null) System.out.println("Nie znaleziono!");
            else System.out.println(s.findStudentByName(szukane_imie).ToString());
            break;
        }
        } catch (WrongDateOfBirth e){
          System.out.println("Błędny format danych!");
        } catch (WrongAge e){
        System.out.println("Błędny wiek!");
        } catch (WrongStudentName e){
        System.out.println("Błędne imie!");        
        } catch (IOException e) {

    }
        }
        
  }
}