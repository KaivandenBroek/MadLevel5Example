package com.example.madlevel5example.ui

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import com.example.madlevel5example.model.Reminder
import com.example.madlevel5example.repository.ReminderRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class ReminderViewModel(application: Application) : AndroidViewModel(application) {
    private val ioScope = CoroutineScope(Dispatchers.IO)
    private val remindersRepository = ReminderRepository(application.applicationContext)

    val reminders: LiveData<List<Reminder>> = remindersRepository.getAllReminders()

    fun insertReminder(reminder: Reminder) {
        ioScope.launch {
            remindersRepository.insertReminder(reminder)
        }
    }

    fun deleteReminder(reminder: Reminder) {
        ioScope.launch {
            remindersRepository.deleteReminder(reminder)
        }
    }
}