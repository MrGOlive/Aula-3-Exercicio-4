package com.example.aula3exercicio4.Controller;

import com.example.aula3exercicio4.Model.Veiculo;
import com.example.aula3exercicio4.Model.VeiculoHatch;
import com.example.aula3exercicio4.Model.VeiculoSUV;
import com.example.aula3exercicio4.Model.VeiculoUtilitario;
import javafx.fxml.FXML;
import javafx.scene.control.*;

import javax.swing.text.View;
import java.util.Objects;

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
    private ComboBox<String> idTemTaxa;
    @FXML
    private TextField idPesoTransportado;
    @FXML
    private Button idApresentarResumo;
    @FXML
    private TextArea idResumo;

    // SETANDO O COMBOBOX
    @FXML
    public void initialize(){
        idCategoriaVeiculo.getItems().addAll("Hatch", "SUV", "Utilitário");
        idTemTaxa.getItems().addAll("Sim", "Não");
        idTemTaxa.setVisible(false);
        idTemTaxa.setManaged(false);
        idPesoTransportado.setVisible(false);
        idPesoTransportado.setManaged(false);

        idCategoriaVeiculo.setOnAction(event -> {
            String selecionado = idCategoriaVeiculo.getValue();

            if (selecionado == "SUV"){
                idTemTaxa.setVisible(true);
                idTemTaxa.setManaged(true);
                idPesoTransportado.setVisible(false);
                idPesoTransportado.setManaged(false);
            }else if (selecionado == "Utilitário"){
                idPesoTransportado.setVisible(true);
                idPesoTransportado.setManaged(true);
                idTemTaxa.setVisible(false);
                idTemTaxa.setManaged(false);
            }else {
                idTemTaxa.setVisible(false);
                idTemTaxa.setManaged(false);
                idPesoTransportado.setVisible(false);
                idPesoTransportado.setManaged(false);
            }
        });
    }

    @FXML
    public void CalcularValor(){
        //  TRANSFORMANDO TUDO EM VARIÁVEL
        String nomeCliente = idNomeCliente.getText();
        String modeloVeiculo = idModeloVeiculo.getText();
        String strValorDiaria = idValorDiaria.getText();
        String strDiasLocacao = idQtdDiasLocacao.getText();
        String categoriaVeiculo = idCategoriaVeiculo.getValue();
        String temTaxa = idTemTaxa.getValue();
        String strPesoTransportado = idPesoTransportado.getText();
        double valorDiaria;
        double qtdDiasLocacao;
        double pesoTransportado;
        Veiculo veiculo = null;

        // VERIFICANDO SE NÃO TEM NENHUM CAMPO VAZIO
        if (nomeCliente.isEmpty() || modeloVeiculo.isEmpty() || strValorDiaria.isEmpty() || strDiasLocacao.isEmpty() || categoriaVeiculo.isEmpty()){
            idResumo.setText("Todos os campos devem ser preenchidos.");
            return;
        }

        // VERIFICA SE ENTRADA DO USUÁRIO É NUMÉRICA E TRANSFORMA OS NUMÉRICOS EM DOUBLE
        try {
            valorDiaria = Double.parseDouble(strValorDiaria);
        } catch (NumberFormatException e) {
            idResumo.setText("Valor da diária inválido.");
            return;
        }
        try {
            qtdDiasLocacao = Double.parseDouble(strDiasLocacao);
        } catch (NumberFormatException e) {
            idResumo.setText("Quantidade de dias de locação inválido.");
            return;
        }

        switch (categoriaVeiculo){
            case "Hatch":
                veiculo = new VeiculoHatch(modeloVeiculo, valorDiaria, qtdDiasLocacao);
                break;
            case "SUV":
                if (temTaxa == null){
                    idResumo.setText("Todos os campos devem ser preenchidos.");
                    return;
                }
                if (temTaxa.equals("Sim")){
                    veiculo = new VeiculoSUV(modeloVeiculo, valorDiaria, qtdDiasLocacao, true);
                }else if (temTaxa.equals("Não")){
                    veiculo = new VeiculoSUV(modeloVeiculo, valorDiaria, qtdDiasLocacao, false);
                }
                break;
            case "Utilitário":
                try {
                    pesoTransportado = Double.parseDouble(strPesoTransportado);
                } catch (NumberFormatException e) {
                    idResumo.setText("Quantidade de peso transportado precisa ser numérico");
                    return;
                }
                veiculo = new VeiculoUtilitario(modeloVeiculo, valorDiaria, qtdDiasLocacao, pesoTransportado);
                break;
            default:
                idResumo.clear();
                idNomeCliente.clear();
                idModeloVeiculo.clear();
                idQtdDiasLocacao.clear();
                idValorDiaria.clear();
                idResumo.setText("ERRO: CATEGORIA VEÍCULO NÃO CORRESPONDE");
                break;
        }
        idResumo.clear();
        idNomeCliente.clear();
        idModeloVeiculo.clear();
        idQtdDiasLocacao.clear();
        idValorDiaria.clear();
        idPesoTransportado.clear();
        idCategoriaVeiculo.getSelectionModel().clearSelection();
        idResumo.setText(veiculo.toString());
    }


}
