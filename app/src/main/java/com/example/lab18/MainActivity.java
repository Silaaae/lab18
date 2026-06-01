package com.example.lab18;

import android.os.Bundle;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.lifecycle.ViewModelProvider;

import com.google.android.material.button.MaterialButton;

/**
 * MainActivity : Votre compagnon de progression personnel.
 * Cette version refactorisée utilise Architecture Components (ViewModel & LiveData)
 * pour une expérience fluide, humaine et sans perte de données lors des rotations.
 */
public class MainActivity extends AppCompatActivity {

    private CounterViewModel viewModel;
    private TextView tvCount;
    private MaterialButton btnIncrement, btnDecrement, btnReset;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // 1. Activation de l'immersion totale (Edge-to-Edge) pour un look moderne
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        // 2. Gestion intelligente des barres système (StatusBar et NavigationBar)
        // On s'assure que notre interface "zen" ne soit pas coupée par les éléments du système
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        // 3. Liaison avec les composants de l'interface graphique
        initViews();

        // 4. Initialisation du ViewModel (Le "cerveau" persistant de l'écran)
        // On demande à Android de nous fournir l'instance qui survit aux rotations
        viewModel = new ViewModelProvider(this).get(CounterViewModel.class);

        // 5. La Magie du LiveData : L'UI réagit d'elle-même aux changements de données
        // Correction : On utilise getCount() pour correspondre au nom défini dans CounterViewModel.java
        viewModel.getCount().observe(this, count -> {
            tvCount.setText(String.valueOf(count));
        });

        // 6. Configuration des interactions utilisateurs
        setupListeners();
    }

    /**
     * Initialise les vues de l'activité en les liant au fichier XML.
     */
    private void initViews() {
        tvCount = findViewById(R.id.tvCount);
        btnIncrement = findViewById(R.id.btnIncrement);
        btnDecrement = findViewById(R.id.btnDecrement);
        btnReset = findViewById(R.id.btnReset);
    }

    /**
     * Connecte les boutons aux actions logiques définies dans le ViewModel.
     */
    private void setupListeners() {
        // Simple et efficace : l'Activité délègue toute la logique au ViewModel
        btnIncrement.setOnClickListener(v -> viewModel.increment());
        btnDecrement.setOnClickListener(v -> viewModel.decrement());
        btnReset.setOnClickListener(v -> viewModel.reset());
    }
}
