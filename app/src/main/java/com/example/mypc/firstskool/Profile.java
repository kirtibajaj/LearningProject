package com.example.mypc.firstskool;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

public class Profile extends Fragment {
    Dialog dialog_phone,dialog_pass;
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.profile, container,
                false);
        //configuring  id of user image
        ImageView User_image=(ImageView)rootView.findViewById(R.id.image_user);
        //configuring id of user name
        TextView username=(TextView)rootView.findViewById(R.id.name_user);
        //configuring id of user follower
        TextView follower=(TextView)rootView.findViewById(R.id.follow_user);
        //configuring id of user following
        TextView following=(TextView)rootView.findViewById(R.id.following_user);
        //configuring id of progress bar
        ProgressBar profilecmplt=(ProgressBar)rootView.findViewById(R.id.progressBar);
        //configuring id of progress of user
        TextView percentage_profilecmplt=(TextView)rootView.findViewById(R.id.percent);
        //configuring id of percentage of accuracy
        TextView accuracy=(TextView)rootView.findViewById(R.id.accuracy_percentage);
        //configuring id of percentage of attempted
        TextView attempted=(TextView)rootView.findViewById(R.id.percentage_attempted);
        //configuring id of percentage of Phone no
        TextView phoneno=(TextView)rootView.findViewById(R.id.contact_user);
        //configuring id of percentage of change contact no
        TextView change_contact=(TextView)rootView.findViewById(R.id.change_phone);
        //configuring id of percentage of change password
        change_contact.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ShowPopup_phone(v);
            }
        });
        dialog_pass=new Dialog(getActivity());
        TextView change_password=(TextView) rootView.findViewById(R.id.set_password);
        dialog_phone=new Dialog(getActivity());
        change_password.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ShowPopup_password(v);
            }
        });

        //configuring id of Edit personal details
        TextView Edit_personal=(TextView)rootView.findViewById(R.id.edit_change_tonext_activity);
        Edit_personal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getActivity(),Edit_Personal_Details.class);
                startActivity(intent);
            }
        });

        //configuring id of username in personal details
        TextView username_personal_details=(TextView)rootView.findViewById(R.id.user_name_in_personaldetails);
        //configuring id of emailid inpersonal details
        TextView email_id_PD=(TextView)rootView.findViewById(R.id.mail_id_in_personal_details);
        //configuring id gender in Personal details
        TextView gender_in_PD=(TextView)rootView.findViewById(R.id.gender_in_personal_details);
        //configuring id of location in personal details
        TextView location_in_PD=(TextView)rootView.findViewById(R.id.loaction_in_personal_details);
        //configuring id of birthday in personal details
        TextView birthday_in_PD=(TextView)rootView.findViewById(R.id.birthdate_in_personal_details);
        return rootView;
    }
    public void ShowPopup_phone(View v){
        dialog_phone.setContentView(R.layout.custompopupfornumberchange);
        dialog_phone.show();
        //configuring id of autocomplete of country code
        AutoCompleteTextView country_code=(AutoCompleteTextView)v.findViewById(R.id.autoCompleteTextView);
        //configuring id of new phone number
        EditText change_phone=(EditText)v.findViewById(R.id.newphonenumber);
        //configuring id of submit buttonin pop up

        TextView submit=(TextView)v.findViewById(R.id.submitphoneno);
    }
    public void ShowPopup_password(View v){
        dialog_pass.setContentView(R.layout.custompopupforpasswordchange);
        dialog_pass.show();
        //configuring id of old password
        AutoCompleteTextView op=(AutoCompleteTextView)v.findViewById(R.id.oldpassword);
        //configuring id of new password
        EditText np=(EditText)v.findViewById(R.id.newpasswd);
        //configuring id of confirm new password
        EditText cnp=(EditText)v.findViewById(R.id.confirmnewpassword);
        //configuring id of submit buttonin pop up
        TextView submit=(TextView)v.findViewById(R.id.submit_passwd);

    }
    public void edittopersonaldetail(View v){
        Intent intent=new Intent(getActivity(),Edit_Personal_Details.class);
        startActivity(intent);
    }




}

