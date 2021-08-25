package com.testdevlab.notesapp.ui.list
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import com.testdevlab.notesapp.R
import com.testdevlab.notesapp.databinding.FragmentListBinding

class ListFragment : Fragment() {
    private lateinit var binding: FragmentListBinding
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        binding = FragmentListBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.createNewNote.setOnClickListener {
            requireActivity().findNavController(R.id.navigation_host_fragment).navigate(R.id.navigation_create_note)
        }

    }
}