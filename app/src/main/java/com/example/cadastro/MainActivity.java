package com.example.cadastro;

import static android.widget.AdapterView.*;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.ResourceBundle;

import android.widget.AdapterView.OnItemSelectedListener;

public class MainActivity extends AppCompatActivity implements  View.OnClickListener {

    private EditText nomeEditText;
    private EditText telefoneEditText;
    private EditText emailEditText;
    private CheckBox checadoCheckbox;
    private RadioButton masculinoRadioButton;
    private RadioButton femininoRadioButton;
    private EditText cidadeEditText;
    private Spinner opcoesSpinner;
    private Button botaoSalvar;
    private Button botaoLimpar;
    Cliente objCliente = new Cliente();
    private String uf="";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        botaoSalvar = findViewById(R.id.botaoSalvar);
        botaoLimpar = findViewById(R.id.botaoLimpar);
        botaoSalvar.setOnClickListener(this);
        botaoLimpar.setOnClickListener(this);


        nomeEditText = findViewById(R.id.nomeEt);
        telefoneEditText = findViewById(R.id.telefoneEt);
        emailEditText = findViewById(R.id.emailEt);
        checadoCheckbox = findViewById(R.id.checadoCb);
        masculinoRadioButton = findViewById(R.id.masculinoRb);
        femininoRadioButton = findViewById(R.id.femininoRb);
        cidadeEditText = findViewById(R.id.cidadeEt);
        opcoesSpinner = findViewById(R.id.opcoesSp);
    }

    @Override
    public void onClick(View view) {
        StringBuilder sb = new StringBuilder();

        sb.append(nomeEditText.getText().toString());
        sb.append("\n");
        sb.append(telefoneEditText.getText().toString());
        sb.append("\n");
        sb.append(emailEditText.getText().toString());
        sb.append("\n");
        sb.append(checadoCheckbox.isChecked() ? "aceita" : "não aceita");
        sb.append("\n");
        sb.append(masculinoRadioButton.isChecked() ? "masculino" : "feminino");
        sb.append("\n");
        sb.append(cidadeEditText.getText().toString());
        sb.append("\n");
        String uf = ((TextView) opcoesSpinner.getSelectedView()).getText().toString();
        sb.append(uf);
        sb.append("\n");


        if (view.getId() == R.id.botaoSalvar) {
            Toast.makeText(this, sb.toString(), Toast.LENGTH_LONG).show();
        }

        if (view.getId() == R.id.botaoLimpar) {
            objCliente.setNome(null);
            objCliente.setTelefone(null);
            objCliente.setEmail(null);
            objCliente.setLista(false);
            objCliente.setSexo(null);
            masculinoRadioButton.setActivated(true);
            objCliente.setCidade(null);

            nomeEditText.setText("");
            telefoneEditText.setText("");
            emailEditText.setText("");
            cidadeEditText.setText("");

            nomeEditText.requestFocus();
        }

    }
}