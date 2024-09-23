package Library_management;

import Enum.Genre;
import exceptions.AccountException;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws AccountException {

        Scanner in = new Scanner(System.in);

        System.out.println("Enter library name : ");
        Library library = Library.getInstance(in.next());
        library.AvailableBooks();

        while (true) {
            System.out.println("Please select one of the following :");
            System.out.println("1 : Create a new user!");
            System.out.println("2 : User login");
            System.out.println("3 : View users!");
            System.out.println("4 : Delete user!");
            System.out.println("5 : User update!");
            System.out.println("6 : Create a new book!");
            System.out.println("7 : View books!");
            System.out.println("8 : Delete book!");
            System.out.println("9 : Book update!");
            System.out.println("10 : Search user!");
            System.out.println("11 : Search book!");
            System.out.println("12 : Update library!");
            System.out.println("13 : Read library!");
            System.out.println("0 : Exit!");

            int choice = in.nextInt();
            switch (choice) {
                case 1: // create user and open book list and select book
                    System.out.println("Enter your first name : ");
                    String first = in.next();
                    System.out.println("Enter your last name : ");
                    String last = in.next();
                    System.out.println("Enter your national code : ");
                    int national = in.nextInt();
                    library.createUser(first,last,national);
                    break;
                case 2: // login and open book list and select book
                    System.out.println("Enter your user id : ");
                    int id = in.nextInt();
                    System.out.println("Enter your first name : ");
                    String fName = in.next();
                    System.out.println("Enter your last name : ");
                    String lName = in.next();
                    System.out.println("Enter your national code : ");
                    int NCode = in.nextInt();
                    boolean temp = library.loginUser(id,fName,lName,NCode);
                    if (temp){
                        library.loadBook();
                        System.out.println("Enter the ID of the book you want to rent (or enter -1 to stop):");
                        int bookId = in.nextInt();
                        library.selectBook(id,bookId);
                    }
                    else
                        System.out.println("Login failed!");
                    break;
                case 3: // load user
                    library.loadUser();
                    System.out.println("If you want to see the full profile of a user, enter the number 1 : ");
                    if(in.nextInt() == 1){
                        System.out.println("Enter your first name : ");
                        String f = in.next();
                        System.out.println("Enter your last name : ");
                        String l = in.next();
                        library.loadUser(f,l);
                    }
                    System.out.println("Want to check out a book?");
                    if (in.next().equals("yes")){
                        System.out.println("Enter User id : ");
                        int i = in.nextInt();
                        library.checkUser(i);
                    }
                    break;
                case 4: // delete user
                    System.out.println("Please enter the user id you want to delete : ");
                    int idDel = in.nextInt();
                    library.deleteUser(idDel);
                    System.out.println("User deleted!");
                    break;
                case 5: // update user
                    System.out.println("Please enter the user id you want to update : ");
                    int idd = in.nextInt();
                    System.out.println("Choose one of the following to update :");
                    System.out.println("1 : Full user change");
                    System.out.println("2 : Change user name");
                    System.out.println("3 : Changing the user's national code");
                    int up = in.nextInt();
                    if (up == 1) {
                        System.out.println("Enter your first name : ");
                        String firstUp = in.next();
                        System.out.println("Enter your last name : ");
                        String lastUp = in.next();
                        System.out.println("Enter your national code : ");
                        int nationalUp = in.nextInt();
                        library.updateUser(idd, firstUp, lastUp, nationalUp);
                    }
                    else if (up == 2) {
                        System.out.println("Enter first name : ");
                        String firstUp = in.next();
                        System.out.println("Enter your last name : ");
                        String lastUp = in.next();
                        library.updateUser(idd,firstUp,lastUp);
                    }
                    else if (up == 3) {
                        System.out.println("Enter your national code : ");
                        library.updateUser(idd,in.nextInt());
                    }
                    else
                        System.out.println("Error");
                    System.out.println("User updated!");
                    break;
                case 6 : // create book
                    System.out.println("Enter the name of your book : ");
                    String name = in.next();
                    System.out.println("Enter the genre of your book : ");
                    Genre genre = Genre.valueOf(in.next());
                    library.createBook(name,genre);
                    System.out.println("New book arrived!");
                    break;
                case 7 : // load book
                    library.loadBook();
                    System.out.println("If you want to see the full profile of a book, enter the number 1 : ");
                    if(in.nextInt() == 1){
                        System.out.println("Enter your book name : ");
                        String book = in.next();
                        library.loadBook(book);
                    }
                    System.out.println("Want to check out a book?");
                    if (in.next().equals("yes")){
                        System.out.println("Enter book id : ");
                        int ii = in.nextInt();
                        library.checkBook(ii);
                    }
                    break;
                case 8 : // delete book
                    System.out.println("Enter the desired book id : ");
                    library.deleteBook(in.nextInt());
                    break;
                case 9 : // update book
                    System.out.println("Enter the desired book id : ");
                    int bId = in.nextInt();
                    System.out.println("Choose one of the following : ");
                    System.out.println("1 : Complete change of the book");
                    System.out.println("2 : Change the name of the book");
                    System.out.println("3 : Changing the genre of the book");
                    int vo = in.nextInt();
                    if (vo == 1) {
                        System.out.println("Enter your name : ");
                        String bName = in.next();
                        System.out.println("Enter your genre : ");
                        Genre gen = Genre.valueOf(in.next());
                        library.updateBook(bId, bName, gen);
                    }
                    else if (vo == 2) {
                        System.out.println("Enter your name : ");
                        library.updateBook(bId, in.next());
                    }
                    else if (vo == 3) {
                        System.out.println("Enter your genre : ");
                        library.updateBook(bId, in.next());
                    }
                    else
                        System.out.println("Error!");
                    System.out.println("Book updated!");
                    break;
                case 10 : // search user
                    System.out.println("How do you want to search?");
                    System.out.println("1 : User id");
                    System.out.println("2 : User name");
                    int v = in.nextInt();
                    if (v == 1){
                        System.out.println("Enter user id : ");
                        library.searchUser(in.nextInt());
                    }
                    else if(v == 2){
                        System.out.println("Enter first name : ");
                        String f = in.next();
                        System.out.println("Enter last name : ");
                        String l = in.next();
                        library.searchUser(f,l);
                    }
                    else
                        System.err.println("Error!");
                    break;
                case 11 : // search book
                    System.out.println("How do you want to search?");
                    System.out.println("1 : book id");
                    System.out.println("2 : book genre");
                    int ch = in.nextInt();
                    if (ch == 1){
                        System.out.println("Enter book id : ");
                        library.searchBook(in.nextInt());
                    }
                    else if(ch == 2){
                        System.out.println("Enter book genre (Capital first letter!) : ");
                        library.searchBook(Genre.valueOf(in.next()));
                    }
                    else
                        System.err.println("Error!");
                    break;
                case 12 : // update library
                    System.out.println("Enter your new library : ");
                    library.updateLibrary(in.next());
                    System.out.println("Library updated!");
                    break;
                case 13 : // read library
                    System.out.println(library.readLibrary());
                    break;
                case 0 : // exit
                    in.close();
                    return;
                default: // Error
                    System.err.println("Please enter a valid value!");
            }
        }
    }
}