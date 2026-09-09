package com.example.aula3exercicio4.Model;

public abstract class Veiculo {
    // DECLARANDO AS VARIÁVEIS DA CLASSE PAI
    private String modeloVeiculo;
    private double valorDiaria;
    private double qtdDiasLocacao;
    private String categoriaVeiculo;
    private double valorFinal;


    // CONSTRUTORES
    public Veiculo(String modeloVeiculo, double valorDiaria, double qtdDiasLocacao, String categoriaVeiculo) {
        this.modeloVeiculo = modeloVeiculo;
        this.valorDiaria = valorDiaria;
        this.qtdDiasLocacao = qtdDiasLocacao;
        this.categoriaVeiculo = categoriaVeiculo;
        this.modeloVeiculo = modeloVeiculo;
    }
        // MÉTODOS
        // CALCULAR VALOR FINAL A SER PAGO
        public abstract double CalcularValor();

        // MOSTRAR BONITINHO NO TO STRING
        @Override
        public String toString() {
            return String.format(
                    "\n--------------------------------------------------\n" +
                            " Categoria:         %s\n" +
                            " Modelo:            %s\n" +
                            " Diária:            R$ %.2f\n" +
                            " Período:           %.0f dia(s)\n" +
                            " Desconto/Acrésc:   Nenhum (Padrão)\n" +
                            "--------------------------------------------------\n" +
                            " TOTAL A PAGAR:     R$ %.2f\n" +
                            "--------------------------------------------------", categoriaVeiculo, // ou this.categoriaVeiculo se for protected na mãe
                    modeloVeiculo,    // ou this.modeloVeiculo
                    valorDiaria,
                    qtdDiasLocacao,
                    CalcularValor());
        }

    // GETTERS E SETTERS
    public String getModeloVeiculo() {
        return modeloVeiculo;
    }

    public void setModeloVeiculo(String modeloVeiculo) {
        this.modeloVeiculo = modeloVeiculo;
    }

    public double getValorDiaria() {
        return valorDiaria;
    }

    public void setValorDiaria(double valorDiaria) {
        this.valorDiaria = valorDiaria;
    }

    public double getQtdDiasLocacao() {
        return qtdDiasLocacao;
    }

    public void setQtdDiasLocacao(double qtdDiasLocacao) {
        this.qtdDiasLocacao = qtdDiasLocacao;
    }

    public String getCategoriaVeiculo() {
        return categoriaVeiculo;
    }

    public void setCategoriaVeiculo(String categoriaVeiculo) {
        this.categoriaVeiculo = categoriaVeiculo;
    }

    public double getValorFinal() {
        return valorFinal;
    }

    public double setValorFinal(double valorFinal) {
        this.valorFinal = valorFinal;
        return valorFinal;
    }
}
