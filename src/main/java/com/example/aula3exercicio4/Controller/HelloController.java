package com.example.aula3exercicio4.Controller;

import com.example.aula3exercicio4.Model.Veiculo;
import com.example.aula3exercicio4.Model.VeiculoHatch;
import com.example.aula3exercicio4.Model.VeiculoSUV;
import com.example.aula3exercicio4.Model.VeiculoUtilitario;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class HelloController {
    @FXML
    private TextField idNomeCliente;
    @FXML
    private TextField idModeloVeiculo;
    @FXML
    private TextField idValorDiaria;
    @FXML
    private TextField idQtdDiasLocacao;
    @FXML
    private ComboBox<String> idCategoriaVeiculo;
    @FXML
    private TextArea idResumo;

    // SETANDO O COMBOBOX
    @FXML
    public void initialize(){
        idCategoriaVeiculo.getItems().addAll("Hatch", "SUV", "Utilitário");
    }

    public void CalcularValor(){
        //  TRANSFORMANDO TUDO EM VARIÁVEL
        String nomeCliente = idNomeCliente.getText();
        String modeloVeiculo = idModeloVeiculo.getText();
        String strValorDiaria = idValorDiaria.getText();
        String strDiasLocacao = idQtdDiasLocacao.getText();
        String categoriaVeiculo = idCategoriaVeiculo.getValue();
        Veiculo veiculo = null;

        // VERIFICANDO SE NÃO TEM NENHUM CAMPO VAZIO
        if (nomeCliente.isEmpty() || modeloVeiculo.isEmpty() || strValorDiaria.isEmpty() || strDiasLocacao.isEmpty() || categoriaVeiculo.isEmpty()){
            idResumo.setText("Todos os campos devem ser preenchidos.");
            return;
        }

        // TRANSFORMA OS NUMÉRICOS EM DOUBLE
        double valorDiaria = Double.parseDouble(strValorDiaria);
        double qtdDiasLocacao = Double.parseDouble(strDiasLocacao);

        switch (categoriaVeiculo){
            case "Hatch":
                veiculo = new VeiculoHatch(modeloVeiculo, valorDiaria, qtdDiasLocacao);
                break;
            case "SUV":
                veiculo = new VeiculoSUV(modeloVeiculo, valorDiaria, qtdDiasLocacao);
                break;
            case "Utilitário":
                veiculo = new VeiculoUtilitario(modeloVeiculo, valorDiaria, qtdDiasLocacao);
                break;
            default:
                idResumo.setText("ERRO: CATEGORIA VEÍCULO NÃO CORRESPONDE");
                break;
        }

    }

    public void ApresentarResumo(){
        idResumo.setText(toString());
    }
}
