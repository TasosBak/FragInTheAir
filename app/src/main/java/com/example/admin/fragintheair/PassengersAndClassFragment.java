package com.example.admin.fragintheair;

import android.app.Activity;
import android.app.DialogFragment;
import android.os.Bundle;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

/**
 * Created by Admin on 12/12/2016.
 */

public class PassengersAndClassFragment extends DialogFragment implements View.OnClickListener{

    Button yes, cancel, ok;
    Activity activity;
    String str;

    EditText adults, kids, babies;
    EditText adultsSource, kidsSource, babiesSource;

    Layout layout;
    OnOkButtonClickedListener myListener;
    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        this.activity = activity;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        //getDialog().setTitle("Στοιχεία επιβάτη");
        str = getArguments().getString(str);

        getDialog().getWindow().requestFeature(Window.FEATURE_NO_TITLE);


        View view = inflater.inflate(R.layout.passengers_and_class_fragment, null);


        ok = (Button)view.findViewById(R.id.done_button);
        ok.setOnClickListener(this);

        cancel = (Button)view.findViewById(R.id.cancel_button);
        cancel.setOnClickListener(this);


        adultsSource = (EditText)view.findViewById(R.id.adults_number_pick);
        kidsSource = (EditText)view.findViewById(R.id.kids_number_pick);
        babiesSource = (EditText)view.findViewById(R.id.babies_number_pick);


        adults = (EditText) getActivity().findViewById(R.id.adults_edit_text);
        kids = (EditText) getActivity().findViewById(R.id.kids_edit_text);
        babies = (EditText) getActivity().findViewById(R.id.baby_edit_text);

//        if(adults == null)
//            adultsSource.setText("0");
//        if(kids == null)
//            adultsSource.setText("0");
//        if(babies == null)
//            adultsSource.setText("0");
//        else {
            adultsSource.setText(adults.getText().toString());
            kidsSource.setText(kids.getText());
            babiesSource.setText(babies.getText());





/*
        yes = (Button)view.findViewById(R.id.button3);
        no = (Button)view.findViewById(R.id.button2);

        yes.setOnClickListener(this);
        no.setOnClickListener(this);
        setCancelable(false);
        */

        return view;
    }

    @Override
    public void onClick(View view) {
        if(view.getId() == R.id.done_button) {
            dismiss();

            //vgazei error an to fragment me to opoio exw sundesei auto to fragment den kanei implement to
            try{
                ((OnOkButtonClickedListener) activity).onOkButtonClicked("test");
            }catch (ClassCastException cce){
                Toast.makeText(getActivity(), "must implement shit brah", Toast.LENGTH_LONG).show();
            }
            //pairnw tis times pou vazei o xrhsths sto Passengers and class fragment kai tis petaw
            //sto main fragment

            adults.setText(adultsSource.getText());
            kids.setText(kidsSource.getText());
            babies.setText(babiesSource.getText());
        }

        else if(view.getId() == R.id.cancel_button) {
            dismiss();
            Toast.makeText(getActivity(), "cancel pressed", Toast.LENGTH_SHORT).show();
            Toast.makeText(getActivity(), str, Toast.LENGTH_LONG).show();
        }

        else {
            dismiss();
            Toast.makeText(getActivity(), "no was clicked", Toast.LENGTH_LONG).show();
        }




    }



    //container activity must implement this interface
    public interface OnOkButtonClickedListener {
        public void onOkButtonClicked(String testStr);
    }

}
