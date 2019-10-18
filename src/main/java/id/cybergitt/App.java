package id.cybergitt;

import id.cybergitt.bookshelf.controllers.BookShelf;
import id.cybergitt.bookshelf.helpers.DigiHelper;
import id.cybergitt.bookshelf.models.Book;

/**
 * Hello world!
 */
public class App {
    /**
     * Says hello to the world.
     * @param args The arguments of the program.
     */
    public static void main(String[] args) {
        showMenu();
        int max_size = 5;
        run_hashmap_slot(max_size);
    }
    
    private static void showMenu(){
        System.out.println("\nMenu:");
        String leftAlignFormat = "   %-35s %-35s %n";
        System.out.format(leftAlignFormat, "   create_book_shelf(total_shelf)", "create_book_shelf 5");
        System.out.format(leftAlignFormat, "   put(title, author)", "put AClashOfKings GeorgeRRMartin");
        System.out.format(leftAlignFormat, "   remove(slot)", "remove 4");
        System.out.format(leftAlignFormat, "   list", "");
        System.out.format(leftAlignFormat, "   find-by-author(author)", "find-by-author JKRowling");
        System.out.format(leftAlignFormat, "   find-by-title(title)", "find-by-title AGameOfThrones");
        System.out.format(leftAlignFormat, "   titles-by-author(author)", "titles-by-author JKRowling");
        System.out.format(leftAlignFormat, "   help", "");
        System.out.format(leftAlignFormat, "   exit", "");
        System.out.println("Enter your command:  ");
    }
    
    private static void runByFile(){
        //to do code here
    }
    
    private static void runByInput(){
        //to do code here
    }
    
    private static void run_hashmap_slot(int max_size){
        DigiHelper helper = new DigiHelper();
        BookShelf shelf = new BookShelf(max_size);
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
        System.out.println("Get empty slot at " + pos_slot);
        shelf.updateSlot(pos_slot, new Book("AGameOfThrones", "GeorgeRRMartin"));
        shelf.addSlot(new Book("AClashOfKings", "GeorgeRRMartin"));
       
        shelf.getList();
        
        shelf.findByAuthor("JKRowling");
        shelf.findByTitle("AGameOfThrones");
        shelf.titleByAuthor("JKRowling");
        shelf.titleByAuthor("UdiDahan");
        
    }
}
