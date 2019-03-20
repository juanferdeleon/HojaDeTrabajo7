import java.io.*;

public class HojaDeTrabajo7 {

    public static void main(String[] args) throws FileNotFoundException, IOException {
        readWords("D:\\Users\\Juanfer De Leon\\Desktop\\Estructura de Datos\\Projects\\HojaDeTrabajo7\\diccionario.txt");
    }

    public String menu(){
        return "\n\tMenu" +
                "1. Agregar diccionario" +
                "2. Leer oracion" +
                "3. Salir";
    }

    public static BinaryTree readWords(String path) throws FileNotFoundException, IOException {
        File file = new File(path);
        FileReader fileReader = new FileReader(file);
        BufferedReader bufferedReader = new BufferedReader(fileReader);

        String line;

        BinaryTree binaryTree = new BinaryTree();

        while ((line = bufferedReader.readLine()) != null) {
            String[] words = line.split(", ");
            System.out.println(words[0]);
            String englishWord = words[0];
            String spanishWord = words[1];
            Association association = new Association(englishWord, spanishWord);
            binaryTree.insert(association);
        }

        return binaryTree;

    }

}
