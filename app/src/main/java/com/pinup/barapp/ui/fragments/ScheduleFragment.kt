package com.pinup.barapp.ui.fragments

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ArrayAdapter
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.pinup.barapp.R
import com.pinup.barapp.databinding.FragmentScheduleBinding
import com.pinup.barapp.ui.adapters.ScheduleAdapter
import com.pinup.barapp.ui.viewmodels.ScheduleViewModel
import dagger.hilt.android.AndroidEntryPoint
import java.time.LocalDate
import java.time.Month
import java.time.format.TextStyle
import java.util.Locale
@AndroidEntryPoint
class ScheduleFragment : Fragment(R.layout.fragment_schedule) {

    private var _binding: FragmentScheduleBinding? = null
    private val binding get() = _binding!!

    private val viewModel: ScheduleViewModel by viewModels()
    private lateinit var adapter: ScheduleAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentScheduleBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        adapter = ScheduleAdapter()
        binding.recyclerSchedule.adapter = adapter

        val months = Month.values().map { it.getDisplayName(TextStyle.FULL, Locale.US) }
        val spinnerAdapter = ArrayAdapter(requireContext(), android.R.layout.simple_spinner_item, months)
        spinnerAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        binding.tvMonth.adapter = spinnerAdapter
        binding.tvMonth.setSelection(LocalDate.now().monthValue - 1)

        binding.tvMonth.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>, view: View?, position: Int, id: Long) {
                val month = Month.of(position + 1)
                viewModel.loadMatchesForMonth(month)
            }

            override fun onNothingSelected(parent: AdapterView<*>) {}
        }

        viewModel.matches.observe(viewLifecycleOwner) { list ->
            adapter.submitList(list)
            binding.tvEmpty.visibility = if (list.isEmpty()) View.VISIBLE else View.GONE
            binding.recyclerSchedule.visibility = if (list.isEmpty()) View.GONE else View.VISIBLE
            Log.d("ScheduleViewModel", "Loaded matches: ${list.size}")

        }
        viewModel.loadMatchesForMonth(LocalDate.now().month)
    }
}
