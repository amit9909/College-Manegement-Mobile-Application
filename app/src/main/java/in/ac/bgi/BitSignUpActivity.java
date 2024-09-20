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
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;

public class BitSignUpActivity extends AppCompatActivity {

    private TextView Signup;
    private EditText name,roll,Email,password;
    private Button register;
    boolean  passwordView;


    private FirebaseAuth mAuth;
    private FirebaseFirestore fstore;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bit_sign_up);

        mAuth = FirebaseAuth.getInstance();
        fstore = FirebaseFirestore.getInstance();

        Signup = (TextView) findViewById(R.id.BitStudentSignuptext);
        name =(EditText) findViewById(R.id.BitStudentSgnupStudentName);
        roll = (EditText) findViewById(R.id.BitStudentSignUpStudentRollNumber);
        Email =(EditText) findViewById(R.id.BitStudentSignUpStudentEmailAddress);
        password =(EditText) findViewById(R.id.BitStudentSignUpStudentPassword);
        register= (Button) findViewById(R.id.BitStudentSignUpStudentSignUpbtn);




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



        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String user = name.getText().toString().trim();
                String rollno = roll.getText().toString().trim();
                String email = Email.getText().toString().trim();
                String pass = password.getText().toString().trim();

                if (user.isEmpty()){
                    Toast.makeText(BitSignUpActivity.this,"Fullname is required",Toast.LENGTH_SHORT).show();
                }

                if(rollno.isEmpty()){
                    Toast.makeText(BitSignUpActivity.this,"Roll Number is requried",Toast.LENGTH_SHORT).show();
                }
                if(rollno.length()<10){
                    Toast.makeText(BitSignUpActivity.this,"Invalid Roll Number",Toast.LENGTH_SHORT).show();
                    return;
                }
                if(email.isEmpty()){
                    Toast.makeText(BitSignUpActivity.this,"Email is requried",Toast.LENGTH_SHORT).show();
                }
                if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()){
                    Toast.makeText(BitSignUpActivity.this,"Invalid Email",Toast.LENGTH_SHORT).show();
                }
                if (pass.isEmpty()){
                    Toast.makeText(BitSignUpActivity.this,"Password is requried",Toast.LENGTH_SHORT).show();
                }
                if (pass.length()<8){
                    Toast.makeText(BitSignUpActivity.this,"Minimum Password Length is 8 words",Toast.LENGTH_SHORT).show();
                }
                else{
                    registerUser();
                }
            }
            private void registerUser(){
                mAuth.createUserWithEmailAndPassword(Email.getText().toString(),password.getText().toString())
                        .addOnCompleteListener(BitSignUpActivity.this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()){
                            insertData();
                            Toast.makeText(BitSignUpActivity.this,"User Created",Toast.LENGTH_SHORT).show();
                            startActivity(new Intent(BitSignUpActivity.this,BitBranchActivity.class));
                            finish();
                        }
                        else {
                            Toast.makeText(BitSignUpActivity.this,"Error :"+task.getException().getMessage(),Toast.LENGTH_SHORT).show();
                        }
                    }
                });
            }
        });

    }
    private void insertData(){
        Map<String,String> item = new HashMap<>();
        item.put("email",Email.getText().toString());
        item.put("eame",name.getText().toString());
        item.put("roll",roll.getText().toString());

        fstore.collection("Student").add(item).addOnCompleteListener(new OnCompleteListener<DocumentReference>() {
            @Override
            public void onComplete(@NonNull Task<DocumentReference> task) {
                Email.setText("");
                name.setText("");
                roll.setText("");
                Toast.makeText(getApplicationContext(),"Inserted Successfully",Toast.LENGTH_LONG).show();
            }
        });
    }

    @Override
    protected void onStart(){
        super.onStart();
        if (mAuth.getCurrentUser()!=null){
            startActivity(new Intent(BitSignUpActivity.this,BitStudentMainActivity.class));
            finish();
        }
    }
}