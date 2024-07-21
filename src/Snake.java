
import java.util.ArrayList;

public class Snake {
    private int Velocidade = 10;
    public   Celula  Cabeca ;
    public   ArrayList<Celula> Corpo =  new ArrayList<Celula>();



    public Snake(Celula PosicaoInicial, int TamanhoBloco) {
            Cabeca = PosicaoInicial;
            Celula Temp = new Celula (Cabeca.getPx()+ TamanhoBloco , Cabeca.getPy());
            Corpo.add(Temp);
    }

    public int getVelocidade() {
        return Velocidade;
    }

    public void setVelocidade(int Velocidade) {
        this.Velocidade = Velocidade;
    }





    
}
