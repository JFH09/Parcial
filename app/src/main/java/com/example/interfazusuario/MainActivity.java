package com.example.interfazusuario;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthUserCollisionException;
import com.google.firebase.database.DatabaseReference;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button btnGuardar;
    private EditText TextCodigoArticulo;
    private EditText TextDescripcion;
    private ProgressDialog progressDialog;
    private FirebaseAuth firebaseAuth;
    private DatabaseReference BDArticulos;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnGuardar= (Button) findViewById(R.id.botonGuardar);
        TextCodigoArticulo= (EditText) findViewById(R.id.TxtCodigoArticulo);
        TextDescripcion = (EditText) findViewById(R.id.TxtDescripcion);


    }


    public void ConecionBD(){
        String codArticulo = TextCodigoArticulo.getText().toString().trim();
        String descripcion  = TextDescripcion.getText().toString().trim();



        if(TextUtils.isEmpty (codArticulo)){
            Toast.makeText(this,"Se debe ingresar un Codigo De Articulo",Toast.LENGTH_LONG).show();
            return;
        }

        if(TextUtils.isEmpty(descripcion)){
            Toast.makeText(this,"Falta ingresar la Descripcion del Producto",Toast.LENGTH_LONG).show();
            return;
        }



        if(!TextUtils.isEmpty(codArticulo)||!TextUtils.isEmpty(descripcion)){
            String id = BDArticulos.push().getKey();
            Articulos articulos = new Articulos(codArticulo,descripcion);
            BDArticulos.child("Informacion").child(id).setValue(articulos);

        }else{
            Toast.makeText(this,"Falta algun Dato / Error ", Toast.LENGTH_LONG).show();
        }



        progressDialog.setMessage("Realizando registro en linea...");
        progressDialog.show();
        progressDialog.dismiss();


    }

    @Override
    public void onClick(View v) {
        ConecionBD();
    }


}
