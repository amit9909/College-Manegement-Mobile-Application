package in.ac.bgi;

import androidx.appcompat.app.AppCompatActivity;

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

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.FirebaseFirestore;

public class BitTeacherSignUpActivity extends AppCompatActivity {

    private TextView Signup;
    private EditText name, phone, Email, password;
    private Button register;
    boolean passwordView;


    private FirebaseAuth mAuth;
    private FirebaseFirestore fstore;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bit_teacher_sign_up);

        mAuth = FirebaseAuth.getInstance();
        fstore = FirebaseFirestore.getInstance();

        Signup = (TextView) findViewById(R.id.BitTeacherSignuptext);
        name = (EditText) findViewById(R.id.BitTeacherName);
        phone = (EditText) findViewById(R.id.BitTeacherPhoneNumber);
        Email = (EditText) findViewById(R.id.BitTeacherEmailAddress);
        password = (EditText) findViewById(R.id.BitTeacherPassword);
        register = (Button) findViewById(R.id.BitTeacherSignUpbtn);

        password.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                final int Right = 2;
                if (motionEvent.getAction() == MotionEvent.ACTION_UP) {
                    if (motionEvent.getRawX() >= password.getRight() - password.getCompoundDrawables()[Right].getBounds().width()) {
                        int selection = password.getSelectionEnd();
                        if (passwordView) {
                            //set drawble img
                            password.setCompoundDrawablesRelativeWithIntrinsicBounds(0, 0, R.drawable.password_hide, 0);
                            //for hide password
                            password.setTransformationMethod(PasswordTransformationMethod.getInstance());
                            passwordView = false;
                        } else {
                            //set drawble img
                            password.setCompoundDrawablesRelativeWithIntrinsicBounds(0, 0, R.drawable.password_view, 0);
                            //for hide password
                            password.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
                            passwordView = true;
                        }
                        password.setSelection(selection);
                        return true;
                    }
                }
                return false;
            }
        });

        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String user = name.getText().toString().trim();
                String phoneno = phone.getText().toString().trim();
                String email = Email.getText().toString().trim();
                String pass = password.getText().toString().trim();

                if (user.isEmpty()) {
                    Toast.makeText(BitTeacherSignUpActivity.this, "Fullname is required", Toast.LENGTH_SHORT).show();
                }

                if (phoneno.isEmpty()) {
                    Toast.makeText(BitTeacherSignUpActivity.this, "Roll Number is requried", Toast.LENGTH_SHORT).show();
                }
                if (phoneno.length() < 10) {
                    Toast.makeText(BitTeacherSignUpActivity.this, "Invalid Roll Number", Toast.LENGTH_SHORT).show();
                    return;
                }
                if (email.isEmpty()) {
                    Toast.makeText(BitTeacherSignUpActivity.this, "Email is requried", Toast.LENGTH_SHORT).show();
                }
                if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
                    Toast.makeText(BitTeacherSignUpActivity.this, "Invalid Email", Toast.LENGTH_SHORT).show();
                }
                if (pass.isEmpty()) {
                    Toast.makeText(BitTeacherSignUpActivity.this, "Password is requried", Toast.LENGTH_SHORT).show();
                }
                if (pass.length() < 8) {
                    Toast.makeText(BitTeacherSignUpActivity.this, "Minimum Password Length is 8 words", Toast.LENGTH_SHORT).show();
                }
//                else{
//                    registerUser();
//                }
            }
        });
    }
}

