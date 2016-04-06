package raymondseger.com.testandroidcomponents;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class TestButterKnifeActivity extends AppCompatActivity {

    @Bind(R.id.textView8) TextView textView8;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_butter_knife);
        ButterKnife.bind(this);

        textView8.setText("hi all");

    }

    @OnClick(R.id.button)
    public void sayHi(Button button) {
        Toast.makeText(TestButterKnifeActivity.this, "hi all 2", Toast.LENGTH_SHORT).show();
    }
}
