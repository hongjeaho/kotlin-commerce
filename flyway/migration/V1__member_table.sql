create table member
(
    uuid         BINARY(16)                          NOT NULL COMMENT 'uuid',
    name         VARCHAR(30)                         NOT NULL COMMENT '사용자명',
    email        VARCHAR(100)                        NOT NULL COMMENT '사용자 이메일',
    password     VARCHAR(100)                        NOT NULL COMMENT '비밀번호',
    created_by   VARCHAR(100)                        NOT NULL COMMENT '생성자',
    created_time DATETIME DEFAULT CURRENT_TIMESTAMP  NOT NULL COMMENT '생성일',
    updated_by   VARCHAR(100)                        NOT NULL COMMENT '수정자',
    updated_time DATETIME DEFAULT CURRENT_TIMESTAMP  NOT NULL COMMENT '수정일',

    PRIMARY KEY (uuid),
    UNIQUE KEY UK_MEMBER_EMAIL (email)
) ENGINE = InnoDB
  DEFAULT CHARSET = UTF8MB4;