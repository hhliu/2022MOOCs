package cycu.nclab.proj.a2022moocs.ui.main;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

import cycu.nclab.proj.a2022moocs.R;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link FragmentFour#newInstance} factory method to
 * create an instance of this fragment.
 */
public class FragmentFour extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;


    final String TAG = "FragmentFour";
    static int count = 0;

    ImageView iv;
    final int IMAGE_ONE = 10001;
    final int IMAGE_TWO = 10002;
    final int IMAGE_THREE = 10003;

    final int interval = 200;

    public FragmentFour() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment FragmentOne.
     */
    // TODO: Rename and change types and number of parameters
    public static FragmentFour newInstance(String param1, String param2) {
        FragmentFour fragment = new FragmentFour();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }

        count++;
        Log.i(TAG, "enter onCreate(), #" + count);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        Log.d(TAG, "enter onCreateView(), #" + count);
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.activity_cute_dog, container, false);
        uiInit(rootView);
        return rootView;
    }

    TextView tx;
    private void uiInit(View v) {
        iv = v.findViewById(R.id.imageView3);
    }

    @Override
    public void onStart() {
        super.onStart();

        Log.i(TAG, "enter onStart(), #" + count);
        // 使用Handler自動切換螢幕畫面
        Message msg = myHandler.obtainMessage();
        msg.what = IMAGE_TWO;
        myHandler.sendMessageDelayed(msg, interval); // 0.2秒後執行
    }

    @Override
    public void onStop() {
        Log.i(TAG, "enter onStop(), #" + count);
        myHandler.removeCallbacksAndMessages(null);
        super.onStop();
    }

    private final Handler myHandler = new Handler(Looper.getMainLooper()) {

        @Override
        public void handleMessage(Message msg) {
            switch (msg.what) {
                case IMAGE_ONE:
                    iv.setImageResource(R.drawable.ic_dog_rotate_right_1);
                    Log.d(TAG, "image_one: " + SystemClock.elapsedRealtime());
                    msg = this.obtainMessage();
                    msg.what = IMAGE_TWO;
                    myHandler.sendMessageDelayed(msg, interval); // 0.5秒後執行
                    break;
                case IMAGE_TWO:
                    iv.setImageResource(R.drawable.ic_dog_rotate_right_2);
                    Log.d(TAG, "image_two: " + SystemClock.elapsedRealtime());
                    msg = this.obtainMessage();
                    msg.what = IMAGE_THREE;
                    myHandler.sendMessageDelayed(msg, interval); // 0.5秒後執行
                    break;
                case IMAGE_THREE:
                    iv.setImageResource(R.drawable.ic_dog_rotate_right_3);
                    Log.d(TAG, "image_three: " + SystemClock.elapsedRealtime());
                    msg = this.obtainMessage();
                    msg.what = IMAGE_ONE;
                    myHandler.sendMessageDelayed(msg, interval); // 0.5秒後執行
                    break;
            }
        }
    };

    @Override
    public void onDestroy() {
        Log.i(TAG, "enter onDestroy(), #" + count);
        count--;
        super.onDestroy();
    }
}