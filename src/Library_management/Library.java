package Library_management;

import Enum.Genre;
import exceptions.AccountException;

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
    public void AvailableBooks(){
        Book.available(instance);
    }
    //create user
    public void createUser(String first , String last , int national) throws AccountException {
        User.create(instance,first,last,national);
    }
    // login user
    public boolean loginUser(int userId , String first , String last , int national) throws AccountException{
        //User login = new User(instance,first,last,national);
        boolean tOf = User.login(userId,first,last,national);
        if (tOf)
            return true;
        else return false;
    }

    // search user
    public void searchUser(int userId) throws AccountException {
//        User search = new User(instance,null,null,userId);
//        search.search(userId);
        User.search(userId);
    }

    public void searchUser(String first , String last) throws AccountException{
        User.search(first,last);
    }

    // delete user
    public void deleteUser(int user_id){
        User.delete(user_id);
        users.remove(user_id);
    }
    // read user
    public void loadUser(){
        User.load();
    }

    public void loadUser(String first , String last) throws AccountException{
        User.load(first,last);
    }

    // update user
    public void updateUser(int user_id , String first , String last , int national) throws AccountException{
        User.update(instance,user_id,first,last,national);
    }
    public void updateUser(int user_id , String first , String last) throws AccountException{
        User.update(instance,user_id,first,last);
    }
    public void updateUser(int user_id , int national) throws AccountException{
        User.update(instance,user_id,national);
    }

    // create book
    public void createBook(String name, Genre genre) throws AccountException {
        Book.create(instance,name,genre);
        bookId++;
    }

    // search book
    public void searchBook(int bookId) throws AccountException {
        Book.search(bookId);
    }

    public void searchBook(Genre genre) throws AccountException{
        Book.search(genre);
    }

    //delete book
    public void deleteBook(int id) throws AccountException {
        Book.delete(id);
        books.remove(id);
    }

    //read book
    public void loadBook(){
        Book.load();
    }

    public void loadBook(String name) throws AccountException{
        Book.load(name);
    }


    //update book
    public void updateBook(int book_id , String name , Genre genre) throws AccountException{
        Book.update(instance,book_id,name,genre);
    }
    public void updateBook(int book_id , String name) throws AccountException{
        Book.update(instance,book_id,name);
    }
    public void updateBook(int book_id , Genre genre) throws AccountException{
        Book.update(instance,book_id,genre);
    }


    public void checkBook(int i) throws AccountException{
        Book.check(i);
    }

    public void checkUser(int i) throws AccountException {
        User.check(i);
    }

    public void selectBook(int id , int bookId) throws AccountException {
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