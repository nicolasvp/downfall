INSERT INTO genres (id, name, created_at) VALUES('1', 'Classic', NOW());
INSERT INTO genres (id, name, created_at) VALUES('2', 'Blues', NOW());
INSERT INTO genres (id, name, created_at) VALUES('3', 'Jazz', NOW());
INSERT INTO genres (id, name, created_at) VALUES('4', 'Rock and Roll', NOW());
INSERT INTO genres (id, name, created_at) VALUES('5', 'Gospel', NOW());
INSERT INTO genres (id, name, created_at) VALUES('6', 'Soul', NOW());
INSERT INTO genres (id, name, created_at) VALUES('7', 'Rock', NOW());
INSERT INTO genres (id, name, created_at) VALUES('8', 'Metal', NOW());
INSERT INTO genres (id, name, created_at) VALUES('9', 'Country', NOW());
INSERT INTO genres (id, name, created_at) VALUES('10', 'Funk', NOW());
INSERT INTO genres (id, name, created_at) VALUES('11', 'Disco', NOW());
INSERT INTO genres (id, name, created_at) VALUES('12', 'House', NOW());
INSERT INTO genres (id, name, created_at) VALUES('13', 'Techno', NOW());
INSERT INTO genres (id, name, created_at) VALUES('14', 'Pop', NOW());
INSERT INTO genres (id, name, created_at) VALUES('15', 'Ska', NOW());
INSERT INTO genres (id, name, created_at) VALUES('16', 'Reggae', NOW());
INSERT INTO genres (id, name, created_at) VALUES('17', 'Hip Hop', NOW());
INSERT INTO genres (id, name, created_at) VALUES('18', 'Salsa', NOW());
INSERT INTO genres (id, name, created_at) VALUES('19', 'Grunge', NOW());
INSERT INTO genres (id, name, created_at) VALUES('20', 'Heavy Metal', NOW());
INSERT INTO genres (id, name, created_at) VALUES('21', 'Thrash Metal', NOW());
INSERT INTO genres (id, name, created_at) VALUES('22', 'Death Metal', NOW());
INSERT INTO genres (id, name, created_at) VALUES('23', 'Power Metal', NOW());
INSERT INTO genres (id, name, created_at) VALUES('24', 'Punk', NOW());

INSERT INTO artists (id, name, image, genre_id, created_at) VALUES('1', 'Ludwig van Beethoven', '', 1, NOW());
INSERT INTO artists (id, name, image, genre_id, created_at) VALUES('2', 'Wolfgang Amadeus Mozart', '', 1, NOW());
INSERT INTO artists (id, name, image, genre_id, created_at) VALUES('3', 'Elvis Presley', '', 4, NOW());
INSERT INTO artists (id, name, image, genre_id, created_at) VALUES('4', 'Little Richard', '', 4, NOW());
INSERT INTO artists (id, name, image, genre_id, created_at) VALUES('5', 'Chuck Berry', '', 4, NOW());
INSERT INTO artists (id, name, image, genre_id, created_at) VALUES('6', 'Earth, Wind & Fire', '', 10, NOW());
INSERT INTO artists (id, name, image, genre_id, created_at) VALUES('7', 'Jamiroquai', '', 10, NOW());
INSERT INTO artists (id, name, image, genre_id, created_at) VALUES('8', 'Ska-p', '', 15, NOW());
INSERT INTO artists (id, name, image, genre_id, created_at) VALUES('9', 'Skatalities', '', 15, NOW());
INSERT INTO artists (id, name, image, genre_id, created_at) VALUES('10', 'Skalariak', '', 15, NOW());
INSERT INTO artists (id, name, image, genre_id, created_at) VALUES('11', 'Bob Marley', '', 16, NOW());
INSERT INTO artists (id, name, image, genre_id, created_at) VALUES('12', 'UB40', '', 16, NOW());
INSERT INTO artists (id, name, image, genre_id, created_at) VALUES('13', 'Dread Mar I', '', 16, NOW());
INSERT INTO artists (id, name, image, genre_id, created_at) VALUES('14', 'Dr Dre', '', 17, NOW());
INSERT INTO artists (id, name, image, genre_id, created_at) VALUES('15', 'Snoop Dog', '', 17, NOW());
INSERT INTO artists (id, name, image, genre_id, created_at) VALUES('16', 'Stone Temple Pilots', '', 19, NOW());
INSERT INTO artists (id, name, image, genre_id, created_at) VALUES('17', 'CandleBox', '', 19, NOW());
INSERT INTO artists (id, name, image, genre_id, created_at) VALUES('18', 'Iron Maiden', '', 20, NOW());
INSERT INTO artists (id, name, image, genre_id, created_at) VALUES('19', 'Slayer', '', 21, NOW());
INSERT INTO artists (id, name, image, genre_id, created_at) VALUES('20', 'Sex Pistols', '', 24, NOW());

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

INSERT INTO tracks (id, name, track_number, duration, album_id, created_at) VALUES('1', 'Se Tuvo que ir', 13, 151, '13', NOW());
INSERT INTO tracks (id, name, track_number, duration, album_id, created_at) VALUES('2', 'The Next Episode', 11, 162, '14', NOW());
INSERT INTO tracks (id, name, track_number, duration, album_id, created_at) VALUES('3', 'Doggfather', 2, 237, '15', NOW());
INSERT INTO tracks (id, name, track_number, duration, album_id, created_at) VALUES('4', 'Creep', 1, '210', '16', NOW());
INSERT INTO tracks (id, name, track_number, duration, album_id, created_at) VALUES('5', 'You', 1, 186, '17', NOW());
INSERT INTO tracks (id, name, track_number, duration, album_id, created_at) VALUES('6', 'The Number of the Beast', 1, 290, '18', NOW());
INSERT INTO tracks (id, name, track_number, duration, album_id, created_at) VALUES('7', 'Angel of Death', 1, 340, '19', NOW());
INSERT INTO tracks (id, name, track_number, duration, album_id, created_at) VALUES('8', 'God Save the Queen', 1, 230, '20', NOW());


