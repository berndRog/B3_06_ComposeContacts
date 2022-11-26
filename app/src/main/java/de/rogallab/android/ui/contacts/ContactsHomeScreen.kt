package de.rogallab.android.ui.contacts

import android.annotation.SuppressLint
import android.app.Activity
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Menu
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.navigation.NavController
import de.rogallab.android.R
import de.rogallab.android.domain.utilities.LogComp
import de.rogallab.android.domain.utilities.LogFun
import de.rogallab.android.ui.composables.ShowErrorMessage
import de.rogallab.android.ui.navigation.NavScreen
import de.rogallab.android.ui.theme.paddings

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@ExperimentalMaterialApi
@Composable
fun ContactsHomeScreen(
   navController: NavController,
   viewModel: ContactsViewModel = androidx.lifecycle.viewmodel.compose.viewModel(),
) {

   val tag: String = "ok>ContactsHomeScreen ."
// viewModel.onErrorMessage("Test SnackBar: Fehlermeldung ...")

   val scaffoldState: ScaffoldState = rememberScaffoldState()

   ShowErrorMessage(
      scaffoldState  =   scaffoldState,               // State ↓
      errorMessage   =   viewModel.errorMessage,      // State ↓
      actionLabel    =   null,
      onErrorDismiss = { viewModel.onErrorDismiss() }, // Event ↑
      onErrorAction  = { viewModel.onErrorAction() }, // Event ↑
   )

   Scaffold(
      scaffoldState = scaffoldState,
      topBar = {
         TopAppBar(
            title = { Text(text = stringResource(R.string.app_name)) },
            navigationIcon = {
               val activity = (LocalContext.current as? Activity)
               IconButton(onClick = {
                  LogFun(tag, "MENU clicked: finish app")
                  // Show navigation menu or navigation drawer
                  activity?.finish()
               }) {
                  Icon(imageVector = Icons.Default.Menu,
                     contentDescription = stringResource(R.string.back))
               }
            }
         )
      },
      floatingActionButton = {
         FloatingActionButton(
            backgroundColor = MaterialTheme.colors.secondaryVariant,
            onClick = {
               LogFun(tag, "FAB clicked: Add a contact")
               navController.navigate(NavScreen.ContactInput.route)
            }
         ) {
            Icon(Icons.Default.Add, "Add a contact")
         }
      },
      floatingActionButtonPosition = FabPosition.End,
      snackbarHost = { snackBarHostState ->
         SnackbarHost(hostState = snackBarHostState) { data ->
            Snackbar(
               //modifier =  Modifier.border(2.dp, MaterialTheme.colors.secondary),
               snackbarData = data,
               actionOnNewLine = true
            )
         }
      }
   ) {
      LogComp(tag, "Scaffold")

      Column(
         modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = MaterialTheme.paddings.small)
            .padding(bottom = it.calculateBottomPadding()),
         horizontalAlignment = Alignment.CenterHorizontally,
         verticalArrangement = Arrangement.Center
      ) {
         Text(
            text = "EMPTY HOMESCREEN",
            style = MaterialTheme.typography.h4
         )
      }
   }
}
