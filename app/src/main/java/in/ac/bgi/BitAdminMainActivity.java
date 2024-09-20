package in.ac.bgi;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.firestore.FirebaseFirestore;

public class BitAdminMainActivity extends AppCompatActivity {


    private FirebaseFirestore fstore;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bit_admin_main);

        fstore = FirebaseFirestore.getInstance();

    }
}