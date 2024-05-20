INSERT INTO movie (onAirFrom,onAirTo,name) VALUES

('2023-10-04 00:00:00','2023-10-11 00:00:00','interstellar'),
('2024-08-04 00:00:00','2024-08-12 00:00:00','inception'),
('2024-01-01 00:00:00','2024-02-11 00:00:00','italiano medio');


INSERT INTO actor (name) VALUES

('Leonardo di Caprio'),
('Maccio Capatonda'),
('Jay Z'),
('Mario Rossi');

INSERT INTO genre (name,description) VALUES

('horror','non adatto ai minori di 18 anni'),
('fantascienza','non adatto a minori di 13 anni'),
('comico','adatto ai bambini'),
('thriller','puo contenere scene non adatte a minori di 16 anni');

INSERT INTO movie_genre  (genre_id ,movie_id) VALUES

(2,2),
(3,2),
(3,3),
(4,3);

INSERT INTO movie_actor  (actor_id,movie_id) VALUES

(1,1),
(3,1),
(3,3),
(2,1),
(2,2),
(4,2);