import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Random;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.Timer;


public class Tabuleiro extends JPanel implements ActionListener, KeyListener{

    private final int T_Altura, T_Largura;
    private final int TamanhoBloco = 30;
    private int Delay = 150;
    private Celula Comida =  new Celula(30, 30);
    private Snake Cobra; 
    private Timer timer;
    private Image ImagMaca;
    private int VelocidadeX = 1 , VelocidadeY = 0;
    Boolean inicio = true;
    

    public Tabuleiro(int Altura, int Largura) {
        this.T_Largura = Largura;
        this.T_Altura = Altura;
        this.Cobra = new Snake(new Celula(90, 90), this.TamanhoBloco);
        PosicionaComida();
        IniciarTabuleiro();
        initGame();

    }

    private  void IniciarTabuleiro(){
        setBackground(Color.black);
        setFocusable(true);
        setPreferredSize(new Dimension(this.T_Largura, this.T_Altura));
        addKeyListener(this);
        setFocusable(true);
    }

    private   void initGame(){
        System.out.println("Iniciando.....");
        timer = new Timer(Delay, this);
        timer.start();
    }

  

    protected void paintComponent (Graphics g){
        super.paintComponent(g);
        draw(g);

    

    }

    private  void PosicionaComida(){
        Random random = new Random() ;
        this.Comida.setPx(TamanhoBloco * random.nextInt(T_Largura/TamanhoBloco));
        this.Comida.setPy(TamanhoBloco * random.nextInt(T_Altura/TamanhoBloco));
        ImageIcon iia = new ImageIcon("resources/apple2.png");
        ImagMaca = iia.getImage();
    }
    private void draw(Graphics g){

        // Grid

        for(int i = 0 ; i < T_Altura /TamanhoBloco; i++){
            g.drawLine(i * TamanhoBloco, 0, i*TamanhoBloco, T_Altura);
            g.drawLine(0, i * TamanhoBloco, T_Largura, i* TamanhoBloco);
        }

        // Comida 
        g.drawImage(ImagMaca, Comida.getPx(), Comida.getPy(), this);


        // snake 
        g.setColor(Color.RED);
        g.fillRect(this.Cobra.Cabeca.getPx(), 
                    this.Cobra.Cabeca.getPy(),
                    TamanhoBloco, TamanhoBloco);

        g.setColor(Color.GREEN);
       
        for (int i = 1; i < this.Cobra.Corpo.size(); i++) {
         g.fillRect(this.Cobra.Corpo.get(i).getPx(), 
            this.Cobra.Corpo.get(i).getPy(),
            TamanhoBloco, TamanhoBloco);
    
        }
    }

    public void actionPerformed(ActionEvent e) {
        if (inicio) {
            Mover();
            Colissao();
            repaint();
        }
    }

    public void Mover(){
        
        for(Celula C: Cobra.Corpo){
            C.setPx(C.getPx()+ TamanhoBloco * VelocidadeX);
            C.setPy(C.getPy()+ TamanhoBloco * VelocidadeY);
        }
       
    }
    public void Colissao (){
        if(this.Cobra.Cabeca.equals(this.Comida)){
            this.Cobra.Corpo.add(new Celula(Comida.getPx(), Comida.getPy()));
            System.out.println(this.Cobra.Corpo.size());
            PosicionaComida();
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void keyReleased(KeyEvent e) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void keyPressed(KeyEvent e) {
        if((e.getKeyCode() == KeyEvent.VK_LEFT && VelocidadeX != 1)){
            VelocidadeX = -1;
            VelocidadeY =0;
        }
        if((e.getKeyCode() == KeyEvent.VK_RIGHT && VelocidadeX != -1)){
            VelocidadeX = 1;
            VelocidadeY =0;
        }
        if((e.getKeyCode()== KeyEvent.VK_UP &&  VelocidadeY != -1)){
            VelocidadeX = 0;
            VelocidadeY =-1;
        }
        if((e.getKeyCode() == KeyEvent.VK_DOWN &&  VelocidadeY !=1)){
            VelocidadeX = 0;
            VelocidadeY =1;
        }
    }

}

    

