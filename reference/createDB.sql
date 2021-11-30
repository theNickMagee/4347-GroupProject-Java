-- REFERENCE ONLY

-- This is just the SQL query used to initially populate the DB, not used in the program

CREATE DATABASE league_management;

CREATE TABLE league_management.GAME
(
  Name VARCHAR(64) NOT NULL,
  PRIMARY KEY (Name)
);

CREATE TABLE  league_management.SCHOOL
(
  Location VARCHAR(64) NOT NULL,
  Name VARCHAR(64) NOT NULL,
  PRIMARY KEY (Name)
);

CREATE TABLE  league_management.PERSON
(
  Name VARCHAR(64) NOT NULL,
  Status VARCHAR(64) NOT NULL,
  Join_date DATE NOT NULL,
  PRIMARY KEY (Name)
);

CREATE TABLE  league_management.PLAYER
(
  Wins INT NOT NULL,
  Losses INT NOT NULL,
  Years_played INT NOT NULL,
  Name VARCHAR(64) NOT NULL,
  PRIMARY KEY (Name),
  FOREIGN KEY (Name) REFERENCES PERSON(Name)
);

CREATE TABLE  league_management.STAFF_MEMBER
(
  Type VARCHAR(64) NOT NULL,
  Name VARCHAR(64) NOT NULL,
  PRIMARY KEY (Name),
  FOREIGN KEY (Name) REFERENCES PERSON(Name)
);

CREATE TABLE  league_management.LEAGUE
(
  Name VARCHAR(64) NOT NULL,
  Logo_link VARCHAR(100)  NOT NULL,
  Game VARCHAR(64) NOT NULL,
  PRIMARY KEY (Name, Game),
  FOREIGN KEY (Game) REFERENCES GAME(Name)
);

CREATE TABLE  league_management.TEAM
(
  Name VARCHAR(64) NOT NULL,
  Wins INT NOT NULL,
  Losses INT NOT NULL,
  Tournements_won INT NOT NULL,
  Established_date DATE NOT NULL,
  Years_established INT NOT NULL,
  Game VARCHAR(64) NOT NULL,
  League VARCHAR(64) NOT NULL,
  School VARCHAR(64) NOT NULL,
  PRIMARY KEY (Name),
  FOREIGN KEY (Game, League) REFERENCES LEAGUE(Game, Name),
  FOREIGN KEY (School) REFERENCES SCHOOL(Name)
);

CREATE TABLE  league_management.GAME_EVENT
(
  Date DATE NOT NULL,
  Winning_team VARCHAR(64) NOT NULL,
  Losing_team VARCHAR(64) NOT NULL,
  PRIMARY KEY (Date, Winning_team, Losing_team),
  FOREIGN KEY (Winning_team) REFERENCES TEAM(Name),
  FOREIGN KEY (Losing_team) REFERENCES TEAM(Name)
);

CREATE TABLE  league_management.EMPLOYS
(
  Team_name VARCHAR(64) NOT NULL,
  Person_name VARCHAR(64) NOT NULL,
  PRIMARY KEY (Team_name, Person_name),
  FOREIGN KEY (Team_name) REFERENCES TEAM(Name),
  FOREIGN KEY (Person_name) REFERENCES PERSON(Name)
);