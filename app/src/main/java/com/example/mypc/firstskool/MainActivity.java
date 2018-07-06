package com.example.mypc.firstskool;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity  implements View.OnClickListener, GoogleApiClient.OnConnectionFailedListener  {

    private TextView txtUserEmailId,txtuserName;
    private LinearLayout prof_section;
    private SignInButton btnLogin;
    private Button btn_logout;
    private ImageView imgViewPhoto;

    private GoogleApiClient googleApiClient;

    private static final int REQ_CODE= 9001;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    
        
        
        imgViewPhoto=findViewById(R.id.imgViewPhoto);

        prof_section=findViewById(R.id.prof_section);

        btn_logout= findViewById(R.id.btn_logout);
        btnLogin=findViewById(R.id.btnLogin);

        txtUserEmailId=findViewById(R.id.txtUserEmailId);
        txtuserName=findViewById(R.id.txtuserName);
        prof_section.setVisibility(View.GONE);

        btnLogin.setOnClickListener(MainActivity.this);
        btn_logout.setOnClickListener(MainActivity.this);

        GoogleSignInOptions signInOptions= new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN).requestEmail().build();
        googleApiClient = new GoogleApiClient.Builder(this).enableAutoManage(this,this).addApi(Auth.GOOGLE_SIGN_IN_API,signInOptions).build();
    
    
    }
    
    @Override
    public void onClick(View view) {
        switch(view.getId())
        {
            case R.id.btnLogin:
                signIn();
                break;

            case R.id.btn_logout:
                signOut();
                break;
        }
    }

    @Override
    public void onConnectionFailed(@NonNull ConnectionResult connectionResult) {

    }

    private void signIn()
    {
        Intent intent =Auth.GoogleSignInApi.getSignInIntent(googleApiClient);
        startActivityForResult(intent,REQ_CODE);

    }

    private void signOut()
    {
        Auth.GoogleSignInApi.signOut(googleApiClient).setResultCallback(new ResultCallback<Status>() {
            @Override
            public void onResult(@NonNull Status status) {
                updateUi(false);
            }
        });
    }

    private void handelResult(GoogleSignInResult result)
    {
        if(result.isSuccess())
        {
            //get user information

            GoogleSignInAccount account= result.getSignInAccount();
            String name= account.getDisplayName();
            String email= account.getEmail();
            String imgUrl=account.getPhotoUrl().toString();

            txtUserEmailId.setText(email);
            txtuserName.setText(name);

            Glide.with(this).load(imgUrl).into(imgViewPhoto);
            updateUi(true);
        }
        else {
            updateUi(false);
        }
    }

    private void updateUi(boolean isLoginFlag)
    {
        if(isLoginFlag)
        {
            prof_section.setVisibility(View.VISIBLE);
            btnLogin.setVisibility(View.GONE);
        }
        else
            prof_section.setVisibility(View.GONE);
        btnLogin.setVisibility(View.VISIBLE);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode==REQ_CODE)
        {
            GoogleSignInResult result= Auth.GoogleSignInApi.getSignInResultFromIntent(data);
            handelResult(result);
        }
    }
}
