package ml.sudarshan.recyclerviewcardviewonitemclicklongclickpopupmenu;

import android.content.Context;
import android.support.v7.widget.PopupMenu;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

/**
 * Created by Sudarshan on 1/11/2017.
 */
public class RecyclerViewAdaptor extends RecyclerView.Adapter<RecyclerViewAdaptor.ViewHolder> {

    private List<Item> list;
    private Context context;

    public RecyclerViewAdaptor(List<Item> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_style, parent, false);

        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(final RecyclerViewAdaptor.ViewHolder holder, final int position) {
        Item myList = list.get(position);

        holder.imageView.setImageResource(myList.getImage());
        holder.textViewHead.setText(myList.getTitle());
        holder.textViewDesc.setText(myList.getDescription());


        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                showPosition(position);
            }

            private void showPosition(int position) {
                Toast.makeText(context, "Clicked and Position is " + position, Toast.LENGTH_SHORT).show();

            }
        });
        holder.itemView.setOnLongClickListener(new View.OnLongClickListener() {

            private void showPositionx(int position) {
                Toast.makeText(context, "Long Clicked and Position is " + position, Toast.LENGTH_SHORT).show();

            }

            @Override
            public boolean onLongClick(View v) {
                showPositionx(position);
                return true;
            }

        });


        holder.buttonViewOption.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //creating a popup menu
                PopupMenu popup = new PopupMenu(context, holder.buttonViewOption);
                //inflating menu from xml resource
                popup.inflate(R.menu.options_menu);
                //adding click listener
                popup.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(MenuItem item) {
                        switch (item.getItemId()) {
                            case R.id.menu1:
                                //handle menu1 click
                                Toast.makeText(context, "menu 1", Toast.LENGTH_SHORT).show();
                                break;
                            case R.id.menu2:

                                Toast.makeText(context, "menu 2", Toast.LENGTH_SHORT).show();
                                //handle menu2 click
                                break;
                            case R.id.menu3:
                                //handle menu3 click
                                break;
                        }
                        return false;
                    }
                });
                //displaying the popup
                popup.show();

            }
        });
    }


    @Override
    public int getItemCount() {

        return list.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder {

        public TextView textViewHead;
        public TextView textViewDesc;
        public TextView buttonViewOption;
        public ImageView imageView;

        public ViewHolder(View itemView) {
            super(itemView);


            imageView = (ImageView) itemView.findViewById(R.id.imageView);
            textViewHead = (TextView) itemView.findViewById(R.id.textViewHead);
            textViewDesc = (TextView) itemView.findViewById(R.id.textViewDesc);
            buttonViewOption = (TextView) itemView.findViewById(R.id.textViewOptions);
        }
    }
}
