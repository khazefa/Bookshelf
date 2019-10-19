package id.cybergitt;

import id.cybergitt.bookshelf.controllers.BookShelf;
import id.cybergitt.bookshelf.helpers.DigiHelper;
import id.cybergitt.bookshelf.models.Book;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

/**
 * Bookshelf
 */
public class App {
    static BookShelf shelf = new BookShelf();
    /**
     * Says hello to the world.
     * @param args The arguments of the program.
     */
    public static void main(String[] args) {
        File myFile = null;
        
        if (0 < args.length) { // if args have parameters
            String myFileName = args[0];
            myFile = new File(myFileName);
            if (myFile.isFile()) { // only accept file reading
                if (myFile.exists()){
                    try {
                        List<String> allLines = Files.readAllLines(Paths.get(myFile.getPath()));
			for (String line : allLines) {
                            runByFile(line);
			}
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        } else { // if args doesnt have parameters
            showMenu();
            BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
            String inputs = "";
            try {
                while (!inputs.equalsIgnoreCase("exit")) {
                    System.out.print("Enter your command:");
                    inputs = in.readLine();
                
                    if(inputs.isEmpty()){
                        System.out.println("System exit..");
                        System.exit(0);
                    }else{
                        runByInput(inputs);
                    }
                }
            } catch (IOException e) {
                System.err.println(e.getMessage());
            }
        }
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
    }
    
    public static void runByFile(String command){
        DigiHelper helper = new DigiHelper();
        List cmd = new ArrayList();
        cmd = helper.commandSplitter(command);
        
        if(cmd.get(0).toString().equalsIgnoreCase("create_book_shelf")){
            int slot_quota = Integer.parseInt(cmd.get(1).toString());
            shelf.setMax_size(slot_quota);
            System.out.println("Created a book shelf with " +shelf.totalShelves()+ " slots");
        }
        else if(cmd.get(0).toString().equalsIgnoreCase("put")){
            if (shelf.shelvesSize() <= shelf.getMax_size()){
                int get_slot = shelf.findEmptySlot();
                if (get_slot > 0){
                    try {
                        shelf.updateSlot(get_slot, new Book(cmd.get(1).toString(), cmd.get(2).toString()));
                    } catch (Exception e) {
                        System.err.println("Error: "+e.getMessage());
                    }
                } else {
                    try {
                        shelf.addSlot(new Book(cmd.get(1).toString(), cmd.get(2).toString()));
                    } catch (Exception e) {
                        System.err.println("Error: "+e.getMessage());
                    }
                }
            } else {
                System.out.println("Book shelf is full");
            }
        }
        else if(cmd.get(0).toString().equalsIgnoreCase("remove")) {
            int pos = Integer.parseInt(cmd.get(1).toString());
            shelf.removeSlot(pos);
        }
        else if(cmd.get(0).toString().equalsIgnoreCase("list")) {
            shelf.getList();
        }
        else if(cmd.get(0).toString().equalsIgnoreCase("find-by-author")) {
            shelf.findByAuthor(cmd.get(1).toString());
        }
        else if(cmd.get(0).toString().equalsIgnoreCase("find-by-title")) {
            shelf.findByTitle(cmd.get(1).toString());
        }
        else if(cmd.get(0).toString().equalsIgnoreCase("titles-by-author")) {
            shelf.titleByAuthor(cmd.get(1).toString());
        }
        else{
            System.out.println("Command not found!");
        }
    }
    
    public static void runByInput(String command){
        DigiHelper helper = new DigiHelper();
        List cmd = new ArrayList();
        cmd = helper.commandSplitter(command);
        
        if(cmd.get(0).toString().equalsIgnoreCase("create_book_shelf")){
            int slot_quota = Integer.parseInt(cmd.get(1).toString());
            shelf.setMax_size(slot_quota);
            System.out.println("Created a book shelf with " +shelf.totalShelves()+ " slots");
        }
        else if(cmd.get(0).toString().equalsIgnoreCase("put")){
            if (shelf.shelvesSize() <= shelf.getMax_size()){
                int get_slot = shelf.findEmptySlot();
                if (get_slot > 0){
                    shelf.updateSlot(get_slot, new Book(cmd.get(1).toString(), cmd.get(2).toString()));
                } else {
                    shelf.addSlot(new Book(cmd.get(1).toString(), cmd.get(2).toString()));
                }
            } else {
                System.out.println("Book shelf is full");
            }
        }
        else if(cmd.get(0).toString().equalsIgnoreCase("remove")) {
            int pos = Integer.parseInt(cmd.get(1).toString());
            shelf.removeSlot(pos);
        }
        else if(cmd.get(0).toString().equalsIgnoreCase("list")) {
            shelf.getList();
        }
        else if(cmd.get(0).toString().equalsIgnoreCase("find-by-author")) {
            shelf.findByAuthor(cmd.get(1).toString());
        }
        else if(cmd.get(0).toString().equalsIgnoreCase("find-by-title")) {
            shelf.findByTitle(cmd.get(1).toString());
        }
        else if(cmd.get(0).toString().equalsIgnoreCase("titles-by-author")) {
            shelf.titleByAuthor(cmd.get(1).toString());
        }
        else if(cmd.get(0).toString().equalsIgnoreCase("help")) {
            showMenu();
        }
        else if(cmd.get(0).toString().equalsIgnoreCase("exit")) {
            System.exit(0);
        }
        else{
            System.out.println("Command not found!");
        }
    }
    
    private static void run_hashmap_slot(int max_size){ // test case
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
