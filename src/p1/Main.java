package p1;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);

        System.out.println("Enter library name : ");
        Library library = Library.getInstance(in.next());
        library.DefaultBook();

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
                        library.readBook();
                        System.out.println("Enter the ID of the book you want to rent (or enter -1 to stop):");
                        int bookId = in.nextInt();
                        library.selectBook(id,fName,lName,NCode,bookId);
                    }
                    else
                        System.out.println("Login failed!");
                    break;
                case 3: // read user
                    library.readUser();
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
                    System.out.println("Enter your first name : ");
                    String firstUp = in.next();
                    System.out.println("Enter your last name : ");
                    String lastUp = in.next();
                    System.out.println("Enter your national code : ");
                    int nationalUp = in.nextInt();
                    library.updateUser(idd,firstUp,lastUp,nationalUp);
                    System.out.println("User updated!");
                    break;
                case 6 : // create book
                    System.out.println("Enter the name of your book : ");
                    String name = in.next();
                    System.out.println("Enter the genre of your book : ");
                    String genre = in.next();
                    library.createBook(name,genre);
                    System.out.println("New book arrived!");
                    break;
                case 7 : // read book
                    library.readBook();
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
                    System.out.println("Enter your name : ");
                    String bName = in.next();
                    System.out.println("Enter your genre : ");
                    String gen = in.next();
                    library.updateBook(bId,bName,gen);
                    System.out.println("Book updated!");
                    break;
                case 10 : // search user
                    System.out.println("How do you want to search?");
                    System.out.println("1 : User id");
                    System.out.println("2 : User name");
                    int ch = in.nextInt();
                    if (ch == 1){
                        System.out.println("Enter user id : ");
                        library.searchUser(in.nextInt());
                    }
                    else if(ch == 2){
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
                    ch = in.nextInt();
                    if (ch == 1){
                        System.out.println("Enter book id : ");
                        library.searchBook(in.nextInt());
                    }
                    else if(ch == 2){
                        System.out.println("Enter book genre (Capital first letter!) : ");
                        library.searchBook(in.next());
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