package Problem2;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class DuplicateCounter {

    private Map<String, Integer> counter;

//    public DuplicateCounter(){
//        counter = new HashMap<String,Integer>();
//    }

    public void count(String file){
        //System.out.println("Trying to read input file " + filename);
        Scanner inputFile = null;
        try {
            inputFile = new Scanner(new File(file));
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
            return;
        }
        inputFile.useDelimiter("([0-9]|[.,!?:;'\"-]|\\s)+");
        while(inputFile.hasNext()) {
            String word = inputFile.next().toLowerCase();
            Integer count = counter.get(word);
            if(count == null)
                count = 1;
            else
                count = count + 1;
            counter.put(word, count);
        }
        inputFile.close();
    }

    public void write(String file2){
        try {
            PrintWriter outfile = new PrintWriter(new File(file2));
            for(String ran : counter.keySet()) {
                outfile.println(counter.get(ran)+ " " + ran);
            }
            outfile.close();
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }

}
