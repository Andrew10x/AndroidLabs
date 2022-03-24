package com.andrew10x.lab1kotlin2

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.LifecycleOwner
import com.andrew10x.lab1kotlin2.databinding.FragmentResOutputBinding

class ResOutputFragment : Fragment() {
    private val dataModel: DataModel by activityViewModels()
    lateinit var binding:FragmentResOutputBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentResOutputBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        dataModel.messageForResOutputFragment.observe(activity as LifecycleOwner) {
            binding.resOutput.text = it
            binding.button.visibility = View.VISIBLE
        }

        binding.button.setOnClickListener {
            dataModel.messageForChooseTrainFragment.value = "Cancel"
            binding.resOutput.text = ""
            binding.button.visibility = View.GONE
        }
    }

    companion object {

        @JvmStatic
        fun newInstance() =
            ResOutputFragment()
    }
}