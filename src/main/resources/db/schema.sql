DROP TABLE IF EXISTS board;
DROP TABLE IF EXISTS post;
DROP TABLE IF EXISTS user;

CREATE TABLE board
(
    board_seq      VARCHAR(20) NOT NULL,
    board_name     VARCHAR(20) NOT NULL,
    file_count     INT         NOT NULL,
    comment_status CHAR(1)     NOT NULL DEFAULT 'N',
    open_status    CHAR(1)     NOT NULL DEFAULT 'Y',
    created_at     DATETIME    NOT NULL DEFAULT NOW(),
    updated_at     DATETIME    NOT NULL DEFAULT NOW(),
    PRIMARY KEY (board_seq)
);

CREATE TABLE user
(
    id       INT          NOT NULL AUTO_INCREMENT,
    username VARCHAR(20)  NOT NULL,
    password VARCHAR(255) NOT NULL,
    role     VARCHAR(20)  NOT NULL,
    PRIMARY KEY (id)
);