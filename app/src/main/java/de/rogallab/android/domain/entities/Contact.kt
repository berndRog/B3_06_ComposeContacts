package de.rogallab.android.domain.entities

import java.util.*

data class Contact(
   var firstName: String,
   var lastName: String,
   var email: String? = null,
   var phone:String? = null,
   var imagePath: String? = "",
   var id: UUID = UUID.randomUUID()
)
