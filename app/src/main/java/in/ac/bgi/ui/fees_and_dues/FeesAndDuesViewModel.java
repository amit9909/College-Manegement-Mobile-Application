package in.ac.bgi.ui.fees_and_dues;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class FeesAndDuesViewModel extends ViewModel {

    private final MutableLiveData<String> mText;

    public FeesAndDuesViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is gallery fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}