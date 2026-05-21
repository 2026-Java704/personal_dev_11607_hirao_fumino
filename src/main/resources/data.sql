-- ユーザーテーブルデータ
INSERT INTO users(name, email, password) VALUES('小野貴裕', 'ono@taka.com', 'taka0119');
INSERT INTO users(name, email, password) VALUES('松本潤', 'jun@arashi.com', 'ikemen1234');
INSERT INTO users(name, email, password) VALUES('出川哲朗', 'degawa@yabaiyo.com', 'yabaiyo5678');
INSERT INTO users(name, email, password) VALUES('マツコ・デラックス', 'matsuko@dx.com', 'dekai9876');
INSERT INTO users(name, email, password) VALUES('大谷翔平', '	ohtani@major.com', 'saikyo017');
INSERT INTO users(name, email, password) VALUES('イーロン・マスク', 'eron@tesra.com', 'spacex123');
INSERT INTO users(name, email, password) VALUES('ビル・ゲイツ', ' bill@rich.com', 'microsoft456');


-- カテゴリーテーブル --
INSERT INTO categories(name) VALUES('丼もの');
INSERT INTO categories(name) VALUES('麵類');
INSERT INTO categories(name) VALUES('デザート');
INSERT INTO categories(name) VALUES('肉料理');
INSERT INTO categories(name) VALUES('野菜');
INSERT INTO categories(name) VALUES('スープ');
INSERT INTO categories(name) VALUES('サラダ');
INSERT INTO categories(name) VALUES('魚介');
INSERT INTO categories(name) VALUES('パン');
INSERT INTO categories(name) VALUES('鍋もの');
INSERT INTO categories(name) VALUES('粉もの');
INSERT INTO categories(name) VALUES('和菓子');
INSERT INTO categories(name) VALUES('その他');

