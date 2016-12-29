package com.example.admin.fragintheair;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by Admin on 29/12/2016.
 */

public class StatusDialog extends android.support.v4.app.DialogFragment {

    TextView statusTextView, messageTextView;
    String status, message;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        Bundle args = getArguments();
        status = args.getString("status");
        message = args.getString("message");
    }


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.status_dialog, null);

        getDialog().getWindow().setTitle("Something went wrong!");

        statusTextView = (TextView) view.findViewById(R.id.statusTextView);
        messageTextView = (TextView) view.findViewById(R.id.messageTextView);

        statusTextView.setText(status);
        messageTextView.setText(message);

        return view;
    }
}
