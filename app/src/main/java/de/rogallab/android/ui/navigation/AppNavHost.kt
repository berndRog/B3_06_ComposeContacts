package de.rogallab.android.ui.navigation

import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import de.rogallab.android.domain.utilities.LogComp
import de.rogallab.android.ui.contacts.ContactInputScreen
import de.rogallab.android.ui.contacts.ContactsHomeScreen

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun AppNavHost(
) {
   val navHostController: NavHostController = rememberNavController()

// https://medium.com/androiddevelopers/animations-in-navigation-compose-36d48870776b

   NavHost(
      navController = navHostController,
      startDestination = NavScreen.ContactsHome.route
   ) {
      composable(
         route = NavScreen.ContactsHome.route,
      ) {
         LogComp("ok>AppNavHost         .", "ContactsHomeScreen()")
         ContactsHomeScreen(
            navController = navHostController
         )
      }

      composable(
         route = NavScreen.ContactInput.route,
      ) {
         LogComp("ok>AppNavHost         .", "ContactInputScreen()")
         ContactInputScreen(
            navController = navHostController
         )
      }
   }
}