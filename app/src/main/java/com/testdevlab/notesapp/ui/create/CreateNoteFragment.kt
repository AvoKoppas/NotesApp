package com.testdevlab.notesapp.ui.create

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import com.testdevlab.notesapp.R
import com.testdevlab.notesapp.common.openFragment
import com.testdevlab.notesapp.databinding.FragmentCreateNoteBinding
import com.testdevlab.notesapp.ui.MainViewModel

class CreateNoteFragment : Fragment() {
    private lateinit var binding: FragmentCreateNoteBinding
    private val viewModel by activityViewModels<MainViewModel>()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        binding = FragmentCreateNoteBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.addNewNote.setOnClickListener {
            viewModel.addNote(binding.titleInput.text.toString(), binding.textInput.text.toString())
            openFragment(R.id.navigation_list)
        }
    }
}