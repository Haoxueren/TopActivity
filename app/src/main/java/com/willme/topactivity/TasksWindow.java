package com.willme.topactivity;

import android.content.Context;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.WindowManager;
import android.widget.TextView;

public class TasksWindow {

    private static WindowManager.LayoutParams sWindowParams;
    private static WindowManager sWindowManager;
    private static View sView;

    public static void init(final Context context) {
        sWindowManager = (WindowManager) context.getApplicationContext()
                .getSystemService(Context.WINDOW_SERVICE);
        sWindowParams = new WindowManager.LayoutParams(WindowManager.LayoutParams.WRAP_CONTENT,
                WindowManager.LayoutParams.WRAP_CONTENT, 2005, 0x18,
                WindowManager.LayoutParams.TYPE_SYSTEM_ALERT);

//		sWindowParams = new WindowManager.LayoutParams(
//				WindowManager.LayoutParams.WRAP_CONTENT,
//				WindowManager.LayoutParams.WRAP_CONTENT, 2005, 0x18,
//				PixelFormat.TRANSLUCENT);
        sWindowParams.gravity = Gravity.LEFT + Gravity.TOP;
        sView = LayoutInflater.from(context).inflate(R.layout.window_tasks,
                null);
    }

    public static void show(Context context, final String text) {
        if (sWindowManager == null) {
            init(context);
        }
        TextView textView = (TextView) sView.findViewById(R.id.text);
        textView.setText(text);
        try {
            sWindowManager.addView(sView, sWindowParams);
        } catch (Exception e) {
        }
    }

    public static void dismiss(Context context) {
        Log.d("TasksWindow", "dismiss");
        try {
            sWindowManager.removeView(sView);
        } catch (Exception e) {
        }
    }

}
