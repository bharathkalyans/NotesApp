package com.bharathkalyans.notesapp

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider

class MainActivity : AppCompatActivity() {

    lateinit var viewModel: NoteViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        viewModel = ViewModelProvider(this,
                ViewModelProvider
                        .AndroidViewModelFactory.getInstance(application))
                .get(NoteViewModel::class.java)

        viewModel.allNotes.observe(this, {

        })
    }

}