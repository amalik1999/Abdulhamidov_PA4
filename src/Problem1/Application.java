package Problem1;

public class Application extends DuplicateRemover {

    public static void main(String[] args) throws Exception {

        DuplicateRemover  duplicateremover = new DuplicateRemover();
        duplicateremover.remove("problem1.txt");
        duplicateremover.Write("unique_words.txt");

    }
}
