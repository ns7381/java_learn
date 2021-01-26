/**
 * 
 */
package com.nathan.learn.spring.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.util.Date;

@MappedSuperclass
@EntityListeners({AuditingEntityListener.class})
@Setter
@Getter
@Where(clause = "deleted='0'")
@SQLDelete(sql = "UPDATE BaseObject SET is_deleted = 1 WHERE id = ?")
public abstract class BaseObject extends IdEntity {
	private static final long serialVersionUID = -192375636795802942L;

    @Column(nullable = false, columnDefinition = "BOOLEAN default '0'")
	private Boolean isDeleted;
    @CreatedDate
    @Column(name = "created_at")
    @Temporal(TemporalType.TIMESTAMP)
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
	private Date createdAt;
    @LastModifiedDate
    @Column(name = "updated_at")
    @Temporal(TemporalType.TIMESTAMP)
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
	private Date updatedAt;
}
