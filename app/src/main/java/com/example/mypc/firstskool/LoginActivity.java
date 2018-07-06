package com.example.mypc.firstskool;

import android.content.DialogInterface;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;

import com.rengwuxian.materialedittext.MaterialEditText;

public class LoginActivity extends AppCompatActivity {

    private Button btnSignIn;
    private Button btnregister;

    RelativeLayout rootLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        btnSignIn = findViewById(R.id.btnSignIn);
        btnregister = findViewById(R.id.btnRegister);
        rootLayout = findViewById(R.id.rootLayout);

        btnregister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showRegisterDialog();
            }
        });

        btnSignIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showLoginDialog();
            }
        });
    }



    private void showLoginDialog() {

        final AlertDialog.Builder dialog = new AlertDialog.Builder(this);
        dialog.setTitle("SIGN IN ");
        dialog.setMessage("Please use Email to Sign In");

        LayoutInflater inflater = LayoutInflater.from(this);
        View login_layout = inflater.inflate(R.layout.login_layout, null);

        final MaterialEditText edtemail = login_layout.findViewById(R.id.edtemail);
        final MaterialEditText edtpassword = login_layout.findViewById(R.id.edtpassword);


        dialog.setView(login_layout);

        dialog.setPositiveButton("SIGN IN", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

                dialogInterface.dismiss();
                btnSignIn.setEnabled(false);



                //Checking Fields

                if (TextUtils.isEmpty(edtemail.getText().toString())) {

                    Snackbar.make(rootLayout, "Please enter Email id", Snackbar.LENGTH_SHORT).show();
                    return;
                }
                if (TextUtils.isEmpty(edtpassword.getText().toString())) {

                    Snackbar.make(rootLayout, "Please enter Password", Snackbar.LENGTH_SHORT).show();
                    return;
                }

                if ((edtpassword.getText().toString().length() < 8)) {

                    Snackbar.make(rootLayout, "Password should be minimum of 8 characters", Snackbar.LENGTH_SHORT).show();
                    return;
                }

                // ----------------------------Login Code here -----------------



            }
        });


        dialog.setNegativeButton("CANCEL", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.dismiss();
            }
        });


        dialog.show();


    }

    private void showRegisterDialog() {

        final AlertDialog.Builder dialog = new AlertDialog.Builder(this);
        dialog.setTitle("REGISTER ");
        dialog.setMessage("Please use Email to register");

        LayoutInflater inflater = LayoutInflater.from(this);
        View register_layout = inflater.inflate(R.layout.register_layout, null);

        final MaterialEditText edtemail = register_layout.findViewById(R.id.edtemail);
        final MaterialEditText edtpassword = register_layout.findViewById(R.id.edtpassword);
        final MaterialEditText edtname = register_layout.findViewById(R.id.edtname);
        final MaterialEditText edtphone = register_layout.findViewById(R.id.edtphone);

        dialog.setView(register_layout);

        dialog.setPositiveButton("REGISTER", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

                dialogInterface.dismiss();

                //Checking about fields

                if (TextUtils.isEmpty(edtemail.getText().toString())) {

                    Snackbar.make(rootLayout, "Please enter Email id", Snackbar.LENGTH_SHORT).show();
                    return;
                }
                if (TextUtils.isEmpty(edtpassword.getText().toString())) {

                    Snackbar.make(rootLayout, "Please enter Password", Snackbar.LENGTH_SHORT).show();
                    return;
                }
                if (TextUtils.isEmpty(edtname.getText().toString())) {

                    Snackbar.make(rootLayout, "Please enter Your Name", Snackbar.LENGTH_SHORT).show();
                    return;
                }
                if (TextUtils.isEmpty(edtphone.getText().toString())) {

                    Snackbar.make(rootLayout, "Please enter Phone", Snackbar.LENGTH_SHORT).show();
                    return;
                }
                if ((edtpassword.getText().toString().length() < 6)) {

                    Snackbar.make(rootLayout, "Password should be minimum of 8 characters", Snackbar.LENGTH_SHORT).show();
                    return;
                }

                // Create new user


            }
        });

        dialog.setNegativeButton("CANCEL", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

                dialogInterface.dismiss();

            }
        });

        dialog.show();

        }
}
