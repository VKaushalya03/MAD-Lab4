package com.example.lab4
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "tasks")
data class Task(
    @PrimaryKey(autoGenerate = true)
    val id: Long = 0L,
    val name: String,
    val description: String,
    val priority: String,
    val deadline: String
)