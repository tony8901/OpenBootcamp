import java.io.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Vector;

public class Main {

    //revisar la sugerencia de usar StringBuilder
    public static String reverse(String texto) {
        String respuesta = "";
        for (int i = texto.length() - 1; i >= 0; i--) {
            respuesta += texto.charAt(i);
        }
        return respuesta;
    }

    public static int DividePorCero(int x, int y) throws ArithmeticException {
        return x / y;
    }

    public static void usarMetodoCopy() throws IOException {
        InputStream fileIn = new FileInputStream("fileIn.txt");
        copy(fileIn, new FileOutputStream("fileOut.txt"));
    }

    public static void copy(InputStream fileIn, OutputStream fileOut) throws IOException {
        fileOut.write(fileIn.readAllBytes());
    }

    public static void main(String[] args) {
        System.out.println("Invertir cadena: ");
        System.out.println(reverse("Hola Mundo") + "\n");

        System.out.println("1. Crea un array unidimensional de Strings y recórrelo, mostrando únicamente sus valores:");
        String[] stringArray = {"valor1", "valor2", "valor3", "valor4"};
        for (String i : stringArray) System.out.print(i + " ");
        System.out.println("\n");

        System.out.println("2. Crea un array bidimensional de enteros y recórrelo, mostrando la posición y el valor " +
                "de cada elemento en ambas dimensiones:");
        int[][] intBiArray = new int[2][4];
        intBiArray[0][0] = 1;
        intBiArray[0][1] = 2;
        intBiArray[0][2] = 3;
        intBiArray[0][3] = 4;
        intBiArray[1][0] = 5;
        intBiArray[1][1] = 6;
        intBiArray[1][2] = 7;
        intBiArray[1][3] = 8;

        for (int i = 0; i < intBiArray.length; i++) {
            for (int j = 0; j < intBiArray[i].length; j++) {
                System.out.println("Position [" + i + "][" + j + "] = " + intBiArray[i][j]);
            }
        }
        System.out.println("\n");

        System.out.println("3. Crea un Vector del tipo de dato que prefieras, y añádele 5 elementos. " +
                "Elimina el 2o y 3er elemento y muestra el resultado final.");
        Vector<Integer> vector = new Vector<>();
        vector.add(1);
        vector.add(2);
        vector.add(3);
        vector.add(4);
        vector.add(5);
        System.out.println("Vector Original: " + vector);
        vector.remove(1);
        vector.remove(1);
        System.out.println("Resultado: " + vector);
        System.out.println("\n");

        System.out.println("4. Indica cuál es el problema de utilizar un Vector con la capacidad por " +
                "defecto si tuviésemos 1000 elementos para ser añadidos al mismo.");
        Vector<String> stringVector = new Vector<>();
        System.out.println("Capacidad del vector por defecto: " + stringVector.capacity());
        for (int i = 0; i < 12; i++) {
            stringVector.add(String.valueOf(i));
        }
        System.out.println("Capacidad del vector despues de capacidad inicial + 1: " + stringVector.capacity());
        System.out.println("Despues de 1 000 elementos tendriamos reservada en memoria una capacidad de 2 000.");
        System.out.println("\n");

        System.out.println("5. Crea un ArrayList de tipo String, con 4 elementos. Cópialo en una LinkedList. " +
                "Recorre ambos mostrando únicamente el valor de cada elemento.");
        ArrayList<String> arrayList = new ArrayList<>();
        arrayList.add("valor1");
        arrayList.add("valor2");
        arrayList.add("valor3");
        arrayList.add("valor4");
        LinkedList<String> linkedList = new LinkedList<>(arrayList);
        System.out.print("arrayList: ");
        for (String i : arrayList) System.out.print(i + " ");
        System.out.print("\n");
        System.out.print("linkedList: ");
        for (String i : linkedList) System.out.print(i + " ");
        System.out.println("\n");

        System.out.println("6. Crea un ArrayList de tipo int, y, utilizando un bucle rellénalo con elementos\n" +
                " 1..10. A continuación, con otro bucle, recórrelo y elimina los numeros pares. Por último, vuelve\n" +
                " a recorrerlo y muestra el ArrayList final. Si te atreves, puedes hacerlo en menos pasos, siempre\n" +
                " y cuando cumplas el primer for de relleno.");
        ArrayList<Integer> arrayList1 = new ArrayList<>();
        int elemento = 1;
        while (elemento <= 10) {
            arrayList1.add(elemento);
            elemento++;
        }
        System.out.println("arrayList original: " + arrayList1);
        for (int i = 0; i < arrayList1.size(); i++) {
            if (arrayList1.get(i) % 2 == 0) arrayList1.remove(i);
        }
        System.out.println("arrayList sin numeros pares: " + arrayList1);
        System.out.println("\n");

        System.out.println("7. Crea una función DividePorCero. Esta, debe generar una excepción \n" +
                "(\"throws\") a su llamante del tipo ArithmeticException que será capturada por su llamante\n" +
                " (desde main, por ejemplo). Si se dispara la excepción, mostraremos el mensaje \"Esto \n" +
                "no puede hacerse\". Finalmente, mostraremos en cualquier caso: \"Demo de código\".\n");
        int x = 1;
        int y = 0;
        try {
            double divide = DividePorCero(x, y);
            System.out.println(divide);
        } catch (ArithmeticException e) {
            System.out.println("Esto no puede hacerse: " + e.getMessage());
        } finally {
            System.out.println("Demo de código");
        }
        System.out.println("\n");

        System.out.println("8. Utilizando InputStream y PrintStream, crea una función que reciba dos\n " +
                "parámetros: \"fileIn\" y \"fileOut\". La tarea de la función será realizar la copia del \n" +
                "fichero dado en el parámetro \"fileIn\" al fichero dado en \"fileOut\".");
        try {
            usarMetodoCopy();
        } catch (FileNotFoundException e) {
            System.out.println("Fichero no encontrado: " + e.getMessage());
            try {
                System.out.println("Creando nuevo fichero...");
                String holaMundo = "Hola Mundo!";
                OutputStream newFile = new FileOutputStream("fileIn.txt");
                newFile.write(holaMundo.getBytes());
                usarMetodoCopy();
            } catch (IOException ex) {
                System.out.println("Definitivamente hubo un error: " + ex.getMessage());
            }
        } catch (IOException e) {
            System.out.println("Error al copiar el fichero: " + e.getMessage());
        }

    }


}
