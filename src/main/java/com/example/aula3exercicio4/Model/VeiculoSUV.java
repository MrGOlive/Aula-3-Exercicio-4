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
        return setValorFinal((getQtdDiasLocacao() * (getValorFinal() * 1.15)) + (getQtdDiasLocacao() * taxaProtecao));
    }

    @Override
    public String toString() {
        return String.format(
                "--------------------------------------------------\n" +
                        " Categoria:         %s\n" +
                        " Modelo:            %s\n" +
                        " Diária:            R$ %.2f\n" +
                        " Período:           %.0f dia(s)\n" +
                        " Seguro/Proteção:   %s\n" +
                        " Taxa de Proteção:  R$ %.2f\n" +
                        "--------------------------------------------------\n" +
                        " TOTAL A PAGAR:     R$ %.2f\n" +
                        "--------------------------------------------------",
                this.getCategoriaVeiculo(),
                this.getModeloVeiculo(),
                this.getValorDiaria(),
                this.getQtdDiasLocacao(),
                (this.temProtecao ? "Sim" : "Não"),
                (this.temProtecao ? this.taxaProtecao : 0.0),
                this.CalcularValor()
        );
    }
}
