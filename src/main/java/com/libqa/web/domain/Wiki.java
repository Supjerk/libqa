package com.libqa.web.domain;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

/**
 * Created by songanji on 2015. 2. 8..
 */
@Entity
@Data
@Slf4j
public class Wiki {

    @Id
    @Column(nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer wikiId;

    @Column(nullable = false)
    private Integer spaceId;

    @Column
    private Integer parentsId;

    @Column(nullable = false, length = 100)
    private String title;

    @Column(nullable = false, columnDefinition = "int default 0")
    private Integer orderIdx = 0;

    @Column(nullable = false, columnDefinition = "int default 0")
    private Integer depthIdx = 0;

    @Column(columnDefinition = "Text", nullable = false)
    private String contents;

    @Column(columnDefinition = "Text", nullable = false)
    private String contentsMarkup;

    @Column(columnDefinition = "TINYINT(1) DEFAULT 0")
    private boolean isLock = false;

    @Column(nullable = false, length = 40)
    private String passwd;

    @Column(nullable = false, length = 40)
    private String userNick;

    @Column(nullable = false)
    private Integer userId;

    @Column
    private Integer viewCount = 0;

    @Column
    private Integer likeCount = 0;

    @Column
    private Integer reportCount;

    @Column(columnDefinition = "TINYINT(1) DEFAULT 0")
    private boolean isFixed = false;

    @Column(length = 100)
    private String wikiUrl;

    @Column(length = 16)
    private String currentIp;

    @Column(length = 10)
    private String editReason;

    @Column(length = 10)
    private String revision;

    @Column(columnDefinition = "TINYINT(1) DEFAULT 0")
    boolean isDeleted = false;

    @Temporal(TemporalType.DATE)
    private Date insertDate;

    @Temporal(TemporalType.DATE)
    private Date updateDate;

    @OneToMany(mappedBy = "wikiId", fetch = FetchType.LAZY)
    @JsonManagedReference
    private List<WikiFile> wikiFiles;

    @OneToMany(mappedBy = "wiki", fetch = FetchType.LAZY)
    private List<WikiSnapShot> wikiSnapShots;

    @Transient
    private String keywords;

    //추후에 삭제대상
    @Transient
    private int replyCount;

//    @OneToMany(mappedBy = "parentsId", fetch = FetchType.LAZY)
//    @JsonManagedReference
    //private List<Wiki> subWikiList;

//    @OneToOne(cascade = CascadeType.ALL, optional = false, fetch = FetchType.LAZY)
//    @JoinColumn(name="parentsId", referencedColumnName = "wikiId", nullable = false, unique = true, insertable = false, updatable = false)
//    @JsonManagedReference
    //private Wiki parentWiki;

    @OneToMany(mappedBy = "wikiId", fetch = FetchType.LAZY)
    @JsonManagedReference
    //@Transient
    private List<Keyword> keywordList;

    @OneToMany(mappedBy = "wiki", fetch = FetchType.LAZY)
    //@Transient
    private List<WikiReply> wikiReplies;
}