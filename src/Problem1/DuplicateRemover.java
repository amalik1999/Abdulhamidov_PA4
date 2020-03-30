package Problem1;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;

public class DuplicateRemover {

    private Set<String> uniqueWords;

    public void remove(String dataFile) throws FileNotFoundException {
        String w;
        uniqueWords = new HashSet<String>();
        Scanner scan = new Scanner(new File(dataFile));
        while (scan.hasNext()) {
            w = scan.next();
            uniqueWords.add(w);
        }
        scan.close();
    }

    public void Write(String outputFile) throws IOException {
        File file;
        FileWriter fileOne = null;

        file = new File(outputFile);

        if (file.exists()) {
            fileOne = new FileWriter(file, true);
            Iterator iterator1 = uniqueWords.iterator();

            while (iterator1.hasNext()) {
                String string1 = (String) iterator1.next();
                fileOne.write(string1 + "\n");
            }
            fileOne.close();
        } else {

            file.createNewFile();
            fileOne = new FileWriter(file);
            Iterator itr = uniqueWords.iterator();

            while (itr.hasNext()) {
                String str = (String) itr.next();
                fileOne.write(str + "\n");
            }
            fileOne.close();
            System.out.println("Data Written to File");
        }

    }

}
