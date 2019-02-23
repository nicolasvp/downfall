INSERT INTO genres (id, name, image, description, created_at) VALUES('1', 'Classic', '', 'Beethoven, Mozart, Bach...', NOW());
INSERT INTO genres (id, name, image, description, created_at) VALUES('2', 'Blues', '', 'B.B King, Steve Ray Vaughan, Jimmy Reed...', NOW());
INSERT INTO genres (id, name, image, description, created_at) VALUES('3', 'Jazz', '', 'Louis Armstrong, John Coltrane...', NOW());
INSERT INTO genres (id, name, image, description, created_at) VALUES('4', 'Rock and Roll', '', 'Elvis Presley, Chuck Berry, Little Richard...', NOW());
INSERT INTO genres (id, name, image, description, created_at) VALUES('5', 'Gospel', '', 'Rosetta Tharpe, Reverend Timothy Wright...', NOW());
INSERT INTO genres (id, name, image, description, created_at) VALUES('6', 'Soul', '', 'James Brown, Stevie Wonder, Ray Charles...', NOW());
INSERT INTO genres (id, name, image, description, created_at) VALUES('7', 'Rock', '', 'The Beatles, Queen, AC/DC....', NOW());
INSERT INTO genres (id, name, image, description, created_at) VALUES('8', 'Metal', '', 'Black Sabbath, Motorhead...', NOW());
INSERT INTO genres (id, name, image, description, created_at) VALUES('9', 'Country', '', 'Johnny Cash, Dixie Chicks...', NOW());
INSERT INTO genres (id, name, image, description, created_at) VALUES('10', 'Funk', '', 'Jamiroquai, Living Colour...', NOW());
INSERT INTO genres (id, name, image, description, created_at) VALUES('11', 'Disco', '', 'Bee Gees, Earth, Wind & Fire...', NOW());
INSERT INTO genres (id, name, image, description, created_at) VALUES('12', 'House', '', 'Knife Party, Skrillex, Zedd...', NOW());
INSERT INTO genres (id, name, image, description, created_at) VALUES('13', 'Techno', '', 'Carl Cox, Richie Hawtin, David Guetta...', NOW());
INSERT INTO genres (id, name, image, description, created_at) VALUES('14', 'Pop', '', 'Michael Jackson, Madonna, Lady Gaga...', NOW());
INSERT INTO genres (id, name, image, description, created_at) VALUES('15', 'Ska', '', 'Ska-p, Skatalities, Skalariak...', NOW());
INSERT INTO genres (id, name, image, description, created_at) VALUES('16', 'Reggae', '', 'Bob Marley, Dread Mar I...', NOW());
INSERT INTO genres (id, name, image, description, created_at) VALUES('17', 'Hip Hop', '', 'Dr Dre, Cancerbero...', NOW());
INSERT INTO genres (id, name, image, description, created_at) VALUES('18', 'Salsa', '', 'Juan Luis Guerra, Celia Cruz...', NOW());
INSERT INTO genres (id, name, image, description, created_at) VALUES('19', 'Grunge', '', 'Nirvana, Sound Garden, Stone Temple Pilots...', NOW());
INSERT INTO genres (id, name, image, description, created_at) VALUES('20', 'Heavy Metal', '', 'Iron Maiden, Saxon, Manowar...', NOW());
INSERT INTO genres (id, name, image, description, created_at) VALUES('21', 'Thrash Metal', '', 'Slayer, Kreator, Dark Angel...', NOW());
INSERT INTO genres (id, name, image, description, created_at) VALUES('22', 'Death Metal', '', 'Cannibal Corpse, Necrophaghist, Death...', NOW());
INSERT INTO genres (id, name, image, description, created_at) VALUES('23', 'Power Metal', '', 'Helloween, Stratovarius, Rhapsody...', NOW());
INSERT INTO genres (id, name, image, description, created_at) VALUES('24', 'Punk', '', 'Sex Pistols, GBH, Ramones', NOW());

