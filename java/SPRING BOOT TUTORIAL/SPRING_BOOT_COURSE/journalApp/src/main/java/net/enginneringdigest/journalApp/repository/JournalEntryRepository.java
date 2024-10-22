package net.enginneringdigest.journalApp.repository;

import net.enginneringdigest.journalApp.entity.JournalEntry;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface JournalEntryRepository extends MongoRepository<JournalEntry,ObjectId> {
}
