DROP TABLE IF EXISTS "news" CASCADE;
DROP TABLE IF EXISTS "report" CASCADE;
DROP TABLE IF EXISTS "comment" CASCADE;
DROP TABLE IF EXISTS "interview" CASCADE; 
DROP TABLE IF EXISTS "admin" CASCADE;
DROP TABLE IF EXISTS "citizen" CASCADE;
DROP TABLE IF EXISTS "person" CASCADE;
DROP TABLE IF EXISTS "InerviewToCitizen" CASCADE;
DROP TABLE IF EXISTS "CommentToCitizen" CASCADE;

CREATE TABLE "person" (
  "id" integer NOT NULL,
  "login" character varying(45) NOT NULL,
  "password" character varying(45) NOT NULL,
  "email" character varying(45) NOT NULL,
  "registrationDate" date NOT NULL,
  PRIMARY KEY ("id")
);
ALTER TABLE "person"
  OWNER TO "postgres";

CREATE TABLE "admin" (
  "adminId" integer NOT NULL,
  "firstName" character varying(45) NOT NULL,
  "lastName" character varying(45) NOT NULL,
  "phone" character varying(20) NOT NULL,
  PRIMARY KEY ("adminId"),
  CONSTRAINT "fk_admin_adminId" FOREIGN KEY ("adminId") REFERENCES "person" ("id")
);
ALTER TABLE "admin"
  OWNER TO "postgres";

CREATE TABLE "citizen" (
  "citizenId" integer NOT NULL,
  "firstName" character varying(45) NOT NULL,
  "lastName" character varying(45) NOT NULL,
  "bonusPoint" integer NOT NULL,
  PRIMARY KEY ("citizenId"),
  CONSTRAINT "fk_citizen_citizenId" FOREIGN KEY ("citizenId") REFERENCES "person" ("id")
);
ALTER TABLE "citizen"
  OWNER TO "postgres"; 

CREATE TABLE "interview" (
  "id" integer NOT NULL,
  "authorId" integer NOT NULL,
  "startDate" date NOT NULL,
  "finishDate" date NOT NULL,
  "text" text NOT NULL,
  PRIMARY KEY ("id"),
  CONSTRAINT "fk_interview_authorId" FOREIGN KEY ("authorId") REFERENCES "admin" ("adminId")
);
ALTER TABLE "interview"
  OWNER TO "postgres";  

CREATE TABLE "comment" (
  "id" integer NOT NULL,
  "text" text NOT NULL,
  "date" date NOT NULL,
  "numberOfVotes" integer NOT NULL,
  "authorId" integer NOT NULL,
  "informId" integer NOT NULL,
  "check" boolean NOT NULL,
  PRIMARY KEY ("id"),
  CONSTRAINT "fk_comment_authorId" FOREIGN KEY ("authorId") REFERENCES "person" ("id"),
  CONSTRAINT "fk_comment_informId" FOREIGN KEY ("informId") REFERENCES "interview" ("id")
);
ALTER TABLE "comment"
  OWNER TO "postgres";

CREATE TABLE "news" (
  "id" integer NOT NULL,
  "title" text NOT NULL,
  "text" text NOT NULL,
  "shortText" text NOT NULL,
  "date" date NOT NULL,
  "authorId" integer NOT NULL,
  PRIMARY KEY ("id"),
  CONSTRAINT "fk_news_authorId" FOREIGN KEY ("authorId") REFERENCES "admin" ("adminId")
);
ALTER TABLE "news"
  OWNER TO "postgres";

CREATE TABLE "report" (
  "id" integer NOT NULL,
  "text" text NOT NULL,
  "result" text NOT NULL,
  "decision" text NOT NULL,
  "date" date NOT NULL,
  "authorId" integer NOT NULL,
  "interviewId" integer NOT NULL,
  PRIMARY KEY ("id"),
  CONSTRAINT "fk_report_authorId" FOREIGN KEY ("authorId") REFERENCES "admin" ("adminId"),
  CONSTRAINT "fk_report_interviewId" FOREIGN KEY ("interviewId") REFERENCES "interview" ("id")
);
ALTER TABLE "report"
  OWNER TO "postgres";  

CREATE TABLE "InerviewToCitizen" (
  "citizenId" integer NOT NULL,
  "interviewId" integer NOT NULL,
  CONSTRAINT "fk_InerviewToCitizen_citizenId" FOREIGN KEY ("citizenId") REFERENCES "citizen" ("citizenId"),
  CONSTRAINT "fk_InerviewToCitizen_interviewId" FOREIGN KEY ("interviewId") REFERENCES "interview" ("id")
);
ALTER TABLE "InerviewToCitizen"
  OWNER TO "postgres";

CREATE TABLE "CommentToCitizen" (
  "commentId" integer NOT NULL,
  "citizenId" integer NOT NULL,
  CONSTRAINT "fk_CommentToCitizen_commentId" FOREIGN KEY ("commentId") REFERENCES "comment" ("id"),
  CONSTRAINT "fk_CommentToCitizen_citizenId" FOREIGN KEY ("citizenId") REFERENCES "citizen" ("citizenId")
);
ALTER TABLE "CommentToCitizen"
  OWNER TO "postgres";  





  