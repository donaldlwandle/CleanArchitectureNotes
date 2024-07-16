package com.donaldlwandle.cleanarchitecturenotes.business.data.local_cache.implementation

import com.donaldlwandle.cleanarchitecturenotes.business.data.local_cache.abstraction.NoteCacheDataSource
import com.donaldlwandle.cleanarchitecturenotes.business.domain.models.Note
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class NoteCacheDataSourceImplementation
@Inject
constructor(
    private  val noteDaoService: NoteDaoService
): NoteCacheDataSource{
    override suspend fun insertNote(note: Note)= noteDaoService.insertNote(note)

    override suspend fun deleteNote(primaryKey: String) = noteDaoService.deleteNote(primaryKey)

    override suspend fun deleteNotes(notes: List<Note>) = noteDaoService.deleteNotes(notes)

    override suspend fun updateNote(primaryKey: String, newTitle: String, newBody: String) = noteDaoService.updateNote(primaryKey, newTitle, newBody)

    override suspend fun searchNotes(query: String, filterAndOrder: String, page: Int) = noteDaoService.searchNotes(query, filterAndOrder, page)

    override suspend fun searchNotesByID(primaryKey: String) = noteDaoService.searchNotesByID(primaryKey)

    override suspend fun getNumOfNotes() = noteDaoService.getNumOfNotes()

    override suspend fun insertNotes(notes: List<Note>) = noteDaoService.insertNotes(notes)
}