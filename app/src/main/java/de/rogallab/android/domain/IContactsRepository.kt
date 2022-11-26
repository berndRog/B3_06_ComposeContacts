package de.rogallab.android.domain
import de.rogallab.android.domain.entities.Contact
import kotlinx.coroutines.flow.Flow
import java.util.*

interface IContactsRepository {

   fun getAll(): Flow<MutableList<Contact>>
   suspend fun getById(id: UUID): Contact?
   suspend fun getByPhone(phone: String): Contact?

   suspend fun add(account: Contact)
   suspend fun addAll(accounts: List<Contact>)
   suspend fun update(account: Contact)
   suspend fun remove(account: Contact)
   suspend fun removeAll()

   suspend fun count(): Int

}