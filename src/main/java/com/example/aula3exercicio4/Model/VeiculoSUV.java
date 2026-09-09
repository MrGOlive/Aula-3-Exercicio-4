package com.example.aula3exercicio4.Model;

public class VeiculoSUV extends Veiculo{
    public VeiculoSUV(String modeloVeiculo, double valorDiaria, double qtdDiasLocacao) {
        super(modeloVeiculo, valorDiaria, qtdDiasLocacao, "SUV");
    }
    public boolean temProtecao;
    public double taxaProtecao;

    @Override
    public double CalcularValor(){
        if (temProtecao = true){
            taxaProtecao = 25;
        }else {
            taxaProtecao = 0;
        }
        return (getQtdDiasLocacao() * (getValorFinal() * 1.15)) + (getQtdDiasLocacao() * taxaProtecao);
    }
}
