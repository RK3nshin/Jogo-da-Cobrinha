import javax.swing.JFrame;

public class App {
    public static void main(String[] args) {
        int TabuleiroAltura = 600;
        int TabuleiroLargura = TabuleiroAltura;

        Tabuleiro jogo = new Tabuleiro(TabuleiroAltura,TabuleiroLargura);

        JFrame frame = new JFrame("Snake Game");
        frame.setVisible(true);
        frame.setSize(TabuleiroAltura,TabuleiroLargura);
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);
        
        frame.add(jogo);
        frame.pack();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // foco e eventos de teclado
        jogo.requestFocus();
    }
}
