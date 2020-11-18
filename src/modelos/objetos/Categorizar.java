package modelos.objetos;

/**
 *
 * @author esmeralda
 */
public class Categorizar {
    Categoria categoria1;
    HechoHistorico hecho;

    public Categorizar(Categoria categoria1, HechoHistorico hecho) {
        this.categoria1 = categoria1;
        this.hecho = hecho;
    }

    public Categoria getCategoria1() {
        return categoria1;
    }

    public void setCategoria1(Categoria categoria1) {
        this.categoria1 = categoria1;
    }

    public HechoHistorico getHecho() {
        return hecho;
    }

    public void setHecho(HechoHistorico hecho) {
        this.hecho = hecho;
    }
    
}
