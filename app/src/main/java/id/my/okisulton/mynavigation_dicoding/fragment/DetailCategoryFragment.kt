package id.my.okisulton.mynavigation_dicoding.fragment

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.findNavController
import id.my.okisulton.mynavigation_dicoding.R
import id.my.okisulton.mynavigation_dicoding.databinding.FragmentDetailCategoryBinding

class DetailCategoryFragment : Fragment() {
    private var _binding : FragmentDetailCategoryBinding? = null
    private val binding get() = _binding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentDetailCategoryBinding.inflate(inflater, container, false)
        return binding?.root
    }

    @SuppressLint("SetTextI18n")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        //without safe argument
//        val dataName = arguments?.getString(CategoryFragment.EXTRA_NAME)
//        val dataDescription = arguments?.getLong(CategoryFragment.EXTRA_STOCK)

        //with save argument
        val dataName = DetailCategoryFragmentArgs.fromBundle(arguments as Bundle).name
        val dataDescription = DetailCategoryFragmentArgs.fromBundle(arguments as Bundle).stock

        binding?.apply {
            tvCategoryName.text = dataName
            tvCategoryDescription.text = "Stock : $dataDescription"
            btnProfile.setOnClickListener {
                view.findNavController().navigate(R.id.action_detailCategoryFragment_to_homeFragment)
            }
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

}