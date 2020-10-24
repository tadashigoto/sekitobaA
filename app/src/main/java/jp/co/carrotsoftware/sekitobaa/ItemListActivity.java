package jp.co.carrotsoftware.sekitobaa;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;
import androidx.appcompat.widget.Toolbar;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import jp.co.carrotsoftware.sekitobaa.theme.ThemeContent;

import java.util.List;

/**
 * An activity representing a list of Items. This activity
 * has different presentations for handset and tablet-size devices. On
 * handsets, the activity presents a list of items, which when touched,
 * lead to a {@link ItemDetailActivity} representing
 * item details. On tablets, the activity presents the list of items and
 * item details side-by-side using two vertical panes.
 */
public class ItemListActivity extends AppCompatActivity {

    /**
     * Whether or not the activity is in two-pane mode, i.e. running on a tablet
     * device.
     */
    private boolean mTwoPane;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_item_list);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        toolbar.setTitle(getTitle());

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        if (findViewById(R.id.item_detail_container) != null) {
            // The detail container view will be present only in the
            // large-screen layouts (res/values-w900dp).
            // If this view is present, then the
            // activity should be in two-pane mode.
            mTwoPane = true;
        }

        View recyclerView = findViewById(R.id.item_list);
        assert recyclerView != null;
        setupRecyclerView((RecyclerView) recyclerView);
    }

    private void setupRecyclerView(@NonNull RecyclerView recyclerView) {
        recyclerView.setAdapter(new SimpleItemRecyclerViewAdapter(this, ThemeContent.ITEMS, mTwoPane));
    }

    public static class SimpleItemRecyclerViewAdapter
            extends RecyclerView.Adapter<SimpleItemRecyclerViewAdapter.ViewHolder> {

        private final ItemListActivity mParentActivity;
        private final List<ThemeContent.ThemeItem> mValues;
        private final boolean mTwoPane;
        private final View.OnClickListener mOnClickListener = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ThemeContent.ThemeItem item = (ThemeContent.ThemeItem) view.getTag();
                if (mTwoPane) {
                    Bundle arguments = new Bundle();
                    arguments.putString(ItemDetailFragment.ARG_ITEM_ID, item.id);
                    ItemDetailFragment fragment = new ItemDetailFragment();
                    fragment.setArguments(arguments);
                    mParentActivity.getSupportFragmentManager().beginTransaction()
                            .replace(R.id.item_detail_container, fragment)
                            .commit();
                } else {
                    Context context = view.getContext();
                    Intent intent = new Intent(context, ItemDetailActivity.class);
                    intent.putExtra(ItemDetailFragment.ARG_ITEM_ID, item.id);

                    context.startActivity(intent);
                }
            }
        };

        SimpleItemRecyclerViewAdapter(ItemListActivity parent,
                                      List<ThemeContent.ThemeItem> items,
                                      boolean twoPane) {
            mValues = items;
            mParentActivity = parent;
            mTwoPane = twoPane;
        }

        @Override
        public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.item_list_content, parent, false);
            return new ViewHolder(view);
        }

        @Override
        public void onBindViewHolder(final ViewHolder holder, int position) {
            holder.midView.setText(mValues.get(position).id);
            holder.mname1View.setText(mValues.get(position).name1);
            holder.mtitleView.setText(mValues.get(position).title);
            holder.mabstract1View.setText(mValues.get(position).abstract1);
            holder.mdocsView.setText(mValues.get(position).docs);
            holder.mgithubView.setText(mValues.get(position).github);
            holder.mgroupView.setText(mValues.get(position).group);
            holder.mpurposeView.setText(mValues.get(position).purpose);
            holder.mstatusView.setText(mValues.get(position).status);
            holder.mmemoView.setText(mValues.get(position).memo);
            holder.mdependenciesView.setText(mValues.get(position).dependencies);
            holder.mplaned_startView.setText(mValues.get(position).planed_start);
            holder.mactual_startView.setText(mValues.get(position).actual_start);
            holder.mdurationView.setText(mValues.get(position).duration);
            holder.mplaned_finishView.setText(mValues.get(position).planed_finish);
            holder.mactual_finishView.setText(mValues.get(position).actual_finish);

            holder.itemView.setTag(mValues.get(position));
            holder.itemView.setOnClickListener(mOnClickListener);
        }

        @Override
        public int getItemCount() {
            return mValues.size();
        }

        class ViewHolder extends RecyclerView.ViewHolder {
            final TextView midView;
            final TextView mname1View;
            final TextView mtitleView;
            final TextView mabstract1View;
            final TextView mdocsView;
            final TextView mgithubView;
            final TextView mgroupView;
            final TextView mpurposeView;
            final TextView mstatusView;
            final TextView mmemoView;
            final TextView mdependenciesView;
            final TextView mplaned_startView;
            final TextView mactual_startView;
            final TextView mdurationView;
            final TextView mplaned_finishView;
            final TextView mactual_finishView;

            ViewHolder(View view) {
                super(view);
                    midView = (TextView) view.findViewById(R.id.id);
                    mname1View = (TextView) view.findViewById(R.id.name1);
                    mtitleView = (TextView) view.findViewById(R.id.title);
                    mabstract1View = (TextView) view.findViewById(R.id.abstract1);
                    mdocsView = (TextView) view.findViewById(R.id.docs);
                    mgithubView = (TextView) view.findViewById(R.id.github);
                    mgroupView = (TextView) view.findViewById(R.id.group);
                    mpurposeView = (TextView) view.findViewById(R.id.purpose);
                    mstatusView = (TextView) view.findViewById(R.id.status);
                    mmemoView = (TextView) view.findViewById(R.id.memo);
                    mdependenciesView = (TextView) view.findViewById(R.id.dependencies);
                    mplaned_startView = (TextView) view.findViewById(R.id.planed_start);
                    mactual_startView = (TextView) view.findViewById(R.id.actual_start);
                    mdurationView = (TextView) view.findViewById(R.id.duration);
                    mplaned_finishView = (TextView) view.findViewById(R.id.planed_finish);
                    mactual_finishView = (TextView) view.findViewById(R.id.actual_finish);
            }
        }
    }
}