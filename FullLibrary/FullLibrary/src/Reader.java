import java.util.ArrayList;

public class Reader {
        String firstName;
        String secondName;
        int id;
        ArrayList<Book> books;

        public Reader(){
        }

        public Reader(String firstName, String secondName, int id) {
            this.firstName = firstName;
            this.secondName = secondName;
            this.id = id;
        }
}
