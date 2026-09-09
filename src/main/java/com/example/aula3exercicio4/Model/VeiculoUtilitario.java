package com.example.aula3exercicio4.Model;

public class VeiculoUtilitario extends Veiculo{
    public VeiculoUtilitario(String modeloVeiculo, double valorDiaria, double qtdDiasLocacao) {
        super(modeloVeiculo, valorDiaria, qtdDiasLocacao, "Utilitário");
    }
    public double pesoTransportado;

    public double valorPeso = pesoTransportado * 0.30;

    @Override
    public double CalcularValor(){
        return (getValorDiaria() * getQtdDiasLocacao()) + valorPeso;
    }

}
