package com.example.lab18;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

/**
 * CounterViewModel : Le "cerveau" persistant de votre application.
 * Il gère la logique du compteur et protège les données contre les rotations d'écran.
 */
public class CounterViewModel extends ViewModel {

    // Source de vérité privée
    private final MutableLiveData<Integer> count = new MutableLiveData<>(0);

    /**
     * Expose le compteur en lecture seule pour l'interface.
     */
    public LiveData<Integer> getCount() {
        return count;
    }

    public void increment() {
        Integer current = count.getValue();
        if (current != null) {
            count.setValue(current + 1);
        }
    }

    public void decrement() {
        Integer current = count.getValue();
        // Optionnel : On évite de descendre sous zéro pour rester "zen"
        if (current != null && current > 0) {
            count.setValue(current - 1);
        }
    }

    public void reset() {
        count.setValue(0);
    }
}
