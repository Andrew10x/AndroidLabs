package com.andrew10x.lab1kotlin2


import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.activity.viewModels
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import androidx.lifecycle.LifecycleOwner
import com.andrew10x.lab1kotlin2.databinding.FragmentChooseTrainBinding
import com.andrew10x.lab1kotlin2.entities.TicketItem
import com.andrew10x.lab1kotlin2.db.MainViewModel

class ChooseTrainFragment : Fragment() {
    private val dataModel: DataModel by activityViewModels()
    lateinit var binding: FragmentChooseTrainBinding
    private  val mainViewModel: MainViewModel by activityViewModels {
        MainViewModel.MainViewModelFactory((context?.applicationContext as MainApp).database)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        binding = FragmentChooseTrainBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        val timeArr = arrayOf("оберіть дату", "9:00", "12:30", "16:50", "19:00", "22:10")
        val timeAdapter = ArrayAdapter(requireContext(), android.R.layout.simple_spinner_item, timeArr)
        timeAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        binding.timeSpinner.adapter = timeAdapter
        binding.choseBtn.setOnClickListener {
            if (binding.timeSpinner.selectedItem === "оберіть дату") {
                Toast.makeText(requireContext(), R.string.no_time_input,
                    Toast.LENGTH_LONG).show()
            }
            else {
                dataModel.messageForResOutputFragment.value = "Ви обрали потяг з міста " +
                        binding.from.text + " до міста " + binding.to.text + " з часом відправки " +
                        binding.timeSpinner.selectedItem

                addTicketToDb()
            }
        }

        binding.openBtn.setOnClickListener {
            val i = Intent(activity, TicketsActivity::class.java)
            startActivity(i)

        }

        dataModel.messageForChooseTrainFragment.observe(activity as LifecycleOwner) {
            if(it === "Cancel"){
                binding.timeSpinner.setSelection(0)
            }
        }
    }

    private fun addTicketToDb() {
        val item = TicketItem(
            null,
            binding.from.text.toString(),
            binding.to.text.toString(),
            binding.timeSpinner.selectedItem.toString()
        )
        mainViewModel.insertTicket(item)
    }

    companion object {
        fun newInstance() =
            ChooseTrainFragment()
    }
}