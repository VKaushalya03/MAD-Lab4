package com.example.lab4
// TaskListFragment.kt

import TaskAdapter
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.fragment_task_list.*

class TaskListFragment : Fragment() {

    private val viewModel: TaskViewModel by viewModels()
    private lateinit var taskAdapter: TaskAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_task_list, container, false)

        taskAdapter = TaskAdapter()
        recyclerViewTasks.apply {
            adapter = taskAdapter
            layoutManager = LinearLayoutManager(requireContext())
        }

        viewModel.allTasks.observe(viewLifecycleOwner, { tasks ->
            tasks?.let { taskAdapter.submitList(it) }
        })

        return view
    }
}
