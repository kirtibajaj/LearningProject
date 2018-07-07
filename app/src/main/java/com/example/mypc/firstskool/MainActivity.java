package com.example.mypc.firstskool;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthUserCollisionException;

public class MainActivity extends AppCompatActivity {
    EditText editText1,editText2;
    Button button;
    TextView textView;
    private FirebaseAuth mAuth;
ProgressDialog progressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_main );
        editText1=(EditText)findViewById( R.id.editemail );
button=(Button)findViewById( R.id.register );
        editText2=(EditText)findViewById( R.id.editpass );
        textView=(TextView)findViewById( R.id.textsign );
        mAuth = FirebaseAuth.getInstance();
progressDialog=new ProgressDialog( this );
        button.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                registeruser();
            }
        } );
        textView.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity( new Intent( MainActivity.this,login.class ) );
            }
        } );
    }
    private void registeruser()
    {

        String email=editText1.getText().toString().trim();
        String password=editText2.getText().toString().trim();
        if(email.isEmpty())
        {
            editText1.setError( "Proper email" );
            editText1.requestFocus();
            return;
        }
        if(!Patterns.EMAIL_ADDRESS.matcher( email ).matches())
        {
            editText1.setError( "Proper email" );
            editText1.requestFocus();
            return;
        }
        if(password.isEmpty())
        {
            editText2.setError( "Proper password" );
            editText2.requestFocus();
            return;
        }

progressDialog.setMessage( "Registering..." );
        progressDialog.show();
        mAuth.createUserWithEmailAndPassword( email,password ).addOnCompleteListener( new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if(task.isSuccessful())
                {
progressDialog.dismiss();
finish();

                    Toast.makeText( MainActivity.this,"Successfull", Toast.LENGTH_LONG ).show();
                }
                else
                {
                    progressDialog.dismiss();
                    if(task.getException() instanceof FirebaseAuthUserCollisionException)
                    Toast.makeText( MainActivity.this,"Already registered", Toast.LENGTH_LONG ).show();
                    else
                        Toast.makeText( MainActivity.this,task.getException().getMessage(), Toast.LENGTH_LONG ).show();
                }

            }
        } );


    }
}
