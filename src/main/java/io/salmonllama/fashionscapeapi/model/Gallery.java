package io.salmonllama.fashionscapeapi.model;

import jakarta.persistence.*;

import java.util.UUID;

@Entity
@Table(name = "gallery")
public class Gallery {
    private UUID id;
    private String serverId;
    private String channelId;
    private String tag;
    private String emoji;

    public Gallery() {

    }

    @Id
    @GeneratedValue
    @Column(name = "id")
    public UUID getId() {
        return id;
    }
    public Gallery setId(UUID id) {
        this.id = id;
        return this;
    }

    @Column(name = "server_id", nullable = false)
    public String getServerId() {
        return serverId;
    }
    public Gallery setServerId(String serverId) {
        this.serverId = serverId;
        return this;
    }

    @Column(name = "channel_id", nullable = false, unique = true)
    public String getChannelId() {
        return channelId;
    }
    public Gallery setChannelId(String channelId) {
        this.channelId = channelId;
        return this;
    }

    @Column(name = "tag", nullable = false)
    public String getTag() {
        return tag;
    }
    public Gallery setTag(String tag) {
        this.tag = tag;
        return this;
    }

    @Column(name = "emoji", nullable = false)
    public String getEmoji() {
        return emoji;
    }
    public Gallery setEmoji(String emoji) {
        this.emoji = emoji;
        return this;
    }
}
