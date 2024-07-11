package com.donaldlwandle.cleanarchitecturenotes.business.domain.models

import com.donaldlwandle.cleanarchitecturenotes.business.domain.utils.DateUtil
import java.util.UUID
import javax.inject.Inject
import javax.inject.Singleton

// produces Notes
@Singleton
class NoteFactory

@Inject
constructor(
    private val dateUtil: DateUtil
){

    // Used to create a new note
    //
    fun createSingleNote(
        id:String? = null,
        title: String,
        body: String? = null
    ) : Note{
        return Note(
            id=id ?: UUID.randomUUID().toString(),
            title =title,
            body = body ?: "" ,
            created_at = dateUtil.getCurrentDateTimestamp(),
            updated_at = dateUtil.getCurrentDateTimestamp()
        )
    }

    //  Generates list of notes( Dummy notes)
    // Will be used for testing
    //input number of notes required
    fun createNotesList (numNotes: Int) :List<Note>{
        val list : ArrayList<Note> = ArrayList()

        for(i in 0 until  numNotes){
            list.add(
                createSingleNote(
                    id = null,
                    title = UUID.randomUUID().toString(),
                    body = UUID.randomUUID().toString()
                )
            )
        }

        return list
    }

}