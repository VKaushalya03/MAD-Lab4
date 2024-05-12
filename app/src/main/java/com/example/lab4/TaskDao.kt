// TaskDao.kt

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.lab4.Task

@Dao
interface TaskDao {

    @Query("SELECT * FROM tasks")
    fun getAllTasks(): LiveData<List<Task>>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertTask(task: Task)

    @Update
    suspend fun updateTask(task: Task)

    @Delete
    suspend fun deleteTask(task: Task)
}
