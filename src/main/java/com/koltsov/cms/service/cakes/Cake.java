package com.koltsov.cms.service.cakes;

import com.koltsov.cms.starter.data.IdAble;
import lombok.*;
import org.hibernate.Hibernate;
import org.springframework.content.commons.annotations.ContentId;
import org.springframework.content.commons.annotations.ContentLength;

import javax.persistence.*;
import java.util.Objects;
import java.util.UUID;

@Getter
@Setter
@ToString
@NoArgsConstructor
@Table(name = "cakes")
@Entity
public class Cake implements IdAble<Long> {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_cake")
    @SequenceGenerator(name = "seq_cake", allocationSize = 1)
    private Long id;

    private String name;

    @ContentId
    private UUID imageId;

    @ContentLength
    private Long imageLength;

    private String imageMimeType;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Cake cake = (Cake) o;
        return id != null && Objects.equals(id, cake.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
