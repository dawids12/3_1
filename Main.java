import java.io.IOException;
import java.util.Scanner;

class Main {
  public static void main(String[] args) {
    try{
      Service1 s = new Service1();
      Scanner scan = new Scanner(System.in);
      int opcja = 10;
      int wiek;
      String imie,data_urodz,nazwisko;
      System.out.println("1 - Dodanie studenta");
      System.out.println("2 - Wypisanie aktualnej listy studentów");
      System.out.println("3 - Wyszukiwanie studenta po imieniu");
      System.out.println("0 - Wyjście z programu");
      while(opcja != 0){
        System.out.println("Podaj opcje:");
        opcja = scan.nextInt();
        scan.nextLine();
        switch(opcja){
          case 1:
            System.out.println("Podaj imie: ");
            imie = scan.nextLine();
            System.out.println("Podaj nazwisko: ");
            nazwisko = scan.nextLine();
            System.out.println("Podaj wiek: ");
            wiek = scan.nextInt();
            scan.nextLine();
            System.out.println("Podaj date urodzenia: ");
            data_urodz = scan.nextLine();
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
        }

    } catch (IOException e) {

    }
  }
}