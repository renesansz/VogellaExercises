package com.example.renesansz.androiddialogfragments;

import android.app.DialogFragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.TextView;

public class MyDialogFragment extends DialogFragment implements TextView.OnEditorActionListener {
    private EditText mEditText;



    public interface UserNameListener {
        void onFinishUserDialog(String user);
    }

    public MyDialogFragment() {
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_username, container);
        mEditText = (EditText) view.findViewById(R.id.username);

        // Set this instance as callback for editor action
        mEditText.setOnEditorActionListener(this);
        mEditText.requestFocus();

        getDialog().getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_VISIBLE);
        getDialog().setTitle("Please enter username");

        return view;
    }

    @Override
    public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
        UserNameListener activity = (UserNameListener) getActivity();

        activity.onFinishUserDialog(mEditText.getText().toString());

        this.dismiss();

        return true;
    }
}
