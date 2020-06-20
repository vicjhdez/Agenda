package com.example.hernandez_victor_agenda;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView= findViewById(R.id.reciclerView);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(layoutManager);

        final List<ModelClass> modelClassList = new ArrayList<>();
        modelClassList.add(new ModelClass(R.drawable.image2,"Patricia Bogard ", "Sexo: Femenino \nFecha de Nacimiento : 13/03/1994 \nCarrera: TIC \nDireccion:  Santo Domingo \nLatitud = 18.5429307  \nLongitud = -69.8983276 "));
        modelClassList.add(new ModelClass(R.drawable.user2,"Starling Javier", "Sexo: Masculino \nFecha de Nacimiento : 15/04/2002 \nCarrera: Arquitectura \nDireccion:  Bonao \nLatitud = 18.9312068  \nLongitud = -70.4037102 "));
        modelClassList.add(new ModelClass(R.drawable.images,"Hanvan Sham ", "Sexo: Masculino \nFecha de Nacimiento : 30/06/1990 \nCarrera: Derecho \nDireccion:  Santo Domingo \nLatitud = 18.50967012955735  \nLongitud = -70.00893091061302 "));
        modelClassList.add(new ModelClass(R.drawable.user,"Juan Perez","Sexo: Masculino \nFecha de Nacimiento : 22/05/2000 \nCarrera: Medicina \nDireccion:  Santo Domingo \nLatitud = 18.50967012955735  \nLongitud = -70.00893091061302 "));

        Adapter adapter = new Adapter(modelClassList);
        recyclerView.setAdapter(adapter);
        adapter.notifyDataSetChanged();

        adapter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String title, body;
                int image;
                title=  modelClassList.get(recyclerView.getChildAdapterPosition(view)).getTitle();
                body=  modelClassList.get(recyclerView.getChildAdapterPosition(view)).getBody();
                image= modelClassList.get(recyclerView.getChildAdapterPosition(view)).getImageIcon();

                showInfo(title, body, image);
            }
        });
    }

    private void showInfo(String t, String b, int image){


        Intent window2 = new Intent(MainActivity.this, Information.class);
        window2.putExtra("Title", t);
        window2.putExtra("Body", b);
        window2.putExtra("Ima", image);

        startActivity(window2);



    }




}
