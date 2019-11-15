    package com.example.assignment2_part2.Adaptor;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import android.content.Intent;

import com.example.assignment2_part2.R;
import com.example.assignment2_part2.StudentDetailsActivity;
import com.example.assignment2_part2.model.Student;
import com.example.assignment2_part2.model.StudentDB;

public class SummaryListAdapter extends BaseAdapter {
    @Override
    public int getCount()
    {
        return StudentDB.getInstance().getStudentList().size();
    }

    @Override
    public Object getItem(int i)
    {
        return StudentDB.getInstance().getStudentList().get(i);
    }

    @Override
    public long getItemId(int i)
    {
        return 0;
    }

    @Override
    public View getView(final int i, View view, ViewGroup viewGroup)
    {
        View row_view;

        if(view == null)
        {
            LayoutInflater inflater = LayoutInflater.from(viewGroup.getContext());
            row_view = inflater.inflate(R.layout.student_row, viewGroup, false);

        }
        else
        {
            row_view = view;
        }

        //
        Student p = StudentDB.getInstance().getStudentList().get(i);

        ((TextView) row_view.findViewById(R.id.first_name)).setText(p.getFirstName());

        ((TextView) row_view.findViewById(R.id.last_name)).setText(p.getLastName());

        ((TextView) row_view.findViewById(R.id.student_id)).setText(p.getStudentId());

        row_view.setTag(new Integer(i));

        row_view.setOnClickListener(
                new View.OnClickListener()
                {
                    @Override
                    public void onClick(View view)
                    {
                        Intent intent = new Intent(view.getContext(), StudentDetailsActivity.class);
                        intent.putExtra("StudentIndex", ((Integer)view.getTag()).intValue());
                        view.getContext().startActivity(intent);
                    }
                }
        );
        return row_view;
    }
}
