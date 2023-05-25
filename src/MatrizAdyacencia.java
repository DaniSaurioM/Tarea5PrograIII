import javax.swing.*;

public class MatrizAdyacencia {
    int Matriz[][];
    int tamaño;

    public MatrizAdyacencia(int tamaño) {
        Matriz = new int[tamaño][tamaño];
        this.tamaño = tamaño;
        // inicializar matriz en 0
        for (int i = 0; i < tamaño; i++) {
            for (int j = 0; j < tamaño; j++) {
                Matriz[i][j] = 0;
            }

        }
    }

    // metodo ingresar datos a la matriz

    public void definirMatriz(int pos1, int pos2) {

            Matriz[pos1 - 1][pos2 - 1] = 1;
            System.out.println("Vertice agregado correctamente");

    }
    public boolean existeVertice (int pos1, int pos2){
        if(Matriz[pos1 - 1][pos2 - 1] == 1){
            return false;
        }
        return true;
    }

    public boolean validarMatriz() {
        int rowCount = Matriz.length;
        int columnCount = Matriz[0].length;
        int[] cF = new int[rowCount]; // Contador de unos por fila
        int[] cC = new int[columnCount];

        for (int i = 0; i < tamaño; i++) {
            for (int j = 0; j < tamaño; j++) {
                if (Matriz[i][j] == 1) {
                    cF[i]++;
                    cC[j]++;
                }
            }
        }
        // Verificar si al menos hay un uno en cada fila y columna
        for (int i = 0; i < rowCount; i++) {
            if (cF[i] == 0) {
                return false; // Falta al menos un uno en la fila i
            }
        }

        for (int j = 0; j < columnCount; j++) {
            if (cC[j] == 0) {
                return false; // Falta al menos un uno en la columna j
            }
        }



        return true; // Todos los requisitos cumplidos

    }

    public  void imprimirMatriz(){

            JFrame frame = new JFrame("Graph Visualizer");
            GraphVisualizer graphVisualizer = new GraphVisualizer(Matriz);
            frame.add(graphVisualizer);
            frame.setSize(500, 500);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setVisible(true);

    }

}
