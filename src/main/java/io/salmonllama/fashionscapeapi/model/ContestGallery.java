package io.salmonllama.fashionscapeapi.model;

import java.sql.Timestamp;
import java.util.UUID;

import jakarta.persistence.*;

@Entity
@Table(name = "contest_gallery")
public class ContestGallery {
    private UUID id;
    private String contestName;
    private Timestamp created;
    private Timestamp contestClose;
    private int entryLimit;
    private boolean canReplaceEntries;

    public ContestGallery() {}

    @Id
    @GeneratedValue
    @Column(name = "id")
    public UUID getId() { return id; }
    public ContestGallery setId(UUID id) {
        this.id = id;
        return this;
    }

    @Column(name = "contest_name")
    public String getContestName() { return contestName; }
    public ContestGallery setContestName(String contestName) {
        this.contestName = contestName;
        return this;
    }

    @Column(name = "created")
    public Timestamp getCreated() { return created; }
    public ContestGallery setCreated(Timestamp created) {
        this.created = created;
        return this;
    }

    @Column(name = "contest_close")
    public Timestamp getContestClose() { return contestClose; }
    public ContestGallery setContestClose(Timestamp contestClose) {
        this.contestClose = contestClose;
        return this;
    }

    @Column(name = "entry_limit")
    public int getEntryLimit() { return entryLimit; }
    public ContestGallery setEntryLimit(int entryLimit) {
        this.entryLimit = entryLimit;
        return this;
    }

    @Column(name = "can_replace_entries")
    public boolean canReplaceEntries() { return canReplaceEntries; }
    public ContestGallery setReplaceEntries(boolean canReplaceEntries) {
        this.canReplaceEntries = canReplaceEntries;
        return this;
    }
}