INSERT INTO artists (id, name, image, youtube_link, spotify_link, genre_id, created_at) VALUES('1', 'Ludwig van Beethoven', '', 'https://www.youtube.com/watch?v=4Tr0otuiQuU', 'https://open.spotify.com/artist/2wOqMjp9TyABvtHdOSOTUS', 1, NOW());
INSERT INTO artists (id, name, image, youtube_link, spotify_link, genre_id, created_at) VALUES('2', 'Wolfgang Amadeus Mozart', '', 'https://www.youtube.com/watch?v=Zi8vJ_lMxQI', 'https://open.spotify.com/artist/4NJhFmfw43RLBLjQvxDuRS', 1, NOW());
INSERT INTO artists (id, name, image, youtube_link, spotify_link, genre_id, created_at) VALUES('3', 'Elvis Presley', '', 'https://www.youtube.com/watch?v=u9sRJ-eOHnc', 'https://open.spotify.com/artist/43ZHCT0cAZBISjO8DG9PnE', 4, NOW());
INSERT INTO artists (id, name, image, youtube_link, spotify_link, genre_id, created_at) VALUES('4', 'Little Richard', '', 'https://www.youtube.com/watch?v=u0Ujb6lJ_mM', 'https://open.spotify.com/artist/4xls23Ye9WR9yy3yYMpAMm', 4, NOW());
INSERT INTO artists (id, name, image, youtube_link, spotify_link, genre_id, created_at) VALUES('5', 'Chuck Berry', '', 'https://www.youtube.com/watch?v=6ROwVrF0Ceg', 'https://open.spotify.com/artist/293zczrfYafIItmnmM3coR', 4, NOW());
INSERT INTO artists (id, name, image, youtube_link, spotify_link, genre_id, created_at) VALUES('6', 'Earth, Wind & Fire', '', 'https://www.youtube.com/watch?v=Gs069dndIYk', 'https://open.spotify.com/artist/4QQgXkCYTt3BlENzhyNETg', 10, NOW());
INSERT INTO artists (id, name, image, youtube_link, spotify_link, genre_id, created_at) VALUES('7', 'Jamiroquai', '', 'https://www.youtube.com/watch?v=4JkIs37a2JE', 'https://open.spotify.com/artist/6J7biCazzYhU3gM9j1wfid', 10, NOW());
INSERT INTO artists (id, name, image, youtube_link, spotify_link, genre_id, created_at) VALUES('8', 'Ska-p', '', 'https://www.youtube.com/watch?v=tkKSnkCv_HM', 'https://open.spotify.com/artist/2fiiGUBgPsIKDCE0bTthnl', 15, NOW());
INSERT INTO artists (id, name, image, youtube_link, spotify_link, genre_id, created_at) VALUES('9', 'The Skatalities', '', 'https://www.youtube.com/watch?v=YWOo_CB7pqA', 'https://open.spotify.com/artist/4og9jrin5xH5JiFPbeGUPb', 15, NOW());
INSERT INTO artists (id, name, image, youtube_link, spotify_link, genre_id, created_at) VALUES('10', 'Skalariak', '', 'https://www.youtube.com/watch?v=3p0BmihBtTY', 'https://open.spotify.com/artist/0hSw6yMPrZuFEVjDX5CoHQ', 15, NOW());
INSERT INTO artists (id, name, image, youtube_link, spotify_link, genre_id, created_at) VALUES('11', 'Bob Marley', '', 'https://www.youtube.com/watch?v=CHekNnySAfM', 'https://open.spotify.com/artist/2QsynagSdAqZj3U9HgDzjD', 16, NOW());
INSERT INTO artists (id, name, image, youtube_link, spotify_link, genre_id, created_at) VALUES('12', 'UB40', '', 'https://www.youtube.com/watch?v=zXt56MB-3vc', 'https://open.spotify.com/artist/69MEO1AADKg1IZrq2XLzo5', 16, NOW());
INSERT INTO artists (id, name, image, youtube_link, spotify_link, genre_id, created_at) VALUES('13', 'Dread Mar I', '', 'https://www.youtube.com/watch?v=a5fHoAx12DY', 'https://open.spotify.com/artist/1aw0Cdl1DIrtUrUA6fGbAR', 16, NOW());
INSERT INTO artists (id, name, image, youtube_link, spotify_link, genre_id, created_at) VALUES('14', 'Dr Dre', '', 'https://www.youtube.com/watch?v=_CL6n0FJZpk', 'https://open.spotify.com/artist/6DPYiyq5kWVQS4RGwxzPC7', 17, NOW());
INSERT INTO artists (id, name, image, youtube_link, spotify_link, genre_id, created_at) VALUES('15', 'Snoop Dog', '', 'https://www.youtube.com/watch?v=QZXc39hT8t4', 'https://open.spotify.com/artist/7hJcb9fa4alzcOq3EaNPoG', 17, NOW());
INSERT INTO artists (id, name, image, youtube_link, spotify_link, genre_id, created_at) VALUES('16', 'Stone Temple Pilots', '', 'https://www.youtube.com/watch?v=sT1DdO3SISg', 'https://open.spotify.com/artist/2UazAtjfzqBF0Nho2awK4z', 19, NOW());
INSERT INTO artists (id, name, image, youtube_link, spotify_link, genre_id, created_at) VALUES('17', 'CandleBox', '', 'https://www.youtube.com/watch?v=fyz-bOqmwIo', 'https://open.spotify.com/artist/3R6c2tWDBeYB1GncjLMn9n', 19, NOW());
INSERT INTO artists (id, name, image, youtube_link, spotify_link, genre_id, created_at) VALUES('18', 'Iron Maiden', '', 'https://www.youtube.com/watch?v=Xg9aQvjMS60', 'https://open.spotify.com/artist/6mdiAmATAx73kdxrNrnlao', 20, NOW());
INSERT INTO artists (id, name, image, youtube_link, spotify_link, genre_id, created_at) VALUES('19', 'Slayer', '', 'https://www.youtube.com/watch?v=yjb0j9l1sz4', 'https://open.spotify.com/artist/1IQ2e1buppatiN1bxUVkrk', 21, NOW());
INSERT INTO artists (id, name, image, youtube_link, spotify_link, genre_id, created_at) VALUES('20', 'Sex Pistols', '', 'https://www.youtube.com/watch?v=yqrAPOZxgzU', 'https://open.spotify.com/artist/1u7kkVrr14iBvrpYnZILJR', 24, NOW());

