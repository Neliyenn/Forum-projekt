ALTER TABLE POST
    ALTER COLUMN create_date SET DEFAULT CURRENT_TIMESTAMP;

--Uzytkownicy
--wszystkie hasla jako zwykły tekst: "password"
INSERT INTO USER (user_id, password, email, username, name, last_name, active)
VALUES
    (1, '$2a$06$OAPObzhRdRXBCbk7Hj/ot.jY3zPwR8n7/mfLtKIgTzdJa4.6TwsIm', 'ramona@gmail.com', 'rama', 'Ramona', 'Pietruszewska', 1);

INSERT INTO USER (user_id, password, email, username, name, last_name, active)
VALUES
    (2, '$2a$06$OAPObzhRdRXBCbk7Hj/ot.jY3zPwR8n7/mfLtKIgTzdJa4.6TwsIm', 'blazej@gmail.com', 'szymko', 'Błażej', 'Szymkowski', 1);

INSERT INTO USER (user_id, password, email, username, name, last_name, active)
VALUES
    (3, '$2a$06$OAPObzhRdRXBCbk7Hj/ot.jY3zPwR8n7/mfLtKIgTzdJa4.6TwsIm', 'hipolit@gmail.com', 'hip', 'Hipolit', 'Tencza', 1);


--Role
INSERT INTO ROLE (role_id, role)
VALUES (1, 'ROLE_ADMIN');

INSERT INTO ROLE (role_id, role)
VALUES (2, 'ROLE_USER');


--Role, Uzytkownicy
INSERT INTO USER_ROLE (user_id, role_id)
VALUES (1, 1);

INSERT INTO USER_ROLE (user_id, role_id)
VALUES (1, 2);

INSERT INTO USER_ROLE (user_id, role_id)
VALUES (2, 2);

INSERT INTO USER_ROLE (user_id, role_id)
VALUES (3, 2);


--Posty
INSERT INTO POST (post_id, user_id, title, body, create_date)
VALUES (1, 1, 'Jakie wycieczki dla 4 latka?',
        'Cześć, wybieramy się z rodziną do Grecji, jakie wycieczki polecacie dla 4 letniego dziecka? Jedziemy na Kretę i nie chcemy siedzieć całe wakacje w hotelu, ale nie chcemy też zabierać małego na wycieczkę, która będzie go męczyć i nie będzie z niej żądnej przyjemności. Z góry dzięki!',  CURRENT_TIMESTAMP());

INSERT INTO POST (post_id, user_id, title, body, create_date)
VALUES (2, 1, 'Najpiękniejszy weekend w Paryżu',
        'Parę lat temu, w naszą pierwszą rocznicę, mój wtedy jeszcze narzeczony zabrał mnie na weekend do Paryża. Wyjazd był cudowny! Wieczorny spacer po Polach Elizejskich i zachód słońca w towarzystwie Wieży Eiffla zostaną już ze mną na zawsze w moich wspomnieniach. Do tego jedzenie. Francuzi znają się na deserach jak mało kto! Byc może to kwestia kompozycji smaków, a może atmosfery miasta, ale nawet zwyczajne makaroniki smakują tu inaczej niż w Polce. Naprawdę warto jechać do Paryża!',  CURRENT_TIMESTAMP());

INSERT INTO POST (post_id, user_id, title, body, create_date)
VALUES (3, 1, 'Zakynthos - ładna wyspa i... tyle?',
        'W podróży poślubnej wybraliśmy się na grecką wyspę Zakynthos. Organizacja lotu i transferu bez zarzutów. Hotel i obsługa także. Jeden, dwa, trzy dni na plaży i zapragnęliśmy czegoś więcej. I tu zaczęły się problemy. Poza pięknymi, pocztówkowymi krajobrazami idealnymi na długie spacery wyspa nie oferuje za wiele miejsc związanych z typowym "zwiedzaniem". Odniosłam wrażenie, że cała wyspa jest po prostu jednym wielkim kurortem wypoczynkowym. Oczywiście nie każdy będzie się tu nudził. Jeśli ktoś będzie chciał spędzić czas w aktywny sposób może spróbować kajakarstwa, snorkelingu, nurkowania, jazdy na nartach wodnych czy quadach. Obowiązkową pamiątką, o której wszyscy mówią jest zdjęcie na tle wraku statku w Zatoce Wraku. Taka personalizowana pocztówka z wakacji.',  CURRENT_TIMESTAMP());

