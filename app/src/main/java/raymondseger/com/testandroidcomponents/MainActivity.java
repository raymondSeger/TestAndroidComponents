package raymondseger.com.testandroidcomponents;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.appyvet.rangebar.IRangeBarFormatter;
import com.appyvet.rangebar.RangeBar;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RangeBar rangebar = (RangeBar) findViewById(R.id.rangebar);
        rangebar.setOnRangeBarChangeListener(new RangeBar.OnRangeBarChangeListener() {
            @Override
            public void onRangeChangeListener(RangeBar rangeBar, int leftPinIndex, int rightPinIndex, String leftPinValue, String rightPinValue) {
                    Toast.makeText(MainActivity.this, leftPinIndex + ' ' + rightPinValue, Toast.LENGTH_SHORT).show();
            }
        });
        rangebar.setFormatter(new IRangeBarFormatter() {
            @Override
            public String format(String s) {
                Log.d("BILLY", s);
                return s;
            }
        });

    }
}
