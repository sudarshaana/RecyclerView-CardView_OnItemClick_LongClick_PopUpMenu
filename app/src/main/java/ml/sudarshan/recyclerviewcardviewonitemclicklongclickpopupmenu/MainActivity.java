package ml.sudarshan.recyclerviewcardviewonitemclicklongclickpopupmenu;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;

    // Item List
    private List<Item> listItem = new ArrayList();

    // ImageList
    private int[] images = {R.drawable.signal, R.drawable.settings, R.drawable.skype, R.drawable.utorrent, R.drawable.wall};

    // Custom Recycler View Adaptor
    private RecyclerViewAdaptor adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));


        for (int i = 0; i < 5; i++) {

            Item item = new Item();
            item.setImage(images[i]);
            item.setTitle("Title " + (i + 1));
            item.setDescription("Description " + (i + 1));

            listItem.add(item);
        }

        adapter = new RecyclerViewAdaptor(listItem, this);
        recyclerView.setAdapter(adapter);


    }


}
