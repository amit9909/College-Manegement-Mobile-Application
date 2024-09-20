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

public class BitLogInActivity extends AppCompatActivity  {
    private TextView studentlogintext;
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
        setContentView(R.layout.activity_bit_log_in);
        mAuth = FirebaseAuth.getInstance();

        studentlogintext = findViewById(R.id.studentlogintext);
        Email = findViewById(R.id.StudentLoginEmailAddress);
        password = findViewById(R.id.StudentLoginPassword);
        forgetpassword = (Button)findViewById(R.id.StudentLoginForgetPassword);
        login = (Button)findViewById(R.id.StudentLoginbtn);
        signup = (Button) findViewById(R.id.StudentLoginSignup);
        teacher=(Button)findViewById(R.id.studentloginteacherbtn);
        admin =(Button)findViewById(R.id.StudentLogindminBtn);

        password.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                final int Right=2;
                if (motionEvent.getAction()==MotionEvent.ACTION_UP){
                    if (motionEvent.getRawX()>=password.getRight()-password.getCompoundDrawables()[Right].getBounds().width()){
                        int selection=password.getSelectionEnd();
                        if (passwordView){
                            //set drawble img
                            password.setCompoundDrawablesRelativeWithIntrinsicBounds(0,0,R.drawable.password_hide,0);
                            //for hide password
                            password.setTransformationMethod(PasswordTransformationMethod.getInstance());
                            passwordView=false;
                        }else {
                            //set drawble img
                            password.setCompoundDrawablesRelativeWithIntrinsicBounds(0,0,R.drawable.password_view,0);
                            //for hide password
                            password.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
                            passwordView=true;
                        }
                        password.setSelection(selection);
                        return true;
                    }
                }
                return false;
            }
        });

        forgetpassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(BitLogInActivity.this,BitForgetPasswordActivity.class));
                finish();
            }
        });

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String email = Email.getText().toString().trim();
                String pass = password.getText().toString().trim();

                if(email.isEmpty()){
                    Toast.makeText(BitLogInActivity.this,"Email is requried",Toast.LENGTH_SHORT).show();
                }
                if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()){
                    Toast.makeText(BitLogInActivity.this,"Invalid Email",Toast.LENGTH_SHORT).show();
                }
                if (pass.isEmpty()){
                    Toast.makeText(BitLogInActivity.this,"Password is requried",Toast.LENGTH_SHORT).show();
                }
                if (pass.length()<8){
                    Toast.makeText(BitLogInActivity.this,"Minimum Password Length is 8 words",Toast.LENGTH_SHORT).show();
                }
                else {
                    LoginUser();
                }
            }

            private void LoginUser(){
                mAuth.signInWithEmailAndPassword(Email.getText().toString(), password.getText().toString())
                        .addOnCompleteListener( new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                if (task.isSuccessful()){
                                    Toast.makeText(getApplicationContext(),"LogIn Successful",Toast.LENGTH_SHORT).show();
                                    startActivity(new Intent(getApplicationContext(),BitStudentMainActivity.class));
                                    finish();
                                }
                                else {
                                    Toast.makeText(BitLogInActivity.this,"Error :"+task.getException().getMessage(),Toast.LENGTH_SHORT).show();
                                }
                            }
                        });
            }
        });



        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(BitLogInActivity.this,BitSignUpActivity.class);
                startActivity(intent);
            }
        });

        admin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(BitLogInActivity.this,AdminStudentIdCollectionActivity.class);
                startActivity(intent);
            }
        });

    }

}