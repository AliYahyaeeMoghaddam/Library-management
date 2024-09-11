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
        Book de = new Book(instance,null,null,0);
        de.Default(instance);
        //Book.Default(instance);
    }
    //create user
    public void createUser(String first , String last , int national){
        User create = new User(instance,first,last,national);
        create.create(instance,first,last,national);
        //User.create(instance,first,last,national);
    }
    // login user
    public boolean loginUser(int userId , String first , String last , int national) {
        User login = new User(instance,first,last,national);
        boolean tOf = login.login(userId,first,last,national);
        if (tOf)
            return true;
        else return false;
        //User.login(userId,first,last,national);
    }
    // search user
    public void searchUser(int userId){
        User search = new User(instance,null,null,userId);
        search.search(userId);
        //User.search(userId);
    }
    public void searchUser(String first , String last){
        User search = new User(instance,first,last,0);
        search.search(first,last);
        //User.search(first,last);
    }
    // delete user
    public void deleteUser(int user_id){
        User delete = new User(instance,null,null,user_id);
        delete.delete(user_id);
        //User.delete(user_id);
        users.remove(user_id);
    }
    // read user
    public void readUser(){
        User read = new User(instance,null,null,0);
        read.read();
        //User.read();
    }
    // update user
    public void updateUser(int user_id , String first , String last , int national){
        User update = new User(instance,first,last,national);
        update.update(instance,user_id,first,last,national);
        //User.update(instance,user_id,first,last,national);
    }
    // create book
    public void createBook(String name,String genre){
        Book create = new Book(instance,name,genre,bookId);
        create.create(instance,name,genre);
        bookId++;
        //Book.create(instance,name,genre);
    }

    // search book
    public void searchBook(int bookId){
        Book search = new Book(instance,null,null,bookId);
        search.search(bookId);
        //Book.search(bookId);
    }

    public void searchBook(String genre){
        Book search = new Book(instance,null,null,0);
        search.search(genre);
        //Book.search(genre);
    }

    //delete book
    public void deleteBook(int id){
        Book del = new Book(instance,null,null,0);
        del.delete(id);
        books.remove(id);
    }
    //read book
    public void readBook(){
        Book read = new Book(instance,null,null,0);
        read.read();
        //Book.read();
    }
    //update book
    public void updateBook(int book_id , String name , String genre){
        Book up = new Book(instance,name,genre,book_id);
        up.update(instance,book_id,name,genre);
        //Book.update(instance,book_id,name,genre);
    }

    public void checkBook(int i){
        Book check = new Book(instance,null,null,i);
        check.check(i);
        //Book.check(i);
    }

    public void checkUser(int i){
        User check = users.get(userId);
        check.check(i);
        //User.check(i);
    }

    public void selectBook(int id, String fName, String lName, int NCode , int bookId) {
        User select = new User(instance,fName,lName,NCode);
        select.selectBook(id,bookId);
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