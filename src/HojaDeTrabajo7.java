import java.io.*;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Scanner;

public class HojaDeTrabajo7 {

    public static void main(String[] args) throws IOException {

        boolean wantsToContinue = true;

        while (wantsToContinue){

            System.out.println(menu());
            System.out.print("\nIngrese una opcion: ");
            Scanner input = new Scanner(System.in);
            String op = input.next();

            BinaryTree diccionary;
            ArrayList sentence;

            switch (op){
                case "1":
                    System.out.print("\n\nIngrese path del archivo diccionario: ");
                    Scanner input2 = new Scanner(System.in);
                    String path = input.next();
                    diccionary = readWords(path);
                    break;
                case "2":
                    System.out.print("\n\nIngrese path del archivo oracion: ");
                    Scanner input3 = new Scanner(System.in);
                    String path2 = input.next();
                    sentence = readSentence(path2);
                    break;
                case "3":
                    wantsToContinue = false;
                    break;
                default:
                    break;
            }

        }
    }

    public static String menu(){
        return "\n\tMenu\n\n" +
                "1. Agregar diccionario\n" +
                "2. Leer oracion\n" +
                "3. Salir\n\n";
    }

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

    public static ArrayList readSentence(String path) throws IOException{

        File file = new File(path);
        Scanner scanner = new Scanner(file);

        ArrayList<String> sentence = new ArrayList<>();

        while (scanner.hasNext()){
            String word = scanner.next();
            sentence.add(word);
        }

        System.out.println(sentence);
        return sentence;

    }

}
