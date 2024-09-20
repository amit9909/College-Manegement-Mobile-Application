package in.ac.bgi.ui.attendence;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class AttendenceViewModel extends ViewModel {

    private final MutableLiveData<String> mText;

    public AttendenceViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is slideshow fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}