---- レシピテーブル --
INSERT INTO recipes(user_id, category_id, name, recipe) VALUES(1, 1, '親子丼', '1. 鶏肉を一口大に切る 2. 玉ねぎを薄切りにする 3. フライパンに油を熱し、鶏肉と玉ねぎを炒める 4. 水と調味料を加えて煮る 5. 卵を溶いて加え、半熟になるまで煮る 6. ご飯の上にのせて完成');
INSERT INTO recipes(user_id, category_id, name, recipe) VALUES(5, 3, 'マカロン', '1. 卵白を泡立てる 2. 粉砂糖とアーモンドプードルを混ぜる 3. 卵白に粉砂糖とアーモンドプードルを加えて混ぜる 4. 絞り袋に入れて天板に絞る 5. 160度のオーブンで15分焼く 6. 好みのクリームを挟んで完成');
INSERT INTO recipes(user_id, category_id, name, recipe) VALUES(4, 2, 'タラコパスタ', '1. パスタを茹でる 2. タラコをほぐす 3. ボウルにバターorオリーブオイル、タラコを入れる 4. 茹でたパスタを加えて、バターを溶かすように混ぜる 5. 大葉かパセリをかけて 6. お皿に盛り付けて完成');
INSERT INTO recipes(user_id, category_id, name, recipe) VALUES(1, 1, 'カツ丼', '1. 豚肉に衣をつけて揚げる 2. 玉ねぎを薄切りにする 3. フライパンに油を熱し、玉ねぎを炒める 4. 水と調味料を加えて煮る 5. カツを加えて少し煮る　6.　卵を溶いて加え、半熟になるまで煮る 7. ご飯の上にのせて完成');
INSERT INTO recipes(user_id, category_id, name, recipe) VALUES(3, 2, 'カルボナーラ', '1. パスタを茹でる 2. グアンチャーレを細切りにする 3. フライパンに油を熱し、鍋肌に焦げ付くようにグアンチャーレを炒める 4. フライパンにお湯を加え、焦げを落とす 5. 固めに茹でたパスタを加えて少し煮る 6.水分がある程度飛んだら卵とチーズと粗目な黒コショウを混ぜたものを加えて混ぜる 6. フライパンにお湯を加えながらちょうどいい濃度にする（固まらないように） 7. お皿に盛り付けて完成');
INSERT INTO recipes(user_id, category_id, name, recipe) VALUES(2, 6, 'お味噌汁', '1. 水を鍋に入れて火にかける 2. だしの素を加える 3. 好みの具材を入れる 4. 沸騰したら火を止める 5. 味噌を溶かして加える 6. お椀に盛り付けて完成');
INSERT INTO recipes(user_id, category_id, name, recipe) VALUES(5, 4, 'ローストビーフ', '1. 牛肉を常温に戻す 2. 塩コショウで下味をつける 3. フライパンに油を熱し、牛肉を焼き色がつくまで焼く 4. オーブンに入れて180度で20分焼く 5. アルミホイルで包んで10分休ませる 6. 薄切りにして完成');
INSERT INTO recipes(user_id, category_id, name, recipe) VALUES(1, 7, 'シーザーサラダ', '1. レタスを洗ってちぎる 2. クルトンを作る（パンを小さく切ってオーブンで焼く） 3. ドレッシングを作る（ディジョンマスタード、ウスターソース、ライム果汁、アンチョビペースト、にんにくを混ぜる） 4. レタスとクルトンをボウルに入れてドレッシングをかけて混ぜる 5. お皿に盛り付けて完成');
INSERT INTO recipes(user_id, category_id, name, recipe) VALUES(7, 9, 'ガーリックトースト', '1. バゲットを斜めに切る 2. バターとコンフィしたにんにくを混ぜたものを塗る 3. オーブンで200度で5分焼く 4. パセリを振ってお皿に盛り付けて完成');
INSERT INTO recipes(user_id, category_id, name, recipe) VALUES(2, 8, '鯛の煮付け', '1. 鯛を切り身にする 2. 鍋に水、酒、みりん、醤油、砂糖を入れて火にかける 3. 煮立ったら鯛を入れて中火で煮る 4. 煮汁が少なくなったら火を止める 5. お皿に盛り付けて完成');
INSERT INTO recipes(user_id, category_id, name, recipe) VALUES(1, 8, '鮭のムニエル', '1. 鮭を切り身にする 2. 塩コショウで下味をつける 3. 小麦粉をまぶす 4. フライパンにバターを熱し、鮭を両面焼く 5. レモンを添えて完成');
INSERT INTO recipes(user_id, category_id, name, recipe) VALUES(4, 10, 'キムチ鍋', '1. 鍋に水を入れて火にかける 2. だしの素を加える 3. キムチ、豚肉、豆腐、野菜を入れる 4. 沸騰したら火を止める 5. お椀に盛り付けて完成');
INSERT INTO recipes(user_id, category_id, name, recipe) VALUES(1, 11, 'お好み焼き', '1. 具材を細かく切る 2. 小麦粉、卵、水を混ぜて生地を作る 3. 生地に具材を加えて混ぜる 4. フライパンに油を熱し、生地を流し入れる 5. 両面を焼いてお皿に盛り付ける 6. お好みでソースやマヨネーズをかけて完成');
INSERT INTO recipes(user_id, category_id, name, recipe) VALUES(2, 3, 'バタースコッチシナモンパイ', '1. パイ生地を作る（小麦粉、バター、水を混ぜてこねる） 2. バタースコッチシナモンフィリングを作る（バター、砂糖、シナモンを混ぜる） 3. パイ生地にフィリングをのせて包む 4. オーブンで180度で25分焼く 5. お皿に盛り付けて完成');
INSERT INTO recipes(user_id, category_id, name, recipe) VALUES(3, 11, 'たこ焼き', '1. たこ焼きの生地を作る（小麦粉、卵、水を混ぜる） 2. たこを小さく切る 3. たこ焼き器に油を熱し、生地を流し入れる 4.ねぎや紅ショウガなどを入れる 5. たこを入れて焼く 5. お皿に盛り付け、ソースやマヨネーズをかけて完成');
INSERT INTO recipes(user_id, category_id, name, recipe) VALUES(3, 9, 'サンドウィッチ', '1. 食パンを用意する 2. 好みの具材を用意する（ハム、チーズ、レタスなど） 3. 食パンに具材を挟む 4. お皿に盛り付けて完成');
INSERT INTO recipes(user_id, category_id, name, recipe) VALUES(4, 7, 'ポテトサラダ', '1. じゃがいもを茹でてつぶす 2. 玉ねぎをみじん切り、きゅうりを輪切り、にんじんを短冊切りにする 3. ハムを細かく切る 4. マヨネーズ、塩コショウで味を調える 5. お皿に盛り付けて完成');
INSERT INTO recipes(user_id, category_id, name, recipe) VALUES(2, 6, 'ポトフ', '1. 鍋に油を加え、お好みのお肉を濃い焼き目がつくように焼く 2. 好みの野菜を入れる（玉ねぎ、にんじんなど） 3. 水を加え、鍋肌を洗うようにしてから煮る 4. お肉が柔らかくなったら火を止める 5. お椀に盛り付けて完成');
INSERT INTO recipes(user_id, category_id, name, recipe) VALUES(6, 4, '照り焼きチキン', '1.フライパンに油を熱し、鶏肉を焼く 2. 照り焼きのタレを作る（醤油、みりん、砂糖を混ぜる） 3. タレをフライパンに加えて鶏肉に絡める 4.鶏肉を食べやすい大きさに切る　5. お皿に盛り付けて完成');
INSERT INTO recipes(user_id, category_id, name, recipe) VALUES(2, 10, 'おでん', '1. 鍋に水を入れて火にかける 2. だしの素を加える 3. 好みの具材を入れる（大根、卵、こんにゃくなど） 4. 沸騰したら火を止める 5. お椀に盛り付けて完成');
INSERT INTO recipes(user_id, category_id, name, recipe) VALUES(4, 10, 'ようかん', '1. 鍋に水を入れて火にかける 2. 砂糖と寒天を加える 3. 沸騰したら火を止める 4. 型に流し入れて冷やし固める 5. お皿に盛り付けて完成');