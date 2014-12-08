/*
 The password column has a wrong name
*/
alter table "user" rename column password to password_hash;