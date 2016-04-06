package raymondseger.com.testandroidcomponents;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class TestAnimation extends AppCompatActivity {

    private TextView textView3;
    private TextView textView4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_animation);

        textView3 = (TextView) findViewById(R.id.textView3);
        textView4 = (TextView) findViewById(R.id.textView4);

        textView3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // test property animation
                /*
                v.setScaleX(0);
                v.setScaleY(0);
                v.animate().scaleX(1).scaleY(1).start();
                */

                // test ObjectAnimator
                /*
                ObjectAnimator.ofInt(v, "bottom", v.getTop(), v.getBottom() ).start();
                */

                // test AnimatorSet
                ObjectAnimator animator1 = ObjectAnimator.ofInt(textView3, "bottom", textView3.getTop(), textView3.getBottom() );
                ObjectAnimator animator2 = ObjectAnimator.ofInt(textView4, "bottom", textView4.getTop(), textView4.getBottom() );
                AnimatorSet animatorSet1 = new AnimatorSet();
                animatorSet1.playSequentially(animator1, animator2);
                animatorSet1.start();
            }
        });
    }
}
