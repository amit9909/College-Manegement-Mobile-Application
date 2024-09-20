package in.ac.bgi;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class BitBranchActivity extends AppCompatActivity {

    private Button button1;
    private Button button2;
    private Button button3;
    private Button button4;
    private Button button5;
    private Button button6;
    private Button button7;
    private FirebaseAuth mAuth;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bit_branch);

        mAuth = FirebaseAuth.getInstance();
        // All Button
        button1 = (Button) findViewById(R.id.BitCSButton);
        button2 = (Button) findViewById(R.id.BitITButton);
        button3 = (Button) findViewById(R.id.BitAIMLButton);
        button4 = (Button) findViewById(R.id.BitDSButton);
        button5 = (Button) findViewById(R.id.BitCEButton);
        button6 = (Button) findViewById(R.id.BitMEButton);
        button7 = (Button) findViewById(R.id.BitECEButton);

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(BitBranchActivity.this,BitStudentMainActivity.class);
                startActivity(intent);
            }
        });

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(BitBranchActivity.this,BitStudentMainActivity.class);
                startActivity(intent);
            }
        });

        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(BitBranchActivity.this,BitStudentMainActivity.class);
                startActivity(intent);
            }
        });

        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(BitBranchActivity.this,BitStudentMainActivity.class);
                startActivity(intent);
            }
        });

        button5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(BitBranchActivity.this,BitStudentMainActivity.class);
                startActivity(intent);
            }
        });

        button6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(BitBranchActivity.this,BitStudentMainActivity.class);
                startActivity(intent);
            }
        });


        button7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(BitBranchActivity.this,BitStudentMainActivity.class);
                startActivity(intent);
            }
        });

    }


}
