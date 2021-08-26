package com.testdevlab.notesapp.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import com.testdevlab.notesapp.R
import com.testdevlab.notesapp.common.openFragment
import com.testdevlab.notesapp.databinding.FragmentViewNoteBinding

class ViewNoteFragment : Fragment() {

    private lateinit var binding: FragmentViewNoteBinding

    private val viewModel by activityViewModels<MainViewModel>()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        binding = FragmentViewNoteBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.item = viewModel.selectedNote

        binding.deleteNote.setOnClickListener {
            viewModel.deleteNote()
            openFragment(R.id.navigation_list)
        }
    }
}