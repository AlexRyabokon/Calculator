package com.example.pochinator;

import javafx.fxml.FXML;
import javafx.scene.control.Label;


import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;


public class Controller {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button btn_1;

    @FXML
    private Button btn_2;

    @FXML
    private Button btn_3;

    @FXML
    private Button btn_plus;

    @FXML
    private Button btn_4;

    @FXML
    private Button btn_5;

    @FXML
    private Button btn_6;

    @FXML
    private Button btn_minus;

    @FXML
    private Button btn_7;

    @FXML
    private Button btn_8;

    @FXML
    private Button btn_9;

    @FXML
    private Button btn_divide;

    @FXML
    private Button btn_sqr;

    @FXML
    private Button btn_zero;

    @FXML
    private Button btn_result;

    @FXML
    private Button btn_mltpl;

    @FXML
    private Label label_field;

    @FXML
    private Button btn_clr;

    @FXML
    private Button btn_pos_neg;

    @FXML
    private Button btn_comma;

    private String str_num = "";
    private String choise = "";
    private double firstNum;


    @FXML
    void initialize() {
        btn_zero.setOnAction(event -> {
            addNumber(0);
        });

        btn_1.setOnAction(event -> {
            addNumber(1);
        });

        btn_2.setOnAction(event -> {
            addNumber(2);
        });

        btn_3.setOnAction(event -> {
            addNumber(3);
        });

        btn_4.setOnAction(event -> {
            addNumber(4);
        });

        btn_5.setOnAction(event -> {
            addNumber(5);
        });

        btn_6.setOnAction(event -> {
            addNumber(6);
        });

        btn_7.setOnAction(event -> {
            addNumber(7);
        });

        btn_8.setOnAction(event -> {
            addNumber(8);
        });

        btn_9.setOnAction(event -> {
            addNumber(9);
        });

        btn_plus.setOnAction(event -> {
            matchAction("+");
        });

        btn_minus.setOnAction(event -> {
            matchAction("-");
        });

        btn_mltpl.setOnAction(event -> {
            matchAction("*");
        });

        btn_divide.setOnAction(event -> {
            matchAction("/");
        });

        btn_sqr.setOnAction(event -> {
            matchAction("s");
        });

        btn_result.setOnAction(event -> {
            if (this.choise == "+" || this.choise == "-"
                    || this.choise == "/" || this.choise == "*" || this.choise != "sqr") {
                resultMethod();
            }
        });
        btn_comma.setOnAction(event -> {
            if (!this.str_num.contains(".")) {
                this.str_num += ".";
                label_field.setText(str_num);
            }
        });

        btn_pos_neg.setOnAction(event -> {
            if (this.str_num != "") {
                double num = Double.parseDouble(this.str_num) * -1;
                this.str_num = Double.toString(num);
                label_field.setText(str_num);
            }
        });

        btn_clr.setOnAction(event -> {
            label_field.setText("0");
            this.str_num = "";
            this.firstNum = 0;
            this.choise = "A";
        });

    }

    void resultMethod() {
        double res = 0;

        switch (this.choise) {
            case "+":
                res = this.firstNum + Double.parseDouble(this.str_num);
                break;
            case "-":
                res = this.firstNum - Double.parseDouble(this.str_num);
                break;
            case "*":
                res = this.firstNum * Double.parseDouble(this.str_num);
                break;

            case "s":
                res = Math.pow(this.firstNum, Double.parseDouble(this.str_num));
                break;

            case "/":
                if (Double.parseDouble(this.str_num) != 0) {
                    res = this.firstNum / Double.parseDouble(this.str_num);
                    break;
                } else {
                    res = 0;
                    break;
                }

        }

        label_field.setText(Double.toString(res));
        this.str_num = "";
        this.choise = "A";
        this.firstNum = 0;
    }

    void addNumber(int number) {
        this.str_num += Integer.toString(number);
        label_field.setText(str_num);
    }

    void matchAction(String choise) {
        if (this.choise != "+" && this.choise != "-" && this.choise != "*" &&
                this.choise != "/" && this.choise != "sqr") {
            this.firstNum = Double.parseDouble(this.str_num);
            if (choise.equals("s")) {
                label_field.setText("sqr");
            } else {
                label_field.setText(choise);
            }

            this.str_num = "";
            this.choise = choise;
        }

    }
}