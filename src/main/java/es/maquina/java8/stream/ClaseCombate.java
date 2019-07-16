package es.maquina.java8.stream;

public class ClaseCombate {

    private String nombreClase;
    private String tipoArma;
    private int vidaBase;

    protected String getNombreClase() {
	return nombreClase;
    }

    protected void setNombreClase(String nombreClase) {
	this.nombreClase = nombreClase;
    }

    protected String getTipoArma() {
	return tipoArma;
    }

    protected void setTipoArma(String tipoArma) {
	this.tipoArma = tipoArma;
    }

    public int getVidaBase() {
	return vidaBase;
    }

    public void setVidaBase(int vidaBase) {
	this.vidaBase = vidaBase;
    }

    @Override
    public String toString() {
	return "nombreClase: " + nombreClase + ", tipoArma: " + tipoArma + ", vidaBase: " + vidaBase;
    }

}
