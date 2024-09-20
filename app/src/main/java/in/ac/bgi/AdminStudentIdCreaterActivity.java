package in.ac.bgi;

import android.content.Intent;
import android.os.Bundle;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.util.Log;
import android.util.Patterns;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;

public class AdminStudentIdCreaterActivity extends AppCompatActivity {
    private static final String TAG = "AdminStudentIdCreaterAc";

    private static final String KEY_NAME = "name";
    private static final String KEY_EMAIL = "email";
    private static final String KEY_ROLL_NUMBER = "roll";
    private static final String KEY_PASSWORD =  "password";
    boolean passwordView;

    private EditText addName ;
    private EditText addEmail;
    private EditText addRollNo;
    private EditText addPassword;

    private Button saveBtn ;
    private FirebaseAuth mAuth;
    private FirebaseFirestore fstore;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_student_id_creater);

        mAuth =FirebaseAuth.getInstance();
        fstore = FirebaseFirestore.getInstance();

        addName=(EditText)findViewById(R.id.add_name);
        addEmail=(EditText)findViewById(R.id.add_email);
        addRollNo=(EditText)findViewById(R.id.add_roll_number);
        addPassword=(EditText)findViewById(R.id.add_password);
        saveBtn=(Button)findViewById(R.id.add_new_student_btn);

        addPassword.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                final int Right=2;
                if (motionEvent.getAction()==MotionEvent.ACTION_UP){
                    if (motionEvent.getRawX()>=addPassword.getRight()-addPassword.getCompoundDrawables()[Right].getBounds().width()){
                        int selection=addPassword.getSelectionEnd();
                        if (passwordView){
                            //set drawble img
                            addPassword.setCompoundDrawablesRelativeWithIntrinsicBounds(0,0,R.drawable.password_hide,0);
                            //for hide password
                            addPassword.setTransformationMethod(PasswordTransformationMethod.getInstance());
                            passwordView=false;
                        }else {
                            //set drawble img
                            addPassword.setCompoundDrawablesRelativeWithIntrinsicBounds(0,0,R.drawable.password_view,0);
                            //for hide password
                            addPassword.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
                            passwordView=true;
                        }
                        addPassword.setSelection(selection);
                        return true;
                    }
                }
                return false;
            }
        });



        saveBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name = addName.getText().toString().trim();
                String rollno = addRollNo.getText().toString().trim();
                String email = addEmail.getText().toString().trim();
                String pass = addPassword.getText().toString().trim();


                if (name.isEmpty()){
                    Toast.makeText(AdminStudentIdCreaterActivity.this,"Fullname is required",Toast.LENGTH_SHORT).show();
                }

                if(rollno.isEmpty()){
                    Toast.makeText(AdminStudentIdCreaterActivity.this,"Roll Number is requried",Toast.LENGTH_SHORT).show();
                }
                if(rollno.length()<10){
                    Toast.makeText(AdminStudentIdCreaterActivity.this,"Invalid Roll Number",Toast.LENGTH_SHORT).show();
                    return;
                }
                if(email.isEmpty()){
                    Toast.makeText(AdminStudentIdCreaterActivity.this,"Email is requried",Toast.LENGTH_SHORT).show();
                }
                if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()){
                    Toast.makeText(AdminStudentIdCreaterActivity.this,"Invalid Email",Toast.LENGTH_SHORT).show();
                }
                if (pass.isEmpty()){
                    Toast.makeText(AdminStudentIdCreaterActivity.this,"Password is requried",Toast.LENGTH_SHORT).show();
                }
                if (pass.length()<8){
                    Toast.makeText(AdminStudentIdCreaterActivity.this,"Minimum Password Length is 8 words",Toast.LENGTH_SHORT).show();
                }
                else{
                    registerUser();
                }
            }
            public void registerUser(){
                mAuth.createUserWithEmailAndPassword(addEmail.getText().toString(),addPassword.getText().toString())
                        .addOnCompleteListener(AdminStudentIdCreaterActivity.this, new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                if (task.isSuccessful()){
                                    saveDetail();
                                    Toast.makeText(AdminStudentIdCreaterActivity.this,"Id Successfully Created",Toast.LENGTH_LONG).show();
                                    startActivity(new Intent(AdminStudentIdCreaterActivity.this,AdminStudentIdCollectionActivity.class) );
                                    finish();
                                }
                                else {
                                    Toast.makeText(AdminStudentIdCreaterActivity.this,"Error",Toast.LENGTH_LONG).show();
                                }
                            }
                        });
            }
        });

    }



    public void saveDetail(){
        String name = addName.getText().toString();
        String email = addEmail.getText().toString();
        String roll = addRollNo.getText().toString();

        Map<String,Object> item = new HashMap<>();
        item.put(KEY_NAME,name);
        item.put(KEY_EMAIL,email);
        item.put(KEY_ROLL_NUMBER,roll);

        fstore.collection("Student").add(item).addOnSuccessListener(new OnSuccessListener<DocumentReference>() {
            @Override
            public void onSuccess(DocumentReference documentReference) {
                Toast.makeText(AdminStudentIdCreaterActivity.this, "Inserted Successfully", Toast.LENGTH_SHORT).show();
            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                Toast.makeText(AdminStudentIdCreaterActivity.this, "Failed, Please Try Again", Toast.LENGTH_SHORT).show();
                Log.d(TAG, e.toString());
            }
        });
    }
}