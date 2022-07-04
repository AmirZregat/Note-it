package com.project.noteit.note

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.project.noteit.R
import com.project.noteit.data.model.Note
import com.project.noteit.databinding.FragmentNoteDetailBinding
import com.project.noteit.util.UiState
import com.project.noteit.util.hide
import com.project.noteit.util.show
import com.project.noteit.util.toast
import dagger.hilt.android.AndroidEntryPoint
import java.util.*

@AndroidEntryPoint
class NoteDetailFragment : Fragment() {
    lateinit var binding: FragmentNoteDetailBinding
    val viewModel: NoteViewModel by viewModels()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentNoteDetailBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.button.setOnClickListener {
            if (validation()) {
                viewModel.addNote(
                    Note(
                        id = "",
                        text = binding.noteMsg.text.toString(),
                        date = Date()
                    )
                )
            }
        }

        viewModel.addNote.observe(viewLifecycleOwner)
        { state ->
            when (state) {
                is UiState.Loading -> {
                    binding.btnProgressAr.show()
                    binding.button.text=""
                }
                is UiState.Failure -> {
                    binding.btnProgressAr.hide()
                    binding.button.text="Create"
                    toast(state.error)
                }
                is UiState.Success -> {
                    binding.btnProgressAr.hide()
                    binding.noteMsg.setText("")
                    toast(state.data)

                }

            }
        }
    }

    private fun validation(): Boolean {
        var isValid = true
        if (binding.noteMsg.text.toString().isNullOrEmpty()) {
            isValid = false
            toast("Enter note")
        }
        return isValid
    }

}