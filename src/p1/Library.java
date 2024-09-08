package p1;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Library {

    private static Library instance;

    private String name;

    private Map <Integer , User> users = new HashMap<>();

    private Map <Integer , Book> books = new HashMap<>();

    private int userId = 1;

    private int bookId = 1;

    Scanner in = new Scanner(System.in);

    private Library(String name){
        this.setName(name);
    }

    public static Library getInstance(String name){
        if(instance == null){
            instance = new Library(name);
        }
        return instance;
    }
    public void DefaultBook(){
        Book.Defult(instance);
    }
    //create user
    public void createUser(String first , String last , int national){
        User.create(instance,first,last,national);
    }
    // login user
    public void loginUser(int userId , String first , String last , int national) {
        User.login(userId,first,last,national);
    }
    // search user
    public void searchUser(int userId){
        User.search(userId);
    }
    public void searchUser(String first , String last){
        User.search(first,last);
    }
    // delete user
    public void deleteUser(int user_id){
        User.delete(user_id);
        users.remove(user_id);
    }
    // read user
    public void readUser(){
        User.read();
    }
    // update user
    public void updateUser(int user_id , String first , String last , int national){
        User.update(instance,user_id,first,last,national);
    }
    // create book
    public void createBook(String name,String genre){
        Book.create(instance,name,genre);
    }

    // select book
    public void selectBook() {
        readBook();

        System.out.println("Please enter your user ID:");
        int userId = in.nextInt();
        User user = getUsers().get(userId);

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
            System.out.println("Enter the ID of the book you want to rent (or enter -1 to stop):");
            int bookId = in.nextInt();

            if (bookId == -1) break;

            Book book = getBooks().get(bookId);

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
    // search book
    public void searchBook(int bookId){
        Book.search(bookId);
    }

    public void searchBook(String genre){
        Book.search(genre);
    }

    //delete book
    public void deleteBook(int id){
        Book.delete(id);
        books.remove(id);
    }
    //read book
    public void readBook(){
        Book.read();
    }
    //update book
    public void updateBook(int book_id , String name , String genre){
        Book.update(instance,book_id,name,genre);
    }

    public void checkBook(int i){
        Book.check(i);
    }

    public void checkUser(int i){
        User.check(i);
    }

    public String readLibrary(){
        return getName();
    }

    public void updateLibrary(String name){
        setName(name);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public Map<Integer, User> getUsers() {
        return users;
    }

    public Map<Integer, Book> getBooks() {
        return books;
    }

    public void setBooks(Map<Integer, Book> books) {
        this.books = books;
    }

    public void setUsers(int userId, User user) {
        users.put(userId,user);
    }

    public void setBooks(int bookId, Book create) {
        books.put(bookId,create);
    }

    @Override
    public String toString(){
        return "";
    }
}