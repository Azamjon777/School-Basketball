package ganhar.emsfv.schoolbacketball.presentation.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import ganhar.emsfv.schoolbacketball.R
import ganhar.emsfv.schoolbacketball.adapter.MenuExpandableListAdapter
import ganhar.emsfv.schoolbacketball.databinding.FragmentMenuBinding

class MenuFragment : Fragment() {

    private lateinit var binding: FragmentMenuBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentMenuBinding.inflate(inflater, container, false)
        val expandableListView = binding.expandableListView

        val menuItems =
            listOf(
                "Интерактив",
                "Главное",
                "Преивущества и риски",
                "Анализ",
                "Стратегии",
                "Заметки"
            )
        val submenuItems = mapOf(
            "Интерактив" to listOf("Интерактив"),
            "Главное" to listOf(
                "Как играть в баскетбол",
                "Основной состав",
                "Распространенные нарушения"
            ),
            "Преивущества и риски" to listOf(
                "Достоинства ставок на баскетбол",
                "Недостатки ставок на баскетбол"
            ),
            "Анализ" to listOf("Предамтчевая аналитика"),
            "Стратегии" to listOf(
                "Основные исходы",
                "Фора",
                "Тотал",
                "Стратегия ставок на тотал в баскетболе",
                "Ставки на баскетбол по четвертям",
                "Стратегия ставок на баскетбол по четвертям"
            ),
            "Заметки" to listOf("Все заметки")
        )

        val adapter = MenuExpandableListAdapter(requireContext(), menuItems, submenuItems)
        expandableListView.setAdapter(adapter)

        expandableListView.setOnChildClickListener { _, _, groupPosition, childPosition, _ ->
            onSubmenuItemClicked(groupPosition, childPosition)
            true
        }
        return binding.root
    }

    private fun onSubmenuItemClicked(groupPosition: Int, childPosition: Int) {
        var text = ""
        var subitemName = ""
        var imageResId = 0
        when (groupPosition) {
            0 -> when (childPosition) {
                0 -> {
                    text = "Интерактив"
                    imageResId = R.drawable.cort
                }
            }

            1 -> when (childPosition) {
                0 -> {
                    text = requireActivity().getString(R.string.title_how_to_play_basketball)
                    subitemName = requireActivity().getString(R.string.how_to_play_basketball)
                    imageResId = R.drawable.default_img
                }

                1 -> {
                    text = "Основной состав"
                    subitemName = requireActivity().getString(R.string.head_team)
                    imageResId = R.drawable.head_team
                }

                2 -> {
                    text = "Распространенные нарушения"
                    subitemName = requireActivity().getString(R.string.fouls)
                    imageResId = R.drawable.default_img
                }
            }

            2 -> when (childPosition) {
                0 -> {
                    text = "Достоинства ставок на баскетбол"
                    subitemName = requireActivity().getString(R.string.advantages)
                    imageResId = R.drawable.advantages
                }

                1 -> {
                    text = "Недостатки ставок на баскетбол"
                    subitemName = requireActivity().getString(R.string.risks)
                    imageResId = R.drawable.default_img
                }
            }

            3 -> when (childPosition) {
                0 -> {
                    text = "Предматчевая аналитика"
                    subitemName = requireActivity().getString(R.string.until_game_analise)
                    imageResId = R.drawable.until_game_analise
                }
            }

            4 -> when (childPosition) {
                0 -> {
                    text = "Основные исходы"
                    subitemName = requireActivity().getString(R.string.game_result)
                    imageResId = R.drawable.game_result
                }

                1 -> {
                    text = "Фора"
                    subitemName = requireActivity().getString(R.string.fora)
                    imageResId = R.drawable.default_img
                }

                2 -> {
                    text = "Тотал"
                    subitemName = requireActivity().getString(R.string.total)
                    imageResId = R.drawable.default_img
                }

                3 -> {
                    text = "Стратегия ставок на тотал в баскетболе"
                    subitemName = requireActivity().getString(R.string.strategy)
                    imageResId = R.drawable.default_img
                }

                4 -> {
                    text = "Ставки на баскетбол по четвертям"
                    subitemName = requireActivity().getString(R.string.bet)
                    imageResId = R.drawable.default_img
                }

                5 -> {
                    text = "Стратегия ставок на баскетбол по четвертям"
                    subitemName = requireActivity().getString(R.string.bet)
                    imageResId = R.drawable.default_img
                }
            }

            5 -> when (childPosition) {
                0 -> {
                    findNavController().navigate(R.id.action_menuFragment_to_notesFragment)
                }
            }
        }

        val bundle = bundleOf(
            "text" to text,
            "subitemName" to subitemName,
            "imageResId" to imageResId
        )
        findNavController().navigate(R.id.action_menuFragment_to_moreDetailsFragment, bundle)
    }
}