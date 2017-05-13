CREATE TABLE IF NOT EXISTS myskeletonv2table (
    id  INT PRIMARY KEY AUTO_INCREMENT,
    text VARCHAR(255)
);

# 初期DBユーザー登録。ハッシュ非対応
# INSERT INTO users (id, username, password, role) VALUES (1, 'admin', 'password', 'ROLE_ADMIN');

# INSERT INTO users (id, username, password, role) VALUES (2, 'user', 'password', 'ROLE_USER');