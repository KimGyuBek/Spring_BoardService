package com.basicproject.boardservice.data.entity;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import lombok.Getter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

@MappedSuperclass
@Getter
public abstract class BaseTime {

    @Column(nullable = false, name = "create_time")
    @CreatedDate
    private String createTime;

    @Column(nullable = false, name = "modified_date")
    @LastModifiedDate
    private String modifiedTime;

    /*해당 엔티티를 저장하기 전에 실행*/
    @PrePersist
    public void onPrePersist() {
        this.createTime =
            LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy.MM.dd"));
        this.modifiedTime = createTime;
    }

    /*해당 엔티티를 업데이트하기 전에 실행*/
    @PreUpdate
    public void onUpdate() {
        this.modifiedTime =
            LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy.MM.dd"));
    }


}
