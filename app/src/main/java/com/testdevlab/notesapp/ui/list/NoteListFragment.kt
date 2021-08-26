package com.testdevlab.notesapp.ui.list

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.findNavController
import com.testdevlab.notesapp.R
import com.testdevlab.notesapp.common.launchMain
import com.testdevlab.notesapp.common.openFragment
import com.testdevlab.notesapp.databinding.FragmentListBinding
import com.testdevlab.notesapp.ui.MainViewModel
import kotlinx.coroutines.flow.collect
import timber.log.Timber

class NoteListFragment : Fragment() {

    private lateinit var binding: FragmentListBinding

    private val viewModel by activityViewModels<MainViewModel>()

    private val adapter by lazy {
        NoteListAdapter { note ->
            Timber.d("Note item clicked: $note")
            viewModel.selectedNote = note
            openFragment(R.id.navigation_view_note)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentListBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.list.adapter = adapter

        binding.createNewNote.setOnClickListener {
            requireActivity().findNavController(R.id.navigation_host_fragment)
                .navigate(R.id.navigation_create_note)
        }

        launchMain {
            viewModel.notes.collect { notes ->
                binding.emptyList.visibility = if (notes.isEmpty()) {
                    View.VISIBLE
                } else {
                    View.GONE
                }
                adapter.noteList = notes
            }
        }
    }
}