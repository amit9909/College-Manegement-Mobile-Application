package in.ac.bgi;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.firestore.FirebaseFirestore;

public class AdminUpdateStudentDataActivity extends AppCompatActivity {
    private static final String TAG = "AdminUpdateStudentDataA";

    private static final String KEY_NAME = "name";
    private static final String KEY_EMAIL = "email";
    private static final String KEY_ROLL_NUMBER = "roll";

    private EditText addName ;
    private EditText addEmail;
    private EditText addRollNo;

    private Button updateBtn;

    private FirebaseFirestore fstore;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_update_student_data);

        fstore=FirebaseFirestore.getInstance();

        addName=(EditText)findViewById(R.id.ud_name);
        addEmail=(EditText)findViewById(R.id.ud_email);
        addRollNo=(EditText)findViewById(R.id.ud_roll_number);
        updateBtn=(Button) findViewById(R.id.update_student_btn);
    }
}