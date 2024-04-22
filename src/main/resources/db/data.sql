INSERT INTO board (board_name, board_type, file_count, comment_status, open_status)
VALUES ('공지사항', 'list', 1, 'Y', 'Y');

INSERT INTO user (username, password, role)
VALUES ('choi', '$2a$10$EiWJIpNUmj31YQjX6C2/DetgTaHT33QmpLv7bwhUT9D6w08mz9FLO', 'USER');

INSERT INTO member (id, password, role)
VALUES ('choi', '$2a$10$EiWJIpNUmj31YQjX6C2/DetgTaHT33QmpLv7bwhUT9D6w08mz9FLO', 'ADMIN');