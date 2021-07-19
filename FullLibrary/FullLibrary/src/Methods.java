import java.util.ArrayList;
import java.util.Scanner;

public class Methods {

    public static void startTheDay(){
        System.out.println("Good day. Congratulations on becoming our new librarian!");
        System.out.println("Your responsibilities will include: adding books to the database and working with readers");
        ArrayList<Book> lybrary = new ArrayList<>();
        ArrayList<Reader> readers = new ArrayList<>();
        System.out.println("Let me help you deal with your responsibilities");
        System.out.println("Try adding a book to the library.");
        addBook(lybrary);
        System.out.println("Let's add a new visitor!");
        addReader(readers);
        System.out.println("Now let's give out the book: ");
        giveABook(lybrary,readers);
        System.out.println("Now let's get the book: ");
        takeABook(lybrary,readers);
        System.out.println("Let's try to delete the book from the database: ");
        dellBook(lybrary);
        System.out.println("Let's try to remove the user from the database: ");
        dellReader(readers);
        System.out.println("We have learned how to work with our base. Let's start working with her!!!");

    }

  //  private static void startWork(){
  //      System.out.println("Нажмите 1 для добавления нового пользователя");
  //  }

    private static ArrayList<Reader> dellReader(ArrayList<Reader> reader){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Select the user we want to delete: ");
        printReaders(reader);
        int userID = scanner.nextInt();
        reader.remove(findReader(userID,reader));
        System.out.println("User deleted successfully.");
        return reader;
    }

    private static ArrayList<Book> dellBook(ArrayList<Book> lyb){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Let's choose which book we want to delete: ");
        printLyb(lyb);
        int bookID = scanner.nextInt();
        lyb.remove(findBook(bookID,lyb));
        System.out.println("Book successfully deleted.");
        return lyb;
    }

    private static ArrayList<Reader> takeABook(ArrayList<Book> lyb, ArrayList<Reader> reader){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Select the person from whom we will pick up the book: ");
        printReaders(reader);
        int userID = scanner.nextInt();
        System.out.println("Choose which book we will pick up: ");
        printReaders(reader);
        int bookID = scanner.nextInt();
        reader.get(findReader(userID,reader)).books.remove(findBook(bookID,lyb));
        return reader;
    }

    private static ArrayList<Reader> giveABook(ArrayList<Book> lyb, ArrayList<Reader> reader){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Select the user to whom you want to issue the book, enter the number : ");
        printReaders(reader);
        int userID = scanner.nextInt();
        System.out.println("Now we will select the book that we want to issue, enter its number: ");
        printLyb(lyb);
        int bookID = scanner.nextInt();
        reader.get(findReader(userID, reader)).books.add(lyb.get(findBook(bookID,lyb)));
        return reader;
    }

    private static int findReader(int tmp,ArrayList<Reader> readers){
        for (int i = 0; i < readers.size(); i++) {
            if (readers.get(i).id == tmp){
                tmp = i;
            }
        }
        return tmp;
    }

    private static int findBook(int tmp,ArrayList<Book> books){
        for (int i = 0; i < books.size(); i++) {
            if (books.get(i).id == tmp){
                tmp = i;
            }
        }
        return tmp;
    }

    private static ArrayList<Book> addBook(ArrayList<Book> lybrary){
        Scanner scanner = new Scanner(System.in);
        Book book = new Book();
        System.out.println("Enter the title of the book:");
        book.name = scanner.next();
        System.out.println("Enter the name of the author:");
        book.autor = scanner.next();
        System.out.println("Enter the book number in the catalog, it must consist of numbers:");
        book.id = checkNumber(book.id);
        lybrary.add(book);
        return lybrary;
    }

    private static ArrayList<Reader> addReader(ArrayList<Reader> reader){
        Scanner scanner = new Scanner(System.in);
        Reader reader1 = new Reader();
        reader1.books = new ArrayList<>();
        System.out.println("Enter visitor's name: ");
        reader1.firstName = scanner.next();
        System.out.println("Enter the last name of the visitor: ");
        reader1.secondName = scanner.next();
        System.out.println("Enter the visitor's membership number consisting of numbers: ");
        reader1.id = checkNumber(reader1.id);
        checkID(reader1.id, reader);
        reader.add(reader1);
        return reader;
    }

    private static int checkID(int check, ArrayList<Reader> reader){

        int count = 0;
        if (reader.size() != 0){
            for (int i = 0; i < reader.size(); i++) {
                if (reader.get(i).id == check){
                    count++;
                }
            }
            if (count > 0){
                System.out.println("This number is already in use enter a new one:");
                check = checkNumber(check);
                checkID(check, reader);
            }
        }

        return check;
    }

    private static void printReaders(ArrayList<Reader> readers){
        for (int i = 0; i < readers.size(); i++) {
            System.out.println("Number: "+readers.get(i).id+" Name: "+readers.get(i).firstName+" Surname: "+readers.get(i).secondName + " Books on hands: ");
            printLyb(readers.get(i).books);
        }

    }

    private static int checkNumber (int number){
        Scanner sc = new Scanner(System.in);
        do {
            while (!sc.hasNextInt()) {
                System.out.println("That's not a number! We need positive number.");
                sc.next();
            }
            number = sc.nextInt();
        } while (number <= 0);

        return number;
    }

    private static void printLyb(ArrayList<Book> lyb){
        for (int i = 0; i < lyb.size(); i++) {
            System.out.println("Book number: "+lyb.get(i).id+" Name: "+lyb.get(i).name+" Author: "+lyb.get(i).autor);
        }
    }






}
