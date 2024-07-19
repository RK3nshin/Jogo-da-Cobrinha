
import java.util.LinkedList;

public class Snake {
    private int Velocidade = 10;
    private int TamanhoInicial = 3;
    public   Celula  Cabeca ;
    public   LinkedList<Celula> Corpo =  new LinkedList<>();



    public Snake(Celula PosicaoInicial, int TamanhoBloco) {
        for ( int i = 0; i < TamanhoInicial; i++){
          if(Corpo.isEmpty()){
            Cabeca = PosicaoInicial;
            Corpo.add(Cabeca);
          }else {
            Celula Temp = new Celula (Corpo.getLast().getPx()+ TamanhoBloco , Corpo.getLast().getPy());
            Corpo.add(Temp);
          }
        }
       
    }

    public int getVelocidade() {
        return Velocidade;
    }

    public void setVelocidade(int Velocidade) {
        this.Velocidade = Velocidade;
    }





    
}
