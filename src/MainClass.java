
import java.util.Scanner;

public class MainClass {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);

        System.out.println("De cuantos vertices necesita el grafo");
        int tamaño =scanner.nextInt();

        MatrizAdyacencia matrizAdyacencia =new MatrizAdyacencia(tamaño);

        boolean salir =false;
        boolean puedoSalir=false;
        do {
            System.out.println("------------MENU----------");

            System.out.println("1. Agregar arista");
            System.out.println("2. Imprimir grafo");
            System.out.println("Seleccione una opcion");
            int opcion = scanner.nextInt();
            switch (opcion) {
                case 1:
                    System.out.println("De que vertice:");
                    int ver1 = scanner.nextInt();
                    System.out.println("a que vertice :");
                    int ver2 = scanner.nextInt();

                    if (ver1 == ver2) {
                        System.out.println("no puede autoreferenciar vertices");

                    } else {
                        boolean valido = matrizAdyacencia.existeVertice(ver1,ver2);
                        if (valido) {
                            System.out.println("Se agrega vertice");
                            matrizAdyacencia.definirMatriz(ver1, ver2);
                        }else{
                            System.out.println("Vertice ya existe");

                        }
                    }
                    break;
                case 2:
                    boolean valido = matrizAdyacencia.validarMatriz();
                    if (valido) {
                        matrizAdyacencia.imprimirMatriz();
                        puedoSalir=true;
                    }else{
                        System.out.println("Matriz incompleta");
                        puedoSalir=false;
                    }
                    break;
                default:
                    System.out.println("Escoge una opcion valida :)");
                    puedoSalir=false;
                    break;
            }
            if (!puedoSalir){
                System.out.println("aun no puedes salir del programa");
            }else{
                System.out.println("Quieres salir");
                System.out.println("Escribe 's' o 'S'");
                char si = scanner.next().charAt(0);
                if (si=='s'||si=='S'){
                    salir=true;
                }else{
                    System.out.println("no valido");
                    salir=false;
                }
            }
        }while (!salir);

    }
}
