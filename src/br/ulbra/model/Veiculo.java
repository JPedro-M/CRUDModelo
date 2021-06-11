
package br.ulbra.model;

/**
 * @author João
 */
public class Veiculo {
    private int id;
    private String marca;
    private String modelo;
    private int ano;
    private String cor;
    private String placa;
    private String motor;
    private String km;
    private Double valor;
    
    public Veiculo(){
        
    }

    public int getId() {
        return id;
    }
    
    public void setId(int id) {
        this.id = id;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public int getAno() {
        return ano;
    }

    public void setAno(int ano) {
        this.ano = ano;
    }

    public String getCor() {
        return cor;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public String getMotor() {
        return motor;
    }

    public void setMotor(String motor) {
        this.motor = motor;
    }

    public String getKm() {
        return km;
    }

    public void setKm(String km) {
        this.km = km;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

    @Override
    public String toString() {
        return "Usuario{" + "id=" + id + ", marca=" + marca + ", modelo=" + modelo + ", ano=" + ano + ", cor=" + cor + "placa=" + placa + "motor=" + motor + "km=" + km + "valor=" + valor + '}';
    }
    
}
