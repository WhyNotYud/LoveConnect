package com.website.loveconnect.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Entity
@Table(name = "messages")
@Getter
@Setter
public class Message {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "message_id")
    private Long messageId;

    @ManyToOne
    @JoinColumn(name = "match_id", nullable = false)
    private Match match;

    @ManyToOne
    @JoinColumn(name = "sender_id", nullable = false)
    private User sender;

    @ManyToOne
    @JoinColumn(name = "receiver_id", nullable = false)
    private User receiver;

    @Column(name = "message_text", nullable = false)
    private String messageText;

    @Column(name = "sent_at", updatable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date sentAt = new Date();

    @Column(name = "is_read", columnDefinition = "BOOLEAN DEFAULT FALSE")
    private Boolean isRead = false;
}