INSERT INTO POST (post_id, user_id, title, body, create_date)
VALUES (4, 1, 'Robimy plany',
        'Robimy plany na weekend we dwoje, co polecacie?',  CURRENT_TIMESTAMP());

INSERT INTO POST (post_id, user_id, title, body, create_date)
VALUES (5, 1, 'Widzieliśmy Golden Gate Bridge',
        'Jest ogromny! Most Golden Gate Bridge ma aż 2737 metrów długości i miesięcznie przejeżdza po nim około 3,4 mln samochodów! Naprawdę wspaniałe i majestatyczne dzieło rąk ludzkich. Jak na swój wiek (85 lat) most prezentuje się naprawdę dobrze, jednak stoi on w miejsu zagrożonym trzęsieniami ziemi, dlatego musi być specjalnie wzmocniony, aby mógł przetrwać. Przewidziany okres eksploatacji mostu to aż 200 lat!',  CURRENT_TIMESTAMP());

INSERT INTO POST (post_id, user_id, title, body, create_date)
VALUES (6, 1, 'Uważajcie',
        'Uważajcie na te małe, obwoźne parki rozrywki. Byliśmy w zeszły weekend w takim parku i córeczka znajomej wypadła z wagonika. Na szczęście był to już koniec przejazdu, a kolejka była zwykłą "ciuchcią" jeżdżącą na poziomie ziemi, ale dla zarówno dla dziecka jak i rodziców był to naprawdę ogromny stres. Już chyba lepiej i bezpiczniej dopłacić za wyjazd do takiej np. Energylandii, gdzie atrakcje są zamontowane na stałe.',  CURRENT_TIMESTAMP());

INSERT INTO POST (post_id, user_id, title, body, create_date)
VALUES (7, 2, 'Co myślicie o biurze podróży TUI? ',
        'Co myślicie o biurze podróży TUI? Znajomy był kiedyś z tym biurem na wakacjach i nie byli zadowoleni, a teraz moja narzeczona znalazła u nich wycieczkę w atrakcyjnej cenie i sobie o tym przypomniałem.',  CURRENT_TIMESTAMP());

INSERT INTO POST (post_id, user_id, title, body, create_date)
VALUES (8, 2, 'Zrobiłem jej niepodziankę',
        'Wyjazd-niepodzianka na mazury dla mojej narzeczonej to był świetny pomysł. Dawno nie byliśmy na spontanicznym wypadzie, a kiedyś bardzo często na takie jeździliśmy. Niestety tempo życia jest jakie jest. Mazury ugościły nas ciszą, czas tam jakby stanął w miejscu. Odpoczęliśmy, zacieśniliśmy nasz związek i z nową energią wracamy do szarej-nie-takiej-szarej rzeczywistości :D ',  CURRENT_TIMESTAMP());

INSERT INTO POST (post_id, user_id, title, body, create_date)
VALUES (9, 2, 'Boże Narodzenie i śnieg',
        'W ubiegłym roku na Boże Narodzenie wybraliśmy się w góry. Nie na wędrówkę. Zarezerwowaliśmy poków w pensjonacie, który organizował świąteczny obiad dla gości. Te kilka dni spędziliśmy razem, w zimowej, ale jednak domowej atmosferze. W tym roku planujemy podobny wyjazd. Polecam każdemu, kto nie ma problemu z "wyrwaniem" się spod rodzinnych świątecznych tradycji.',  CURRENT_TIMESTAMP());

