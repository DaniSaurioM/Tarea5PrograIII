import javax.swing.*;

public class MatrizAdyacencia {
    int Matriz[][];
    int Pesos[][];
    int tamaño;

    public MatrizAdyacencia(int tamaño) {
        Matriz = new int[tamaño][tamaño];
        Pesos = new int[tamaño][tamaño];
        this.tamaño = tamaño;
        // inicializar matriz en 0
        for (int i = 0; i < tamaño; i++) {
            for (int j = 0; j < tamaño; j++) {
                Matriz[i][j] = 0;
                Pesos[i][j] = 0;
            }

        }
    }

    // metodo ingresar datos a la matriz

    public void definirMatriz(int pos1, int pos2,int peso) {
        Matriz[pos1 - 1][pos2 - 1] = 1;
        Pesos[pos1 - 1][pos2 - 1] = peso;
        System.out.println("Vertice agregado correctamente");

    }
    public boolean existeVertice (int pos1, int pos2){
        if(Matriz[pos1 - 1][pos2 - 1] == 1){
            return false;
        } else if (Matriz[pos2 - 1][pos1 - 1] == 1) {
            return false;
        }
        return true;
    }

    public boolean validarMatriz() {

        boolean[] visitados = new boolean[tamaño];

        dfs(0, visitados); // Comenzar el recorrido DFS desde el vértice 0

        // Verificar si todos los vértices han sido visitados
        for (boolean visitado : visitados) {
            if (!visitado) {
                return false; // Grafo no conectado
            }
        }

        return true; // Grafo conectado
    }

    private void dfs(int vertice, boolean[] visitados) {
        visitados[vertice] = true;

        for (int i = 0; i < tamaño; i++) {
            if (Matriz[vertice][i] == 1 && !visitados[i]) {
                dfs(i, visitados);
            }
        }
    }


    public  void imprimirMatriz(){

            JFrame frame = new JFrame("Grafo con matriz de adyacencia");
            GraphVisualizer graphVisualizer = new GraphVisualizer(Matriz,Pesos);
            frame.add(graphVisualizer);
            frame.setSize(500, 500);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setVisible(true);

    }

}
