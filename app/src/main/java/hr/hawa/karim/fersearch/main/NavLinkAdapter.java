package hr.hawa.karim.fersearch.main;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import org.jsoup.select.Elements;

import hr.hawa.karim.fersearch.R;

public class NavLinkAdapter extends RecyclerView.Adapter<NavLinkAdapter.NavLinkViewHolder> {
    private final Context context;
    private final Elements elementList;

    public NavLinkAdapter(Context context, Elements elementList) {
        this.context = context;
        this.elementList = elementList;
    }

    @NonNull
    @Override
    public NavLinkViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new NavLinkViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.row_nav_link, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull NavLinkViewHolder holder, int position) {
        holder.nameView.setText(elementList.get(position).text());
    }

    @Override
    public int getItemCount() {
        return elementList.size();
    }

    protected class NavLinkViewHolder extends RecyclerView.ViewHolder {
        public final TextView nameView;

        public NavLinkViewHolder(View rootView) {
            super(rootView);
            nameView = rootView.findViewById(R.id.name);
        }
    }
}
