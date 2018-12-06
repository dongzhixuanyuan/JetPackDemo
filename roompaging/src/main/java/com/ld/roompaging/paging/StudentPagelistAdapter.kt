package com.ld.roompaging.paging

import android.arch.paging.PagedListAdapter
import android.support.v7.util.DiffUtil
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.ld.roompaging.R
import com.ld.roompaging.db.Student
import kotlinx.android.synthetic.main.student_item.view.*

class StudentPagelistAdapter : PagedListAdapter<Student,
        StudentPagelistAdapter.StudentViewHolder>(DEFAULT_COMPARATOR) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): StudentViewHolder {
        return when (viewType) {
            R.layout.student_item -> StudentViewHolder.create(parent)
            else -> StudentViewHolder.create(parent)
        }

    }

    override fun getItemViewType(position: Int): Int {
        return R.layout.student_item
    }

    override fun onBindViewHolder(holder: StudentViewHolder, position: Int) {
        var item = getItem(position)
        with(holder.view) {
            number.text = item?.number.toString()
            address.text = item?.address
            name.text = item?.name
        }
    }


    class StudentViewHolder(val view: View) : RecyclerView.ViewHolder(view) {
        companion object {
            fun create(parent: ViewGroup): StudentViewHolder {
                var view = LayoutInflater.from(parent.context).inflate(R.layout.student_item, parent, false)
                return StudentViewHolder(view)
            }
        }
    }

    companion object {
        val DEFAULT_COMPARATOR = object : DiffUtil.ItemCallback<Student>() {
            override fun areItemsTheSame(p0: Student, p1: Student): Boolean {
                if (p0.number == p1.number) {
                    return true
                }
                return false
            }

            override fun areContentsTheSame(p0: Student, p1: Student): Boolean {
                return true
            }

        }
    }
}