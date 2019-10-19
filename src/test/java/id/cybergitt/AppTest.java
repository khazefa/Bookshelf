/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package id.cybergitt;

import id.cybergitt.bookshelf.controllers.BookShelf;
import id.cybergitt.bookshelf.helpers.DigiHelper;
import id.cybergitt.bookshelf.models.Book;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author khazefa
 */
public class AppTest {
    
    public AppTest() {
    }
    
    @Test
    public void testAcceptOnlyCamelCaseWord(){
        System.out.println("test camel case words validation");
        DigiHelper helper = new DigiHelper();
        String[] words = {"HarryPotterAndTheGobletOfFire", "TheMazeRunner", "MockingJay", "AngryBirds"}; 
        
        for (String word : words) {
            assertTrue("CamelCase valid", !helper.camelCaseChecker(word).equalsIgnoreCase("--"));
        }
    }
    
    @Test
    public void testEmptyShelf(){
        BookShelf shelf = new BookShelf();
        assertSame("Shelf is empty", 0, shelf.shelvesSize());
    }

    /**
     * Test of main method, of class App.
     */
    @Test
    public void testMain() {
        System.out.println("test main class");
        DigiHelper helper = new DigiHelper();
        BookShelf shelf = new BookShelf(5);
        System.out.println("Created a book shelf with " +shelf.totalShelves()+ " slots");

        shelf.addSlot(new Book("HarryPotterAndTheGobletOfFire", "JKRowling"));
        shelf.addSlot(new Book("TheMazeRunner", "JamesDashner"));
        shelf.addSlot(new Book("HarryPotterAndTheOrderOfThePhoenix", "JKRowling"));
        shelf.addSlot(new Book("HarryPotterAndTheDeathlyHallows", "JKRowling"));
//        try {
//            shelf.addSlot(new Book("", ""));
//        } catch (Exception e) {
//            System.err.println("Error: "+e.getMessage());
//        }
        shelf.addSlot(new Book("TheHungerGames", "SuzanneCollins"));
        shelf.removeSlot(4);
        
        shelf.getList();
        
        int pos_slot = shelf.findEmptySlot();
        shelf.updateSlot(pos_slot, new Book("AGameOfThrones", "GeorgeRRMartin"));
        shelf.addSlot(new Book("AClashOfKings", "GeorgeRRMartin"));
       
        shelf.getList();
        
        shelf.findByAuthor("JKRowling");
        shelf.findByTitle("AGameOfThrones");
        shelf.titleByAuthor("JKRowling");
        shelf.titleByAuthor("UdiDahan");
    }
    
}
