//package in.ac.bgi.ui.library;
//
//import androidx.lifecycle.ViewModel;
//
//public class LibraryViewModel extends ViewModel {
//    // TODO: Implement the ViewModel
//}

package in.ac.bgi.ui.library;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class LibraryViewModel extends ViewModel {

    private final MutableLiveData<String> mText;

    public LibraryViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("this is incomplete");
    }

    public LiveData<String> getText() {
        return mText;
    }
}