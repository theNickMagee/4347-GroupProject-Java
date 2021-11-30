
-- INSRERT GAMES FIRST
INSERT INTO league_management.GAME (Name)
VALUES ("Overwatch")

INSERT INTO league_management.GAME (Name)
VALUES ("Rocket League")


-- LEAGUES
INSERT INTO league_management.LEAGUE (Name,  Game)
VALUES ("National Swiss 2021", "Overwatch")

INSERT INTO league_management.LEAGUE (Name,  Game)
VALUES ("Spring 2021 Western", "Rocket League")

INSERT INTO league_management.LEAGUE (Name,  Game)
VALUES ("Starleague 2021", "Counter-Strike")

--SCHOOLS
INSERT INTO league_management.SCHOOL (Location,  Name)
VALUES ("Michigan", "Northwood University"),
 ("Ohio", "Ohio State University"),
 ("Harrisburg", "Harrisburg University"),
 ("Florida", "University of Florida"),
 ("California", "University of California, Irvine"),
 ("Bellevue ", "Bellevue University"),
 ("Maryville", "Maryville University"),
 ("Akron", "Akron University"),
 ("Utah", "University of Utah")


INSERT INTO league_management.SCHOOL (Location,  Name)
VALUES ("Dallas", "University of Texas at Dallas"),
 ("Oregon", "University of Oregon"),
 ("Texas", "University of North Texas"),
 ("Louisiana", "LSU"),
 ("Texas", "Texas Tech")

-- TEAMS
 INSERT INTO league_management.TEAM (Name, Wins, Losses, Tournements_won, Established_date, Years_established, Game, League, School)
VALUES ("Timberwolves", 10, 0, 5, "1-1-2015", 6, "Overwatch","National Swiss 2021",  "Northwood University"),
("Buckeyes", 9, 1, 2, "1-1-2020", 1, "Overwatch","National Swiss 2021",  "Ohio State University"),
("Wolves", 9, 1, 1, "1-1-2021", 1, "Overwatch","National Swiss 2021",  "Harrisburg University"),
("Gators", 9, 1, 1, "1-1-2011", 10, "Overwatch", "National Swiss 2021", "University of Florida"),
("Waves", 5, 1, 0, "1-1-2018", 3, "Overwatch","National Swiss 2021",  "University of California, Irvine"),
("Bears", 4, 6, 0, "1-1-2010", 11, "Overwatch","National Swiss 2021",  "Bellevue University"),
("Devils", 3, 7, 0, "1-1-2014", 7, "Overwatch","National Swiss 2021",  "Maryville University"),
("Zips", 3, 7, 0, "1-1-2019", 2, "Overwatch","National Swiss 2021",  "Akron University"),
("Utes", 8, 2, 0, "1-1-2020", 1, "Overwatch","National Swiss 2021",  "University of Utah")

 INSERT INTO league_management.TEAM (Name, Wins, Losses, Tournements_won, Established_date, Years_established, Game, League, School)
VALUES ("Eagles", 10, 0, 5, "1-1-2015", 6, "Overwatch","Spring 2021 Western",  "University of North Texas"),
("Tigers", 9, 1, 2, "1-1-2020", 1, "Rocket League","Spring 2021 Western",  "LSU"),
("Red Raiders", 9, 1, 1, "1-1-2021", 1, "Rocket League","Spring 2021 Western",  "Texas Tech"),
("Ducks", 9, 1, 1, "1-1-2011", 10, "Rocket League", "Spring 2021 Western", "University of Oregon")
