import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Graphics;

public class GraphVisualizer extends JPanel {
    private int[][] MatrizAdyacencia;
    private int[][] Pesos;

    public GraphVisualizer(int[][] MatrizAdyacencia,int[][] Pesos) {
        this.MatrizAdyacencia = MatrizAdyacencia;
        this.Pesos = Pesos;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        // Obtener el número de nodos del grafo
        int numNodes = MatrizAdyacencia.length;

        // Calcular el tamaño y posición de los nodos en el panel
        int nodeRadius = 30;
        int centerX = getWidth() / 2;
        int centerY = getHeight() / 2;
        double angle = 2 * Math.PI / numNodes;

        // Dibujar los nodos y las aristas
        for (int i = 0; i < numNodes; i++) {
            int x = (int) (centerX + Math.cos(i * angle) * centerX * 0.8);
            int y = (int) (centerY + Math.sin(i * angle) * centerY * 0.8);

            // Dibujar el nodo
            g.drawOval(x - nodeRadius, y - nodeRadius, 2 * nodeRadius, 2 * nodeRadius);
            g.drawString("Nodo " + (i + 1), x - 20, y);

            // Dibujar las aristas
            for (int j = 0; j < numNodes; j++) {
                if (MatrizAdyacencia[i][j] > 0) {
                    int destX = (int) (centerX + Math.cos(j * angle) * centerX * 0.8);
                    int destY = (int) (centerY + Math.sin(j * angle) * centerY * 0.8);

                    g.drawLine(x, y, destX, destY);
                    // Mostrar el peso de la arista
                    g.drawString(String.valueOf(Pesos[i][j]), (x + destX) / 2, (y + destY) / 2 + 15);
                }
            }
        }
    }
}
