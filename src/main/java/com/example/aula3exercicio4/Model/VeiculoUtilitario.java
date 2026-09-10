package com.example.aula3exercicio4.Model;
public class VeiculoUtilitario extends Veiculo{
    public double valorPeso;
    private double pesoTransportado;

    public VeiculoUtilitario(String modeloVeiculo, double valorDiaria, double qtdDiasLocacao, double pesoTransportado) {
        super(modeloVeiculo, valorDiaria, qtdDiasLocacao, "Utilitário");
        this.pesoTransportado = pesoTransportado;
        this.valorPeso = this.pesoTransportado * 0.30;
    }

    @Override
    public double CalcularValor(){
        return (getValorDiaria() * getQtdDiasLocacao()) + valorPeso;
    }

    @Override
    public String toString(){
        return String.format(
                "\n Peso transportado: %.2f kg" +
                        "\n Adicional de peso: R$ %.2f",
                this.pesoTransportado,
                valorPeso
        ) + super.toString();
    }
}
