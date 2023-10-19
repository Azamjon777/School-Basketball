package ganhar.emsfv.schoolbacketball.presentation.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import ganhar.emsfv.schoolbacketball.databinding.FragmentMoreDetailsBinding

class MoreDetailsFragment : Fragment() {

    private lateinit var binding: FragmentMoreDetailsBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentMoreDetailsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val title = arguments?.getString("text", "")
        val subitemName = arguments?.getString("subitemName", "")
        val imageResId = arguments?.getInt("imageResId", 0)

        binding.text.text = subitemName
        binding.title.text = title

        if (imageResId != null && imageResId != 0) {
            binding.imageOfItem.setImageResource(imageResId)
        }
        binding.exit.setOnClickListener {
            requireActivity().onBackPressed()
        }
    }
}
