package de.rogallab.android.ui.navigation

import androidx.compose.ui.graphics.vector.ImageVector

sealed class NavScreen(
   val route: String,
   val resIdTitle: Int? = null,
   val icon: ImageVector? = null
) {
   object ContactsHome: NavScreen(
      route = "contactsHomeScreen"
   )
   object ContactInput: NavScreen(
      route = "contactInputScreen"
   )
}