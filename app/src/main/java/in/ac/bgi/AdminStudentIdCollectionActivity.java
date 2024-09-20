package in.ac.bgi;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.Query;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;
import java.util.List;

public class AdminStudentIdCollectionActivity extends AppCompatActivity {
     RecyclerView recyclerView;
     ArrayList<Model> dataList;
     FirebaseFirestore fstore;
     MyAdapter adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_student_id_collection);

        fstore=FirebaseFirestore.getInstance();
        recyclerView=(RecyclerView) findViewById(R.id.recview);

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        dataList=new ArrayList<>();

        adapter=new MyAdapter(dataList);
        recyclerView.setAdapter(adapter);

        fstore.collection("Student").orderBy("name", Query.Direction.ASCENDING).get()
                .addOnSuccessListener(new OnSuccessListener<QuerySnapshot>() {
                    @Override
                    public void onSuccess(QuerySnapshot queryDocumentSnapshots) {
                        List<DocumentSnapshot> list=queryDocumentSnapshots.getDocuments();
                        for (DocumentSnapshot d:list){
                            Model obj=d.toObject(Model.class);
                            dataList.add(obj);
                        }
                        adapter.notifyDataSetChanged();
                    }
                });

    }
}