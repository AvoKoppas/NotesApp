package com.testdevlab.notesapp.ui.createnote

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.testdevlab.notesapp.databinding.FragmentCreateNoteBinding

class CreateNoteFragment : Fragment() {

    private lateinit var binding: FragmentCreateNoteBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        binding = FragmentCreateNoteBinding.inflate(layoutInflater)
        return binding.root
    }
}