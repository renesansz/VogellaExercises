package com.example.renesansz.androiddialogfragments;

import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.widget.Toast;

public class MyAlertDialogFragment extends DialogFragment {
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        return new AlertDialog.Builder(getActivity())
                            .setIcon(R.drawable.error)
                            .setTitle("Alert Dialog Fragment Example")
                            .setMessage("This is a message")
                            .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int which) {
                                    Toast.makeText(getActivity(), "Pressed OK", Toast.LENGTH_SHORT).show();
                                }
                            })
                            .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int which) {
                                    Toast.makeText(getActivity(), "Cancel", Toast.LENGTH_SHORT).show();
                                }
                            }).create();
    }

    public void show(FragmentManager manager, String fragment_edit_name) {
    }
}
