package io.salmonllama.fashionscapeapi.model;

import java.sql.Timestamp;
import java.util.UUID;

import jakarta.persistence.*;

@Entity
@Table(name = "outfit")
public class Outfit {
    private UUID id;
    private String link;
    private String submitter;
    private String tag;
    private String meta;
    private String discordName;
    private Timestamp created;
    private Timestamp updated;
    private boolean isDeleted;
    private boolean isFeatured;
    private int displayCount;
    private String deleteHash;

    public Outfit() {

    }

    @Id
    @GeneratedValue
    @Column(name = "id", nullable = false, unique = true)
    public UUID getId() {
        return id;
    }
    public Outfit setId(UUID id) {
        this.id = id;
        return this;
    }

    @Column(name = "link", nullable = false)
    public String getLink() {
        return link;
    }
    public Outfit setLink(String link) {
        this.link = link;
        return this;
    }

    @Column(name = "submitter", nullable = false)
    public String getSubmitter() {
        return submitter;
    }
    public Outfit setSubmitter(String submitter) {
        this.submitter = submitter;
        return this;
    }

    @Column(name = "tag", nullable = false)
    public String getTag() {
        return tag;
    }
    public Outfit setTag(String tag) {
        this.tag = tag;
        return this;
    }

    @Column(name = "meta")
    public String getMeta() {
        return meta;
    }
    public Outfit setMeta(String meta) {
        this.meta = meta;
        return this;
    }

    @Column(name = "discord_name", nullable = false)
    public String getDiscordName() {
        return discordName;
    }
    public Outfit setDiscordName(String discordName) {
        this.discordName = discordName;
        return this;
    }

    @Column(name = "created")
    public Timestamp getCreated() {
        return created;
    }
    public Outfit setCreated(Timestamp created) {
        this.created = created;
        return this;
    }

    @Column(name = "updated")
    public Timestamp getUpdated() {
        return updated;
    }
    public Outfit setUpdated(Timestamp updated) {
        this.updated = updated;
        return this;
    }

    @Column(name = "deleted")
    public boolean getDeleted() {
        return isDeleted;
    }
    public Outfit setDeleted(boolean isDeleted) {
        this.isDeleted = isDeleted;
        return this;
    }

    @Column(name = "featured")
    public boolean getFeatured() {
        return isFeatured;
    }
    public Outfit setFeatured(boolean isFeatured) {
        this.isFeatured = isFeatured;
        return this;
    }

    @Column(name = "displayed")
    public int getDisplayCount() {
        return displayCount;
    }
    public Outfit setDisplayCount(int displayCount) {
        this.displayCount = displayCount;
        return this;
    }

    @Column(name = "delete_hash", nullable = false)
    public String getDeleteHash() {
        return deleteHash;
    }
    public Outfit setDeleteHash(String deleteHash) {
        this.deleteHash = deleteHash;
        return this;
    }
}
