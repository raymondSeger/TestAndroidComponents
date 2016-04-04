package raymondseger.com.testandroidcomponents;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;
import android.widget.Toast;

import com.paging.listview.PagingListView;

import java.util.ArrayList;

public class PagingListViewActivity extends AppCompatActivity {

    int pager = 0;
    PagingListView paging_list_view;
    private TestAdapter testAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_paging_list_view);

        ArrayList<String> official_accounts = new ArrayList<>();
        official_accounts.add("Raymond");
        official_accounts.add("H");
        official_accounts.add("S");
        official_accounts.add("A");
        official_accounts.add("X");
        official_accounts.add("C");
        official_accounts.add("E");
        official_accounts.add("Q");

        paging_list_view = (PagingListView) findViewById(R.id.paging_list_view);
        testAdapter = new TestAdapter(getBaseContext(), official_accounts);
        paging_list_view.setAdapter(testAdapter);
        paging_list_view.setHasMoreItems(true);
        paging_list_view.setPagingableListener(new PagingListView.Pagingable() {
            @Override
            public void onLoadMoreItems() {
                if (pager < 3) {
                    pager++;
                    Log.d("BILLY", String.valueOf(pager));
                    paging_list_view.setIsLoading(false);
                } else {
                    paging_list_view.onFinishLoading(false, null);
                }
            }
        });
    }
}
