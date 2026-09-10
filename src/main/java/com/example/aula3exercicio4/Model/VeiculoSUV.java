package com.example.aula3exercicio4.Model;

public class VeiculoSUV extends Veiculo{
    private boolean temProtecao;
    public double taxaProtecao;
    public double totalProtecao;

    public VeiculoSUV(String modeloVeiculo, double valorDiaria, double qtdDiasLocacao, boolean temProtecao) {
        super(modeloVeiculo, valorDiaria, qtdDiasLocacao, "SUV");
        this.temProtecao = temProtecao;
    }

    @Override
    public double CalcularValor(){
        if (temProtecao == true){
            taxaProtecao = 25;
            totalProtecao = taxaProtecao * getQtdDiasLocacao();
        }else {
            taxaProtecao = 0;
        }
        return (getQtdDiasLocacao() * (getValorFinal() * 1.15)) + totalProtecao;
    }

    @Override
    public String toString(){
        return String.format(
                "\n Proteção:          %s (Total: R$ %.2f)",
                this.temProtecao ? "Sim" : "Não",
                totalProtecao
        ) + super.toString();
    }
}
