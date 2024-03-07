package com.example.gicom_ipbeja.view;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.bumptech.glide.Glide;
import com.example.gicom_ipbeja.R;
import com.example.gicom_ipbeja.data.localdatabase.CoursesItem;

import java.util.ArrayList;
import java.util.List;

public class AutoCompleteCourseAdapter extends ArrayAdapter<CoursesItem> implements Filterable {

    private List<CoursesItem> courseListFull;
    private List<CoursesItem> courseListFiltered = new ArrayList<>();
    ;

    private OnCourseItemClickListener onCourseItemClickListener;

    private Context context;

    public AutoCompleteCourseAdapter(Context context) {
        super(context, 0);
        this.context = context;
        this.courseListFull = new ArrayList<>();
    }

    @NonNull
    @Override
    public Filter getFilter() {
        return courseFilter;
    }

    @Override
    public int getCount() {
        return courseListFiltered.size();
    }

    public void updateList(List<CoursesItem> newList) {
        courseListFull = newList;
        getFilter().filter("");
    }

    @Nullable
    @Override
    public CoursesItem getItem(int position) {
        return courseListFiltered.get(position);
    }

    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.restaurant_autocomplete_row, parent, false);
        }

        TextView courseNameTextView = convertView.findViewById(R.id.course_name);
        ImageView courseImageView = convertView.findViewById(R.id.course_image);

        CoursesItem course = getItem(position);
        if (course != null) {
            courseNameTextView.setText(course.getCourseName());

            Glide.with(context)
                    .load(course.getFlagImage())
                    .into(courseImageView);
        }
        convertView.setOnClickListener(v -> {
            if (course != null && onCourseItemClickListener != null) {
                onCourseItemClickListener.onCourseItemClick(course);
            }
        });

        return convertView;
    }

    private Filter courseFilter = new Filter() {
        @Override
        protected FilterResults performFiltering(CharSequence constraint) {
            FilterResults filterResults = new FilterResults();

            if (constraint != null) {
                String filterPattern = constraint.toString().toLowerCase().trim();
                List<CoursesItem> filteredList = new ArrayList<>();

                for (CoursesItem restaurant : courseListFull) {
                    if (restaurant != null && restaurant.getCourseName() != null &&
                            restaurant.getCourseName().toLowerCase().contains(filterPattern)) {
                        filteredList.add(restaurant);
                    }
                }

                filterResults.values = filteredList;
                filterResults.count = filteredList.size();
            }

            return filterResults;
        }

        @Override
        protected void publishResults(CharSequence constraint, FilterResults results) {
            courseListFiltered = (List<CoursesItem>) results.values;

            if (results.count > 0) {
                notifyDataSetChanged();
            } else {
                notifyDataSetInvalidated();
            }
        }

        @Override
        public CharSequence convertResultToString(Object resultValue) {
            return ((CoursesItem) resultValue).getCourseName();
        }
    };


    public void setOnCourseItemClickListener(OnCourseItemClickListener listener) {
        this.onCourseItemClickListener = listener;
    }

    public interface OnCourseItemClickListener {
        void onCourseItemClick(CoursesItem coursesItem);
    }
}
