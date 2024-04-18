INSERT INTO board (board_seq, board_name, file_count, comment_status, open_status)
VALUES ('B_001', '공지사항', 1, 'Y', 'Y');

INSERT INTO user (username, password, role)
VALUES ('choi', '$2a$10$EiWJIpNUmj31YQjX6C2/DetgTaHT33QmpLv7bwhUT9D6w08mz9FLO', 'ROLE_USER');