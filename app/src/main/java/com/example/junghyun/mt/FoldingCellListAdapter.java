package com.example.junghyun.mt;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.ramotion.foldingcell.FoldingCell;


import java.util.HashSet;
import java.util.List;

/**
 * Simple example of ListAdapter for using with Folding Cell
 * Adapter holds indexes of unfolded elements for correct work with default reusable views behavior
 */
@SuppressWarnings({"WeakerAccess", "unused"})
public class FoldingCellListAdapter extends ArrayAdapter<Item> {

    private HashSet<Integer> unfoldedIndexes = new HashSet<>();
    private View.OnClickListener defaultRequestBtnClickListener;

    public FoldingCellListAdapter(Context context, List<Item> objects) {
        super(context, 0, objects);
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, @NonNull ViewGroup parent) {
        // get item for selected view
        Item item = getItem(position);
        // if cell is exists - reuse it, if not - create the new one from resource
        FoldingCell cell = (FoldingCell) convertView;
        ViewHolder viewHolder;
        if (cell == null) {
            viewHolder = new ViewHolder();
            LayoutInflater vi = LayoutInflater.from(getContext());
            cell = (FoldingCell) vi.inflate(R.layout.cell, parent, false);
            // binding view parts to view holder
            viewHolder.titleName = cell.findViewById(R.id.MT_title_name);
            viewHolder.contentName = cell.findViewById(R.id.MT_content_name);
            viewHolder.titleId = cell.findViewById(R.id.MT_title_id);
            viewHolder.titleDate = cell.findViewById(R.id.MT_title_date);
            viewHolder.contentDate = cell.findViewById(R.id.MT_content_date);
            viewHolder.titleLocation = cell.findViewById(R.id.MT_title_location);
            viewHolder.contentLocation = cell.findViewById(R.id.MT_content_location);
            viewHolder.contentPeople = cell.findViewById(R.id.MT_content_people);
            viewHolder.contentPrice = cell.findViewById(R.id.MT_content_price);
            viewHolder.contentModifyBtn = cell.findViewById(R.id.content_modify_btn);
            viewHolder.contentChecklistBtn=cell.findViewById(R.id.content_checklist_btn);
            viewHolder.contentInformBtn=cell.findViewById(R.id.content_inform_btn);
            viewHolder.titleIcon=cell.findViewById(R.id.MT_title_icon);
            cell.setTag(viewHolder);
        } else {
            // for existing cell set valid valid state(without animation)
            if (unfoldedIndexes.contains(position)) {
                cell.unfold(true);
            } else {
                cell.fold(true);
            }
            viewHolder = (ViewHolder) cell.getTag();
        }

        if (null == item)
            return cell;

        // bind data from selected element to view through view holder
        viewHolder.titleName.setText(item.getTitle());
        viewHolder.contentName.setText(item.getTitle());
        viewHolder.titleId.setText("# "+item.getId());
        viewHolder.titleDate.setText(item.getDate());
        viewHolder.contentDate.setText(item.getDate());
        viewHolder.titleLocation.setText(item.getLocation());
        viewHolder.contentLocation.setText(item.getLocation());
        viewHolder.contentPeople.setText(item.getPeople()+" 명");
        viewHolder.contentPrice.setText(String.valueOf(item.getPrice())+" 원");

        switch (position%4){
            case 0 :
                viewHolder.titleIcon.setImageResource(R.drawable.ic_dancing);
                break;
            case 1 :
                viewHolder.titleIcon.setImageResource(R.drawable.ic_drinking);
                break;
            case 2 :
                viewHolder.titleIcon.setImageResource(R.drawable.ic_sea);
                break;
            default:
                viewHolder.titleIcon.setImageResource(R.drawable.ic_vomit);
        }

        // set custom btn handler for list item from that item
        if (item.getRequestBtnClickListener() != null) {
            viewHolder.contentModifyBtn.setOnClickListener(item.getRequestBtnClickListener());
        } else {
            // (optionally) add "default" handler if no handler found in item
            viewHolder.contentModifyBtn.setOnClickListener(defaultRequestBtnClickListener);
        }

        return cell;
    }

    // simple methods for register cell state changes
    public void registerToggle(int position) {
        if (unfoldedIndexes.contains(position))
            registerFold(position);
        else
            registerUnfold(position);
    }

    public void registerFold(int position) {
        unfoldedIndexes.remove(position);
    }

    public void registerUnfold(int position) {
        unfoldedIndexes.add(position);
    }

    public View.OnClickListener getDefaultRequestBtnClickListener() {
        return defaultRequestBtnClickListener;
    }

    public void setDefaultRequestBtnClickListener(View.OnClickListener defaultRequestBtnClickListener) {
        this.defaultRequestBtnClickListener = defaultRequestBtnClickListener;
    }

    // View lookup cache
    private static class ViewHolder {
        TextView titleName;
        TextView contentName;
        TextView titleId;
        TextView titleDate;
        TextView contentDate;
        TextView titleLocation;
        TextView contentLocation;
        TextView contentPeople;
        TextView contentPrice;
        TextView contentModifyBtn;
        TextView contentChecklistBtn;
        TextView contentInformBtn;
        ImageView titleIcon;

    }
}
