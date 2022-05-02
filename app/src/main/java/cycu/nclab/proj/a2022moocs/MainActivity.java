package cycu.nclab.proj.a2022moocs;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    TextView tx;
    Button bt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tx = findViewById(R.id.textView);
        bt = findViewById(R.id.button);
        bt.setOnClickListener(this);
        tx.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.textView:
                tx.setTextColor(getResources().getColor(R.color.purple_200));
                tx.setText("Hello World!");
                break;
            case R.id.button:
                tx.setTextColor(Color.GREEN);
                tx.setText("點我、點我");
                break;
        }
    }

// 方法二
//    private View.OnClickListener myClickListener = new View.OnClickListener() {
//        @Override
//        public void onClick(View v) {
//            tx.setTextColor(Color.GREEN);
//        }
//    };

// 方法一
//    public void onButtonClick(View view) {
//        tx.setTextColor(Color.GREEN);
//    }

}