package cycu.nclab.proj.a2022moocs;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class Bookkeeping extends AppCompatActivity implements View.OnClickListener{
    final String TAG = this.getClass().getSimpleName();
    static int count = 0;

    Button btSave;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bookkeeping_constraintlayout);

        uiInit();
        count++;
        Log.d(TAG, "enter onCreate(), #" + count);
    }

    private void uiInit() {
        btSave = findViewById(R.id.button);
    }

    private void varInit() {
    }

    private void registerListener() {
        btSave.setOnClickListener(this);
    }

    private void releaseListener() {
        btSave.setOnClickListener(null);
    }

    @Override
    protected void onStart() {
        super.onStart();
        varInit();
        registerListener();
        Log.d(TAG, "enter onStart(), #" + count);
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d(TAG, "enter onResume(), #" + count);
    }

    @Override
    protected void onPause() {
        Log.d(TAG, "enter onPause(), #" + count);
        super.onPause();
    }

    @Override
    protected void onStop() {
        Log.d(TAG, "enter onStop(), #" + count);
        releaseListener();
        super.onStop();
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d(TAG, "enter onRestart(), #" + count);
    }

    @Override
    protected void onDestroy() {
        Log.d(TAG, "enter onDestroy(), #" + count);
        count--;        // -- 遞減運算子； 等於 count = count - 1;
        super.onDestroy();
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.button) {  // 儲存帳務資料
            finish();   // 結束這個Activity
        }
    }
}