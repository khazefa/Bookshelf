/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package id.cybergitt.bookshelf.controllers;

import id.cybergitt.bookshelf.models.Book;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author khazefa
 */
public class BookShelf {
    private int max_size = 0;
    HashMap<Integer, Book> shelves = new HashMap<>();

    public BookShelf() {
        this.max_size = getMax_size();
    }
    
    public BookShelf(int max_size) {
        this.max_size = max_size;
    }

    public int getMax_size() {
        return max_size;
    }

    public void setMax_size(int max_size) {
        this.max_size = max_size;
    }
    
    public int totalShelves(){
        return getMax_size();
    }
    
    public int shelvesSize(){
        return shelves.size() == 0 || shelves.isEmpty() ? 0 : shelves.size();
    }
    
    public void addSlot(Book b){
        String msg = "";
        if (getMax_size() > 0){
            if( shelves.size() < getMax_size() ){
                int slot = shelves.size() + 1;
                shelves.put(slot, b);
                msg = "Allocated slot number: " + slot;
            }
            else {
                msg = "Book shelf is full";
            }
        } else{
            msg = "Slot capacity not set.";
        }
        System.out.println(msg);
    }
    
    public void updateSlot(int slot, Book b){
        String msg = "";
        if( shelves.size() > 0 ){
            shelves.put(slot, b);
            msg = "Allocated slot number: " + slot;
        } else {
            msg = "Cannot update an empty slot";
        }
        System.out.println(msg);
    }
    
    public void removeSlot(int position){
        String msg = "";
        if( shelves.size() > 0 ){
            shelves.put(position, new Book("--", "--"));
            msg = "Slot number " + position + " is free";
        } else {
            msg = "Cannot remove empty slots";
        }
        System.out.println(msg);
    }
    
    public void getAll() {
        String leftAlignFormat = "| %-9d | %-50s | %-25s |%n";
        System.out.format("+------------+--------------------------------------------------+-------------------------+%n");
        System.out.format("| Slot No.   | Book Title                                       | Author                  |%n");
        System.out.format("+------------+--------------------------------------------------+-------------------------+%n");

        if ( shelves.size() > 0 ){
            for (Map.Entry<Integer, Book> entry : shelves.entrySet()) {
                Integer key = entry.getKey();
                Book value = entry.getValue();
                System.out.format(leftAlignFormat, key, value.getTitle(), value.getAuthor());
            }
        } else {
            System.out.format(leftAlignFormat, 0, "--", "--");
        }
        System.out.format("+------------+--------------------------------------------------+-------------------------+%n");
    }
    
    public void getList() {
        String leftAlignFormat = "%-10d %-48s %-25s %n";
        System.out.format("Slot No.   Book Title                                       Author                  %n");

        if ( shelves.size() > 0 ){
            for (Map.Entry<Integer, Book> entry : shelves.entrySet()) {
                Integer key = entry.getKey();
                Book value = entry.getValue();
                if (!value.getTitle().equalsIgnoreCase("--")){
                    System.out.format(leftAlignFormat, key, value.getTitle(), value.getAuthor());
                }
            }
        } else {
            System.out.format(leftAlignFormat, 0, "--", "--");
        }
    }
    
    public int findEmptySlot(){
        int position = 0;
        
        if ( shelves.size() > 0 ){
            for (Map.Entry<Integer, Book> entry : shelves.entrySet()) {
                Integer key = entry.getKey();
                Book value = entry.getValue();
                if(value.getTitle().equalsIgnoreCase("--") && value.getAuthor().equalsIgnoreCase("--")){
                    if ( key.compareTo(key + 1) < 0){
                        position = key;
                    }
                }
            }
        } else {
            position = 0;
        }
        
        return position;
    }
    
    public boolean isDuplicateTitle(String title){
        for (Map.Entry<Integer, Book> entry : shelves.entrySet()) {
            Integer key = entry.getKey();
            Book value = entry.getValue();
            if (title.equalsIgnoreCase(value.getTitle())){
                return true;
            }
        }
        return false;
    }
    
    public void findByTitle(String title){
        List<Integer> arr = new ArrayList<Integer>();
        for (Map.Entry<Integer, Book> entry : shelves.entrySet()) {
            Integer key = entry.getKey();
            Book book = entry.getValue();
            
            if(book.getTitle().equalsIgnoreCase(title)){
                arr.add(key);
            }
        }
        if (arr.isEmpty()){
            System.out.println("Not found");
        } else {
            System.out.println(arr.toString().replace(", ", ", ").replaceAll("[\\[.\\]]", ""));
        }
    }
    
    public void findByAuthor(String author){
        List<Integer> arr = new ArrayList<Integer>();
        for (Map.Entry<Integer, Book> entry : shelves.entrySet()) {
            Integer key = entry.getKey();
            Book book = entry.getValue();
            
            if(book.getAuthor().equalsIgnoreCase(author)){
                arr.add(key);
            }
        }
        if (arr.isEmpty()){
            System.out.println("Not found");
        } else {
            System.out.println(arr.toString().replace(", ", ", ").replaceAll("[\\[.\\]]", ""));
        }
    }
    
    public void titleByAuthor(String author){
        List<String> arr = new ArrayList<String>();
        for (Map.Entry<Integer, Book> entry : shelves.entrySet()) {
            Integer key = entry.getKey();
            Book book = entry.getValue();
            
            if(book.getAuthor().equalsIgnoreCase(author)){
                arr.add(book.getTitle());
            }
        }
        if (arr.isEmpty()){
            System.out.println("Not found");
        } else {
            System.out.println(arr.toString().replace(", ", ", ").replaceAll("[\\[.\\]]", ""));
        }
    }
}
