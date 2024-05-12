package com.example.lab4
// AddTaskFragment.kt

import com.example.lab4.AddTaskFragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import kotlinx.android.synthetic.main.fragment_add_task.*
import kotlinx.android.synthetic.main.fragment_add_task.view.*

class AddTaskFragment : Fragment() {

    private val viewModel: TaskViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_add_task, container, false)

        view.buttonSubmit.setOnClickListener {
            val name = editTextTaskName.text.toString()
            val description = editTextTaskDescription.text.toString()
            val priority = editTextTaskPriority.text.toString()
            val deadline = editTextTaskDeadline.text.toString()

            if (name.isNotBlank() && description.isNotBlank() && priority.isNotBlank() && deadline.isNotBlank()) {
                val task = Task(name = name, description = description, priority = priority, deadline = deadline)
                viewModel.insertTask(task)
                clearFields()
            }
        }

        return view
    }

    private fun clearFields() {
        editTextTaskName.text.clear()
        editTextTaskDescription.text.clear()
        editTextTaskPriority.text.clear()
        editTextTaskDeadline.text.clear()
    }
}
