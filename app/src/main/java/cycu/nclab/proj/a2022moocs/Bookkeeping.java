package cycu.nclab.proj.a2022moocs;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TextView;
import android.widget.TimePicker;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

public class Bookkeeping extends AppCompatActivity implements View.OnClickListener{
    final String TAG = this.getClass().getSimpleName();
    static int count = 0;

    TextView theDate, theTime;
    Button btSave;
    Calendar c;
    // 設定日期顯示的格式
    SimpleDateFormat df = new SimpleDateFormat("yyyy/MM/dd", Locale.getDefault());
    // 設定時間顯示的格式
    SimpleDateFormat df2 = new SimpleDateFormat("hh a", Locale.US);

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
        theDate = findViewById(R.id.textView6);
        theTime = findViewById(R.id.textView7);
    }

    private void varInit() {
        c = Calendar.getInstance();
        theDate.setText(df.format(c.getTime()));
        theTime.setText(df2.format(c.getTime()));

    }

    private void registerListener() {
        btSave.setOnClickListener(this);
        theDate.setOnClickListener(this);
        theTime.setOnClickListener(this);
    }

    private void releaseListener() {
        btSave.setOnClickListener(null);
        theDate.setOnClickListener(null);
        theTime.setOnClickListener(null);
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
        switch (v.getId()) {
            case R.id.button:
                // 儲存帳務資料
                finish(); // 結束這個Activity
                break;
            case R.id.textView6:
                // 設定日期
                new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker datePicker, int i, int i1, int i2) {
                        c.set(Calendar.YEAR, i);
                        c.set(Calendar.MONTH, i1);
                        c.set(Calendar.DAY_OF_MONTH, i2);
                        theDate.setText(df.format(c.getTime()));
                    }
                }, c.get(Calendar.YEAR),
                        c.get(Calendar.MONTH), c.get(Calendar.DAY_OF_MONTH)).show();
                break;
            case R.id.textView7:
                // 設定時間
                new TimePickerDialog(this, new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker timePicker, int i, int i1) {
                        c.set(Calendar.HOUR_OF_DAY, i);
                        c.set(Calendar.MINUTE, i1);
                        theTime.setText(df2.format(c.getTime()));
                    }
                }, c.get(Calendar.HOUR_OF_DAY),
                        c.get(Calendar.MINUTE), true).show();
                break;
        }
    }
}