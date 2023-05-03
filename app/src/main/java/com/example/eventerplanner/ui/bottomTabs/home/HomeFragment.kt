package com.example.eventerplanner.ui.bottomTabs.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Button
import androidx.compose.material.SwipeToDismiss
import androidx.compose.material.Text
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.ComposeView
import androidx.compose.ui.platform.ViewCompositionStrategy
import androidx.compose.ui.unit.sp
import androidx.fragment.app.Fragment
import androidx.navigation.NavBackStackEntry
import androidx.navigation.findNavController
import com.example.eventerplanner.R
import com.example.eventerplanner.presentation.theme.EventerPlannerTheme

class HomeFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return ComposeView(requireContext()).apply {
            setViewCompositionStrategy(ViewCompositionStrategy.DisposeOnViewTreeLifecycleDestroyed)
            setContent {
                EventerPlannerTheme {
                    Column(
                        modifier = Modifier.fillMaxSize(),
                        verticalArrangement = Arrangement.Center,
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {

                        Text(
                            text = "HomeFragment",
                            fontSize = 36.sp
                        )
                        Button(
                            onClick = {
                                findNavController().navigate(R.id.action_homeFragment_to_detailEventFragment)
                            }
                        ) {
                            Text("К экрану карточки")
                        }
                        Button(
                            onClick = {
                                findNavController().navigate(R.id.action_homeFragment_to_detailCategoriesFragment)
                            }
                        ) {
                            Text("К экрану категорий")
                        }
                    }
                }
            }
        }
    }
}
