package com.example.calculadoranew;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import net.objecthunter.exp4j.Expression;
import net.objecthunter.exp4j.ExpressionBuilder;

public class MainActivity extends AppCompatActivity  implements View.OnClickListener{

    //inicializa todos os componentes
    private Button zero, one, two, three, four, five, six, seven, eight, nine, point, limpar, parenteses,
            percent, divisao, multiply, equals, plus, minous;
    private ImageView backspace;
    private TextView content, result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        iniciarComponentes();

        //recupera o clicklistener de todos os botões neste contexto
        zero.setOnClickListener(this);
        one.setOnClickListener(this);
        two.setOnClickListener(this);
        three.setOnClickListener(this);
        four.setOnClickListener(this);
        five.setOnClickListener(this);
        six.setOnClickListener(this);
        seven.setOnClickListener(this);
        eight.setOnClickListener(this);
        nine.setOnClickListener(this);
        point.setOnClickListener(this);
        parenteses.setOnClickListener(this);
        percent.setOnClickListener(this);
        divisao.setOnClickListener(this);
        multiply.setOnClickListener(this);
        plus.setOnClickListener(this);
        minous.setOnClickListener(this);

        limpar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                content.setText("");
                result.setText("");
            }
        });

        backspace.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                TextView content = findViewById(R.id.content);
                String string = content.getText().toString();

                if(!string.isEmpty()){

                    byte var0 = 0;
                    //pega a largura dos caracteres e diminui em -1, apagando apenas 1
                    int var1 = string.length()-1;
                    String contents = string.substring(var0, var1);
                    content.setText(contents);
                }
            }
        });

        equals.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               try {
                   Expression expressao = new ExpressionBuilder(content.getText().toString()).build();
                   //faz todos os tratamentos necessarios
                   double resultado = expressao.evaluate();
                   long longResult = (long) resultado;

                   if(resultado == (double) longResult){
                       result.setText((CharSequence) String.valueOf(longResult));
                   }else{
                       result.setText((CharSequence) String.valueOf(resultado));
                   }
               }catch (Exception e){
                   result.setText("Erro!");
               }

            }
        });

        percent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    Expression expressao = new ExpressionBuilder(content.getText().toString()).build();

                    double resultado = expressao.evaluate() / 100;
                    long longResult = (long) resultado;

                    if (resultado == (double) longResult) {
                        result.setText((CharSequence) String.valueOf(longResult));
                    } else {
                        result.setText((CharSequence) String.valueOf(resultado));
                    }
                }catch (Exception e){
                    result.setText("Error!");
                }
            }
        });
    }
    //da aos componentes suas devidas referencias
    private void iniciarComponentes(){
        zero = findViewById(R.id.zero);
        one = findViewById(R.id.one);
        two = findViewById(R.id.two);
        three = findViewById(R.id.three);
        four = findViewById(R.id.four);
        five = findViewById(R.id.five);
        six = findViewById(R.id.six);
        seven = findViewById(R.id.seven);
        eight = findViewById(R.id.eight);
        nine = findViewById(R.id.nine);
        equals = findViewById(R.id.equals);
        limpar = findViewById(R.id.limpar);
        point = findViewById(R.id.point);
        divisao = findViewById(R.id.divisao);
        multiply = findViewById(R.id.multiply);
        minous = findViewById(R.id.minous);
        percent = findViewById(R.id.percent);
        backspace = findViewById(R.id.backspace);
        parenteses = findViewById(R.id.parenteses);
        plus = findViewById(R.id.plus);
        result = findViewById(R.id.result);
        content = findViewById(R.id.content);
    }
    public void Acrescentar(String string, boolean limpar_dados) {

        if (result.getText().equals("")) {
            content.setText(" ");
        }
        if (limpar_dados) {
            result.setText(" ");
            content.append(string);
        } else {
            content.append(result.getText());
            content.append(string);
            result.setText(" ");
        }
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.zero:
                Acrescentar("0", true);
                break;
            case R.id.one:
                Acrescentar("1", true);
                break;
            case R.id.two:
                Acrescentar("2", true);
                break;
            case R.id.three:
                Acrescentar("3", true);
                break;
            case R.id.four:
                Acrescentar("4", true);
                break;
            case R.id.five:
                Acrescentar("5", true);
                break;
            case R.id.six:
                Acrescentar("6", true);
                break;
            case R.id.seven:
                Acrescentar("7", true);
                break;
            case R.id.eight:
                Acrescentar("8", true);
                break;
            case R.id.nine:
                Acrescentar("9", true);
                break;
            case R.id.divisao:
                Acrescentar("/", true);
                break;
            case R.id.multiply:
                Acrescentar("*", true);
                break;
            case R.id.minous:
                Acrescentar("-", true);
                break;
            case R.id.percent:
                Acrescentar("%", true);
                break;
            case R.id.point:
                Acrescentar(".", true);
                break;
            case R.id.parenteses:
                Acrescentar("(", true);
                break;
            case R.id.plus:
                Acrescentar("+", true);
                break;
        }
    }
}