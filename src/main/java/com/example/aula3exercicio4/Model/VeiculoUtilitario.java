package com.example.aula3exercicio4.Model;

public class VeiculoUtilitario extends Veiculo{
    public VeiculoUtilitario(String modeloVeiculo, double valorDiaria, double qtdDiasLocacao) {
        super(modeloVeiculo, valorDiaria, qtdDiasLocacao, "Utilitário");
    }
    public double pesoTransportado;

    @Override
    public double CalcularValor(){
        return setValorFinal((getValorDiaria() * getQtdDiasLocacao()) + (pesoTransportado * 0.30));
    }

    @Override
    public String toString() {
        double taxaPeso = this.pesoTransportado * 0.30;

        return String.format(
                "--------------------------------------------------\n" +
                        " Categoria:         %s\n" +
                        " Modelo:            %s\n" +
                        " Diária Base:       R$ %.2f\n" +
                        " Período:           %.0f dia(s)\n" +
                        " Carga:             %.2f kg\n" +
                        " Adicional Carga:   R$ %.2f (R$ 0,30/kg)\n" +
                        "--------------------------------------------------\n" +
                        " TOTAL A PAGAR:     R$ %.2f\n" +
                        "--------------------------------------------------",
                this.getCategoriaVeiculo(), // ou this.categoriaVeiculo se for protected
                this.getModeloVeiculo(),    // ou this.modeloVeiculo se for protected
                this.getValorDiaria(),
                this.getQtdDiasLocacao(),
                this.pesoTransportado,
                taxaPeso,
                this.CalcularValor()
        );
    }
}
