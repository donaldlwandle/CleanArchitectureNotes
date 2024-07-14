package com.donaldlwandle.cleanarchitecturenotes.business.data.local_cache.abstraction

import com.donaldlwandle.cleanarchitecturenotes.business.domain.models.Note

interface NoteCacheDataSource {

     //Insert a note into a local cache sql lite database
     suspend fun  insertNote(note:Note): Long

     // Delete a Note from a local cache sql lite database
     suspend fun  deleteNote(primaryKey:String): Int

     //Delete Multiple notes from the local cache sql lite database
     suspend fun deleteNotes(notes: List<Note>) : Int

     //update an already existing note from a local cache sql lite database
     suspend fun updateNote(primaryKey: String, newTitle:String , newBody:String) : Int

     //Search notes from local cache sql lite database
     suspend fun  searchNotes(query:String , filterAndOrder: String, page:Int) : List<Note>

     //Search notes from local cache sql lite database by ID
     suspend fun searchNotesByID(primaryKey: String) : Note

     // Get the total number of notes existing in the local cache sql  of lite database
     suspend fun getNumOfNotes():Int

     //Insert list of notes in to the sql lite local cache database
     //Only used for testing
     suspend fun insertNotes(notes:List<Note>): LongArray
}