package p1;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class User {

    private Library instance;

    private String firstName;

    private String lastName;

    private int nationalCode;

    private int user_id = 1;

    private String rentedBooks;

    private final String[] currentBook = new String[3]; // max 3  ->  array[3]

    private int index = 0;

    private int count = 0;

    private Map<Integer , User> users = new HashMap<>();

    public User(Library instance , String firstName , String lastName , int nationalCode){
        this.instance = instance;
        this.firstName = firstName;
        this.lastName = lastName;
        this.nationalCode = nationalCode;
    }
    public void addBook(String bookName){
        for(int i = 0 ; i < currentBook.length ; i++){
            if (currentBook[i] == null){
                currentBook[i] = bookName;
                setCount(getCount() + 1);
                break;
            }
        }
    }
    public void selectBook(int user_id , int bookId) {

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

            Book book = new Book(instance,"","",0);
            book = book.getBooks().get(bookId);

            if (book == null) {
                System.out.println("Book not found! Please try again.");
                i--;
                continue;
            }

            if (book.getCurrentUser() != null) {
                System.out.println("This book is already rented by someone else.");
                i--;
            }
            else {
                user.addBook(String.valueOf(book));
                book.setCurrentUser(String.valueOf(user));
                user.setCurrentBook(book.getName());
                //String his = user.getFirstName() + " " + user.getLastName();
                //book.setUserHistory(his);
                System.out.println("Book '" + book.getName() + "' rented successfully!");
            }
        }
    }
    public void create(Library instance, String firstName, String lastName, int nationalCode){
        User user = new User(instance,firstName,lastName,nationalCode);
        users.put(user_id,user);
        instance.setUsers(user_id,user);
        System.out.format("User created!\tYour user id : %d\n",user_id);
        System.out.println("Do you want to login to your account?");
        user_id++;
    }
    public boolean login(int userId , String first , String last , int national){
        if(users.containsKey(userId)){
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
    public void read(){
        for (User us : users.values()) {
            System.out.println("Name : " + us.firstName + " " + us.lastName + "\t\tnational code : " + us.nationalCode + "\tuser id : " + us.user_id);
        }
    }
    public void check(int i){
        if(users.containsKey(i)) {
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
    public void update(Library instance , int id , String firstName , String lastName , int nationalCode){
        User user = users.get(id);
        user.setInstance(instance);
        if (user != null) {
            user.firstName = firstName;
            user.lastName = lastName;
            user.nationalCode = nationalCode;
            users.put(id, user);
            instance.setUsers(id, user);
        } else
            System.out.println("user is null");
    }
    public void delete(int id){

        User user = users.get(id);
        if (user != null) {
            users.remove(id);
        } else
            System.out.println("user not found");

    }
    public void search(int userId){
        if(users.containsKey(userId)){
            User user = users.get(userId);
            System.out.println(user.getFirstName() + " " + user.getLastName());
        }
        else
            System.out.println("not found!");
    }
    public void search(String firstName , String lastName){
        for (User user : users.values()){
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

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public Library getInstance() {
        return instance;
    }

    public void setInstance(Library instance) {
        this.instance = instance;
    }

    public Map<Integer, User> getUsers() {
        return users;
    }

    public void setUsers(Map<Integer, User> users) {
        this.users = users;
    }
}