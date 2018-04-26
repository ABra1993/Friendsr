package example.promo.friendsr;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * This function creates an adapter for the Friend class and returns converted view with the correct
 * objects when the user scrolls down/up.
 */
public class FriendsAdapter extends ArrayAdapter<Friend> {

    private List<Friend> data;

    // stores Friend objects in variable
    public FriendsAdapter(@NonNull Context context, int resource, @NonNull ArrayList<Friend> objects) {
        super(context, resource, objects);
        data = objects;
    }

    // returns view containing Friend objects
    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.grid_item, parent, false);
        }

        TextView textView = convertView.findViewById(R.id.textView);
        ImageView imageView = convertView.findViewById(R.id.imageView);
        textView.setText(data.get(position).getName());
        imageView.setImageResource(data.get(position).getDrawableId());

        return convertView;
    }
}
