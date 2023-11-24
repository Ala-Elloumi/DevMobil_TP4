package com.example.ala_elloumi_mesure_glycemie.vue;
// Les importation necessaires
import androidx.appcompat.app.AppCompatActivity;
import android.annotation.SuppressLint;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import com.example.ala_elloumi_mesure_glycemie.R;
import com.example.ala_elloumi_mesure_glycemie.controller.Controller;

public class MainActivity extends AppCompatActivity {
    // Declaration des variable
    private TextView tvAge,tvresult;
    private SeekBar sbAge;
    private RadioButton rbtOui;
    private EditText etValeur;
    private Button btnConsulter;

    // Instance du classe Controller
    /*private final Controller controller = new Controller();*/
    Controller controller = Controller.getInstance();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // Appel de la methode init()
        init();

        // Action sur le SeekBar
        sbAge.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                // Afficher les informations utiles dans la console de débogage
                Log.i("information","onProgressChange"+progress);
                // Mettre à jour le TextView (tvAge) avec la nouvelle valeur de la SeekBar
                tvAge.setText("Votre Age : "+progress);
            }
            @Override
            public void onStartTrackingTouch(SeekBar seekBar) { }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) { }
        });

        /*consulterBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                calculer(v);
            }
            }*/

        // Action sur le bouton  consulter
        btnConsulter.setOnClickListener(view -> {
            int age=sbAge.getProgress();
            String val= etValeur.getText().toString();
            boolean verifAge=age!=0,verifValeur=!val.isEmpty();
            boolean valeur = rbtOui.isChecked();
            if (verifAge && verifValeur) {
                float valeurMesure = Float.parseFloat(val);
                // Creation d'un patient avec les données inserer en utilisant la methode createPatient() du classe Controller
                controller.createPatient(age, valeur, valeurMesure);
                // Récuperation du resultat apres le calcule avec la methode getReponse()
                String reponse = controller.getReponse();
                // Affichage du resultat au Patient
                tvresult.setText(reponse);
            } else {
                if (!verifAge) {
                    Toast.makeText(MainActivity.this, "Veuillez verifier votre Age !", Toast.LENGTH_SHORT).show();
                }
                if (!verifValeur) {
                    Toast.makeText(MainActivity.this, "Veuillez verifier votre Valeur !", Toast.LENGTH_LONG).show();
                }
            }
        });
    }
    private void init()
    {
        // Initialisation des attributs
        tvAge=findViewById(R.id.tvAge);
        sbAge=findViewById(R.id.sbAge);
        rbtOui=findViewById(R.id.rbtOui);
        etValeur=findViewById(R.id.etValeur);
        btnConsulter=findViewById(R.id.btnConsulter);
        tvresult=findViewById(R.id.tvresult);
    }
}



