package p1;

import java.util.HashMap;
import java.util.Map;

public class Library {

    private static Library instance;

    private String name;

    private Map <Integer , User> users = new HashMap<>();

    private Map <Integer , Book> books = new HashMap<>();

    private int userId = 1;

    private int bookId = 1;


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
        Book.Default(instance);
    }
    //create user
    public void createUser(String first , String last , int national){
        User.create(instance,first,last,national);
    }
    // login user
    public boolean loginUser(int userId , String first , String last , int national) {
        //User login = new User(instance,first,last,national);
        boolean tOf = User.login(userId,first,last,national);
        if (tOf)
            return true;
        else return false;
    }

    // search user
    public void searchUser(int userId){
//        User search = new User(instance,null,null,userId);
//        search.search(userId);
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
    public void createBook(String name,Genre genre){
        Book.create(instance,name,genre);
        bookId++;
    }

    // search book
    public void searchBook(int bookId){
        Book.search(bookId);
    }

    public void searchBook(Genre genre){
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
    public void updateBook(int book_id , String name , Genre genre){
        Book.update(instance,book_id,name,genre);
    }

    public void checkBook(int i){
        Book.check(i);
    }

    public void checkUser(int i){
        User.check(i);
    }

    public void selectBook(int id, String fName, String lName, int NCode , int bookId) {
//        User select = new User(instance,fName,lName,NCode);
//        select.selectBook(id,bookId);
        User.selectBook(id,bookId);
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