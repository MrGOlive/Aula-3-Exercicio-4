package com.example.aula3exercicio4.Model;

public class VeiculoHatch extends Veiculo{
    public String[] modeloshatch = {
        "VW GOL", "CV CELTA", "FIAT UNO","VW GOLF" , "CV KADETT", "FIAT TEMPRA"
    };

    public VeiculoHatch(String modeloVeiculo, double valorDiaria, double qtdDiasLocacao) {
        super(modeloVeiculo, valorDiaria, qtdDiasLocacao, "Hatch");
    }

    @Override
    public double CalcularValor(){
        return (getValorDiaria() * getQtdDiasLocacao());
    }

}
