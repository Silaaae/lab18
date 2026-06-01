package com.example.lab18;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class MainViewModel extends ViewModel {

    private final MutableLiveData<Integer> count = new MutableLiveData<>(0);

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
        if (current != null) {
            count.setValue(current - 1);
        }
    }

    public void reset() {
        count.setValue(0);
    }
}