INSERT INTO POST (post_id, user_id, title, body, create_date)
VALUES (10, 2, 'Polskie morze - zimne morze',
        'Pojechaliśmy na urlop nad polskie morze. Niestety zawiedliśmy się bardzo. Zacznijmy od tego, że za wyjazd zapłaciliśmy tyle, ile kosztuje wycieczka zagraniczna do np. Grecji. Wiadomo, inflacja, rosnące wszędzie ceny, no można było się spodziewać, więc po prostu postanowiliśmy cieszyć się urlopem. Pierwszy dzień na plaży. Pogody brak, nie padało, ale było za zimno żeby pływać i się opalać. Postanowiliśmy wyruszyć na spacer i zjeść rybę prosto z nadmorskiej smażalni. I to był świetny pomysł, a zarazem najlepsza część wyjazdu jaka spotkała nas na miejscu. Kiedy pogoda się poprawiła poszliśmy popływać. Wszyscy wczasowicze wylegli na plażę stawiając swoje parawany tak, że ledwo człowiek miał miejsce żeby przejść nie zaczepiając o żadne tyczki wystające z piasku. Za publiczne śmietniki robiły ludziom dziecięce budowle z piasku. Całości dopełniała zimna woda w morzu i rodzice zmieniający dzieciom pampersy w słonej wodzie. Po tym wyjeździe postanowilismy, że już nad polskie morze nie wrócimy.',  CURRENT_TIMESTAMP());

INSERT INTO POST (post_id, user_id, title, body, create_date)
VALUES (11, 3, 'Męski wyjazd na sylwestra',
        'Pojechaliśmy z kumplami na męskiego sylwestra do Zakopanego. Tłumy ludzi i oczywiście wielka scena. Mimo wszystko impreza udana. Kiedy znudziliśmy się skakaniem na mrozie i zdzieraniem gardeł, wróciliśmy do apartamentu, odpaliliśmy odliczanie w telewizji i zaczęliśmy własnego sylwestra :P',  CURRENT_TIMESTAMP());

INSERT INTO POST (post_id, user_id, title, body, create_date)
VALUES (12, 3, 'Pytanie dość delikatne i połowicznie podróżnicze',
        'Chcę oświadczyć się dziewczynie w romantycznym miejscu, co polecacie?',  CURRENT_TIMESTAMP());


--Komentarze
INSERT INTO COMMENT (post_id, user_id, body, create_date)
VALUES (1, 2, 'Świetne jest ponoć Kretaquarium, kuzynka polecała.', CURRENT_TIMESTAMP());

INSERT INTO COMMENT (post_id, user_id, body, create_date)
VALUES (1, 3, 'Znajomy był z rodziną, dwoje dzieci 3 i 5 lat, w Parku Dinozaurów w Heraklionie. Maluchy zachwycone :P', CURRENT_TIMESTAMP());

INSERT INTO COMMENT (post_id, user_id, body, create_date)
VALUES (4, 2, 'Może mazury?', CURRENT_TIMESTAMP());

INSERT INTO COMMENT (post_id, user_id, body, create_date)
VALUES (7, 1, 'Kiepskie podejście do klienta, nie ma co liczyć na ich pomoc na wyjeździe.', CURRENT_TIMESTAMP());

INSERT INTO COMMENT (post_id, user_id, body, create_date)
VALUES (7, 3, 'Podobno oferta wycieczki nijak ma się do tego co turysta zastaje na miejscu.', CURRENT_TIMESTAMP());

INSERT INTO COMMENT (post_id, user_id, body, create_date)
VALUES (12, 1, 'Zabierz ją na weekend do miasta miłości, do Paryża! :D', CURRENT_TIMESTAMP());

INSERT INTO COMMENT (post_id, user_id, body, create_date)
VALUES (12, 2, 'To Twoja kobieta, ja proponuję, zabierz ją do miejsca, które zawsze chciała odwiedzić.', CURRENT_TIMESTAMP());