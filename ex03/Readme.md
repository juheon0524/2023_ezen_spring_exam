#### 테이블 생성tbl_board
create SEQUENCE seq_board;

create table tbl_board (
    bno number(10,0),
    title varchar2(200) not null,
    content varchar2(2000) not null,
    writer varchar2(50) not null,
    regdate date DEFAULT sysdate,
    updatedate date default sysdate
);

alter table tbl_board add CONSTRAINT pk_board
primary key(bno);

insert into tbl_board(bno, title, content, writer)
values(seq_board.nextval, '테스트 제목5', '테스트 내용5','user005');
commit;
select * from tbl_board;



#### 테이블 생성tbl_reply
create table tbl_reply (
    rno number(10,0),
    bno number(10,0) not null,
    reply varchar2(1000) not null,
    replyer varchar2(50) not null,
    replyDate date default sysdate,
    updateDate date default sysdate
);
--시퀀스 생성
create SEQUENCE seq_reply;
--기본키 생성(rno)
alter table tbl_reply add CONSTRAINT pk_reply primary key(rno);
--외래키 생성(bno)
alter table tbl_reply add constraint fk_reply_board
FOREIGN key(bno) REFERENCES tbl_board(bno);