INSERT INTO albums (id, name, image, release_date, artist_id, created_at) VALUES('1', 'Symphony No. 5', '', '1808-12-22', '1', NOW());
INSERT INTO albums (id, name, image, release_date, artist_id, created_at) VALUES('2', 'Symphony No. 40', '', '1788-07-25', '2', NOW());
INSERT INTO albums (id, name, image, release_date, artist_id, created_at) VALUES('3', 'His Hand in Mine', '', '1960-12-01', '3', NOW());
INSERT INTO albums (id, name, image, release_date, artist_id, created_at) VALUES('4', 'Heres Little Richard', '', '1957-03-01', '4', NOW());
INSERT INTO albums (id, name, image, release_date, artist_id, created_at) VALUES('5', 'After School Session', '', '1957-05-01', '5', NOW());
INSERT INTO albums (id, name, image, release_date, artist_id, created_at) VALUES('6', 'Head to the Sky', '', '1973-05-01', '6', NOW());
INSERT INTO albums (id, name, image, release_date, artist_id, created_at) VALUES('7', 'A Funk Odyssey', '', '2001-09-03', '7', NOW());
INSERT INTO albums (id, name, image, release_date, artist_id, created_at) VALUES('8', 'El Vals del Obrero', '', '1996-03-21', '8', NOW());
INSERT INTO albums (id, name, image, release_date, artist_id, created_at) VALUES('9', 'From Paris With Love', '', '2002-06-17', '9', NOW());
INSERT INTO albums (id, name, image, release_date, artist_id, created_at) VALUES('10', 'Klub Ska', '', '1999-05-05', '10', NOW());
INSERT INTO albums (id, name, image, release_date, artist_id, created_at) VALUES('11', 'Soul Rebels', '', '1970-12-01', '11', NOW());
INSERT INTO albums (id, name, image, release_date, artist_id, created_at) VALUES('12', 'Labour of Love', '', '1983-01-01', '12', NOW());
INSERT INTO albums (id, name, image, release_date, artist_id, created_at) VALUES('13', 'Caminaras Caminos', '', '2018-05-24', '13', NOW());
INSERT INTO albums (id, name, image, release_date, artist_id, created_at) VALUES('14', '2001', '', '1999-10-16', '14', NOW());
INSERT INTO albums (id, name, image, release_date, artist_id, created_at) VALUES('15', 'Tha Doggfather', '', '1996-11-12', '15', NOW());
INSERT INTO albums (id, name, image, release_date, artist_id, created_at) VALUES('16', 'Core', '', '1992-09-29', '16', NOW());
INSERT INTO albums (id, name, image, release_date, artist_id, created_at) VALUES('17', 'CandleBox', '', '1993-07-20', '17', NOW());
INSERT INTO albums (id, name, image, release_date, artist_id, created_at) VALUES('18', 'The Number of the Beast', '', '1982-03-22', '18', NOW());
INSERT INTO albums (id, name, image, release_date, artist_id, created_at) VALUES('19', 'Reign in Blood', '', '1986-06-07', '19', NOW());
INSERT INTO albums (id, name, image, release_date, artist_id, created_at) VALUES('20', 'Never mind the Bollocks', '', '1977-10-28', '20', NOW());

