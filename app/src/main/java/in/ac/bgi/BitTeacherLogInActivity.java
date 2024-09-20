package in.ac.bgi;

import android.content.Intent;
import android.os.Bundle;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.util.Patterns;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;



public class BitTeacherLogInActivity extends AppCompatActivity {

    private TextView teacherlogintext;
    private EditText Email;
    private EditText password;
    private Button forgetpassword;
    private Button login;
    private Button signup;
    private Button teacher;
    private Button admin;
    boolean  passwordView;
    private FirebaseAuth mAuth;
    private FirebaseUser currentUser;

    @Override
    protected void onStart() {
        super.onStart();
        currentUser = mAuth.getCurrentUser();
        if (currentUser != null) {
            Intent intent = new Intent(getApplicationContext(),BitBranchActivity.class);
            startActivity(intent);
            finish();
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bit_teacher_log_in);
        mAuth = FirebaseAuth.getInstance();

        teacherlogintext = findViewById(R.id.teacherlogintext);
        Email = findViewById(R.id.TeacherLoginEmailAddress);
        password = findViewById(R.id.TeacherLoginPassword);
        forgetpassword = (Button)findViewById(R.id.TeacherLoginForgetPassword);
        login = (Button)findViewById(R.id.TeacherLoginbtn);
        signup = (Button) findViewById(R.id.TeacherLoginSignup);
        teacher=(Button)findViewById(R.id.teacherloginteacherbtn);
        admin =(Button)findViewById(R.id.TeacherLogindminBtn);
    }
}