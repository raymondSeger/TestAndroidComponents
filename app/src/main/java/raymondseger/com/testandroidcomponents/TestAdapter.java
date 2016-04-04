package raymondseger.com.testandroidcomponents;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class TestAdapter extends BaseAdapter {

    private Context context;
    private ArrayList<String> official_accounts;

    public TestAdapter(Context context, ArrayList<String> official_accounts) {
        this.context            = context;
        this.official_accounts  = official_accounts;
    }

    @Override
    public int getCount() {
        return official_accounts.size();
    }

    @Override
    public Object getItem(int position) {
        return official_accounts.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        convertView = null;

        if (convertView == null) {
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView             = (View) inflater.inflate( R.layout.layout_for_official_account, null);

            TextView textView              = (TextView) convertView.findViewById(R.id.textView);

            textView.setText( official_accounts.get(position).toString() );
        }

        return convertView;
    }
}
