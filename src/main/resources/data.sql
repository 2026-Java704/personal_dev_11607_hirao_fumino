-- ユーザーテーブルデータ
INSERT INTO users(name, email, password) VALUES('松本潤', 'jun@arashi.com', 'ikemen1234');
INSERT INTO users(name, email, password) VALUES('出川哲朗', 'degawa@yabaiyo.com', 'yabaiyo5678');
INSERT INTO users(name, email, password) VALUES('マツコ・デラックス', 'matsuko@dx.com', 'dekai9876');
INSERT INTO users(name, email, password) VALUES('大谷翔平', '	ohtani@major.com', 'saikyo017');
INSERT INTO users(name, email, password) VALUES('イーロン・マスク', 'eron@tesra.com', 'spacex123');
INSERT INTO users(name, email, password) VALUES('ビル・ゲイツ', ' bill@rich.com', 'microsoft456');
INSERT INTO users(name, email, password) VALUES('スティーブ・ジョブズ', 'steve@tensai.com', 'apple789');


-- カテゴリーテーブル --
INSERT INTO categories(name) VALUES('丼もの');
INSERT INTO categories(name) VALUES('麵類');
INSERT INTO categories(name) VALUES('デザート');
INSERT INTO categories(name) VALUES('肉料理');
INSERT INTO categories(name) VALUES('野菜料理');
INSERT INTO categories(name) VALUES('スープ');
INSERT INTO categories(name) VALUES('サラダ');
INSERT INTO categories(name) VALUES('魚介');
INSERT INTO categories(name) VALUES('パン');
INSERT INTO categories(name) VALUES('鍋もの');
INSERT INTO categories(name) VALUES('粉もの');
INSERT INTO categories(name) VALUES('和菓子');
INSERT INTO categories(name) VALUES('その他');

