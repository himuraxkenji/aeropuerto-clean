delete from pilots;
drop sequence if exists pilots_id_seq;
create sequence pilots_id_seq
  start with 1
  increment by 1;