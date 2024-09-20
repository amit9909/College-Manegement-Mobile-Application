package in.ac.bgi;



import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;

public class BitForgetPasswordActivity extends AppCompatActivity {

    private TextView forgottext;
    private EditText Email ;
    private Button confirm;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bit_forget_password);

        Email=findViewById(R.id.BitStudentForgetPasswordEmailAddress);
        confirm = findViewById(R.id.BitStudentForgetPasswordbtn);

        confirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String email = Email.getText().toString();

                if (email.isEmpty()){
                    Toast.makeText(BitForgetPasswordActivity.this,"Please Enter your Email",Toast.LENGTH_SHORT).show();
                }
                if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()){
                    Toast.makeText(BitForgetPasswordActivity.this,"Invalid Email",Toast.LENGTH_SHORT).show();
                }
                else {
                    forgetPassword();
                }
            }
        });
    }

    private void forgetPassword() {
        FirebaseAuth auth = FirebaseAuth.getInstance();
        auth.sendPasswordResetEmail(Email.getText().toString()).addOnCompleteListener(new OnCompleteListener<Void>() {
            @Override
            public void onComplete(@NonNull Task<Void> task) {
                if (task.isSuccessful()){
                    Toast.makeText(BitForgetPasswordActivity.this,"Check Your Email",Toast.LENGTH_SHORT).show();
                    startActivity(new Intent(BitForgetPasswordActivity.this, BitLogInActivity.class));
                    finish();
                }
                else {
                    Toast.makeText(BitForgetPasswordActivity.this,"Error:"+task.getException().getMessage(),Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}