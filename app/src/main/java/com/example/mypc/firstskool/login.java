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

public class login extends AppCompatActivity {
    EditText editText1,editText2;
    Button button;
    TextView textView;
    private FirebaseAuth mAuth;
    ProgressDialog progressDialog;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_login );

        editText1=(EditText)findViewById( R.id.editemail2 );
        editText2=(EditText)findViewById( R.id.editpass2 );
        button=(Button)findViewById( R.id.login );

        textView=(TextView)findViewById( R.id.textregister );
        mAuth = FirebaseAuth.getInstance();

        progressDialog=new ProgressDialog( this );
        button.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                signuser();
            }
        } );

        textView.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity( new Intent( login.this,MainActivity.class ) );
            }
        } );
        if(mAuth.getCurrentUser()!=null)
        {
            finish();
            Intent intent=new Intent( login.this,welcome.class );

            startActivity( intent );

        }

    }
    private void signuser()
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
        progressDialog.setMessage( "Loging In..." );
        progressDialog.show();
        mAuth.signInWithEmailAndPassword( email,password ).addOnCompleteListener( new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if(task.isSuccessful())
                {
                    progressDialog.dismiss();
                    finish();
                    Intent intent=new Intent( login.this,welcome.class );

                    startActivity( intent );


                }
                else
                {
                    progressDialog.dismiss();
                    Toast.makeText( login.this,task.getException().getMessage(), Toast.LENGTH_LONG ).show();
                }
            }
        } );
    }
}
