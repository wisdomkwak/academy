--join_member2.sql
drop table join_member
create table join_member2(
  	join_code number(38) unique not null 
  	/*unique ���� ������ �ߺ����� ������� �ʰ� null�� ���*/  	
  , join_id varchar2(20) primary key /*ȸ�����̵�*/
  , join_pwd varchar2(20) not null /*ȸ�����*/
  , join_name varchar2(50) not null /*ȸ���̸�*/
  , join_zip varchar2(5) not null /* 5�ڸ� �����ȣ */
  , join_addr1 varchar2(100) not null /*�ּ�*/
  , join_addr2 varchar2(100) not null /*������ �ּ� */
  , join_tel varchar2(20) not null /*����*/
  , join_phone varchar2(20) not null /*����ȣ */
  , join_email varchar2(100) not null /*���ڿ��� �ּ�*/
  , join_file varchar2(100)  /*������ �������ϸ�*/
  , join_regdate date /*���� ��¥*/
  , join_state number(10) /*����ȸ�� 1, Ż��ȸ�� 2 */
  , join_delcont varchar2(4000) /*Ż�� ���� */
  , join_deldate date /*Ż�� ��¥ */
  , join_original varchar2(100) /*�������ϸ�*/
);

/***** join_member ���̺��� join_code ������ ���� *****/
create sequence join_member_joincode_seq 
increment by 1 start with 1 nocache;

select * from join_member2;
--drop sequence join_member_joincode_seq; 


select * from products

select * from products order by id

create sequence json_seq 
increment by 1 start with 1 nocache;