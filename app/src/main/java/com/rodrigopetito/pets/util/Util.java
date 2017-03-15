package com.rodrigopetito.pets.util;

import android.content.Context;
import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;

/**
 * Created by rodrigopetito on 3/15/17.
 */

public class Util {


    public static void showRestartDialog(Context context, DialogInterface.OnClickListener listener) {
        new AlertDialog.Builder(context)
                .setTitle("Error")
                .setMessage("Algo ha fallado, por favor vuelva a intentarlo")
                .setPositiveButton("Reintentar", listener)
                .setNegativeButton("Cancelar", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                })
                .show();
    }

}
