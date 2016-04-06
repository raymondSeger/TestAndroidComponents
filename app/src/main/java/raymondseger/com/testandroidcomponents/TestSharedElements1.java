package raymondseger.com.testandroidcomponents;

import android.app.ActivityOptions;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class TestSharedElements1 extends AppCompatActivity {

    private ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_shared_elements1);

        TextView textView7 = (TextView) findViewById(R.id.textView7);
        imageView = (ImageView) findViewById(R.id.imageView);

        textView7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(TestSharedElements1.this, TestSharedElements2.class);

                // this will create scene transition data
                ActivityOptions options = ActivityOptions.makeSceneTransitionAnimation(TestSharedElements1.this, imageView, "theImageName");

                startActivity(intent, options.toBundle() );
            }
        });
    }
}
