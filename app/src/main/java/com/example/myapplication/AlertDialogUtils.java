package com.example.myapplication;

import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class AlertDialogUtils {

    public static void showCustomAlertDialog(Context context, String newTitle, Class Onclikclassname) {
        View customView = LayoutInflater.from(context).inflate(R.layout.custom_dialog, null);
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setView(customView);

        ImageView cancel = customView.findViewById(R.id.btnCancelTop);


        TextView dtitle2 = customView.findViewById(R.id.dtitle2);
        TextView btnConfirm = customView.findViewById(R.id.btnConfirm);

        // Set the new text value
        dtitle2.setText(newTitle);

        final AlertDialog dialog = builder.create();
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        dialog.show();

        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });

        btnConfirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                Intent intent = new Intent(context, Onclikclassname); // Replace NewActivity with the name of your new activity class
                context.startActivity(intent);

            }
        });


    }
}
