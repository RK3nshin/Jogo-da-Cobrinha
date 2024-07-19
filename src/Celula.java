public class Celula {
    private   int Px , Py ;
    public Celula(int Px, int Py) {
        this.Px = Px;
        this.Py = Py;
    }
    public int getPx(){
        return  this.Px;
    }
    public int getPy(){
        return this.Py;
    }
    public void setPx(int Px){
        this.Px = Px;
    }
    public void setPy(int Py){
        this.Py = Py;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Celula celula = (Celula) obj;
        return Px == celula.Px && Py == celula.Py;
    }

    @Override
    public int hashCode() {
        int result = Integer.hashCode(Px);
        result = 31 * result + Integer.hashCode(Py);
        return result;
    }
}
