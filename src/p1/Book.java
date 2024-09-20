package p1;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static p1.Genre.*;

public class Book {

    private Library instance;

    private String name;

    private Genre genre;

    private static String[] userHistory;

    private static int IndexOfUserHistory = 0;

    private String currentUser;

    private static int book_id = 1;

    private static List <Book> books = new ArrayList<>();

    private Book(Library instance , String name , Genre genre , int book_id){
        setInstance(instance);
        setName(name);
        setGenre(genre);
        setBook_id(book_id);
    }

    public static void Default(Library instance){
        Book book1 = new Book(instance,"Three Men in a Boat",COMEDY,book_id);
        books.add(book_id,book1);
        instance.setBooks(book_id++,book1);
        Book book2 = new Book(instance,"The Hitchhiker's Guide to the Galaxy",COMEDY,book_id);
        books.add(book_id,book2);
        instance.setBooks(book_id++,book2);
        Book book3 = new Book(instance,"Catch-22",COMEDY,book_id);
        books.add(book_id,book3);
        instance.setBooks(book_id++,book3);
        Book book4 = new Book(instance,"Death of a Salesman",DRAMA,book_id);
        books.add(book_id,book4);
        instance.setBooks(book_id++,book4);
        Book book5 = new Book(instance,"The Grapes of Wrath",DRAMA,book_id);
        books.add(book_id,book5);
        instance.setBooks(book_id++,book5);
        Book book6 = new Book(instance,"Atonement",DRAMA,book_id);
        books.add(book_id,book6);
        instance.setBooks(book_id++,book6);
        Book book7 = new Book(instance,"Don Quixote",SCIENTIFIC,book_id);
        books.add(book_id,book7);
        instance.setBooks(book_id++,book7);
        Book book8 = new Book(instance,"A Brief History of Time",SCIENTIFIC,book_id);
        books.add(book_id,book8);
        instance.setBooks(book_id++,book8);
        Book book9 = new Book(instance,"The Selfish Gene",DON_QUIXOTE,book_id);
        books.add(book_id,book9);
        instance.setBooks(book_id++,book9);
        Book book10 = new Book(instance,"Charlotte's Web",CHILDREN,book_id);
        books.add(book_id,book10);
        instance.setBooks(book_id++,book10);
    }

    public static void create(Library instance , String name , Genre genre){
        Book create = new Book(instance , name , genre , book_id);
        books.add(book_id,create);
        instance.setBooks(book_id,create);
        book_id++;
    }

    public static void delete(int book_id){
        books.remove(book_id);
    }

    public static void read(){
        for(Book b : books){
            System.out.println(b);
        }
    }

    public static void update(Library instance , int id , String name , Genre genre){
        Book update = books.get(id);
        if(update != null){
            update.setName(name);
            update.setGenre(genre);
            books.add(id,update);
            instance.setBooks(id,update);
        }
        else
            System.err.println("book not found!");
    }

    public static void check(int i){
        if(books.contains(i)) {
            Book book = books.get(i);
            if (book.getCurrentUser() != null)
                System.out.println("Current user : " + book.getCurrentUser());
            else
                System.out.println("No one was found!");
            System.out.println("User history : ");
            if (book.getUserHistory() != null) {
                for (String str : book.getUserHistory()) {
                    System.out.println(str);
                }
            }
            else
                System.out.println("No one was found!");
        } else
            System.out.println("not found!");
    }

    public static void search(int bookId){
        if(books.contains(bookId)){
            Book book = books.get(bookId);
            System.out.println(book);
        }else
            System.out.println("not found!");
    }

    public static void search(Genre genre){
        for(Book book : books){
            if(book.getGenre().equals(genre)) {
                System.out.println(book);
            } else
                System.out.println("not found!");
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Genre getGenre() {
        return genre;
    }

    public void setGenre(Genre genre) {
        this.genre = genre;
    }

    public int getBook_id() {
        return book_id;
    }

    public void setBook_id(int book_id) {
        this.book_id = book_id;
    }

    @Override
    public String toString(){
        return String.format("Name : %s\tGenre : %s\tBook id : %d",name,genre,book_id);
    }

    public String getCurrentUser() {
        return currentUser;
    }

    public void setCurrentUser(String currentUser) {
        this.currentUser = currentUser;
        //setUserHistory(currentUser);
    }

    public String[] getUserHistory() {
        return userHistory;
    }

    public static void setUserHistory(String userHis) {
        userHistory[IndexOfUserHistory] = userHis;
        IndexOfUserHistory++;
    }

    public static List <Book> getBooks() {
        return books;
    }

    public void setBooks(List <Book> books) {
        this.books = books;
    }

    public Library getInstance() {
        return instance;
    }

    public void setInstance(Library instance) {
        this.instance = instance;
    }
}