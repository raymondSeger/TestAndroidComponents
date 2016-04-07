package raymondseger.com.testandroidcomponents;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import java.io.FileNotFoundException;

import io.realm.DynamicRealm;
import io.realm.Realm;
import io.realm.RealmConfiguration;
import io.realm.RealmMigration;
import io.realm.RealmQuery;
import io.realm.RealmResults;
import io.realm.exceptions.RealmMigrationNeededException;
import raymondseger.com.testandroidcomponents.classes.UserRealmObject;

public class TestSQLLiteActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_sqllite);

        // this is only good for development. Please read https://realm.io/docs/java/latest/#migrations
        RealmConfiguration realmConfig = new RealmConfiguration.Builder(getApplicationContext())
                .deleteRealmIfMigrationNeeded()
                .build();
        Realm realm = Realm.getInstance(realmConfig);

        // WRITE
        realm.beginTransaction();
        final UserRealmObject user1 = realm.createObject(UserRealmObject.class);
        user1.setName("Rex");
        user1.setAge("1");

        final UserRealmObject user2= realm.createObject(UserRealmObject.class);
        user2.setName("Jett");
        user2.setAge("1");

        final UserRealmObject user3= realm.createObject(UserRealmObject.class);
        user3.setName("Gabriel");
        user3.setAge("2");
        realm.commitTransaction();

        Log.v("BILLY", "Name of the user: " + user1.getName());

        // Search
        RealmResults<UserRealmObject> results  = realm.where(UserRealmObject.class)
                .equalTo("age", "1")
                .findAll();

        Toast.makeText(TestSQLLiteActivity.this, String.valueOf( results.size() ) , Toast.LENGTH_SHORT).show();
        // get the result
        for (int i = 0; i < results.size(); i++) {
            UserRealmObject u = results.get(i);
            Log.v("BILLY", u.toString() );
        }

    }
}
