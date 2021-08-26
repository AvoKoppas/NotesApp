package com.testdevlab.notesapp.common

import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import com.testdevlab.notesapp.R

fun Fragment.openFragment(id: Int) = activity?.findNavController(R.id.navigation_host_fragment)?.navigate(id)