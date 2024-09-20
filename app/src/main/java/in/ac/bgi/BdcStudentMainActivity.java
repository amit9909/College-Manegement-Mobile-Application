package in.ac.bgi;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.google.android.material.navigation.NavigationView;
import com.google.android.material.snackbar.Snackbar;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.FirebaseFirestore;

import in.ac.bgi.databinding.ActivityBitStudentMainBinding;

public class BdcStudentMainActivity extends AppCompatActivity  {

    private static final String KEY_NAME = "name";

    private AppBarConfiguration mAppBarConfiguration;
    private ActivityBitStudentMainBinding binding;
    private FirebaseAuth mAuth;
    private FirebaseFirestore fstore;
    private FirebaseUser currentUser;





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mAuth = FirebaseAuth.getInstance();
        fstore = FirebaseFirestore.getInstance();
        currentUser = mAuth.getCurrentUser();





        binding = ActivityBitStudentMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        setSupportActionBar(binding.appBarBitStudentMain.toolbar);
        binding.appBarBitStudentMain.fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
        DrawerLayout drawer = binding.drawerLayout;
        NavigationView navigationView = binding.navView;
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        mAppBarConfiguration = new AppBarConfiguration.Builder(
                R.id.nav_home, R.id.nav_notes, R.id.nav_labs_and_projects, R.id.nav_tutorials_and_assingments, R.id.nav_attendence, R.id.nav_result, R.id.nav_fees_and_dues ,  R.id.nav_library)
                .setOpenableLayout(drawer)
                .build();
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_bit_student_main);
        NavigationUI.setupActionBarWithNavController(this, navController, mAppBarConfiguration);
        NavigationUI.setupWithNavController(navigationView, navController);

        View header = navigationView.getHeaderView(0);
        TextView headerName = header.findViewById(R.id.nav_name_view);
        TextView headerEmail = header.findViewById(R.id.nav_email_view);

//        headerName.setText();
        headerEmail.setText(currentUser.getEmail());
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        getMenuInflater().inflate(R.menu.bit_student_main, menu);
        return true;
    }

    @Override
    public boolean onSupportNavigateUp() {
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_bit_student_main);
        return NavigationUI.navigateUp(navController, mAppBarConfiguration)
                || super.onSupportNavigateUp();
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_settings: {
                Toast.makeText(getApplicationContext(), "not construsted", Toast.LENGTH_SHORT).show();
                break;
            }
            case R.id.action_log_out: {
                mAuth.signOut();
                Intent intent = new Intent(BdcStudentMainActivity.this, BitLogInActivity.class);
                startActivity(intent);
                break;
            }
        }


        return super.onOptionsItemSelected(item);
    }



}
