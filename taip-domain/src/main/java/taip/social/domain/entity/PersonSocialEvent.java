package taip.social.domain.entity;

import taip.commons.entity.PersistentEntity;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * @author Catalin Manolescu <cc.manolescu@gmail.com>
 */
@Entity
@Table(name = "person_social_events")
@SequenceGenerator(name = "person_social_events_id_seq", sequenceName = "person_social_events_id_seq")
@XmlAccessorType(XmlAccessType.PUBLIC_MEMBER)
@XmlRootElement(name = "person_social_event")
public class PersonSocialEvent implements PersistentEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "person_social_events_id_seq")
    private long id;

    @ManyToOne
    @JoinColumn(name = "person_id", nullable = false)
    private Person person;

    @ManyToOne
    @JoinColumn(name = "social_event_id", nullable = false)
    private SocialEvent event;

    @Column(name = "like")
    @Enumerated(EnumType.STRING)
    private Like like;

    @Override
    public long getId() {
        return id;
    }

    @Override
    public void setId(long id) {
        this.id = id;
    }
}
