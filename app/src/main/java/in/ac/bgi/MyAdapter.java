package in.ac.bgi;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public  class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {
    ArrayList<Model> datalist;
    private int position;

    public MyAdapter(ArrayList<Model> datalist) {

        this.datalist = datalist;
    }

    @NonNull
    @Override
    public MyAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view=LayoutInflater.from(parent.getContext()).inflate(R.layout.single__row,parent,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyAdapter.MyViewHolder holder, int position) {
        this.position = position;
        holder.name.setText(datalist.get(position).getName());
        holder.email.setText(datalist.get(position).getEmail());
        holder.roll.setText(datalist.get(position).getRoll());

        holder.name.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(holder.name.getContext(),AdminViewStudentAccountActivity.class);
                intent.putExtra("viewname",datalist.get(position).getName());
                intent.putExtra("viewemail",datalist.get(position).getEmail());
                intent.putExtra("viewroll",datalist.get(position).getRoll());

                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                holder.name.getContext().startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return datalist.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView name,email,roll;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            name=itemView.findViewById(R.id.temp_name);
            email=itemView.findViewById(R.id.temp_email);
            roll=itemView.findViewById(R.id.temp_roll_number);
        }
    }
}
