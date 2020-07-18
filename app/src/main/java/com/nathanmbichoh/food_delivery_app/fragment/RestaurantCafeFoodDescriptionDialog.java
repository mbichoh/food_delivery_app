package com.nathanmbichoh.food_delivery_app.fragment;

import android.annotation.SuppressLint;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.DialogFragment;

import com.nathanmbichoh.food_delivery_app.R;

import java.util.Objects;

public class RestaurantCafeFoodDescriptionDialog  extends DialogFragment {

    @SuppressLint("InflateParams")
    @NonNull
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        //AlertDialog builder
        AlertDialog.Builder builder = new AlertDialog.Builder(Objects.requireNonNull(getActivity()));
        //layout inflater
        LayoutInflater inflater = requireActivity().getLayoutInflater();
        //Inflate and set the layout for the dialog and pass null as the parent view because its going in the dialog layout
        builder.setView(inflater.inflate(R.layout.activity_food_description_and_order, null));
        // Create the AlertDialog object and return it
        return builder.create();
    }
}
