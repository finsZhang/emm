-- auto Generated on 2017-05-23 18:35:44 
-- DROP TABLE IF EXISTS card_card; 
CREATE TABLE card_card(
    card_id VARCHAR2(50) NOT NULL,
    card_business_code VARCHAR2(50) DEFAULT '' NOT NULL,
    id_no VARCHAR2(50) DEFAULT '' NOT NULL,
    card_no VARCHAR2(50) DEFAULT '' NOT NULL,
    card_validity VARCHAR2(50) DEFAULT '' NOT NULL,
    name VARCHAR2(50) DEFAULT '' NOT NULL,
    sex VARCHAR2(50) DEFAULT '' NOT NULL,
    nation VARCHAR2(50) DEFAULT '' NOT NULL,
    phone VARCHAR2(50) DEFAULT '' NOT NULL,
    address VARCHAR2(50) DEFAULT '' NOT NULL,
    unit VARCHAR2(50) DEFAULT '' NOT NULL,
    cardholder_type VARCHAR2(50) DEFAULT '' NOT NULL,
    city_code VARCHAR2(50) DEFAULT '' NOT NULL,
    card_serial VARCHAR2(50) DEFAULT '' NOT NULL,
    chip_serial VARCHAR2(50) DEFAULT '' NOT NULL,
    band_card VARCHAR2(50) DEFAULT '' NOT NULL,
    enable_flag VARCHAR2(50) DEFAULT '' NOT NULL,
    deposit_flag VARCHAR2(50) DEFAULT '' NOT NULL,
    card_time VARCHAR2(50) DEFAULT '' NOT NULL,
    deposit VARCHAR2(50) DEFAULT '' NOT NULL,
    master_card_type VARCHAR2(50) DEFAULT '' NOT NULL,
    daugher_card_type VARCHAR2(50) DEFAULT '' NOT NULL,
    card_status VARCHAR2(50) DEFAULT '' NOT NULL,
    card_model VARCHAR2(50) DEFAULT '' NOT NULL,
    card_cost VARCHAR2(50) DEFAULT '' NOT NULL,
    bar_code VARCHAR2(50) DEFAULT '' NOT NULL,
    create_time VARCHAR2(50) DEFAULT '' NOT NULL,
    modify_time VARCHAR2(50) DEFAULT '' NOT NULL,
    id_type VARCHAR2(50) DEFAULT '' NOT NULL,
    birth VARCHAR2(50) DEFAULT '' NOT NULL,
    card_ncmsno VARCHAR2(50) DEFAULT '' NOT NULL,
    CONSTRAINT card_card_pk PRIMARY KEY (card_id));
create sequence card_card_seq start with 1 increment by 1 nomaxvalue;
create trigger card_card_trigger
before insert on card_card
for each row
   begin
     select card_card_seq.nextval into :new.card_id from dual;
   end;
