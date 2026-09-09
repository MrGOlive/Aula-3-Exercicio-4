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
        return setValorFinal(getValorDiaria() * getQtdDiasLocacao());
    }

    @Override
    public String toString() {
        return String.format(
                "--------------------------------------------------\n" +
                        " Categoria:         %s\n" +
                        " Modelo:            %s\n" +
                        " Diária:            R$ %.2f\n" +
                        " Período:           %.0f dia(s)\n" +
                        " Desconto/Acrésc:   Nenhum (Padrão)\n" +
                        "--------------------------------------------------\n" +
                        " TOTAL A PAGAR:     R$ %.2f\n" +
                        "--------------------------------------------------",
                this.getCategoriaVeiculo(), // ou this.categoriaVeiculo se for protected na mãe
                this.getModeloVeiculo(),    // ou this.modeloVeiculo
                this.getValorDiaria(),
                this.getQtdDiasLocacao(),
                this.CalcularValor()
        );
    }
}
