-- ユーザーテーブルデータ
INSERT INTO users(name, email, password) VALUES('田中太郎', 'tanaka@aaa.com', 'test123');
INSERT INTO users(name, email, password) VALUES('鈴木一郎', 'suzuki@aaa.com', 'test456');

-- カテゴリーテーブル --
INSERT INTO categories(name) VALUES('丼もの');
INSERT INTO categories(name) VALUES('麵類');
INSERT INTO categories(name) VALUES('デザート');
INSERT INTO categories(name) VALUES('肉料理');
INSERT INTO categories(name) VALUES('スープ');
INSERT INTO categories(name) VALUES('サラダ');
INSERT INTO categories(name) VALUES('魚介');
INSERT INTO categories(name) VALUES('パン');
INSERT INTO categories(name) VALUES('鍋もの');
INSERT INTO categories(name) VALUES('粉もの');

---- レシピテーブル --
INSERT INTO recipes(user_id, category_id, name, recipe) VALUES(1, 1, '親子丼', '親子丼の作り方');
INSERT INTO recipes(user_id, category_id, name, recipe) VALUES(1, 3, 'マカロン', 'マカロンの作り方');
INSERT INTO recipes(user_id, category_id, name, recipe) VALUES(2, 2, 'タラコパスタ', 'タラコパスタの作り方');
INSERT INTO recipes(user_id, category_id, name, recipe) VALUES(1, 1, 'カツ丼', 'カツ丼の作り方');
INSERT INTO recipes(user_id, category_id, name, recipe) VALUES(1, 2, 'カルボナーラ', 'カルボナーラの作り方');
INSERT INTO recipes(user_id, category_id, name, recipe) VALUES(2, 5, 'お味噌汁', 'お味噌汁の作り方');
INSERT INTO recipes(user_id, category_id, name, recipe) VALUES(1, 4, 'ローストビーフ', 'ローストビーフの作り方');
INSERT INTO recipes(user_id, category_id, name, recipe) VALUES(1, 6, 'シーザーサラダ', 'シーザーサラダの作り方');
INSERT INTO recipes(user_id, category_id, name, recipe) VALUES(2, 8, 'ガーリックトースト', 'ガーリックトーストの作り方');
INSERT INTO recipes(user_id, category_id, name, recipe) VALUES(2, 7, '鯛の煮付け', '鯛の煮付けの作り方');
INSERT INTO recipes(user_id, category_id, name, recipe) VALUES(1, 7, '鮭のムニエル', '鮭のムニエルの作り方');
INSERT INTO recipes(user_id, category_id, name, recipe) VALUES(1, 9, 'キムチ鍋', 'キムチ鍋の作り方');
INSERT INTO recipes(user_id, category_id, name, recipe) VALUES(1, 10, 'お好み焼き', 'お好み焼きの作り方');
INSERT INTO recipes(user_id, category_id, name, recipe) VALUES(2, 3, 'バタースコッチシナモンパイ', 'バタースコッチシナモンパイの作り方');
INSERT INTO recipes(user_id, category_id, name, recipe) VALUES(2, 10, 'たこ焼き', 'たこ焼きの作り方');
INSERT INTO recipes(user_id, category_id, name, recipe) VALUES(2, 8, 'サンドウィッチ', 'サンドウィッチの作り方');
INSERT INTO recipes(user_id, category_id, name, recipe) VALUES(2, 6, 'ポテトサラダ', 'ポテトサラダの作り方');
INSERT INTO recipes(user_id, category_id, name, recipe) VALUES(2, 5, 'ポトフ', 'ポトフの作り方');
INSERT INTO recipes(user_id, category_id, name, recipe) VALUES(2, 4, '照り焼きチキン', '照り焼きチキンの作り方');
INSERT INTO recipes(user_id, category_id, name, recipe) VALUES(2, 9, 'おでん', 'おでんの作り方');