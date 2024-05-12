// UpdateTaskFragment.kt

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.example.lab4.R
import com.example.lab4.Task
import com.example.lab4.TaskViewModel
import kotlinx.android.synthetic.main.fragment_update_task.*
import kotlinx.android.synthetic.main.fragment_update_task.view.*

class UpdateTaskFragment : Fragment() {

    private val viewModel: TaskViewModel by viewModels()
    private lateinit var taskToUpdate: Task

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_update_task, container, false)

        taskToUpdate = arguments?.getParcelable("task")!!

        view.apply {
            editTextTaskName.setText(taskToUpdate.name)
            editTextTaskDescription.setText(taskToUpdate.description)
            editTextTaskPriority.setText(taskToUpdate.priority)
            editTextTaskDeadline.setText(taskToUpdate.deadline)

            buttonUpdate.setOnClickListener {
                val name = editTextTaskName.text.toString()
                val description = editTextTaskDescription.text.toString()
                val priority = editTextTaskPriority.text.toString()
                val deadline = editTextTaskDeadline.text.toString()

                if (name.isNotBlank() && description.isNotBlank() && priority.isNotBlank() && deadline.isNotBlank()) {
                    val updatedTask = Task(taskToUpdate.id, name, description, priority, deadline)
                    viewModel.updateTask(updatedTask)
                    requireActivity().supportFragmentManager.popBackStack()
                }
            }

            buttonDelete.setOnClickListener {
                viewModel.deleteTask(taskToUpdate)
                requireActivity().supportFragmentManager.popBackStack()
            }
        }

        return view
    }
}