---- レシピテーブル --
INSERT INTO recipes(user_id, category_id, name, recipe) VALUES(1, 1, '親子丼', E'\n1. 鶏肉を一口大に切る \n 2. 玉ねぎを薄切りにする \n 3. フライパンに油を熱し、鶏肉と玉ねぎを炒める \n 4. 水と調味料を加えて煮る \n5 . 卵を溶いて加え、半熟になるまで煮る \n6. ご飯の上にのせて完成');
INSERT INTO recipes(user_id, category_id, name, recipe) VALUES(5, 3, 'マカロン', E'\n1. 卵白を泡立てる \n2. 粉砂糖とアーモンドプードルを混ぜる \n3. 卵白に粉砂糖とアーモンドプードルを加えて混ぜる \n4. 絞り袋に入れて天板に絞る \n5. 160度のオーブンで15分焼く \n6. 好みのクリームを挟んで完成');
INSERT INTO recipes(user_id, category_id, name, recipe) VALUES(4, 2, 'タラコパスタ', E'\n1. パスタを茹でる \n2. タラコをほぐす \n3. ボウルにバターorオリーブオイル、タラコを入れる \n4. 茹でたパスタを加えて、バターを溶かすように混ぜる \n5. 大葉かパセリをかけて \n6. お皿に盛り付けて完成');
INSERT INTO recipes(user_id, category_id, name, recipe) VALUES(1, 1, 'カツ丼', E'\n1. 豚肉に衣をつけて揚げる \n2. 玉ねぎを薄切りにする \n3. フライパンに油を熱し、玉ねぎを炒める \n4. 水と調味料を加えて煮る \n5. カツを加えて少し煮る　\n6.　卵を溶いて加え、半熟になるまで煮る \n7. ご飯の上にのせて完成');
INSERT INTO recipes(user_id, category_id, name, recipe) VALUES(3, 2, 'カルボナーラ', E'\n1. パスタを茹でる \n2. グアンチャーレを細切りにする \n3. フライパンに油を熱し、鍋肌に焦げ付くようにグアンチャーレを炒める \n4. フライパンにお湯を加え、焦げを落とす \n5. 固めに茹でたパスタを加えて少し煮る \n6.水分がある程度飛んだら卵とチーズと粗目な黒コショウを混ぜたものを加えて混ぜる \n7. フライパンにお湯を加えながらちょうどいい濃度にする（固まらないように） \n8. お皿に盛り付けて完成');
INSERT INTO recipes(user_id, category_id, name, recipe) VALUES(2, 6, 'お味噌汁', E'\n1. 水を鍋に入れて火にかける \n2. だしの素を加える \n3. 好みの具材を入れる \n4. 沸騰したら火を止める \n5. 味噌を溶かして加える \n6. お椀に盛り付けて完成');
INSERT INTO recipes(user_id, category_id, name, recipe) VALUES(6, 5, 'ラタトゥイユ', E'\n1. 玉ねぎ、にんじん、ズッキーニ、ナスを一口大に切る \n2. フライパンに油を熱し、玉ねぎとにんじんを炒める \n3. ズッキーニとナスを加えてさらに炒める \n4. トマト缶を加えて煮る \n5. 塩コショウで味を調える \n6. お皿に盛り付けて完成');
INSERT INTO recipes(user_id, category_id, name, recipe) VALUES(7, 5, '野菜炒め', E'\n1. 好みの野菜を一口大に切る \n2. フライパンに油を熱し、野菜を炒める \n3. 塩コショウで味を調える \n4. お皿に盛り付けて完成');
INSERT INTO recipes(user_id, category_id, name, recipe) VALUES(5, 4, 'ローストビーフ', E'\n1. 牛肉を常温に戻す \n2. 塩コショウで下味をつける \n3. フライパンに油を熱し、牛肉を焼き色がつくまで焼く \n4. オーブンに入れて180度で20分焼く \n5. アルミホイルで包んで10分休ませる \n6. 薄切りにして完成');
INSERT INTO recipes(user_id, category_id, name, recipe) VALUES(1, 7, 'シーザーサラダ', E'\n1. レタスを洗ってちぎる \n2. クルトンを作る（パンを小さく切ってオーブンで焼く） \n3. ドレッシングを作る（ディジョンマスタード、ウスターソース、ライム果汁、アンチョビペースト、にんにくを混ぜる） \n4. レタスとクルトンをボウルに入れてドレッシングをかけて混ぜる \n5. お皿に盛り付けて完成');
INSERT INTO recipes(user_id, category_id, name, recipe) VALUES(7, 9, 'ガーリックトースト', E'\n1. バゲットを斜めに切る \n2. バターとコンフィしたにんにくを混ぜたものを塗る \n3. オーブンで200度で5分焼く \n4. パセリを振ってお皿に盛り付けて完成');
INSERT INTO recipes(user_id, category_id, name, recipe) VALUES(2, 8, '鯛の煮付け', E'\n1. 鯛を切り身にする \n2. 鍋に水、酒、みりん、醤油、砂糖を入れて火にかける \n3. 煮立ったら鯛を入れて中火で煮る \n4. 煮汁が少なくなったら火を止める \n5. お皿に盛り付けて完成');
INSERT INTO recipes(user_id, category_id, name, recipe) VALUES(1, 8, '鮭のムニエル', E'\n1. 鮭を切り身にする \n2. 塩コショウで下味をつける \n3. 小麦粉をまぶす \n4. フライパンにバターを熱し、鮭を両面焼く \n5. レモンを添えて完成');
INSERT INTO recipes(user_id, category_id, name, recipe) VALUES(4, 10, 'キムチ鍋', E'\n1. 鍋に水を入れて火にかける \n2. だしの素を加える \n3. キムチ、豚肉、豆腐、野菜を入れる \n4. 沸騰したら火を止める \n5. お椀に盛り付けて完成');
INSERT INTO recipes(user_id, category_id, name, recipe) VALUES(1, 11, 'お好み焼き', E'\n1. 具材を細かく切る \n2. 小麦粉、卵、水を混ぜて生地を作る \n3. 生地に具材を加えて混ぜる \n4. フライパンに油を熱し、生地を流し入れる \n5. 両面を焼いてお皿に盛り付ける \n6. お好みでソースやマヨネーズをかけて完成');
INSERT INTO recipes(user_id, category_id, name, recipe) VALUES(2, 3, 'バタースコッチシナモンパイ', E'\n1. パイ生地を作る（小麦粉、バター、水を混ぜてこねる） \n2. バタースコッチシナモンフィリングを作る（バター、砂糖、シナモンを混ぜる） \n3. パイ生地にフィリングをのせて包む \n4. オーブンで180度で25分焼く \n5. お皿に盛り付けて完成');
INSERT INTO recipes(user_id, category_id, name, recipe) VALUES(3, 11, 'たこ焼き', E'\n1. たこ焼きの生地を作る（小麦粉、卵、水を混ぜる） \n2. たこを小さく切る \n3. たこ焼き器に油を熱し、生地を流し入れる \n4.ねぎや紅ショウガなどを入れる \n5. たこを入れて焼く \n6. お皿に盛り付け、ソースやマヨネーズをかけて完成');
INSERT INTO recipes(user_id, category_id, name, recipe) VALUES(3, 9, 'サンドウィッチ', E'\n1. 食パンを用意する \n2. 好みの具材を用意する（ハム、チーズ、レタスなど）\n3. 食パンに具材を挟む \n4. お皿に盛り付けて完成');
INSERT INTO recipes(user_id, category_id, name, recipe) VALUES(4, 7, 'ポテトサラダ', E'\n1. じゃがいもを茹でてつぶす \n2. 玉ねぎをみじん切り、きゅうりを輪切り、にんじんを短冊切りにする \n3. ハムを細かく切る \n4. マヨネーズ、塩コショウで味を調える \n5. お皿に盛り付けて完成');
INSERT INTO recipes(user_id, category_id, name, recipe) VALUES(2, 6, 'ポトフ', E'\n1. 鍋に油を加え、お好みのお肉を濃い焼き目がつくように焼く \n2. 好みの野菜を入れる（玉ねぎ、にんじんなど） \n3. 水を加え、鍋肌を洗うようにしてから煮る \n4. お肉が柔らかくなったら火を止める \n5. お椀に盛り付けて完成');
INSERT INTO recipes(user_id, category_id, name, recipe) VALUES(6, 4, '照り焼きチキン', E'\n1.フライパンに油を熱し、鶏肉を焼く \n2. 照り焼きのタレを作る（醤油、みりん、砂糖を混ぜる） \n3. タレをフライパンに加えて鶏肉に絡める \n4.鶏肉を食べやすい大きさに切る　\n5. お皿に盛り付けて完成');
INSERT INTO recipes(user_id, category_id, name, recipe) VALUES(2, 10, 'おでん', E'\n1. 鍋に水を入れて火にかける \n2. だしの素を加える \n3. 好みの具材を入れる（大根、卵、こんにゃくなど） \n4. 沸騰したら火を止める \n5. お椀に盛り付けて完成');
INSERT INTO recipes(user_id, category_id, name, recipe) VALUES(4, 12, 'ようかん', E'\n1. 鍋に水を入れて火にかける \n2. 砂糖と寒天を加える \n3. 沸騰したら火を止める \n4. 型に流し入れて冷やし固める \n5. お皿に盛り付けて完成');