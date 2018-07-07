package com.example.mypc.firstskool;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class welcome extends AppCompatActivity {

    Button button;
    FirebaseAuth mAuth;

    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_welcome );
        mAuth= FirebaseAuth.getInstance();
        button=(Button)findViewById( R.id.button2 );
        textView=(TextView)findViewById( R.id.textView );

        FirebaseUser user=mAuth.getCurrentUser();
        textView.setText( "Welcome  "+user.getEmail() );
        button.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mAuth.signOut();
                finish();
                startActivity( new Intent( welcome.this,login.class ) );
            }
        } );

    }
}
