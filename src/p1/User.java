package p1;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class User {

    private static Library instance;

    private String firstName;

    private String lastName;

    private int nationalCode;

    private static int user_id = 1;

    private String rentedBooks;

    private static final String[] currentBook = new String[3]; // max 3  ->  array[3]

    private int index = 0;

    private static int count = 0;

    private static List <User> users = new ArrayList<>();

    private User(Library instance , String firstName , String lastName , int nationalCode){
        this.instance = instance;
        this.firstName = firstName;
        this.lastName = lastName;
        this.nationalCode = nationalCode;
    }
    public static void addBook(String bookName){
        for(int i = 0 ; i < currentBook.length ; i++){
            if (currentBook[i] == null){
                currentBook[i] = bookName;
                setCount(getCount() + 1);
                break;
            }
        }
    }
    public static void selectBook(int user_id , int bookId) {

        User user = users.get(user_id);

        if (user == null) {
            System.out.println("User not found!");
            return;
        }

        if (user.getCount() >= 3) {
            System.out.println("You have already rented the maximum number of books (3).");
            return;
        }

        System.out.println("You can choose up to " + (3 - user.getCount()) + " books:");
        for (int i = 0; i < (3 - user.getCount()); i++) {
            //System.out.println("Enter the ID of the book you want to rent (or enter -1 to stop):");

            if (bookId == -1) break;

            if (Book.getBooks().get(bookId) == null) {
                System.out.println("Book not found! Please try again.");
                i--;
                continue;
            }

            if (Book.getBooks().get(bookId).getCurrentUser() != null) {
                System.out.println("This book is already rented by someone else.");
                i--;
            }
            else {
                user.addBook(String.valueOf(Book.getBooks().get(bookId)));
                Book.getBooks().get(bookId).setCurrentUser(String.valueOf(user));
                user.setCurrentBook(Book.getBooks().get(bookId).getName());
                //String his = user.getFirstName() + " " + user.getLastName();
                //book.setUserHistory(his);
                System.out.println("Book '" + Book.getBooks().get(bookId).getName() + "' rented successfully!");
            }
        }
    }
    public static void create(Library instance, String firstName, String lastName, int nationalCode){
        User user = new User(instance,firstName,lastName,nationalCode);
        users.add(user_id,user);
        instance.setUsers(user_id,user);
        System.out.format("User created!\tYour user id : %d\n",user_id);
        System.out.println("Do you want to login to your account?");
        user_id++;
    }
    public static boolean login(int userId , String first , String last , int national){
        if(users.contains(userId)){
            User user = users.get(userId);
            if(user.getFirstName().equals(first) &&
                    user.getLastName().equals(last) &&
                    user.getNationalCode() == national //&&
                    //user.getUser_id() == userId
            ){

                //selectBook(userId);
                System.out.println("correct!");
                return true;
            }
            else
                System.out.println("The specification is incorrect!");
            return false;
        }
        else
            System.out.println("The specification is incorrect!!");
        return false;
    }
    public static void read(){
        for (User us : users) {
            System.out.println("Name : " + us.firstName + " " + us.lastName + "\t\tnational code : " + us.nationalCode + "\tuser id : " + us.user_id);
        }
    }
    public static void check(int i){
        if(users.contains(i)) {
            User user = users.get(i);
            System.out.println("Current book : ");
            if (user.getCurrentBook() != null) {
                for (String str : user.getCurrentBook()) {
                    System.out.println(str);
                }
            }
            else
                System.out.println("No one was found!");
        } else
            System.out.println("not found!");
    }
    public static void update(Library instance , int id , String firstName , String lastName , int nationalCode){
        User user = users.get(id);
        user.setInstance(instance);
        if (user != null) {
            user.firstName = firstName;
            user.lastName = lastName;
            user.nationalCode = nationalCode;
            users.add(id, user);
            instance.setUsers(id, user);
        } else
            System.out.println("user is null");
    }
    public static void delete(int id){

        User user = users.get(id);
        if (user != null) {
            users.remove(id);
        } else
            System.out.println("user not found");

    }
    public static void search(int userId){
        if(users.contains(userId)){
            User user = users.get(userId);
            System.out.println(user.getFirstName() + " " + user.getLastName());
        }
        else
            System.out.println("not found!");
    }
    public static void search(String firstName , String lastName){
        for (User user : users){
            if(user.getFirstName().equals(firstName) && user.getLastName().equals(lastName)){
                System.out.println(user);
            }
        }
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getNationalCode() {
        return nationalCode;
    }

    public void setNationalCode(int nationalCode) {
        this.nationalCode = nationalCode;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public String getRentedBooks() {
        return rentedBooks;
    }

    public void setRentedBooks(String rentedBooks) {
        this.rentedBooks = rentedBooks;
    }

    public String[] getCurrentBook() {
        return currentBook;
    }

    public void setCurrentBook(String currentBook) {
        this.currentBook[index] = currentBook;
        index++;
        //setRentedBooks(currentBook);
    }

    @Override
    public String toString(){
        return String.format("Name : %s %s\tNational code : %d\tUser id : %d",firstName,lastName,nationalCode,user_id);
    }

    public static int getCount() {
        return count;
    }

    public static void setCount(int coun) {
        count = coun;
    }

    public Library getInstance() {
        return instance;
    }

    public void setInstance(Library instance) {
        this.instance = instance;
    }

    public List <User> getUsers() {
        return users;
    }

    public void setUsers(List <User> users) {
        this.users = users;
    }
}