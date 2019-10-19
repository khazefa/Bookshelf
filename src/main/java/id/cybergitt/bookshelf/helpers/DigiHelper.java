/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package id.cybergitt.bookshelf.helpers;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author khazefa
 */
public class DigiHelper {
    String spaceRegex = " ";
    String cmdPattern = "^[a-zA-Z0-9_-]*$";
//    String camelCasePattern = "([A-Z]+[a-z0-9]+)+";
    String camelCasePattern = "[A-Z]([A-Z0-9]*[a-z][a-z0-9]*[A-Z]|[a-z0-9]*[A-Z][A-Z0-9]*[a-z])[A-Za-z0-9]*";

    public DigiHelper() {
        
    }
    
    public String camelCaseChecker(String input){
        if (input.trim().matches(camelCasePattern)) {
            return input;
        } else {
            return "--";
        }
    }
    
    public List commandSplitter(String input){
        List list = new ArrayList();
        if(input.trim().isEmpty() || "".equals(input.trim())){
            list = new ArrayList();
        }else {
            if(input.contains(spaceRegex)){
                String[] words = input.split(spaceRegex);
                int i = 0;
                for (String word : words) {
                    list.add(i, word);
                    i++;
                }
            }else{
                list.add(0, input);
            }
        }
        return list;
    }
    
}
