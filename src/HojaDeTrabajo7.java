import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class HojaDeTrabajo7 {

    public static void main(String[] args) throws IOException {

        boolean wantsToContinue = true;

        BinaryTree dictionary = new BinaryTree();
        ArrayList<String> sentence;

        while (wantsToContinue){

            System.out.println(menu());
            System.out.print("\nIngrese una opcion: ");
            Scanner input = new Scanner(System.in);
            String op = input.next();

            switch (op){
                case "1":
                    System.out.print("\n\nIngrese path del archivo diccionario: ");
                    Scanner input2 = new Scanner(System.in);
                    String path = input2.next();
                    dictionary = readWords(path);
                    break;
                case "2":
                    if (dictionary != null){
                        System.out.print("\n\nIngrese path del archivo oracion: ");
                        Scanner input3 = new Scanner(System.in);
                        String path2 = input3.next();
                        sentence = readSentence(path2);
                        sentence = translate(sentence, dictionary);
                        String translatedSentence = "";
                        for (String word: sentence) {
                            translatedSentence += " " + word;
                        }
                        System.out.println("\nOracion Traducida: " + translatedSentence);
                    } else {
                        System.out.println("\nERROR: NO se ha ingresado un diccionario.");
                    }
                    break;
                case "3":
                    wantsToContinue = false;
                    break;
                default:
                    System.out.println("\nLa opcion ingresada no es valida.");
                    break;
            }

        }
    }

    /**
     * String of the menu
     * @return
     */
    public static String menu(){
        return "\n\tMenu\n\n" +
                "1. Agregar diccionario\n" +
                "2. Leer oracion\n" +
                "3. Salir\n\n";
    }

    /**
     * Read a txt file associating each word
     * @param path
     * @return BinaryTree with the words
     * @throws IOException
     */
    public static BinaryTree readWords(String path) throws IOException {
        File file = new File(path);
        FileReader fileReader = new FileReader(file);
        BufferedReader bufferedReader = new BufferedReader(fileReader);

        String line;

        BinaryTree<Association> binaryTree = new BinaryTree();

        while ((line = bufferedReader.readLine()) != null) {
            String[] words = line.split(", ");
            String englishWord = words[0];
            String spanishWord = words[1];
            Association association = new Association(englishWord, spanishWord);
            binaryTree.insert(association);
        }

        return binaryTree;

    }

    /**
     * Read a txt file with the sentence you want to translate
     * @param path
     * @return Arralist with the words
     * @throws IOException
     */
    public static ArrayList readSentence(String path) throws IOException{

        File file = new File(path);
        Scanner scanner = new Scanner(file);

        ArrayList<String> sentence = new ArrayList<>();

        while (scanner.hasNext()){
            String word = scanner.next();
            sentence.add(word);
        }

        return sentence;

    }

    /**
     * Trnaslate the sentence
     * @param sentence
     * @param dictionary
     * @return Arralist with spanish words
     */
    public static ArrayList translate(ArrayList<String> sentence, BinaryTree dictionary){

        ArrayList<String> newSentece = new ArrayList();

        for (String word:sentence) {
            Association association = (Association) dictionary.search(word);
            if (association != null){
                newSentece.add(association.getSpanishWord());
            } else {
                newSentece.add("*" + word + "*");
            }
        }

        return newSentece;

    }

}
