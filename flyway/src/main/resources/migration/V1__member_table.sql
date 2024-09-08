create table member
(
    seq          BIGINT                              NOT NULL AUTO_INCREMENT COMMENT '회원 일련번호',
    name         VARCHAR(30)                         NOT NULL COMMENT '사용자명',
    email        VARCHAR(100)                        NOT NULL COMMENT '사용자 이메일',
    password     VARCHAR(100)                        NOT NULL COMMENT '비밀번호',
    grade_code   VARCHAR(255)                        NOT NULL COMMENT '등급',
    created_by   VARCHAR(100)                        NOT NULL COMMENT '생성자',
    created_time DATETIME DEFAULT CURRENT_TIMESTAMP  NOT NULL COMMENT '생성일',
    updated_by   VARCHAR(100)                        NOT NULL COMMENT '수정자',
    updated_time DATETIME DEFAULT CURRENT_TIMESTAMP  NOT NULL COMMENT '수정일',

    PRIMARY KEY (seq),
    UNIQUE KEY UK_MEMBER_EMAIL (email)
) ENGINE = InnoDB
  DEFAULT CHARSET = UTF8MB4 COMMENT='고객 테이블';

create table member_login_history (
  seq          BIGINT                              NOT NULL AUTO_INCREMENT COMMENT '로그 일련번호',
  member_seq   BIGINT                              NOT NULL COMMENT '회원 일련번호',
  created_by   VARCHAR(100)                        NOT NULL COMMENT '생성자',
  created_time DATETIME DEFAULT CURRENT_TIMESTAMP  NOT NULL COMMENT '생성일',

  PRIMARY KEY (seq)
 ) ENGINE = InnoDB
  DEFAULT CHARSET = UTF8MB4 COMMENT='고객 로그인 이력 테이블';

ALTER TABLE `member_login_history`
  ADD FOREIGN KEY (`member_seq`) REFERENCES `member` (`seq`);
