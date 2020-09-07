package course.labs.frags;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.ListFragment;

public class ListFrag extends ListFragment {

    ItemSelected activity;
    public interface ItemSelected
    {
        void onItemSelected(int index);
    }

    public ListFrag()
    {

    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        activity = (ItemSelected) context;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        String [] data = getResources().getStringArray(R.array.players);

        setListAdapter(new ArrayAdapter<String>(getActivity(),android.R.layout.simple_list_item_1, data));
        if(this.getActivity().findViewById(R.id.layout_portrait) == null)
        {
            activity.onItemSelected(0);
        }
       // activity.onItemSelected(0);
    }

    @Override
    public void onListItemClick(@NonNull ListView l, @NonNull View v, int position, long id) {
        activity.onItemSelected(position);
    }
}
