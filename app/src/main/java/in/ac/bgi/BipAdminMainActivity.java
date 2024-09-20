package in.ac.bgi;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.google.firebase.firestore.FirebaseFirestore;

public class BipAdminMainActivity extends AppCompatActivity {
    private FirebaseFirestore fstore;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bip_admin_main);

        fstore = FirebaseFirestore.getInstance();
    }
}