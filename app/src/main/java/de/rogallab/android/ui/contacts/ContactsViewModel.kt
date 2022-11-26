package de.rogallab.android.ui.contacts

import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import de.rogallab.android.domain.entities.Contact
import de.rogallab.android.domain.utilities.LogFun
import java.util.*

class ContactsViewModel() : ViewModel() {

   var id: UUID = UUID.randomUUID()

   // State = Observables (DataBinding)
   var firstName: String by mutableStateOf(value = "")
      private set
   fun onFirstNameChange(value: String) { firstName = value }

   var lastName: String by mutableStateOf(value = "")
      private set
   fun onLastNameChange(value: String) { lastName = value }

   var email: String? by mutableStateOf(value = null)
      private set
   fun onEmailChange(value: String) { email = value }

   var phone: String? by mutableStateOf(value = null)
      private set
   fun onPhoneChange(value: String) { phone = value }

   var imagePath: String? by mutableStateOf(value = null)
      private set
   fun onImagePathChange(value: String?) { imagePath = value }

   // State errorMessage
   var errorMessage: String? by mutableStateOf(value = null)
      private set
   fun onErrorMessage(value: String) { errorMessage = value }
   // error handling -> dismissed
   fun onErrorDismiss() { LogFun(_tag,"onErrorReject()") }
   // error handling
   fun onErrorAction() { LogFun(_tag,"onErrorAction()") }

   init{
//    errorMessage = "Test SnackBar: Fehlermeldung ..."
   }

   // lifecycle ViewModel
   override fun onCleared() {
      Log.d(_tag, "onCleared()")
      super.onCleared()
   }

   private fun setStateFromContact(contact: Contact) {
      id        = contact.id
      firstName = contact.firstName
      lastName  = contact.lastName
      email     = contact.email
      phone     = contact.phone
      imagePath = contact.imagePath
   }

   private fun getContactFromState(): Contact =
      Contact(firstName, lastName, email, phone, imagePath, UUID.randomUUID())

   companion object {
      private val _tag:String = "ok>ContactViewModel   ."
   }
}