INSERT INTO tracks (name, track_number, duration, album_id, created_at) VALUES('Se Tuvo que ir', 13, 151, '13', NOW());
INSERT INTO tracks (name, track_number, duration, album_id, created_at) VALUES('The Next Episode', 11, 162, '14', NOW());
INSERT INTO tracks (name, track_number, duration, album_id, created_at) VALUES('Doggfather', 2, 237, '15', NOW());
INSERT INTO tracks (name, track_number, duration, album_id, created_at) VALUES('Creep', 1, '210', '16', NOW());
INSERT INTO tracks (name, track_number, duration, album_id, created_at) VALUES('You', 1, 186, '17', NOW());
INSERT INTO tracks (name, track_number, duration, album_id, created_at) VALUES('The Number of the Beast', 1, 290, '18', NOW());
INSERT INTO tracks (name, track_number, duration, album_id, created_at) VALUES('Angel of Death', 1, 340, '19', NOW());
INSERT INTO tracks (name, track_number, duration, album_id, created_at) VALUES('God Save the Queen', 1, 230, '20', NOW());
INSERT INTO tracks (name, track_number, duration, album_id, created_at) VALUES('Angel of Death', 1, 340, '19', NOW());
INSERT INTO tracks (name, track_number, duration, album_id, created_at) VALUES('Raining Blood', 2, 210, '19', NOW());
INSERT INTO tracks (name, track_number, duration, album_id, created_at) VALUES('Jesus saves', 3, 270, '19', NOW());
INSERT INTO tracks (name, track_number, duration, album_id, created_at) VALUES('Run to the Hills', 2, 150, '18', NOW());
INSERT INTO tracks (name, track_number, duration, album_id, created_at) VALUES('22 Acacia Avenue', 3, 210, '18', NOW());
INSERT INTO tracks (name, track_number, duration, album_id, created_at) VALUES('Invaders', 4, 330, '18', NOW());
INSERT INTO tracks (name, track_number, duration, album_id, created_at) VALUES('Still Dre', 2, 210, '14', NOW());
INSERT INTO tracks (name, track_number, duration, album_id, created_at) VALUES('Bang Bang', 3, 120, '14', NOW());

INSERT INTO users (name, email, username, password, enabled) VALUES ('Administrador', 'admin@mail.com', 'admin', '$2a$10$8lYtUcBEFVloCaYGmvUKRef9TO7WQS6oZ02EXHUrhRcsT/pZQPHYq', 1);
INSERT INTO users (name, email, username, password, enabled) VALUES ('Nicolas', 'nicolas@mail.com', 'usuario', '$2a$10$drFxAUx3GML.L1Avi9dPnev6orDSHBKmmA9XTGvUeDV98BEWWFn1K', 1);

/* Los roles deben tener el prefijo ROLE_ */
INSERT INTO roles (name, description) VALUES ('ROLE_ADMIN', 'Administrador del sistema');
INSERT INTO roles (name, description) VALUES ('ROLE_USER', 'Usuario del sistema');

INSERT INTO users_roles (user_id, role_id) VALUES (1, 1);
INSERT INTO users_roles (user_id, role_id) VALUES (1, 2);
INSERT INTO users_roles (user_id, role_id) VALUES (2, 2);

