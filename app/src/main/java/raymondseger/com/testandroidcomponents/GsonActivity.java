package raymondseger.com.testandroidcomponents;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import raymondseger.com.testandroidcomponents.classes.TestObject;

import com.google.gson.Gson;

public class GsonActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gson);

        // Serialization
        TestObject obj  = new TestObject();
        Gson gson       = new Gson();
        String json     = gson.toJson(obj);
        Log.d("BILLY", json);

        // Deserialization
        TestObject obj2 = gson.fromJson(json, TestObject.class);
        Log.d("BILLY", obj2.toString() );
    }
}
